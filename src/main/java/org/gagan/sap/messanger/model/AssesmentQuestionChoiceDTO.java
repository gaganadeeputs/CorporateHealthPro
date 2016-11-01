package org.gagan.sap.messanger.model;

public class AssesmentQuestionChoiceDTO {

	private int id;
	private String value;
	private String type;

	public AssesmentQuestionChoiceDTO() {

	}

	public AssesmentQuestionChoiceDTO(int id, String value, String type) {
		super();
		this.id = id;
		this.value = value;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
