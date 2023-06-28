package com.nkxgen.spring.orm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employmentofferdocuments")
public class EmploymentOfferDocument {

	@EmbeddedId
	private EmploymentOfferdocComposite empoff;

	@Column(name = "eofd_idty_id")
	private int offeridentity;

	@ManyToOne
	@JoinColumn(name = "eofd_id", referencedColumnName = "eofr_cand_id", insertable = false, updatable = false)
	private HrmsEmploymentOffer employmentOffer;

	@ManyToOne
	@JoinColumn(name = "eofd_idty_id", referencedColumnName = "idty_id", insertable = false, updatable = false)
	private InductionDocumentTypes documentType;

	public EmploymentOfferDocument(EmploymentOfferdocComposite comp, int idtyId) {
		this.offeridentity = idtyId;
		this.empoff = comp;
	}

	public EmploymentOfferDocument() {
	}

	public int getOfferidentity() {
		return offeridentity;
	}

	public void setOfferidentity(int offeridentity) {
		this.offeridentity = offeridentity;
	}

	public HrmsEmploymentOffer getEmploymentOffer() {
		return employmentOffer;
	}

	public void setEmploymentOffer(HrmsEmploymentOffer employmentOffer) {
		this.employmentOffer = employmentOffer;
	}

	public InductionDocumentTypes getDocumentType() {
		return documentType;
	}

	public void setDocumentType(InductionDocumentTypes documentType) {
		this.documentType = documentType;
	}

	public EmploymentOfferdocComposite getEmpoff() {
		return empoff;
	}

	public void setEmpoff(EmploymentOfferdocComposite empoff) {
		this.empoff = empoff;
	}

	@Override
	public String toString() {
		return "empoffdocuments [empoff=" + empoff + ", eofdIdtyId=" + offeridentity + "]";
	}

}
