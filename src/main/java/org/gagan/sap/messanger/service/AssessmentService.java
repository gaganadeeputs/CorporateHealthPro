package org.gagan.sap.messanger.service;

import java.util.ArrayList;
import java.util.List;

import org.gagan.sap.messanger.database.HibernateUtil;
import org.gagan.sap.messanger.exceptions.DataNotFoundException;
import org.gagan.sap.messanger.model.AssesmentDTO;
import org.gagan.sap.messanger.persistance.pojo.Assesment;
import org.gagan.sap.messanger.persistance.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class AssessmentService {
	@SuppressWarnings("unchecked")
	public AssesmentDTO getAssessment(int assessmentId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria assessmentCriteria = session.createCriteria(Assesment.class);
		assessmentCriteria.add(Restrictions.eq("id", assessmentId));
		assessmentCriteria.add(Restrictions.eq("deleteFl", false));
		List<Object> assessments = assessmentCriteria.list();
		if (assessments == null || assessments.isEmpty())
			throw new DataNotFoundException("Assessment with Id:" + assessmentId + " Not found");
		Assesment existingAssessment = (Assesment) assessments.get(0);
		return constructAssessmentDTO(existingAssessment);

	}

	public AssesmentDTO addAssessment(AssesmentDTO assessmentDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Assesment assesment = new Assesment();
		assesment.setName(assessmentDTO.getName());
		try {
			session.beginTransaction();
			session.save(assesment);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}
		return constructAssessmentDTO(assesment);
	}

	@SuppressWarnings("unchecked")
	public void updateAssessment(AssesmentDTO assesmentDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria assessmentCriteria = session.createCriteria(Assesment.class);
		assessmentCriteria.add(Restrictions.eq("id", assesmentDTO.getId()));
		assessmentCriteria.add(Restrictions.eq("deleteFl", false));
		List<Object> users = assessmentCriteria.list();
		if (users == null || users.isEmpty())
			throw new DataNotFoundException("Assessment with Id:" + assesmentDTO.getId() + " Not found");
		User existingUser = (User) users.get(0);
		try {
			session.beginTransaction();
			session.save(existingUser);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteAssessment(int assessmentId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria assessmentCriteria = session.createCriteria(Assesment.class);
		assessmentCriteria.add(Restrictions.eq("id", assessmentId));
		assessmentCriteria.add(Restrictions.eq("deleteFl", false));
		List<Object> assessments = assessmentCriteria.list();
		if (assessments == null || assessments.isEmpty())
			throw new DataNotFoundException("Assessment with Id:" + assessmentId + " Not found");
		Assesment assesment = (Assesment) assessments.get(0);
		try {
			session.beginTransaction();
			assesment.setDeleteFl(true);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	@SuppressWarnings("unchecked")
	public List<AssesmentDTO> getAllAssessments() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria assessmentCriteria = session.createCriteria(Assesment.class);
		assessmentCriteria.add(Restrictions.eq("deleteFl", false));
		List<Assesment> assessments = assessmentCriteria.list();
		return constructAssessmentDTOList(assessments);
	}

	private List<AssesmentDTO> constructAssessmentDTOList(List<Assesment> assessments) {
		List<AssesmentDTO> assessmentDTOlist = new ArrayList<>();
		for (int index = 0; index < assessments.size(); index++) {
			Assesment assessment = assessments.get(index);
			AssesmentDTO assesmentDTO = constructAssessmentDTO(assessment);
			assessmentDTOlist.add(assesmentDTO);
		}
		return assessmentDTOlist;
	}

	private AssesmentDTO constructAssessmentDTO(Assesment assessment) {
		return new AssesmentDTO(assessment.getId(), assessment.getName());
	}
}
