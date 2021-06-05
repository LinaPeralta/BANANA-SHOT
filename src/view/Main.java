package view;
import controlP5.ControlP5;
import processing.core.PApplet;

public class Main extends PApplet{

	//Libraries
	private ControlP5 cp5;
	
	//Start screen
	
	//Instruction screen
	
	//Play screen
	
	//Stat screen
	
	//Game over screen
	
	
	//Variables
	private int screen;
	
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
		
	
	@Override
	public void settings() {
		size(1300, 700);
	}
	
	@Override
	public void setup() {
		
		//Library
		cp5 = new ControlP5(this);
		//Start screen
		
		//Instruction screen
		
		//Play screen
		
		//Stat screen
		
		//Game over screen
		
		
		//Variables
		screen = 0;
		
		
	}
	
	@Override
	public void draw() {
		background(255);
		
		switch (screen) {
		//Start screen
		case 0:
			
			break;
		//Instructions screen
		case 1:
			
			break;
		//Play screen
		case 2:
			
			break;
		//Game over screen
		case 3:
	
			break;
		//Stat screen
		case 4:
	
			break;
		}	
		
	}
	
	@Override
	public void mousePressed() {
		
		switch (screen) {
		//Start screen
		case 0:
			
			
			
			
			
			
			
			
			break;
		//Instructions screen
		case 1:
			
			
			
			
			
			
			
			
			
			
			break;
		//Play screen
		case 2:
			
			
			
			
			
			
			
			
			
			break;
		//Game over screen
		case 3:
	
			
			
			
			
			
			
			
			break;
		//Stat screen
		case 4:
	
			
			
			
			
			
			
			break;
		}	

	}

	@Override
	public void keyPressed() {

	}

	
}
