package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class User {
	
	private String name, date, time, points;

	public User(String name) {
		this.name = name;
		
		//VARIABLES
		//The variables are blank for now, to later be filled with the information from the game
		date = "";
		time = "";
		points = "";
	}
	
	public String getName() {
		return name;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setPoints(String points) {
		this.points = points;
	}

}
