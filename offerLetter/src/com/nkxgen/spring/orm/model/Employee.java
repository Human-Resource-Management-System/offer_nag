
package com.nkxgen.spring.orm.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "hrms_employees")
public class Employee {

	@Id
	private Integer empl_id;
	private String empl_frstname;
	private String empl_lastname;
	private String empl_surname;
	private Integer empl_rmanager_empl_id;// reporting manager
	private Integer empl_hr_empl_id;// concerned HR
	private String empl_jbgr_id;
	private String empl_photo; // image
	private Date empl_jondate; // date
	private Date empl_dob;// date
	private String empl_designation;//

	private String empl_offemail;//
	private String empl_pemail;// v(60)
	private Long empl_mobile;// int(11)
	private String empl_alemail;// v(60)
	private String empl_bloodgroup;// v(10)
	private String empl_gender;// c(1)
	private String empl_address;// v(255)
	private String empl_fname;// v(100) //father name
	private Date empl_luudate;// datetime
	private String empl_luuser;// int

	public Employee() {
	}

	public Employee(Integer empl_id, String empl_frstname, String empl_lastname, String empl_surname,
			Integer empl_rmanager_empl_id, Integer empl_hr_empl_id, String empl_jbgr_id, String empl_photo,
			Date empl_jondate, Date empl_dob, String empl_designation, String empl_offemail, String empl_pemail,
			Long empl_mobile, String empl_altemail, String empl_bloodgroup, String empl_gender, String empl_address,
			String empl_fname, Date empl_luudate, String empl_luuser) {
		this.empl_id = empl_id;
		this.empl_frstname = empl_frstname;
		this.empl_lastname = empl_lastname;
		this.empl_surname = empl_surname;
		this.empl_rmanager_empl_id = empl_rmanager_empl_id;
		this.empl_hr_empl_id = empl_hr_empl_id;
		this.empl_jbgr_id = empl_jbgr_id;
		this.empl_photo = empl_photo;
		this.empl_jondate = empl_jondate;
		this.empl_dob = empl_dob;
		this.empl_designation = empl_designation;
		this.empl_offemail = empl_offemail;
		this.empl_pemail = empl_pemail;
		this.empl_mobile = empl_mobile;
		this.empl_alemail = empl_altemail;
		this.empl_bloodgroup = empl_bloodgroup;
		this.empl_gender = empl_gender;
		this.empl_address = empl_address;
		this.empl_fname = empl_fname;
		this.empl_luudate = empl_luudate;
		this.empl_luuser = empl_luuser;
	}

	public Integer getEmpl_id() {
		return empl_id;
	}

	public void setEmpl_id(Integer empl_id) {
		this.empl_id = empl_id;
	}

	public String getEmpl_frstname() {
		return empl_frstname;
	}

	public void setEmpl_frstname(String empl_frstname) {
		this.empl_frstname = empl_frstname;
	}

	public String getEmpl_lastname() {
		return empl_lastname;
	}

	public void setEmpl_lastname(String empl_lastname) {
		this.empl_lastname = empl_lastname;
	}

	public String getEmpl_surname() {
		return empl_surname;
	}

	public void setEmpl_surname(String empl_surname) {
		this.empl_surname = empl_surname;
	}

	public Integer getEmpl_rmanager_empl_id() {
		return empl_rmanager_empl_id;
	}

	public void setEmpl_rmanager_empl_id(Integer empl_rmanager_empl_id) {
		this.empl_rmanager_empl_id = empl_rmanager_empl_id;
	}

	public Integer getEmpl_hr_empl_id() {
		return empl_hr_empl_id;
	}

	public void setEmpl_hr_empl_id(Integer empl_hr_empl_id) {
		this.empl_hr_empl_id = empl_hr_empl_id;
	}

	public String getEmpl_jbgr_id() {
		return empl_jbgr_id;
	}

	public void setEmpl_jbgr_id(String empl_jbgr_id) {
		this.empl_jbgr_id = empl_jbgr_id;
	}

	public String getEmpl_photo() {
		return empl_photo;
	}

	public void setEmpl_photo(String empl_photo) {
		this.empl_photo = empl_photo;
	}

	public Date getEmpl_jondate() {
		return empl_jondate;
	}

	public void setEmpl_jondate(Date empl_jondate) {
		this.empl_jondate = empl_jondate;
	}

	public Date getEmpl_dob() {
		return empl_dob;
	}

	public void setEmpl_dob(Date empl_dob) {
		this.empl_dob = empl_dob;
	}

	public String getEmpl_designation() {
		return empl_designation;
	}

	public void setEmpl_designation(String empl_designation) {
		this.empl_designation = empl_designation;
	}

	public String getEmpl_offemail() {
		return empl_offemail;
	}

	public void setEmpl_offemail(String empl_offemail) {
		this.empl_offemail = empl_offemail;
	}

	public String getEmpl_pemail() {
		return empl_pemail;
	}

	public void setEmpl_pemail(String empl_pemail) {
		this.empl_pemail = empl_pemail;
	}

	public Long getEmpl_mobile() {
		return empl_mobile;
	}

	public void setEmpl_mobile(Long empl_mobile) {
		this.empl_mobile = empl_mobile;
	}

	public String getEmpl_altemail() {
		return empl_alemail;
	}

	public void setEmpl_altemail(String empl_altemail) {
		this.empl_alemail = empl_altemail;
	}

	public String getEmpl_bloodgroup() {
		return empl_bloodgroup;
	}

	public void setEmpl_bloodgroup(String empl_bloodgroup) {
		this.empl_bloodgroup = empl_bloodgroup;
	}

	public String getEmpl_gender() {
		return empl_gender;
	}

	public void setEmpl_gender(String empl_gender) {
		this.empl_gender = empl_gender;
	}

	public String getEmpl_address() {
		return empl_address;
	}

	public void setEmpl_address(String empl_address) {
		this.empl_address = empl_address;
	}

	public String getEmpl_fname() {
		return empl_fname;
	}

	public void setEmpl_fname(String empl_fname) {
		this.empl_fname = empl_fname;
	}

	public Date getEmpl_luudate() {
		return empl_luudate;
	}

	public void setEmpl_luudate(Date empl_luudate) {
		this.empl_luudate = empl_luudate;
	}

	public String getEmpl_luuser() {
		return empl_luuser;
	}

	public void setEmpl_luuser(String empl_luuser) {
		this.empl_luuser = empl_luuser;
	}

	@Override
	public String toString() {
		return "Employee{" + "empl_id=" + empl_id + ", empl_frstname='" + empl_frstname + '\'' + ", empl_lastname='"
				+ empl_lastname + '\'' + ", empl_surname='" + empl_surname + '\'' + ", empl_rmanager_empl_id="
				+ empl_rmanager_empl_id + ", empl_hr_empl_id=" + empl_hr_empl_id + ", empl_jbgr_id=" + empl_jbgr_id
				+ ", empl_photo='" + empl_photo + '\'' + ", empl_jondate=" + empl_jondate + ", empl_dob=" + empl_dob
				+ ", empl_designation='" + empl_designation + '\'' + ", empl_offemail='" + empl_offemail + '\''
				+ ", empl_pemail='" + empl_pemail + '\'' + ", empl_mobile=" + empl_mobile + ", empl_altemail='"
				+ empl_alemail + '\'' + ", empl_bloodgroup='" + empl_bloodgroup + '\'' + ", empl_gender='" + empl_gender
				+ '\'' + ", empl_address='" + empl_address + '\'' + ", empl_fname='" + empl_fname + '\''
				+ ", empl_luudate=" + empl_luudate + ", empl_luuser='" + empl_luuser + '\'' + '}';

	}

}
