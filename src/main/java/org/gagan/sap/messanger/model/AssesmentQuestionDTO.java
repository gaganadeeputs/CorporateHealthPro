package org.gagan.sap.messanger.model;

import java.util.ArrayList;
import java.util.List;

public class AssesmentQuestionDTO {

	private int id;
	private String question;
	private String questionType;
	private List<AssesmentQuestionChoiceDTO> choices = new ArrayList<>();
	
	
	public AssesmentQuestionDTO()
	{
		
	}

	public AssesmentQuestionDTO(int id, String question, String questionType, 
			List<AssesmentQuestionChoiceDTO> choices) {
		super();
		this.id = id;
		this.question = question;
		this.questionType = questionType;
		this.choices = choices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}


	public List<AssesmentQuestionChoiceDTO> getChoices() {
		return choices;
	}

	public void setChoices(List<AssesmentQuestionChoiceDTO> choices) {
		this.choices = choices;
	}

}
