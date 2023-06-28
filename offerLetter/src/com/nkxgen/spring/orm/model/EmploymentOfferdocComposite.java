package com.nkxgen.spring.orm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmploymentOfferdocComposite implements Serializable {

	@Column(name = "eofd_id", insertable = false, updatable = false)
	private int offerid;

	@Column(name = "eofd_docindex")
	private int documentIndex;

	public int getOfferid() {
		return offerid;
	}

	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}

	public int getDocumentIndex() {
		return documentIndex;
	}

	public void setDocumentIndex(int documentIndex) {
		this.documentIndex = documentIndex;
	}

}
