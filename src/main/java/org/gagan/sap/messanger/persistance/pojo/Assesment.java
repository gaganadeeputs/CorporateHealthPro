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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ASSESSMENT")
public class Assesment implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2853383278246531868L;
	private int id;
	private String name;
	private int versionId;
	private boolean deleteFl;
	private List<AssesmentQuestion> assesmentQuestions=new ArrayList<>();

	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	@Column(name = "ASSESMENT_TYPE")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="assesment")
	public List<AssesmentQuestion> getAssesmentQuestions() {
		return assesmentQuestions;
	}

	public void setAssesmentQuestions(List<AssesmentQuestion> assesmentQuestions) {
		this.assesmentQuestions = assesmentQuestions;
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
