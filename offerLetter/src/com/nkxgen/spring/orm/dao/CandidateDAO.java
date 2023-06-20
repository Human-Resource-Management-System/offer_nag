package com.nkxgen.spring.orm.dao;

import java.util.List;

import com.nkxgen.spring.orm.model.Candidate;
import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.model.Eofr;
import com.nkxgen.spring.orm.model.OfferModel;

public interface CandidateDAO {
	List<Candidate> findAllIssuedCandidates();

	Candidate getCandidateById(int employeeId);

	Long getLatestEofrIdFromDatabase();

	void insertEofrInto(Eofr eofr);

	Employee getHrById(int hR_id);

	List<String> getAllDocuments();

	void updateEmploymentOfferDocuments(Eofr eofr, OfferModel offerModel);

	void updateCandidateStatus(String cand_status, String newValue);

}
