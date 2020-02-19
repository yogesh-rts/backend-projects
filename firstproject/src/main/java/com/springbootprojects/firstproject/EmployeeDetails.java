package com.springbootprojects.firstproject;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;





@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;
	private String eName;
	private int eAge;
	private double eSalary;
	private String eAddress;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="employeeDetails", cascade = CascadeType.ALL)
	private Set<CompanyDetails> companyDetails;
	
	public Set<CompanyDetails> getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(Set<CompanyDetails> companyDetails) {
		this.companyDetails = companyDetails;
	}

	public int geteId() {
		return eId;
	}
	
	public void seteId(int eId) {
		this.eId = eId;
	}
	
	public String geteName() {
		return eName;
	}
	
	public void seteName(String eName) {
		this.eName = eName;
	}
	
	public int geteAge() {
		return eAge;
	}
	
	public void seteAge(int eAge) {
		this.eAge = eAge;
	}
	
	public double geteSalary() {
		return eSalary;
	}
	
	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}
	
	public String geteAddress() {
		return eAddress;
	}
	
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [eId=" + eId + ", eName=" + eName + ", eAge=" + eAge + ", eSalary=" + eSalary
				+ ", eAddress=" + eAddress + "]";
	}
	
	
}
