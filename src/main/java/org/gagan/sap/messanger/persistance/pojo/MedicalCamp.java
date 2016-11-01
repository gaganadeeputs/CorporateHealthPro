package org.gagan.sap.messanger.persistance.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "MEDICAL_CAMP")
public class MedicalCamp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 995162966168242336L;
	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	private int versionId;
	private boolean deleteFl;
	private Company company;
	private List<MedicalCampDetail> medicalCampDetails=new ArrayList<>();
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

	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	

	@OneToMany(mappedBy = "medicalCamp")
	public List<MedicalCampDetail> getMedicalCampDetails() {
		return medicalCampDetails;
	}

	public void setMedicalCampDetails(List<MedicalCampDetail> medicalCampDetails) {
		this.medicalCampDetails = medicalCampDetails;
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
	
	public MedicalCamp()
	{
		
	}

	public MedicalCamp(String name, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}


}
