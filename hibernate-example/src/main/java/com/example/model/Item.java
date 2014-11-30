package com.example.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * @author tatsuya
 *
 */
public class Item {

	@XmlAttribute
    private Long itemId;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private Long userId;
	
	@XmlTransient
	private User user;

	@XmlTransient
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@XmlTransient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name; 
	}

	@XmlTransient
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@XmlTransient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
