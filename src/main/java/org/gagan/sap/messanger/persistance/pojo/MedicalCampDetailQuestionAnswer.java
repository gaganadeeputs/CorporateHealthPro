package org.gagan.sap.messanger.persistance.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICAL_CAMP_DETAIL_Q_A")
public class MedicalCampDetailQuestionAnswer implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1957728360314424421L;

	public MedicalCampDetailQuestionAnswer()
	{
	
	}
	public MedicalCampDetailQuestionAnswer(AssesmentQuestionChoice choice, AssesmentQuestion question,
			MedicalCampDetail campDetail, String answer) {
		super();
		this.choice = choice;
		this.question = question;
		this.campDetail = campDetail;
		this.answer = answer;
	}

	private int id;
	private AssesmentQuestionChoice choice;
	private AssesmentQuestion question;
	private MedicalCampDetail campDetail;
	private String answer;
	private int versionId;
	private boolean deleteFl;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ANSWER")
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "QUESTION_ID")
	public AssesmentQuestion getQuestion() {
		return question;
	}

	public void setQuestion(AssesmentQuestion question) {
		this.question = question;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CHOICE_ID")
	public AssesmentQuestionChoice getChoice() {
		return choice;
	}

	public void setChoice(AssesmentQuestionChoice choice) {
		this.choice = choice;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CAMP_DETAIL_ID")
	public MedicalCampDetail getCampDetail() {
		return campDetail;
	}

	public void setCampDetail(MedicalCampDetail campDetail) {
		this.campDetail = campDetail;
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
