package org.gagan.sap.messanger.service;

import java.util.ArrayList;
import java.util.List;

import org.gagan.sap.messanger.database.HibernateUtil;
import org.gagan.sap.messanger.exceptions.DataNotFoundException;
import org.gagan.sap.messanger.model.MedicalCampDTO;
import org.gagan.sap.messanger.model.MedicalCampDetailCountByStatusDTO;
import org.gagan.sap.messanger.persistance.pojo.MedicalCamp;
import org.gagan.sap.messanger.persistance.pojo.Status;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MedicalCampService {

	public MedicalCampDTO createMedicalCamp(int companyId, MedicalCampDTO medicalCampDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MedicalCamp medicalCamp = new MedicalCamp();
		setMedicalCampData(medicalCamp, medicalCampDTO);
		try {
			session.beginTransaction();
			session.save(medicalCamp);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}
		return constructMedicalCampDTO(medicalCamp);
	}

	public void updateMedicalCamp(int medicalCampId, MedicalCampDTO medicalCampDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MedicalCamp medicalCamp = getMedicalCampObject(medicalCampId, session);
		setMedicalCampData(medicalCamp, medicalCampDTO);
		try {
			session.beginTransaction();
			session.save(medicalCamp);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	private void setMedicalCampData(MedicalCamp medicalCamp, MedicalCampDTO medicalCampDTO) {
		medicalCamp.setName(medicalCampDTO.getName());
		medicalCamp.setStartDate(medicalCampDTO.getStartDate());
		medicalCamp.setEndDate(medicalCampDTO.getEndDate());
	}

	public void deleteMedicalCamp(int medicalCampId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MedicalCamp medicalCamp = getMedicalCampObject(medicalCampId, session);
		try {
			session.beginTransaction();
			medicalCamp.setDeleteFl(true);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public MedicalCampDTO getMedicalCamp(int campId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MedicalCamp medicalCamp = getMedicalCampObject(campId, session);
		return constructMedicalCampDTO(medicalCamp);

	}

	@SuppressWarnings("unchecked")
	public MedicalCamp getMedicalCampObject(int campId, Session session) {

		Criteria medicalCampCriteria = session.createCriteria(MedicalCamp.class);
		medicalCampCriteria.add(Restrictions.eq("deleteFl", false));
		medicalCampCriteria.add(Restrictions.eq("id", campId));
		List<MedicalCamp> medicalCamps = medicalCampCriteria.list();
		if (medicalCamps == null || medicalCamps.isEmpty())
			throw new DataNotFoundException("Medical Camp with Id:" + campId + " Not found");
		MedicalCamp medicalCamp = (MedicalCamp) medicalCamps.get(0);
		return medicalCamp;
	}

	private MedicalCampDTO constructMedicalCampDTO(MedicalCamp medicalCamp) {
		return new MedicalCampDTO(medicalCamp.getId(), medicalCamp.getName(), medicalCamp.getStartDate(),
				medicalCamp.getEndDate());
	}

	@SuppressWarnings("unchecked")
	public List<MedicalCampDTO> getAllMedicalCampsForCompany(int companyId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria medicalCampCriteria = session.createCriteria(MedicalCamp.class);
		medicalCampCriteria.add(Restrictions.eq("deleteFl", false));
		medicalCampCriteria.add(Restrictions.eq("company.id", companyId));
		List<MedicalCamp> medicalCamps = medicalCampCriteria.list();
		return constructMedicalCampDTOList(medicalCamps);
	}

	private List<MedicalCampDTO> constructMedicalCampDTOList(List<MedicalCamp> medicalCamps) {
		List<MedicalCampDTO> medicalCampDTOList = new ArrayList<>();
		for (int index = 0; index < medicalCamps.size(); index++) {
			MedicalCamp medicalCamp = medicalCamps.get(index);
			medicalCampDTOList.add(constructMedicalCampDTO(medicalCamp));
		}
		return medicalCampDTOList;
	}

	@SuppressWarnings("unchecked")
	public List<MedicalCampDTO> getAllMedicalCampsPaginatedForCompany(int companyId, int start, int length) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria medicalCampCriteria = session.createCriteria(MedicalCamp.class);
		medicalCampCriteria.add(Restrictions.eq("deleteFl", false));
		medicalCampCriteria.add(Restrictions.eq("company.id", companyId));
		medicalCampCriteria.setFirstResult(start);
		medicalCampCriteria.setMaxResults(length);
		List<MedicalCamp> medicalCamps = medicalCampCriteria.list();
		return constructMedicalCampDTOList(medicalCamps);
	}

	@SuppressWarnings("unchecked")
	public List<MedicalCampDetailCountByStatusDTO> getMedicalCampConsolidatedReport(int campId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select count(*),mcd.status from MedicalCampDetail mcd where mcd.medicalCamp.id=:campId group by status";

		Query query = session.createQuery(hql);
		query.setParameter("campId", campId);
		List<Object[]> listResult = query.list();
		List<MedicalCampDetailCountByStatusDTO> campDetailCountByStatusDTOs = new ArrayList<>();

		for (Object[] aRow : listResult) {
			Long count = (Long) aRow[0];
			Status status = (Status) aRow[1];
			campDetailCountByStatusDTOs.add(new MedicalCampDetailCountByStatusDTO(count, status.name()));
		}

		return campDetailCountByStatusDTOs;
	}

}
