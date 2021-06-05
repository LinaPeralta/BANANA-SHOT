package view;
import controlP5.ControlP5;
import processing.core.PApplet;

public class Main extends PApplet{

	//Libraries
	private ControlP5 cp5;
	
	//Start screen
	private StartScreen start;
	//Instruction screen
	private InstructionScreen instructions;
	//Play screen
	private PlayScreen playScreen;
	//Stat screen
	
	//Game over screen
	
	
	//Variables
	private int screen;
	private int level;
	
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
		start = new StartScreen(this, cp5);
		//Instruction screen
		instructions = new InstructionScreen(this);
		//Play screen
		playScreen = new PlayScreen (this);
		//Stat screen
		
		//Game over screen
		
		
		//Variables
		screen = 0;
		level = 0;
		
	}
	
	@Override
	public void draw() {
		background(255);
		
		switch (screen) {
		//Start screen
		case 0:
			start.draw();
			break;
		//Instructions screen
		case 1:
			instructions.draw();
			break;
		//Play screen
		case 2:
			playScreen.levelScreens();
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
			//Show text when restart
			start.showText();
			//If to hide text, add user and switch to the following screen
			if (mouseX > 540 && mouseX < 765 && mouseY > 580 && mouseY < 637 && start.isBoxFilled()) {
				start.addUser();
				start.hideText();
				screen = 1;
			}
			
			
			
			
			
			
			
			break;
		//Instructions screen
		case 1:
			if (mouseX > 530 && mouseX < 775 && mouseY > 590 && mouseY < 650) {
				screen = 2;
			}
			
			
			
			
			
			
			
			
			
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
