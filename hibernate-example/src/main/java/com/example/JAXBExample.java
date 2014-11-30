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
		createUserAndItems();
		User user = findUser();
		JAXB.marshal(user, System.out);
		
		List<User> userList = findUsers();
		JAXB.marshal(userList, System.out);
	}

	private static User findUser() throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query selectUserQuery = session.createQuery("from User ");
        User selectedUser = (User) selectUserQuery.list().get(0);

        Query selectItemQuery = session.createQuery("from Item where userId = " + selectedUser.getUserId());
        List<Item> items = selectItemQuery.list();
        selectedUser.setItems(items);
        session.getTransaction().commit();

        return selectedUser;
	}
	
	private static List<User> findUsers() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query selectItemQuery = session.createQuery("from eg.User");
        @SuppressWarnings("unchecked")
		List<User> users = selectItemQuery.list();
        session.getTransaction().commit();
        return users;
	}
	
	private static void createUserAndItems() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        //Delete all items.
        Query deleteItemQuery = session.createQuery("delete from Item");
        deleteItemQuery.executeUpdate();
        
        //Delete all users.
        Query deleteUserQuery = session.createQuery("delete from User");
        deleteUserQuery.executeUpdate();

        //Create User.
        User user = new User();
        user.setName("user1");
        session.save(user);
        
        //Create Items.
        Item item1 = buildItem("item1", user.getUserId());
        Item item2 = buildItem("item2", user.getUserId());
        Item item3 = buildItem("item3", user.getUserId());

        session.save(item1);
        session.save(item2);
        session.save(item3);
        
        user = new User();
        user.setName("user2");
        session.save(user);
        
        item1 = buildItem("item1", user.getUserId());
        item2 = buildItem("item2", user.getUserId());
        item3 = buildItem("item3", user.getUserId());
        
        session.save(item1);
        session.save(item2);
        session.save(item3);
        
        session.getTransaction().commit();
        
        
    }
	
	private static Item buildItem(String _name, Long _userId) {
		Item item = new Item();
		item.setName(_name);
		item.setUserId(_userId);
		return item;
	}

}
