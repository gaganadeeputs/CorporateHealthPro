package org.gagan.sap.messanger.service;

import java.util.List;

import org.gagan.sap.messanger.database.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class SecurityService {

	@SuppressWarnings("unchecked")
	public static boolean isValidAPIKey(String apiKey){
		Session session=HibernateUtil.getSessionFactory().openSession();
		String hqlQuery = "SELECT u.apiKey FROM  User u";
		Query query = session.createQuery(hqlQuery);
		List<String> results = query.list();
		return results.contains(apiKey);
	}
}
