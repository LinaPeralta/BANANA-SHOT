package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import processing.core.PApplet;
import processing.core.PFont;

public class User implements Comparable<User> {
	
	private PApplet app;
	
	private String name, time, date, score;
	

	public User(PApplet app, String name) {
		
		this.app = app;
		this.name = name;
				
		//VARIABLES
		//The variables are blank for now, to later be filled with the information from the game
		date = "";
		time = "";
		score = "";

		
	}
	
	public void drawData(int y, PFont font) {
		
		app.fill(0);
		app.textFont(font);
		
		app.text(name, 269, y);
		app.text(date, 529, y);
		app.text(score, 749, y);
		app.text(time, 969, y);
		
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
