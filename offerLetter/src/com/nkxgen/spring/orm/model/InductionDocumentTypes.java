package com.nkxgen.spring.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HRMS_inductionDocumentTypes")
public class InductionDocumentTypes {

	@Id
	@Column(name = "idty_id")
	private int idtyId;

	@Column(name = "idty_code")
	private String idtyCode;

	@Column(name = "idty_title")
	private String idtyTitle;

	@Column(name = "idty_desc")
	private String idtyDescription;

	public InductionDocumentTypes() {
	}

	public int getIdtyId() {
		return idtyId;
	}

	public void setIdtyId(int idtyId) {
		this.idtyId = idtyId;
	}

	public String getIdtyCode() {
		return idtyCode;
	}

	public void setIdtyCode(String idtyCode) {
		this.idtyCode = idtyCode;
	}

	public String getIdtyTitle() {
		return idtyTitle;
	}

	public void setIdtyTitle(String idtyTitle) {
		this.idtyTitle = idtyTitle;
	}

	public String getIdtyDescription() {
		return idtyDescription;
	}

	public void setIdtyDescription(String idtyDescription) {
		this.idtyDescription = idtyDescription;
	}
}