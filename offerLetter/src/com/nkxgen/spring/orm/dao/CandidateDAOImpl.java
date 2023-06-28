package com.nkxgen.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.controller.Offerlettercontroller;
import com.nkxgen.spring.orm.model.Candidate;
import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.model.EmploymentOfferDocument;
import com.nkxgen.spring.orm.model.EmploymentOfferdocComposite;
import com.nkxgen.spring.orm.model.HrmsEmploymentOffer;
import com.nkxgen.spring.orm.model.InductionDocumentTypes;
import com.nkxgen.spring.orm.model.OfferModel;

@Repository
public class CandidateDAOImpl implements CandidateDAO {
	private final Logger logger = LoggerFactory.getLogger(Offerlettercontroller.class);

	@PersistenceContext
	private EntityManager entityManager;
	Candidate cann;

	// get all the candidates list whom offer letter already provided
	@Override
	public List<Candidate> findAllProvidedCandidates() {
		logger.info("requested to get all the provided candidates from data base by using status i.e AC");

		TypedQuery<Candidate> query = entityManager
				.createQuery("SELECT c FROM Candidate c WHERE c.cand_status = :status", Candidate.class);
		query.setParameter("status", "AC");
		return query.getResultList();
	}

	// get all the candidates list for whom the offer letter have to be send
	@Override
	public List<Candidate> findAllIssuedCandidates() {
		logger.info(
				"requested to get all the  candidates for issue offerletters from data base by using status i.e NA");

		TypedQuery<Candidate> query = entityManager
				.createQuery("SELECT c FROM Candidate c WHERE c.cand_status = :status", Candidate.class);
		query.setParameter("status", "NA");
		return query.getResultList();
	}

	// used to get the admin details who is processing the offer letter
	@Override
	public Employee getHrById(int hR_id) {
		logger.info("getting hr details by hr id");

		return entityManager.find(Employee.class, hR_id);

	}

	// get candidate details by ID
	@Override
	public Candidate getCandidateById(int candidateId) {
		logger.info("getting candidate details by candId");

		cann = entityManager.find(Candidate.class, candidateId);
		return cann;
	}

	// update the candidate status from NA to AC after issuing offer letters.
	@Override
	@Transactional
	public void updateCandidateStatus(String cand_status, String newValue) {
		logger.info(" update the candidate status from NA to AC after offerletter given ");

		cann.setCand_status(newValue); // Modify the desired column value
		entityManager.merge(cann); // Save the changes to the database
	}

	// insert the new candidate information in employment offers table
	@Override
	@Transactional
	public void insertEofrInto(HrmsEmploymentOffer eofr) {
		logger.info("inserting all the employment offer data into data base ");

		entityManager.persist(eofr);
	}

	// getting latest employment offerId for incrementing the eofrId for new row
	@Override
	public int getLatestEofrIdFromDatabase() {
		logger.info(" get latest eofrId");

		TypedQuery<Integer> query = entityManager
				.createQuery("SELECT CAST(MAX(e.offerId) AS int) FROM HrmsEmploymentOffer e", Integer.class);
		return query.getSingleResult();
	}

	// get all the induction documents to select by HR , the documents should bring by candidate while coming to
	// induction program
	@Override
	public List<String> getAllDocuments() {
		logger.info(
				"requested all the documents from employmentofferdocuemntTypes for hr to select which documents to bring for induction ");

		TypedQuery<String> query = entityManager.createQuery("SELECT e.idtyTitle FROM InductionDocumentTypes e",
				String.class);
		return query.getResultList();
	}

	// to insert offerId, docIndex,IdtyId of the particular candidate in employment offers documents

	@Override
	@Transactional

	public void updateEmploymentOfferDocuments(HrmsEmploymentOffer employmentOfferModel, OfferModel of,
			EmploymentOfferdocComposite empoffdocComposite, EmploymentOfferDocument employmentofferdocument) {
		logger.info("Update the employmentofferdocuments table with eofd_id, docindex, and IdtyId of the document");

		logger.info(""); // Added line

		System.out.println("in here");
		// getting eofrId
		logger.info("Get all required models from HrmsEmploymentOffer to retrieve eofrId");

		int eofrId = employmentOfferModel.getCandidateId();
		// getting the list of documents should bring by candidate
		List<String> documentsToBring = of.getDocuments();
		System.out.println(documentsToBring);
		logger.info(" get the docuemnts from  HrmsEmploymentOffer which was  the documents selected by hr");
		// setting inductionDocumentTypes model from inductionDocumentTypes table
		List<InductionDocumentTypes> inductionDocuments = getInductionDocuments();

		System.out.println(inductionDocuments);
		int docIndex = 1;
		for (String document : documentsToBring) {
			// getting IdtyId by the document name
			int idtyId = findIdtyIdByTitle(inductionDocuments, document);
			logger.info("Assigning eofrId: " + eofrId);

			// these four steps is for assigning eofrId,docIndex,idtyId to the employmentofferdocuments entity model
			empoffdocComposite.setOfferid(eofrId);
			logger.info("Assigning docIndex: " + docIndex);

			empoffdocComposite.setDocumentIndex(docIndex);
			employmentofferdocument.setEmpoff(empoffdocComposite);
			logger.info("Assigning offeridentity: " + idtyId);

			employmentofferdocument.setOfferidentity(idtyId);
			// EmploymentOfferDocument documentModel = new EmploymentOfferDocument(empoffdocComposite, idtyId);
			logger.info("Saving employmentofferdocument into the database");

			// update the data into data base which got from entity model of employmentofferdocuments
			saveEmploymentOfferDocument(employmentofferdocument);
			logger.info("EmploymentOfferDocument saved successfully");

			docIndex++;
		}
	}

	private List<InductionDocumentTypes> getInductionDocuments() {
		logger.info("Fetching inductionDocumentTypes from the database");

		TypedQuery<InductionDocumentTypes> query = entityManager.createQuery("SELECT d FROM InductionDocumentTypes d",
				InductionDocumentTypes.class);
		return query.getResultList();
	}

	// persists into employmenofferdocuemnts table
	@Transactional
	private void saveEmploymentOfferDocument(EmploymentOfferDocument document) {
		logger.info("Saving employment offer document into the database");
		entityManager.persist(document);
		logger.info("Employment offer document saved successfully");

	}

	// getting IdtyId by the document name
	private int findIdtyIdByTitle(List<InductionDocumentTypes> inductionDocuments, String title) {
		logger.info("Finding IdtyId by title: " + title);
		for (InductionDocumentTypes document : inductionDocuments) {
			if (document.getIdtyTitle().equalsIgnoreCase(title)) {
				logger.info("IdtyId found for title: " + title + ", IdtyId: " + document.getIdtyId());
				return document.getIdtyId();
			}
		}
		logger.info("IdtyId not found for title: " + title);
		return 0; // Return an appropriate default value if the document title is not found
	}

}
