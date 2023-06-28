package com.nkxgen.spring.orm.dao;

import java.util.List;

import com.nkxgen.spring.orm.model.Candidate;
import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.model.HrmsEmploymentOffer;
import com.nkxgen.spring.orm.model.OfferModel;

public interface CandidateDAO {
	List<Candidate> findAllIssuedCandidates();

	Candidate getCandidateById(int employeeId);

	int getLatestEofrIdFromDatabase();

	void insertEofrInto(HrmsEmploymentOffer eofr);

	Employee getHrById(int hR_id);

	List<String> getAllDocuments();

	void updateCandidateStatus(String cand_status, String newValue);

	List<Candidate> findAllProvidedCandidates();

	void updateEmploymentOfferDocuments(HrmsEmploymentOffer employmentOfferModel, OfferModel of);

}
