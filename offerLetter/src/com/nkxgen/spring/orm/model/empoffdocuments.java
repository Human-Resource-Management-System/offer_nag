package com.nkxgen.spring.orm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employmentofferdocuments")
public class empoffdocuments {
	// Other code

	@EmbeddedId
	private empoffdocscomposite empoff;

	@Column(name = "eofd_idty_id")
	private int eofdIdtyId;

	empoffdocuments() {
	}

	public int getEofdIdtyId() {
		return eofdIdtyId;
	}

	public empoffdocuments(empoffdocscomposite empoff, int eofdIdtyId) {
		super();
		this.empoff = empoff;
		this.eofdIdtyId = eofdIdtyId;
	}

	public empoffdocscomposite getEmpoff() {
		return empoff;
	}

	public void setEmpoff(empoffdocscomposite empoff) {
		this.empoff = empoff;
	}

	public void setEofdIdtyId(int eofdIdtyId) {
		this.eofdIdtyId = eofdIdtyId;
	}

}
