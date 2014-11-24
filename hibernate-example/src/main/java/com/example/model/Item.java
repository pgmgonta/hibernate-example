package com.example.model;

/**
 * @author tatsuya
 *
 */
public class Item {

    private Long itemId;
	private String name;
	private Long userId;
	private User user;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name; 
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	**/
	
	
}
