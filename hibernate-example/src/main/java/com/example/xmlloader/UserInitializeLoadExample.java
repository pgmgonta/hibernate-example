package com.example.xmlloader;

import java.io.FileInputStream;
import java.io.InputStream;

import com.example.model.User;

public class UserInitializeLoadExample {
	
	
	
	public static void main(String... args) {
		UserInitializeLoadExample uile = new UserInitializeLoadExample();
		uile.load();
	}

	public void load() {
		try(FileInputStream fis = new FileInputStream("src/main/resources/com/example/import/users.xml")) {
			
			Users users = JAXBListLoader.load(fis, Users.class);
			for (User user : users.getUsers()) {
				System.out.println("name: " + user.getName());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
