package org.gagan.sap.messanger.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CompanyDTO {

	private int id;
	private String name;
	private String branchName;
	private String aboutCompany;
	private String representativeName;
	private String companyLogoPath;
	private String hrLogoPath;
	private String hrSignaturePath;
	private AddressDTO address;
	private List<MedicalCampDTO> medicalCamps = new ArrayList<>();
	
	public CompanyDTO(){
		
	}
	
	public CompanyDTO(int id, String name, String branchName, String aboutCompany, String representativeName,String companyLogoPath,
			String hrLogoPath,String hrSignaturePath,AddressDTO address, List<MedicalCampDTO> medicalCamps) {
		super();
		this.id = id;
		this.name = name;
		this.branchName = branchName;
		this.aboutCompany = aboutCompany;
		this.representativeName = representativeName;
		this.address = address;
		this.medicalCamps = medicalCamps;
		this.companyLogoPath=companyLogoPath;
		this.hrLogoPath=hrLogoPath;
		this.hrSignaturePath=hrSignaturePath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAboutCompany() {
		return aboutCompany;
	}
	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}
	public String getRepresentativeName() {
		return representativeName;
	}
	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public List<MedicalCampDTO> getMedicalCamps() {
		return medicalCamps;
	}
	public void setMedicalCamps(List<MedicalCampDTO> medicalCamps) {
		this.medicalCamps = medicalCamps;
	}

	public String getCompanyLogoPath() {
		return companyLogoPath;
	}

	public void setCompanyLogoPath(String companyLogoPath) {
		this.companyLogoPath = companyLogoPath;
	}

	public String getHrLogoPath() {
		return hrLogoPath;
	}

	public void setHrLogoPath(String hrLogoPath) {
		this.hrLogoPath = hrLogoPath;
	}

	public String getHrSignaturePath() {
		return hrSignaturePath;
	}

	public void setHrSignaturePath(String hrSignaturePath) {
		this.hrSignaturePath = hrSignaturePath;
	}


	
	
}
