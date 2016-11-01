package org.gagan.sap.messanger.service;

import java.util.ArrayList;
import java.util.List;

import org.gagan.sap.messanger.database.HibernateUtil;
import org.gagan.sap.messanger.exceptions.DataNotFoundException;
import org.gagan.sap.messanger.model.AddressDTO;
import org.gagan.sap.messanger.model.CompanyDTO;
import org.gagan.sap.messanger.persistance.pojo.Address;
import org.gagan.sap.messanger.persistance.pojo.Company;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class CompanyService {

	@SuppressWarnings("unchecked")
	public List<CompanyDTO> getALlCompanies() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Company cmp where cmp.deleteFl = false");
		List<Company> companies = query.list();
		return constructCompanyDTOList(companies);
	}

	@SuppressWarnings("unchecked")
	public List<CompanyDTO> getCompaniesPaginated(int startIndex, int lenght) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Company cmpy where cmpy.deleteFl = false");
		query.setFirstResult(startIndex);
		query.setMaxResults(lenght);
		List<Company> companies = query.list();
		return constructCompanyDTOList(companies);
	}

	public CompanyDTO getCompany(int companyId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Company company = (Company) session.get(Company.class, companyId);
		return constructCompanyDTO(company);

	}

	public CompanyDTO addCompany(CompanyDTO company) {
		Company newCompany = new Company();
		setCompanyData(company, newCompany);
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(newCompany);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return company;

	}

	public void updateCompany(int companyId, CompanyDTO company) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Company existingCompany = (Company) session.get(Company.class, companyId);
		if (existingCompany == null)
			throw new DataNotFoundException("Company with Id:" + companyId + " Not found");
		try {
			session.beginTransaction();
			setCompanyData(company, existingCompany);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	public void deleteCompany(int companyId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Company company = (Company) session.get(Company.class, companyId);
		if (company == null)
			throw new DataNotFoundException("Company with Id:" + companyId + " Not found");
		try {
			session.beginTransaction();
			company.setDeleteFl(true);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

	}

	public List<CompanyDTO> constructCompanyDTOList(List<Company> companies) {
		List<CompanyDTO> companyDTOs = new ArrayList<>();
		for (Company company : companies) {
			companyDTOs.add(constructCompanyDTO(company));
		}
		return companyDTOs;
	}

	public CompanyDTO constructCompanyDTO(Company company) {
		return new CompanyDTO(company.getId(), company.getName(), company.getBranchName(), company.getAboutCompany(),
				company.getRepresentativeName(),company.getCompanyLogoPath(),company.getHrLogoPath(),company.getHrSignaturePath(),
				new AddressDTO(company.getAddress().getAddress(), company.getAddress().getPincode()), null);
	}

	public void setCompanyData(CompanyDTO companyDTO, Company company) {
		company.setAboutCompany(companyDTO.getAboutCompany());
		company.setRepresentativeName(companyDTO.getRepresentativeName());
		company.setAddress(new Address(companyDTO.getAddress().getAddress(), companyDTO.getAddress().getPincode()));
		company.setBranchName(companyDTO.getBranchName());
	}

	@SuppressWarnings("unchecked")
	public List<CompanyDTO> getAllCompaniesWithMatchingName(String companyName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 Criteria companyNameCriteria=session.createCriteria(Company.class);
		companyNameCriteria.add(Restrictions.ilike("name", companyName,MatchMode.ANYWHERE));
		List<Company> companies=companyNameCriteria.list();
		return constructCompanyDTOList(companies);

	}

	public Long getCompaniesCount() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return  (Long) session.createQuery("select count(*) from Company cmp where cmp.deleteFl=false").uniqueResult();
	}



	public void setImageLocationsForCompanyId(int companyId, String companyLogoLocation, String hrLogoLocation,
			String hrSignatureLocation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Company existingCompany = (Company) session.get(Company.class, companyId);
		if (existingCompany == null)
			throw new DataNotFoundException("Company with Id:" + companyId + " Not found");
		try {
			session.beginTransaction();
			existingCompany.setCompanyLogoPath(companyLogoLocation);
			existingCompany.setHrLogoPath(hrLogoLocation);
			existingCompany.setHrLogoPath(hrSignatureLocation);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
