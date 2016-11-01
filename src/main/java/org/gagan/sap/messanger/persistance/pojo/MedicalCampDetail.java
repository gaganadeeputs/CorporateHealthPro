package org.gagan.sap.messanger.persistance.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "MEDICAL_CAMP_DETAIL")
public class MedicalCampDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 983812432086400805L;
	private int id;
	private MedicalCamp medicalCamp;
	private User user;
	private User doctor;
	private Assesment assesement;
	private Status status;
	private String doctorComments;
	private int versionId;
	private boolean deleteFl;
	private List<MedicalCampDetailQuestionAnswer> medicalCampDetailQuestionAnswers = new ArrayList<>();
    
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="MEDICAL_CAMP_ID")
	public MedicalCamp getMedicalCamp() {
		return medicalCamp;
	}

	public void setMedicalCamp(MedicalCamp medicalCamp) {
		this.medicalCamp = medicalCamp;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
  

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="DOCTOR_ID")
	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ASSESSMENT_ID")
	public Assesment getAssesement() {
		return assesement;
	}

	public void setAssesement(Assesment assesement) {
		this.assesement = assesement;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "COMMENTS_BY_DOCTOR")
	public String getDoctorComments() {
		return doctorComments;
	}

	public void setDoctorComments(String doctorComments) {
		this.doctorComments = doctorComments;
	}
  
	@OneToMany(cascade = CascadeType.ALL, mappedBy="campDetail")
	public List<MedicalCampDetailQuestionAnswer> getMedicalCampDetailQuestionAnswers() {
		return medicalCampDetailQuestionAnswers;
	}

	public void setMedicalCampDetailQuestionAnswers(List<MedicalCampDetailQuestionAnswer> medicalCampDetailQuestionAnswers) {
		this.medicalCampDetailQuestionAnswers = medicalCampDetailQuestionAnswers;
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
