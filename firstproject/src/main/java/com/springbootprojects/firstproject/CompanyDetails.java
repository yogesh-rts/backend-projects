package com.springbootprojects.firstproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "company_details")
public class CompanyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	//private int eId;
	private String department;
	private String jobTitle;
	
	@ManyToOne
	@JoinColumn(name = "e_id")
	@JsonBackReference 
	private EmployeeDetails employeeDetails;

	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}

	/*
	 * public int geteId() { return eId; } public void seteId(int eId) { this.eId =
	 * eId; }
	 */
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	/*
	 * @Override public String toString() { return "CompanyDetails [cId=" + cId +
	 * ", eId=" + eId + ", department=" + department + ", jobTitle=" + jobTitle +
	 * "]"; }
	 */
	
	
}
