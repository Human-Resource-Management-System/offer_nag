package com.nkxgen.spring.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.orm.dao.CandidateDAO;
import com.nkxgen.spring.orm.model.Candidate;
import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.model.EmploymentOfferDocument;
import com.nkxgen.spring.orm.model.EmploymentOfferdocComposite;
import com.nkxgen.spring.orm.model.HrmsEmploymentOffer;
import com.nkxgen.spring.orm.model.OfferModel;
import com.nkxgen.spring.orm.service.offerlettermail;

@Controller
public class Offerlettercontroller {
	private final Logger logger = LoggerFactory.getLogger(Offerlettercontroller.class);

	private CandidateDAO cd;
	OfferModel of;

	@Autowired
	public Offerlettercontroller(CandidateDAO cd) {
		this.cd = cd;
	}

	// getting data of candidates whose offerletters are already provided
	@RequestMapping("/provided")
	public String getOfferLetterProvidedCandidates(Model model) {
		logger.info("Request received for  offers already provided");

		List<Candidate> candidates = cd.findAllProvidedCandidates();
		model.addAttribute("candidates", candidates);
		return "offerlettercandidates";
	}

	// getting data of candidates whose offerletters have to be issue
	@RequestMapping("/issue")
	public String getIssuingCandidates(Model model) {
		logger.info("Request received for  offers to be issue");

		List<Candidate> candidates = cd.findAllIssuedCandidates();
		model.addAttribute("candidates", candidates);
		return "offerlettercandidates";
	}

	// getting a form for issuing offerletter with details of candidates and respective admin automatically
	@RequestMapping("/get-candidate-details")
	public String getCandidateDetails(@RequestParam("id") int candidateId, Model model) {
		logger.info(
				"after selection of a candidate for issue offerletter getting candidate details or candidate object");

		Candidate candidate = cd.getCandidateById(candidateId);
		int HR_id = 301;
		Employee emp = cd.getHrById(HR_id);
		logger.info(
				"getting hr details for specifing the hr details on the offerletter (nothing but the admin who has logged in)");

		List<String> listOfDocuments = cd.getAllDocuments();
		logger.info(
				"getting the list of documents should bring while coming to induction , it will be selected by hr from dropdown");

		model.addAttribute("candidate", candidate);
		model.addAttribute("hr", emp);
		model.addAttribute("listOfDocuments", listOfDocuments);

		return "viewCandidate";
	}

	// redirect the
	@RequestMapping("/email")
	public String sendToMail(@Validated OfferModel offerModel, Model model) {
		of = offerModel;
		logger.info("getting all the data from the filled by hr storing it in the offerModel ");

		System.out.println(offerModel.getDocuments());
		model.addAttribute("offerModel", offerModel);

		// Return the appropriate view
		return "email";
	}

	// insert the candidate data in emplomentOffers table , employmentOfferDocuments table and changing status of
	// employee from NA to AC
	@RequestMapping("/sendOfferLetter")

	public void redirectedFromOfferLetter(HrmsEmploymentOffer eofr,
			EmploymentOfferdocComposite employmentofferdocComposite, EmploymentOfferDocument employmentofferdocument,
			Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("Entering redirectedFromOfferLetter method");
		logger.info(
				"Received 3 models in parameters: EmploymentOfferdocComposite, EmploymentOfferDocument, and HrmsEmploymentOffer");
		logger.info(
				"EmploymentOfferdocComposite is used to add a composite key row in the employmentofferdocuments table");
		logger.info("EmploymentOfferDocument consists of EmploymentOfferdocComposite and idttyid");
		logger.info("HrmsEmploymentOffer is used for inserting data into the employmentoffers table");

		logger.info(
				"Getting the latest eofrid from the database and adding 1 to insert a new row (for sequential increment)");
		eofr.setOfferId(cd.getLatestEofrIdFromDatabase() + 1);
		logger.info("setting refid");
		logger.info("Setting refid for the employment offer");
		eofr.setReferenceId("ref " + eofr.getOfferId());
		eofr.setCandidateId(Integer.parseInt(of.getCandidateId()));
		System.out.println(of);

		eofr.setHrEmail(of.getAdminEmail());
		eofr.setHrMobileNumber(Long.parseLong(of.getAdminMobile()));
		eofr.setOfferDate(Date.valueOf(of.getOfferDate()));
		eofr.setOfferedJob(of.getOfferedJob());
		eofr.setReportingDate(Date.valueOf(LocalDate.parse(of.getReportingDate())));
		eofr.setStatus("INPR");
		logger.info("setting all the data to HrmsEmploymentOffer for inserting into employmentoffers table");

		try {
			offerlettermail.sendEmail(request, response, of);
			logger.info("Email sent successfully to the candidate");

		} catch (Exception e) {
			logger.error("Error occurred while sending email to the candidate", e);

			e.printStackTrace();
		}
		logger.info("sent mail to the candidate");
		cd.insertEofrInto(eofr);
		logger.info("inserting data into HrmsEmploymentOffer here by calling dao method");
		cd.updateEmploymentOfferDocuments(eofr, of, employmentofferdocComposite, employmentofferdocument);
		logger.info("inserting into  employmentofferdocuemnts table");

		cd.updateCandidateStatus("cand_status", "AC");
		logger.info("finally after all, now change candidate status from NA to AC");

	}
}
