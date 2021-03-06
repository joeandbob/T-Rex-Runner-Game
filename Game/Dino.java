package Game;
import processing.core.PApplet;
import processing.core.PImage;

public class Dino {
	// Fields
	PImage img;
	PApplet window;
	private float x, y, yspeed;
	private String filename;
	private float width, height;
	protected float gravity;
	// Constructor
	public Dino(float x, float y, PApplet window, String filename) {
		this.x = x;
		this.y = y;
		this.window = window;
		this.img = window.loadImage(filename);
		this.yspeed = 10;
		this.gravity = 0.4f;
		this.width = img.width;
		this.height = img.height;
	}
	
	//draw method
	public void draw(int count, boolean lose) {
		if (lose) {
		if (count > 5) {
			img = window.loadImage("../assets/t_rex_running1.png");
			window.image(img, x, y);
		}
		else {
			img = window.loadImage("../assets/t_rex_running2.png");
			window.image(img, x, y);
		}
		}
	}
	
	public void moveRight(int distance) {
		this.x += distance;
	}
	
	public void moveLeft(int distance) {
		this.x -= distance;
	}
	
	public void setPosition(int X, int Y) {
		this.x = X;
		this.y = Y;
	}
	
	public boolean isOffScreenToLeft() {
		return (x < 0);
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void jump() {
		if(this.y == 200) {
		this.yspeed = 10;
			this.y -= yspeed;
		updatePosition();
		}
	}
	
	public void updatePosition() {
		if (this.y < 200) {
		this.y = this.y - yspeed;
		this.yspeed = (this.yspeed - this.gravity);
		}
		else {
			this.y = 200;
		}
	}
	//part 
	public boolean isIntervalOverlapping(float x1, float width1,float x2,float width2) {
		if (x1 + width1 < x2) {
			return false;
		}
		
		else if(x2 + width2 < x1) {
			return false;
		}
		else {
			return true;
		}
	}
	//collision testing
	public boolean isCollidingWithCactus(Cactus cact) {
		boolean xOverlap = isIntervalOverlapping(this.x, this.width, cact.getX(), cact.getWidth());
		boolean yOverlap = isIntervalOverlapping(this.y, this.height, cact.getY(), cact.getHeight());
		
		if(xOverlap == true && yOverlap == true) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	

	
	
}