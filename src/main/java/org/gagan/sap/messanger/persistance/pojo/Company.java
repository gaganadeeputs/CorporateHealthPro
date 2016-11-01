package org.gagan.sap.messanger.persistance.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515559320082470998L;
	private int id;
	private String name;
	private String branchName;
	private String aboutCompany;
	private String representativeName;
	private String companyLogoPath;
	private String hrLogoPath;
	private String hrSignaturePath;
	private Address address;
	private int versionId;
	private boolean deleteFl;
	private List<MedicalCamp> medicalCamps = new ArrayList<>();

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "BRANCH_NAME")
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column(name = "ABOUT_COMPANY")
	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	@Column(name = "REPRESENTATIVE_NAME")
	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

	@Column(name = "COMPANY_LOGO_PATH")
	public String getCompanyLogoPath() {
		return companyLogoPath;
	}

	public void setCompanyLogoPath(String companyLogoPath) {
		this.companyLogoPath = companyLogoPath;
	}

	@Column(name = "HR_LOGO_PATH")
	public String getHrLogoPath() {
		return hrLogoPath;
	}

	public void setHrLogoPath(String hrLogoPath) {
		this.hrLogoPath = hrLogoPath;
	}

	@Column(name = "HR_SIGNATURE_PATH")
	public String getHrSignaturePath() {
		return hrSignaturePath;
	}

	public void setHrSignaturePath(String hrSignaturePath) {
		this.hrSignaturePath = hrSignaturePath;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
	public List<MedicalCamp> getMedicalCamps() {
		return medicalCamps;
	}

	public void setMedicalCamps(List<MedicalCamp> medicalCamps) {
		this.medicalCamps = medicalCamps;
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

}
