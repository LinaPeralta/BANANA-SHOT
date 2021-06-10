package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Gorilla {
	
	private PApplet app;
	
	private PImage gorilla;
	
<<<<<<< HEAD
	private int  health, bulletsG, addBullets, frameB;
	
	private int x, y, x2, y2, width, height, speedX, speedY, coolDown, vulnerable;
=======
	private int  health, bulletsG, coolDown;
	
	private int x, y, width, height, vulnerable;
>>>>>>> 5c75f7cbcbb094c2414a8bfb6b35646f2bfb2fdd

	private boolean dir, visible;
	
	private ArrayList<Bullet> bullets;
	
	public Gorilla(PApplet app) {
		
		this.app = app;
		
		//Attributes
		x = 920;
		y = 88;
		
		x2 = 910;
		y2 = 118;
		
		width = 200;
		height = 200;
<<<<<<< HEAD
		
		//addBullets = 20;
		
		speedX = 20;
		
		dir = true;
		
=======
		bulletsG = 30;
		dir = false;
>>>>>>> 5c75f7cbcbb094c2414a8bfb6b35646f2bfb2fdd
		health = 3;
		coolDown = 150;
		
<<<<<<< HEAD
		//frameB = 20;
		
=======
		//Image
>>>>>>> 5c75f7cbcbb094c2414a8bfb6b35646f2bfb2fdd
		gorilla = app.loadImage("./data/images/gorilla.png");
		
		//Arraylist
		bullets = new ArrayList<>();

	}
	
	public void draw() {		
<<<<<<< HEAD
		System.out.println(bullets.size());
//		
//		if (addBullets > 0) {
//		
//			addBullets--;
//			
//		}
			
		app.image(gorilla, x, y, width, height);
			
		
//		//Bullets
		
//		if(bulletsG == 0 && visible) {
//			initShoot();
//			bulletsG = 20;
//		}
		
//		//
//		if(bulletsG>0) {
//			bulletsG--;
//		}
		
		//creates and removes bullets		
=======
		app.image(gorilla, x, y, width, height);
			
		if(bulletsG>0) {
			bulletsG--;
		}
		
		//enemyBullets
		if(bulletsG == 0) {
			initShoot();
			bulletsG = 30;
		}

		//Drawing bullets, moving bullets and eliminating
>>>>>>> 5c75f7cbcbb094c2414a8bfb6b35646f2bfb2fdd
		shoot();
		removeBullet();
		
	}
	
	public void initShoot() {
<<<<<<< HEAD

	//	if (addBullets == 0 ) {
			
			Bullet bullet = new Bullet(app, x2+100, y2+150, dir);
			bullets.add(bullet);
			
			//initShoot();
			//addBullets = 20;
			
	//	}
		
	}
	
	public void dirBullet() {
		
		dir = true;
		speedX = 20;
		//x2 = speedX;
		
		//y2 += speedY;
		
		//setX(x-speedX);
	
=======
		int xBullet = x+100;
		int yBullet = y+150;
		Bullet bullet = new Bullet(app, xBullet, yBullet, dir);
		bullets.add(bullet);
>>>>>>> 5c75f7cbcbb094c2414a8bfb6b35646f2bfb2fdd
	}
	
	
	public void shoot() {
<<<<<<< HEAD
		
		for (int i = 0; i < bullets.size()  ; i++) {
			
			bullets.get(i).setVisible(true);
			
			bullets.get(i).draw();
			
			dirBullet();
			
=======
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw();
>>>>>>> 5c75f7cbcbb094c2414a8bfb6b35646f2bfb2fdd
			new Thread(bullets.get(i)).start();
		}
	}
	
	public void removeBullet() {
		
<<<<<<< HEAD
	for (int i = 0; i < bullets.size(); i++) {
		
		if(bullets.get(i).getX()<0 || bullets.get(i).getX() < 0) {
		
//		bullets.get(i).isVisible()==false
			
		bullets.remove(i);
		
	}
	
}
=======
		for (int i = 0; i < bullets.size(); i++) {
			if(bullets.get(i).getX()<0 || bullets.get(i).isVisible()==true) {
				bullets.remove(i);
			}
	}
>>>>>>> 5c75f7cbcbb094c2414a8bfb6b35646f2bfb2fdd
	
}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public PImage getGorilla() {
		return gorilla;
	}

	public void setGorilla(PImage gorilla) {
		this.gorilla = gorilla;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVulnerable() {
		return vulnerable;
	}

	public void setVulnerable(int vulnerable) {
		this.vulnerable = vulnerable;
	}

	public boolean isDir() {
		return dir;
	}

	public void setDir(boolean dir) {
		this.dir = dir;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}


	
}
