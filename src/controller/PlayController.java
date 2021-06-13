package controller;

import model.Interaction;
import processing.core.PApplet;

public class PlayController {

	private PApplet app;
	private Interaction interaction;

	public PlayController(PApplet app) {
		this.app = app;

		interaction = new Interaction(app);

	}

	public void draw() {

		interaction.draw();
		interaction.monkeyBullet();

	}

	public void drawG() {
		interaction.bananaBullet();
		interaction.drawG();
	}

	public void drawLevels(int level) {
		interaction.drawBananas(level);
		interaction.interactionPlatforms(level);
		interaction.coinMonkey(level);
		
	}

	public void monkeyMove(int movement) {
		interaction.monkeyMove(movement);
	}

	
	public Interaction getInteraction() {
		return interaction;
	}

}
