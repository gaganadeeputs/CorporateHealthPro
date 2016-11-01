package org.gagan.sap.messanger.service;

import java.util.ArrayList;
import java.util.List;

import org.gagan.sap.messanger.database.HibernateUtil;
import org.gagan.sap.messanger.model.AssesmentQuestionChoiceDTO;
import org.gagan.sap.messanger.model.AssesmentQuestionDTO;
import org.gagan.sap.messanger.persistance.pojo.AssesmentQuestion;
import org.gagan.sap.messanger.persistance.pojo.AssesmentQuestionChoice;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class AsssessmentQuestionService {

	@SuppressWarnings("unchecked")
	public List<AssesmentQuestionDTO> getAllQuestions(int assessmentId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria assesmentQuestionCriteria = session.createCriteria(AssesmentQuestion.class);
		assesmentQuestionCriteria.add(Restrictions.eq("deleteFl", false));
		assesmentQuestionCriteria.add(Restrictions.eq("assesment.id", assessmentId));
		List<AssesmentQuestion> assessments = assesmentQuestionCriteria.list();
		return constructAssessmentQuestionDTOList(assessments);
	}

	private List<AssesmentQuestionDTO> constructAssessmentQuestionDTOList(List<AssesmentQuestion> assessments) {
		List<AssesmentQuestionDTO> assesmentQuestionDTOList = new ArrayList<>();
		for (int index = 0; index < assessments.size(); index++) {
			AssesmentQuestion assessmentQuestion = assessments.get(index);
			assesmentQuestionDTOList.add(constrctAssesmentQuestionDTO(assessmentQuestion));
		}
		return assesmentQuestionDTOList;
	}

	private AssesmentQuestionDTO constrctAssesmentQuestionDTO(AssesmentQuestion assessmentQuestion) {
		List<AssesmentQuestionChoice> choices = assessmentQuestion.getChoices();
		List<AssesmentQuestionChoiceDTO> choiceDTOList = constructAssesmentQuestionChoiceDTOList(choices);
		return new AssesmentQuestionDTO(assessmentQuestion.getId(), assessmentQuestion.getQuestion(),
				assessmentQuestion.getQuestionType(), choiceDTOList);
	}

	public List<AssesmentQuestionChoiceDTO> constructAssesmentQuestionChoiceDTOList(
			List<AssesmentQuestionChoice> choices) {
		List<AssesmentQuestionChoiceDTO> choiceDTOList = new ArrayList<>();
		if(choices!=null){
		for (int index = 0; index < choices.size(); index++) {
			choiceDTOList.add(constructAssesmentQuestionChoiceDTO(choices.get(index)));
		}
		}
		return choiceDTOList;
	}

	private AssesmentQuestionChoiceDTO constructAssesmentQuestionChoiceDTO(
			AssesmentQuestionChoice assesmentQuestionChoice) {
		return new AssesmentQuestionChoiceDTO(assesmentQuestionChoice.getId(),assesmentQuestionChoice.getValue(),assesmentQuestionChoice.getType());
	}

}
