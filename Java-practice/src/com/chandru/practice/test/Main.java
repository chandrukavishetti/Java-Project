package com.chandru.practice.test;

import java.util.*;

class User {
	private String name;
	private List<User> users; // directly holding reference of all users

	public User(String name) {
		this.name = name;
		this.users = new ArrayList<>();
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void send(String msg) {
		for (User user : users) {
			if (user != this) {
				user.receive(msg);
			}
		}
	}

	public void receive(String msg) {
		System.out.println(name + " received: " + msg);
	}
}

public class Main {
	public static void main(String[] args) {
		User u1 = new User("Harshit");
		User u2 = new User("Rahul");
		User u3 = new User("Aman");

		// manually connecting each user with others
		u1.addUser(u2);
		u1.addUser(u3);

		u2.addUser(u1);
		u2.addUser(u3);

		u3.addUser(u1);
		u3.addUser(u2);

		u1.send("Hello Everyone!");
	}
}