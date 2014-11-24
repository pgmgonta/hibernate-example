package com.example;

import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Query;
import org.hibernate.Session;

import com.example.model.Item;
import com.example.model.User;
import com.example.util.HibernateUtil;

public class JAXBExample {
	
	public static void main(String... args) throws Exception {
		User user = findUser();
		JAXB.marshal(user, System.out);
	}

	private static User findUser() throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query selectUserQuery = session.createQuery("from User ");
        User selectedUser = (User) selectUserQuery.uniqueResult();

        Query selectItemQuery = session.createQuery("from Item where userId = " + selectedUser.getUserId());
        List<Item> items = selectItemQuery.list();
        selectedUser.setItems(items);
        session.getTransaction().commit();

        return selectedUser;
	}
}
