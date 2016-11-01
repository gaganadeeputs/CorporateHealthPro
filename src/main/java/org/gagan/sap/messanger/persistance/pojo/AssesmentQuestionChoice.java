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
import javax.persistence.Table;
@Entity
@Table(name = "ASSESSMENT_QUESTION_CHOICE")
public class AssesmentQuestionChoice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3243486158542300908L;
	private int id;
	private AssesmentQuestion assesementQuestion;
	private String value;
	private String type;
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

	@Column(name = "CHOICE_VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

	@Column(name = "CHOICE_TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ASSESSMENT_QUESTION_ID")
	public AssesmentQuestion getAssesementQuestion() {
		return assesementQuestion;
	}

	public void setAssesementQuestion(AssesmentQuestion assesementQuestion) {
		this.assesementQuestion = assesementQuestion;
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
