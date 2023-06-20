package com.nkxgen.spring.orm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employmentoffers")
public class Eofr {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "eofr_id")
	private Long eofr_id; // Auto-generated eofr_id

	private String eofr_ref_id; // Auto-generated eofr_ref_id
	public int eofr_cand_id;
	private Date eofr_offerdate;
	private String eofr_offeredjob;
	private Date eofr_reportingdate;
	private long eofr_hrmobileno;
	private String eofr_hremail;
	private String eofr_status;

	public Eofr() {
		// Default constructor
	}

	public Long getEofr_id() {
		return eofr_id;
	}

	public void setEofr_id(Long long1) {
		this.eofr_id = long1;
	}

	public String getEofr_ref_id() {
		return eofr_ref_id;
	}

	public void setEofr_ref_id(String eofr_ref_id) {
		this.eofr_ref_id = eofr_ref_id;
	}

	public int getEofr_cand_id() {
		return eofr_cand_id;
	}

	public void setEofr_cand_id(int eofr_cand_id) {
		this.eofr_cand_id = eofr_cand_id;
	}

	public Date getEofr_offerdate() {
		return eofr_offerdate;
	}

	public void setEofr_offerdate(Date eofr_offerdate) {
		this.eofr_offerdate = eofr_offerdate;
	}

	public String getEofr_offerjobe() {
		return eofr_offeredjob;
	}

	public void setEofr_offerjobe(String eofr_offerjobe) {
		this.eofr_offeredjob = eofr_offerjobe;
	}

	public Date getEofr_reportingdate() {
		return eofr_reportingdate;
	}

	public void setEofr_reportingdate(Date eofr_reportingdate) {
		this.eofr_reportingdate = eofr_reportingdate;
	}

	public long getEofr_hrmobileno() {
		return eofr_hrmobileno;
	}

	public void setEofr_hrmobileno(long eofr_hrmobileno) {
		this.eofr_hrmobileno = eofr_hrmobileno;
	}

	public String getEofr_hremail() {
		return eofr_hremail;
	}

	public void setEofr_hremail(String eofr_hremail) {
		this.eofr_hremail = eofr_hremail;
	}

	public String getEofr_status() {
		return eofr_status;
	}

	public void setEofr_status(String eofr_status) {
		this.eofr_status = eofr_status;
	}

}
