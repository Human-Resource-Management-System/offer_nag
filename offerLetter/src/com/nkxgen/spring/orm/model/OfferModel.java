package com.nkxgen.spring.orm.model;

import java.util.List;

public class OfferModel {
	private String candidateName;
	private String adminMobile;
	private String adminEmail;
	private String offerDate;
	private String offeredJob;
	private String reportingDate;
	private List<String> documents;

	public OfferModel() {
	}

	public OfferModel(String candidateName, String adminMobile, String adminEmail, String offerDate, String offeredJob,
			String reportingDate, List<String> documents) {
		this.candidateName = candidateName;
		this.adminMobile = adminMobile;
		this.adminEmail = adminEmail;
		this.offerDate = offerDate;
		this.offeredJob = offeredJob;
		this.reportingDate = reportingDate;
		this.documents = documents;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(String offerDate) {
		this.offerDate = offerDate;
	}

	public String getOfferedJob() {
		return offeredJob;
	}

	public void setOfferedJob(String offeredJob) {
		this.offeredJob = offeredJob;
	}

	public String getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(String reportingDate) {
		this.reportingDate = reportingDate;
	}

	public List<String> getDocuments() {
		return documents;
	}

	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
}
