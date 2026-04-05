package com.chandru.practice.model;

import java.util.*;

interface Mediator {
	void sendMessage(String msg, User user);
}

class ChatMediator implements Mediator {
	private List<User> users = new ArrayList<>();

	public void addUser(User user) {
		users.add(user);
	}

	public void sendMessage(String msg, User sender) {
		for (User user : users) {
			if (user != sender) {
				user.receive(msg);
			}
		}
	}
}

abstract class User {
	protected Mediator mediator;
	protected String name;

	public User(Mediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}

	abstract void send(String msg);

	abstract void receive(String msg);
}

class ChatUser extends User {

	public ChatUser(Mediator mediator, String name) {
		super(mediator, name);
	}

	public void send(String msg) {
		mediator.sendMessage(msg, this);
	}

	public void receive(String msg) {
		System.out.println(name + " received: " + msg);
	}
}

public class Main {
	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediator();

		User u1 = new ChatUser(mediator, "Harshit");
		User u2 = new ChatUser(mediator, "Rahul");
		User u3 = new ChatUser(mediator, "Aman");

		mediator.addUser(u1);
		mediator.addUser(u2);
		mediator.addUser(u3);

		u1.send("Hello Everyone!");
	}
}