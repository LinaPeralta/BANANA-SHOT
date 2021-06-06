package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class User implements Comparable<User> {
	
	private PApplet app;
	
	private String name, date, time, points;
	

	public User(PApplet app, String name) {
		
		this.app = app;
		
		this.name = name;
		//this.time = time;
		
		//VARIABLES
		//The variables are blank for now, to later be filled with the information from the game
		
//		date = "";
//		time = "";
//		points = "";
		
	}
	
	public void drawData(int x, int y) {
		
		app.fill(0);
		app.textSize(15);
		app.text(name, x, y);
		app.text(time, x+ 45*4, y );
		
		//app.text(date2, x+ 120*4, y );
		//app.text(score, x+ 180*4, y);

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

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
