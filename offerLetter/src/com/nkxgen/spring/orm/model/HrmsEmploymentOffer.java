package com.nkxgen.spring.orm.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employmentoffers")
public class HrmsEmploymentOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eofr_id")
	private int offerId;

	@Column(name = "eofr_ref_id")
	private String referenceId;

	@Column(name = "eofr_cand_id", unique = true)
	private int candidateId;

	@Column(name = "eofr_offerdate")
	private Date offerDate;

	@Column(name = "eofr_offeredjob")
	private String offeredJob;

	@Column(name = "eofr_reportingdate")
	private Date reportingDate;

	@Column(name = "eofr_hrmobileno")
	private long hrMobileNumber;

	@Column(name = "eofr_hremail")
	private String hrEmail;

	@Column(name = "eofr_status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eofr_cand_id", referencedColumnName = "cand_id", insertable = false, updatable = false)
	private Candidate candidate;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	public String getOfferedJob() {
		return offeredJob;
	}

	public void setOfferedJob(String offeredJob) {
		this.offeredJob = offeredJob;
	}

	public Date getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(Date reportingDate) {
		this.reportingDate = reportingDate;
	}

	public long getHrMobileNumber() {
		return hrMobileNumber;
	}

	public void setHrMobileNumber(long hrMobileNumber) {
		this.hrMobileNumber = hrMobileNumber;
	}

	public String getHrEmail() {
		return hrEmail;
	}

	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}
