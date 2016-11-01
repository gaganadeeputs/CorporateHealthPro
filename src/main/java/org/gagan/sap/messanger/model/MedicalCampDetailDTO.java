package org.gagan.sap.messanger.model;

import java.util.ArrayList;
import java.util.List;

import org.gagan.sap.messanger.persistance.pojo.Status;

public class MedicalCampDetailDTO {

	private int id;
	private UserDTO user;
	private UserDTO doctor;
	private AssesmentDTO assesement;
	private Status status;
	private String doctorComments;
	private List<MedicalCampDetailQuestionAnswersDTO> medicalCampDetailQuestionAnswers = new ArrayList<>();

	public MedicalCampDetailDTO() {

	}

	public MedicalCampDetailDTO(int id, UserDTO user, UserDTO doctor, AssesmentDTO assesement, Status status,
			String doctorComments, List<MedicalCampDetailQuestionAnswersDTO> medicalCampDetailQuestionAnswers) {
		super();
		this.id = id;
		this.user = user;
		this.doctor = doctor;
		this.assesement = assesement;
		this.status = status;
		this.doctorComments = doctorComments;
		this.medicalCampDetailQuestionAnswers = medicalCampDetailQuestionAnswers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public UserDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(UserDTO doctor) {
		this.doctor = doctor;
	}

	public AssesmentDTO getAssesement() {
		return assesement;
	}

	public void setAssesement(AssesmentDTO assesement) {
		this.assesement = assesement;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDoctorComments() {
		return doctorComments;
	}

	public void setDoctorComments(String doctorComments) {
		this.doctorComments = doctorComments;
	}

	public List<MedicalCampDetailQuestionAnswersDTO> getMedicalCampDetailQuestionAnswers() {
		return medicalCampDetailQuestionAnswers;
	}

	public void setMedicalCampDetailQuestionAnswers(
			List<MedicalCampDetailQuestionAnswersDTO> medicalCampDetailQuestionAnswers) {
		this.medicalCampDetailQuestionAnswers = medicalCampDetailQuestionAnswers;
	}
}
