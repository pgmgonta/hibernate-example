package com.example;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.example.model.Item;
import com.example.model.User;
import com.example.util.HibernateUtil;

public class HibernateOneToManySample {

	public static void main(String[] args) {
		HibernateOneToManySample mng = new HibernateOneToManySample();
		mng.createUserAndItems();
	}

	private void createUserAndItems() {
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
        System.out.println(user.getUserId());
        Item item1 = buildItem("item1", user.getUserId());
        Item item2 = buildItem("item2", user.getUserId());
        Item item3 = buildItem("item3", user.getUserId());

        session.save(item1);
        session.save(item2);
        session.save(item3);
        session.getTransaction().commit();
        
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User selectedUser = (User) session.load(User.class, user.getUserId());

        Query selectItemQuery = session.createQuery("from Item where userId = " + user.getUserId());
        @SuppressWarnings("unchecked")
		List<Item> items = selectItemQuery.list();
        
        selectedUser.setItems(items);
        session.getTransaction().commit();
        
        System.out.println(selectedUser.getName());
        for(Item item : selectedUser.getItems()) {
        	System.out.println(item.getName() );
        }
        
        
    }
	
	private Item buildItem(String _name, Long _userId) {
		Item item = new Item();
		item.setName(_name);
		item.setUserId(_userId);
		return item;
	}


}
