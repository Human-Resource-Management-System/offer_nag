package com.nkxgen.spring.orm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "hrms_inductiondocumenttypes")
public class Inductiondocuments {
	@Id

	private int idty_id;
	private String idty_title;

	public Inductiondocuments() {
		// Default constructor
	}

	public Inductiondocuments(int idtyId, String idtyTitle) {
		this.idty_id = idtyId;
		this.idty_title = idtyTitle;
	}

	public int getIdtyId() {
		return idty_id;
	}

	public void setIdtyId(int idtyId) {
		this.idty_id = idtyId;
	}

	public String getIdtyTitle() {
		return idty_title;
	}

	public void setIdtyTitle(String idtyTitle) {
		this.idty_title = idtyTitle;
	}
}
