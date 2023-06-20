package com.nkxgen.spring.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.orm.dao.CandidateDAO;
import com.nkxgen.spring.orm.model.Candidate;
import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.model.Eofr;
import com.nkxgen.spring.orm.model.Inductiondocuments;
import com.nkxgen.spring.orm.model.OfferModel;
import com.nkxgen.spring.orm.model.empoffdocuments;

@Controller
public class CandidateController {
	private CandidateDAO cd;
	OfferModel of;
	Candidate can;
	Inductiondocuments indoc;

	@Autowired
	public CandidateController(CandidateDAO cd) {
		this.cd = cd;

	}

	@RequestMapping("/")

	public String getissuingCandidates(Model model) {
		List<Candidate> candidates = cd.findAllIssuedCandidates();
		model.addAttribute("candidates", candidates);
		return "front";
	}

	@RequestMapping("/get-candidate-details")
	public String getEmployeeDetails(@RequestParam("id") int candidateId, Inductiondocuments indocm, Model model) {
		Candidate candidate = cd.getCandidateById(candidateId);
		int HR_id = 301;
		Employee emp = cd.getHrById(HR_id);
		indoc = indocm;
		can = candidate;
		List<String> listOfDocuments = cd.getAllDocuments();
		model.addAttribute("candidate", candidate);
		model.addAttribute("hr", emp);
		model.addAttribute("listOfDocuments", listOfDocuments);

		return "viewCandidate";
	}

	@RequestMapping("/email")
	public String sendToMail(@Validated OfferModel offerModel, Model model) {
		of = offerModel;

		System.out.println(offerModel.getDocuments());
		model.addAttribute("offerModel", offerModel);

		// Return the appropriate view
		return "email";
	}

	@RequestMapping("/sendOfferLetter")

	public String redirectedFromOfferLetter(Eofr eofr, empoffdocuments eod, Model model) {
		eofr.setEofr_id(cd.getLatestEofrIdFromDatabase() + 1);
		eofr.setEofr_ref_id("ref " + eofr.getEofr_id());
		eofr.eofr_cand_id = can.getCand_id();
		System.out.println(can.getCand_id());
		eofr.setEofr_hremail(of.getAdminEmail());
		eofr.setEofr_hrmobileno(Long.parseLong(of.getAdminMobile()));
		eofr.setEofr_offerdate(Date.valueOf(of.getOfferDate()));
		eofr.setEofr_offerjobe(of.getOfferedJob());
		eofr.setEofr_reportingdate(Date.valueOf(LocalDate.parse(of.getReportingDate())));
		eofr.setEofr_status("INPR");

		cd.insertEofrInto(eofr);

		cd.updateEmploymentOfferDocuments(eofr, of);

		cd.updateCandidateStatus("cand_status", "AC");

		// eod.setEofrId((long) can.getCand_id());
		// eod.setEofdDocIndex();
		// eod.setEofdIdtyId(eofdIdtyId);
		return "front";
	}

}
