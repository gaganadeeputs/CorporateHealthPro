package org.gagan.sap.messanger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gagan.sap.messanger.database.HibernateUtil;
import org.gagan.sap.messanger.database.util.StringUtil;
import org.gagan.sap.messanger.exceptions.DataNotFoundException;
import org.gagan.sap.messanger.model.AddressDTO;
import org.gagan.sap.messanger.model.CompanyDTO;
import org.gagan.sap.messanger.model.UserAdditionalInfoDTO;
import org.gagan.sap.messanger.model.UserDTO;
import org.gagan.sap.messanger.persistance.pojo.Address;
import org.gagan.sap.messanger.persistance.pojo.BloodGroup;
import org.gagan.sap.messanger.persistance.pojo.Company;
import org.gagan.sap.messanger.persistance.pojo.Gender;
import org.gagan.sap.messanger.persistance.pojo.User;
import org.gagan.sap.messanger.persistance.pojo.UserAdditionInfo;
import org.gagan.sap.messanger.persistance.pojo.UserRole;
import org.gagan.sap.messanger.persistance.pojo.UserType;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserService {

	public List<UserDTO> getAllUsers(String userType) {
		List<User> users = getUsersOfType(userType);
		return constructUserDTOList(users);
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> getAllUsersPaginated(int startIndex, int length, String userType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("deleteFl", false));
		userCriteria.add(Restrictions.eq("userType", getUserTypeFromString(userType)));
		userCriteria.setFirstResult(startIndex);
		userCriteria.setMaxResults(length);
		List<User> users = userCriteria.list();
		return constructUserDTOList(users);

	}

	@SuppressWarnings("unchecked")
	public UserDTO getUser(int userId, String userType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("id", userId));
		userCriteria.add(Restrictions.eq("userType", getUserTypeFromString(userType)));
		List<Object> users = userCriteria.list();
		if (users == null || users.isEmpty())
			throw new DataNotFoundException("User with Id:" + userId + " Not found");
		User user = (User) users.get(0);
		return constructUserDTO(user);

	}

	public UserDTO addUser(UserDTO userDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = new User();
		setDataToUser(userDTO, user, session);
		user.setUserAdditionInfo(getAdditionInfo(userDTO.getUserAdditionalInfo(), session));
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			closeSession(session);
		}
		return userDTO;
	}

	@SuppressWarnings("unchecked")
	public void updateUser(UserDTO userDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("id", userDTO.getUserId()));
		userCriteria.add(Restrictions.eq("deleteFl", false));
		userCriteria.add(Restrictions.eq("userType", getUserTypeFromString(userDTO.getUserType())));
		List<Object> users = userCriteria.list();
		if (users == null || users.isEmpty())
			throw new DataNotFoundException("User with Id:" + userDTO.getUserId() + " Not found");
		User existingUser = (User) users.get(0);
		setDataToUser(userDTO, existingUser, session);
		existingUser.setUserAdditionInfo(getAdditionInfo(userDTO.getUserAdditionalInfo(), session));
		try {
			session.beginTransaction();
			session.save(existingUser);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteUser(int userId, String userType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("id", userId));
		userCriteria.add(Restrictions.eq("userType", getUserTypeFromString(userType)));
		List<Object> users = userCriteria.list();
		if (users == null || users.isEmpty())
			throw new DataNotFoundException("User with Id:" + userId + " Not found");
		User user = (User) users.get(0);
		try {
			session.beginTransaction();
			user.setDeleteFl(true);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			closeSession(session);
		}

	}

	public void setDataToUser(UserDTO userDTO, User user, Session session) {
		user.setApiKey(userDTO.getFirstName());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setCreatedTime(new Date());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		user.setUserType(getUserTypeFromString(userDTO.getUserType()));
		user.setGender(Gender.valueOf(userDTO.getGender()));
		user.setRole(getRoleOfName(userDTO.getRoleName(), session));
		user.setCreatedTime(new Date());
	}

	@SuppressWarnings("unchecked")
	private UserRole getRoleOfName(String roleName, Session session) {
		Criteria userCriteria = session.createCriteria(UserRole.class);
		userCriteria.add(Restrictions.eq("roleName", roleName.toUpperCase()));
		userCriteria.add(Restrictions.eq("deleteFl", false));
		List<UserRole> userRoles = userCriteria.list();
		if (userRoles == null || userRoles.isEmpty())
			throw new DataNotFoundException("Role with Name:" + roleName + " Not found");
		return (UserRole) userRoles.get(0);
	}

	public void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

	private UserAdditionInfo getAdditionInfo(UserAdditionalInfoDTO userAdditionalInfoDTO, Session session) {
		Company company = null;
		if (userAdditionalInfoDTO.getCompany() != null) {
			company = (Company) session.get(Company.class, userAdditionalInfoDTO.getCompany().getId());
		}
		Address address = new Address(userAdditionalInfoDTO.getAddress().getAddress(),
				userAdditionalInfoDTO.getAddress().getPincode());
		return new UserAdditionInfo(userAdditionalInfoDTO.getEmailId(), userAdditionalInfoDTO.getMobileNo(),
				userAdditionalInfoDTO.getDesignation(), BloodGroup.valueOf(userAdditionalInfoDTO.getBloodGroup()),
				company, address);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsersOfType(String userType) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("deleteFl", false));
		userCriteria.add(Restrictions.eq("userType", getUserTypeFromString(userType)));
		List<User> users = userCriteria.list();
		return users;
	}

	public UserType getUserTypeFromString(String userType) {
		return UserType.valueOf(userType.toUpperCase());
	}

	public List<UserDTO> constructUserDTOList(List<User> users) {
		List<UserDTO> userDTOlist = new ArrayList<>();
		for (int index = 0; index < users.size(); index++) {
			User user = users.get(index);
			UserDTO userDTO = constructUserDTO(user);
			userDTOlist.add(userDTO);
		}
		return userDTOlist;
	}

	public UserDTO constructUserDTO(User user) {
		UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getPassword(),
				user.getApiKey(), user.getDateOfBirth(), user.getRole().getRoleName(), user.getGender().name(),
				user.getCreatedTime(), user.getLogoPath(), user.getSignaturePath());
		UserAdditionInfo additionalInfo = user.getUserAdditionInfo();
		Company company = additionalInfo.getCompany();
		AddressDTO addressDTO = new AddressDTO(additionalInfo.getAddress().getAddress(),
				additionalInfo.getAddress().getPincode());
		CompanyDTO companyDTO = null;
		if (company != null) {
			companyDTO = new CompanyDTO(company.getId(), company.getName(), company.getAboutCompany(),
					company.getBranchName(), company.getCompanyLogoPath(), company.getHrLogoPath(),
					company.getHrSignaturePath(), null, null, null);
		}
		userDTO.setUserAdditionalInfo(new UserAdditionalInfoDTO(additionalInfo.getEmailId(),
				additionalInfo.getMobileNo(), additionalInfo.getDesignation(), additionalInfo.getBloodGroup().name(),
				company.getId(), company.getName(), company.getBranchName(), addressDTO, companyDTO));
		return userDTO;
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> getAllUsersForCompany(int companyId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("deleteFl", false));
		userCriteria.add(Restrictions.eq("userAdditionInfo.company.id", companyId));
		List<User> users = userCriteria.list();
		return constructUserDTOList(users);
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> getAllUsersPaginatedForCompany(int companyId, int startIndex, int length) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("deleteFl", false));
		userCriteria.add(Restrictions.eq("userAdditionInfo.company.id", companyId));
		userCriteria.setFirstResult(startIndex);
		userCriteria.setMaxResults(length);
		List<User> users = userCriteria.list();
		return constructUserDTOList(users);
	}

	public Long getUsersCount() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Long) session.createQuery("select count(*) from User user where user.deleteFl=false").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> getMatchingUsers(String firstName, String lastName, String mobileNo, String emailId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("deleteFl", false));
		if (!StringUtil.isNullOrEmptyorBlankString(firstName))
			userCriteria.add(Restrictions.ilike("firstName", firstName));
		if (!StringUtil.isNullOrEmptyorBlankString(firstName))
			userCriteria.add(Restrictions.ilike("lastName", lastName));
		if (!StringUtil.isNullOrEmptyorBlankString(mobileNo))
			userCriteria.add(Restrictions.eq("userAdditionInfo.mobileNo", mobileNo));
		if (!StringUtil.isNullOrEmptyorBlankString(emailId))
			userCriteria.add(Restrictions.ilike("userAdditionInfo.emailId", emailId));
		List<User> users = userCriteria.list();
		return constructUserDTOList(users);
	}

	@SuppressWarnings("unchecked")
	public void setLocationsForUserId(int userId, String userLogoLocation, String userSignatureLocation) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria userCriteria = session.createCriteria(User.class);
		userCriteria.add(Restrictions.eq("id", userId));
		List<Object> users = userCriteria.list();
		if (users == null || users.isEmpty())
			throw new DataNotFoundException("User with Id:" + userId + " Not found");
		User existingUser = (User) users.get(0);
		try {
			session.beginTransaction();
			existingUser.setLogoPath(userLogoLocation);
			existingUser.setSignaturePath(userSignatureLocation);
			session.save(existingUser);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			closeSession(session);
		}

	}
}
