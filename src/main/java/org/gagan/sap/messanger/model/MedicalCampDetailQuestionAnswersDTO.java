package org.gagan.sap.messanger.model;

import java.util.List;

public class MedicalCampDetailQuestionAnswersDTO {


	private AssesmentQuestionDTO question;
	private String answer;
	private List<AssesmentQuestionChoiceDTO> choices;

	public MedicalCampDetailQuestionAnswersDTO() {

	}

	public MedicalCampDetailQuestionAnswersDTO( AssesmentQuestionDTO question, String answer,
			List<AssesmentQuestionChoiceDTO> choices) {
		super();
		this.question = question;
		this.answer = answer;
		this.choices = choices;
	}

	public AssesmentQuestionDTO getQuestion() {
		return question;
	}

	public void setQuestion(AssesmentQuestionDTO question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<AssesmentQuestionChoiceDTO> getChoices() {
		return choices;
	}

	public void setChoices(List<AssesmentQuestionChoiceDTO> choice) {
		this.choices = choice;
	}

}
