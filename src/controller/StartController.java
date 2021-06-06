package controller;

import java.util.ArrayList;

import model.User;
import processing.core.PApplet;

public class StartController {

	private ArrayList <User> users;

	public StartController() {
		users = new ArrayList<>();
	}
	
	public void addUser(String name) {
		users.add(new User(null, name));
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

}
