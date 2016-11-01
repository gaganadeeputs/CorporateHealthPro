package org.gagan.sap.messanger.persistance.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class MedicalCampDetailQuestion {
	private int id;
	private MedicalCampDetail medicalCampDetail;
	private AssesmentQuestion question;
	private List<MedicalCampDetailQuestionAnswer> medicalCampDetailQuestionAnswers=new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="MEDICAL_CAMP_DETAIL_ID")
	public MedicalCampDetail getMedicalCampDetail() {
		return medicalCampDetail;
	}

	public void setMedicalCampDetail(MedicalCampDetail medicalCampDetail) {
		this.medicalCampDetail = medicalCampDetail;
	}

	public AssesmentQuestion getQuestion() {
		return question;
	}

	public void setQuestion(AssesmentQuestion question) {
		this.question = question;
	}
	
	@OneToMany(mappedBy="question")
	public List<MedicalCampDetailQuestionAnswer> getMedicalCampDetailQuestionAnswers() {
		return medicalCampDetailQuestionAnswers;
	}

	public void setMedicalCampDetailQuestionAnswers(
			List<MedicalCampDetailQuestionAnswer> medicalCampDetailQuestionAnswers) {
		this.medicalCampDetailQuestionAnswers = medicalCampDetailQuestionAnswers;
	}

}
