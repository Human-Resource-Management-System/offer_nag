package com.nkxgen.spring.orm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class empoffdocscomposite implements Serializable {

	public int getEofrId() {
		return eofrId;
	}

	public void setEofrId(int eofrId) {
		this.eofrId = eofrId;
	}

	public int getEofdDocIndex() {
		return eofdDocIndex;
	}

	public void setEofdDocIndex(int eofdDocIndex) {
		this.eofdDocIndex = eofdDocIndex;
	}

	@Column(name = "eofd_id")
	private int eofrId;

	@Column(name = "eofd_docindex")
	private int eofdDocIndex;

}
