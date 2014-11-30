package com.example.xmlloader;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.example.model.User;

@XmlRootElement(name="users")
public class Users  {
	
	@XmlElement(name="user")
	private List<User> users;

	@XmlTransient
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
