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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "ASSESSMENT_QUESTION")
public class AssesmentQuestion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -950937470098903780L;
	private int id;
	private String question;
	private String questionType;
	private Assesment assesment;
	private int versionId;
	private boolean deleteFl;
	private List<AssesmentQuestionChoice> choices=new ArrayList<>();

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	@Column(name = "QUESTION")
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	@Column(name = "QUESTION_TYPE")
	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@ManyToOne
	@JoinColumn(name="ASSESSMENT_ID")
	public Assesment getAssesment() {
		return assesment;
	}

	public void setAssesment(Assesment assesment) {
		this.assesment = assesment;
	}


	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="assesementQuestion")
	public List<AssesmentQuestionChoice> getChoices() {
		return choices;
	}

	public void setChoices(List<AssesmentQuestionChoice> choices) {
		this.choices = choices;
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
