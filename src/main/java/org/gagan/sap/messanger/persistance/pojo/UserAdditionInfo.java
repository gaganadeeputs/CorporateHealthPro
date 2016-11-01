package org.gagan.sap.messanger.persistance.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "USER_ADDITIONAL_INFO")
public class UserAdditionInfo implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 4398164962885276458L;
	private int Id;
    private String emailId;
    private String mobileNo;
    private String designation;
    private BloodGroup bloodGroup;
    private Company company;
	private Address address;
	private int versionId;
	private boolean deleteFl;
    
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "EMAIL_ID")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "MOBILE_NO")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "DESIGNATION")
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "BLOOD_GROUP")
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
     

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COMPANY_ID")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	@Column(name = "VERSION_ID")
	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	@Column(name = "DELETE_FL")
	public boolean getDeleteFl() {
		return deleteFl;
	}

	public void setDeleteFl(boolean isDelete) {
		this.deleteFl = isDelete;
	}
	
	public UserAdditionInfo()
	{
		
	}

	public UserAdditionInfo(String emailId, String mobileNo, String designation, BloodGroup bloodGroup, Company company,
			Address address) {
		super();
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.designation = designation;
		this.bloodGroup = bloodGroup;
		this.company = company;
		this.address = address;
	}

}
