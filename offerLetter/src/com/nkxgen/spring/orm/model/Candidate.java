package com.nkxgen.spring.orm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_candidates")
public class Candidate {

	@Id
	@Column(name = "cand_id")
	private int cand_id;
	private String cand_firstname;
	private String cand_lastname;
	private Date cand_rdate;
	private String cand_status;

	// Getters and setters
	public int getCand_id() {
		return cand_id;
	}

	public void setCand_id(int cand_id) {
		this.cand_id = cand_id;
	}

	public String getCand_firstname() {
		return cand_firstname;
	}

	public void setCand_firstname(String cand_firstname) {
		this.cand_firstname = cand_firstname;
	}

	public String getCand_lastname() {
		return cand_lastname;
	}

	public void setCand_lastname(String cand_lastname) {
		this.cand_lastname = cand_lastname;
	}

	public Date getCand_rdate() {
		return cand_rdate;
	}

	public void setCand_rdate(Date cand_rdate) {
		this.cand_rdate = cand_rdate;
	}

	public String getCand_status() {
		return cand_status;
	}

	public void setCand_status(String cand_status) {
		this.cand_status = cand_status;
	}

	// Getters and setters

}
