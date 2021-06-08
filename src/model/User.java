package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import processing.core.PApplet;

public class User implements Comparable<User> {
	
	private PApplet app;
	
	private String name, time, date, score;
	

	public User(PApplet app, String name ) {
		
		this.app = app;
		
		this.name = name;
				
		date = "";
		time = "";
		score = "";

		
		//VARIABLES
		//The variables are blank for now, to later be filled with the information from the game

		
	}
	
	public void drawData(int x, int y) {
		
		app.fill(0);
		app.textSize(25);
		app.text(name, x, y);
		app.text(time, x + 800 , 200 );
		app.text(date, 400, 200);
		app.text(score, x+ 600, 200 );

	}
	
	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getScore() {
		return score;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
