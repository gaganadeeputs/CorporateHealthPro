package org.gagan.sap.messanger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gagan.sap.messanger.database.HibernateUtil;
import org.gagan.sap.messanger.exceptions.DataNotFoundException;
import org.gagan.sap.messanger.model.AssesmentDTO;
import org.gagan.sap.messanger.model.AssesmentQuestionChoiceDTO;
import org.gagan.sap.messanger.model.AssesmentQuestionDTO;
import org.gagan.sap.messanger.model.MedicalCampDetailDTO;
import org.gagan.sap.messanger.model.MedicalCampDetailQuestionAnswersDTO;
import org.gagan.sap.messanger.model.UserDTO;
import org.gagan.sap.messanger.persistance.pojo.Assesment;
import org.gagan.sap.messanger.persistance.pojo.AssesmentQuestion;
import org.gagan.sap.messanger.persistance.pojo.AssesmentQuestionChoice;
import org.gagan.sap.messanger.persistance.pojo.MedicalCamp;
import org.gagan.sap.messanger.persistance.pojo.MedicalCampDetail;
import org.gagan.sap.messanger.persistance.pojo.MedicalCampDetailQuestionAnswer;
import org.gagan.sap.messanger.persistance.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MedicalCampDetailService {

	public MedicalCampDetailDTO getMedicalCampDeatil(int medicalCampDetailId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MedicalCampDetail medicalCampDetail = getMedicalCompDetailObject(medicalCampDetailId, session);
		return constructMedicalCampDetailDTO(medicalCampDetail);
	}

	@SuppressWarnings("unchecked")
	public List<MedicalCampDetailDTO> getAllMedicalCampDetailsPaginated(int medicalCampId, int startIndex, int length) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(MedicalCampDetail.class);
		userCriteria.add(Restrictions.eq("deleteFl", false));
		userCriteria.add(Restrictions.eq("medicalCamp.id", medicalCampId));
		userCriteria.setFirstResult(startIndex);
		userCriteria.setMaxResults(length);
		List<MedicalCampDetail> medicalCampDetails = session.createCriteria(MedicalCampDetail.class).list();
		return constructMedicalCampDetailDTOList(medicalCampDetails);
	}

	@SuppressWarnings("unchecked")
	public List<MedicalCampDetailDTO> getAllMedicalCampDetails(int medicalCampId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(MedicalCampDetail.class);
		userCriteria.add(Restrictions.eq("deleteFl", false));
		userCriteria.add(Restrictions.eq("medicalCamp.id", medicalCampId));
		List<MedicalCampDetail> medicalCampDetails = session.createCriteria(MedicalCampDetail.class).list();
		return constructMedicalCampDetailDTOList(medicalCampDetails);
	}

	public MedicalCampDetailDTO createMedicalCampDetail(int medicalCampId, MedicalCampDetailDTO campDetailDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MedicalCampDetail medicalCampDetail = new MedicalCampDetail();
		setDataToMedicalCampDetail(medicalCampId, campDetailDTO, medicalCampDetail, session, false);
		try {
			session.beginTransaction();
			for (MedicalCampDetailQuestionAnswer questionAnswer : medicalCampDetail
					.getMedicalCampDetailQuestionAnswers()) {
				session.save(questionAnswer);
			}
			session.save(medicalCampDetail);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}
		return constructMedicalCampDetailDTO(medicalCampDetail);
	}

	public void updateMedicalCampDetail(int medicalCampDetailId, MedicalCampDetailDTO campDetailDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MedicalCampDetail medicalCampDetail = getMedicalCompDetailObject(medicalCampDetailId, session);
		setDataToMedicalCampDetail(medicalCampDetailId, campDetailDTO, medicalCampDetail, session, true);
		try {
			session.beginTransaction();
			session.saveOrUpdate(medicalCampDetail);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public void deleteMedicalCampDetail(int medicalCampDetailId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MedicalCampDetail medicalCampDetail = getMedicalCompDetailObject(medicalCampDetailId, session);
		try {
			session.beginTransaction();
			medicalCampDetail.setDeleteFl(true);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	@SuppressWarnings("unchecked")
	public MedicalCampDetail getMedicalCompDetailObject(int medicalCampDetailId, Session session) {
		Criteria medicalCampDetailCriteria = session.createCriteria(MedicalCampDetail.class);
		medicalCampDetailCriteria.add(Restrictions.eq("id", medicalCampDetailId));
		medicalCampDetailCriteria.add(Restrictions.eq("deleteFl", false));
		List<Object> medicalCampDetails = medicalCampDetailCriteria.list();
		if (medicalCampDetails == null || medicalCampDetails.isEmpty())
			throw new DataNotFoundException("Record with Id:" + medicalCampDetailId + " Not found");
		MedicalCampDetail medicalCampDetail = (MedicalCampDetail) medicalCampDetails.get(0);
		return medicalCampDetail;
	}

	private MedicalCampDetailDTO constructMedicalCampDetailDTO(MedicalCampDetail medicalCampDetail) {

		User user = medicalCampDetail.getUser();
		UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getPassword(),
				user.getApiKey(), user.getDateOfBirth(), user.getRole().getRoleName(), user.getGender().name(),
				user.getCreatedTime(),user.getLogoPath(),user.getSignaturePath());
		User doctor = medicalCampDetail.getDoctor();
		UserDTO doctorDTO = new UserDTO(doctor.getId(), doctor.getFirstName(), doctor.getLastName(),
				doctor.getPassword(), doctor.getApiKey(), doctor.getDateOfBirth(), doctor.getRole().getRoleName(),
				doctor.getGender().name(), doctor.getCreatedTime(),user.getLogoPath(),user.getSignaturePath());
		Assesment assessment = medicalCampDetail.getAssesement();
		AssesmentDTO assessmentDTO = new AssesmentDTO(assessment.getId(), assessment.getName());
		List<MedicalCampDetailQuestionAnswersDTO> medicalCampDetailQuestionAnswers = constructMedicalCampDetailQuestionAnswersDTOList(
				medicalCampDetail);
		MedicalCampDetailDTO medicalCampDetailDTO = new MedicalCampDetailDTO(medicalCampDetail.getId(), userDTO,
				doctorDTO, assessmentDTO, medicalCampDetail.getStatus(), medicalCampDetail.getDoctorComments(),
				medicalCampDetailQuestionAnswers);
		return medicalCampDetailDTO;
	}

	private List<MedicalCampDetailQuestionAnswersDTO> constructMedicalCampDetailQuestionAnswersDTOList(
			MedicalCampDetail medicalCampDetail) {
		List<MedicalCampDetailQuestionAnswersDTO> medicalCampDetailQuestionAnswersDTOList = new ArrayList<>();

		List<MedicalCampDetailQuestionAnswer> medicalCampDetailQuestionAnswers = medicalCampDetail
				.getMedicalCampDetailQuestionAnswers();

		Map<AssesmentQuestion, List<MedicalCampDetailQuestionAnswer>> questionToAnswersMap = getQuestionToAnswersMap(
				medicalCampDetailQuestionAnswers);
		AsssessmentQuestionService asssessmentQuestionService = new AsssessmentQuestionService();

		for (AssesmentQuestion question : questionToAnswersMap.keySet()) {
			List<MedicalCampDetailQuestionAnswer> answers = questionToAnswersMap.get(question);
			List<AssesmentQuestionChoiceDTO> assesmentQuestionChoiceDTOList = new ArrayList<>();
			List<AssesmentQuestionChoice> choices = question.getChoices();
			List<AssesmentQuestionChoiceDTO> choiceDTOList = asssessmentQuestionService
					.constructAssesmentQuestionChoiceDTOList(choices);
			AssesmentQuestionDTO assesmentQuestionDTO = new AssesmentQuestionDTO(question.getId(),
					question.getQuestion(), question.getQuestionType(), choiceDTOList);
			String freeAnswer = null;
			for (MedicalCampDetailQuestionAnswer medicalCampDetailQuestionAnswer : answers) {
				freeAnswer = medicalCampDetailQuestionAnswer.getAnswer();
				if (medicalCampDetailQuestionAnswer.getChoice() != null) {
					assesmentQuestionChoiceDTOList
							.add(new AssesmentQuestionChoiceDTO(medicalCampDetailQuestionAnswer.getChoice().getId(),
									medicalCampDetailQuestionAnswer.getChoice().getValue(),
									medicalCampDetailQuestionAnswer.getChoice().getType()));
				}
			}
			medicalCampDetailQuestionAnswersDTOList.add(new MedicalCampDetailQuestionAnswersDTO(assesmentQuestionDTO,
					freeAnswer, assesmentQuestionChoiceDTOList));
		}

		return medicalCampDetailQuestionAnswersDTOList;
	}

	private List<MedicalCampDetailDTO> constructMedicalCampDetailDTOList(List<MedicalCampDetail> medicalCampDetails) {
		List<MedicalCampDetailDTO> medicalCampDTOList = new ArrayList<>();
		for (int index = 0; index < medicalCampDetails.size(); index++) {
			medicalCampDTOList.add(constructMedicalCampDetailDTO(medicalCampDetails.get(index)));
		}
		return medicalCampDTOList;
	}

	public Map<AssesmentQuestion, List<MedicalCampDetailQuestionAnswer>> getQuestionToAnswersMap(
			List<MedicalCampDetailQuestionAnswer> medicalCampDetailQuestionAnswers) {
		Map<AssesmentQuestion, List<MedicalCampDetailQuestionAnswer>> questionToAnswersMap = new HashMap<>();
		for (int index = 0; index < medicalCampDetailQuestionAnswers.size(); index++) {
			MedicalCampDetailQuestionAnswer medicalCampDetailQuestionAnswer = medicalCampDetailQuestionAnswers
					.get(index);
			AssesmentQuestion assesmentQuestion = medicalCampDetailQuestionAnswer.getQuestion();
			if (questionToAnswersMap.containsKey(assesmentQuestion)) {

				questionToAnswersMap.get(assesmentQuestion).add(medicalCampDetailQuestionAnswer);
			} else {
				List<MedicalCampDetailQuestionAnswer> questionswers = new ArrayList<>();
				questionswers.add(medicalCampDetailQuestionAnswer);
				questionToAnswersMap.put(assesmentQuestion, questionswers);
			}
		}
		return questionToAnswersMap;
	}

	private void setDataToMedicalCampDetail(int medicalCampId, MedicalCampDetailDTO campDetailDTO,
			MedicalCampDetail medicalCampDetail, Session session, boolean isUpdate) {

		medicalCampDetail.setStatus(campDetailDTO.getStatus());
		medicalCampDetail
				.setAssesement((Assesment) session.get(Assesment.class, campDetailDTO.getAssesement().getId()));
		medicalCampDetail.setUser((User) session.get(User.class, campDetailDTO.getUser().getUserId()));
		medicalCampDetail.setDoctor((User) session.get(User.class, campDetailDTO.getDoctor().getUserId()));
		medicalCampDetail.setDoctorComments(campDetailDTO.getDoctorComments());
		medicalCampDetail.setMedicalCamp((MedicalCamp) session.get(MedicalCamp.class, medicalCampId));
		List<MedicalCampDetailQuestionAnswer> medicalCampDetailQuestionAnswerList = new ArrayList<>();

		List<MedicalCampDetailQuestionAnswersDTO> questionAnswersDTOs = campDetailDTO
				.getMedicalCampDetailQuestionAnswers();
		for (MedicalCampDetailQuestionAnswersDTO questionAnswersDTO : questionAnswersDTOs) {
			AssesmentQuestion assesmentQuestion = (AssesmentQuestion) session.get(AssesmentQuestion.class,
					questionAnswersDTO.getQuestion().getId());
			if (isUpdate) {
				// delete the old records for the new medicalCampDetail id
				deleteOldRecords(campDetailDTO.getId(), session);
			}

			// if question has choices then for each choice create multiple
			// entries
			if (questionAnswersDTO.getChoices() != null && !questionAnswersDTO.getChoices().isEmpty()) {
				for (AssesmentQuestionChoiceDTO choiceDTO : questionAnswersDTO.getChoices()) {

					AssesmentQuestionChoice choice = (AssesmentQuestionChoice) session
							.get(AssesmentQuestionChoice.class, choiceDTO.getId());
					medicalCampDetailQuestionAnswerList.add(
							new MedicalCampDetailQuestionAnswer(choice, assesmentQuestion, medicalCampDetail, null));
				}
			}
			// else create a single object and add it to list since its a free
			// type question.
			else {

				medicalCampDetailQuestionAnswerList.add(new MedicalCampDetailQuestionAnswer(null, assesmentQuestion,
						medicalCampDetail, questionAnswersDTO.getAnswer()));
			}
		}
		medicalCampDetail.setMedicalCampDetailQuestionAnswers(medicalCampDetailQuestionAnswerList);

	}

	@SuppressWarnings("unchecked")
	private void deleteOldRecords(int medicalCampDetailId, Session session) {
		Criteria medicalCampDetailQuestionAnswerCreteria = session
				.createCriteria(MedicalCampDetailQuestionAnswer.class);
		medicalCampDetailQuestionAnswerCreteria.add(Restrictions.eq("campDetail.id", medicalCampDetailId));

		List<MedicalCampDetailQuestionAnswer> medicalCampDetails = session
				.createCriteria(MedicalCampDetailQuestionAnswer.class).list();
		for (MedicalCampDetailQuestionAnswer medicalCampDetailQuestionAnswer : medicalCampDetails) {
			session.delete(medicalCampDetailQuestionAnswer);
		}

	}

	@SuppressWarnings("unchecked")
	public MedicalCampDetailDTO getMedicalCampDetailForCampIdAndUserId(int campId, int userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria medicalCampDetailCriteria = session.createCriteria(MedicalCampDetail.class);
		medicalCampDetailCriteria.add(Restrictions.eq("user.id", userId));
		medicalCampDetailCriteria.add(Restrictions.eq("medicalCamp.id", campId));
		medicalCampDetailCriteria.add(Restrictions.eq("deleteFl", false));
		List<Object> medicalCampDetails = medicalCampDetailCriteria.list();
		if (medicalCampDetails == null || medicalCampDetails.isEmpty())
			throw new DataNotFoundException("Record for user with Id:" + userId + " Not found");
		MedicalCampDetail medicalCampDetail = (MedicalCampDetail) medicalCampDetails.get(0);
		return constructMedicalCampDetailDTO(medicalCampDetail);
	}

}
