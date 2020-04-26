package game.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Entity {
//	final double radius = 20; //to be edited
	protected double x_coordinate;
	protected double y_coordinate;
	 protected double xspeed;
	 protected double yspeed;
	protected Image img;
	protected boolean isMoving = false;
	
	public Entity(double x, double y) {
		this.setX_coordinate(x);
		this.setY_coordinate(y);
	}
	
	public abstract void bounce(GraphicsContext gc);
	
	
	public Image getImg() {
		return img;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}


	public double getXspeed() {
		return xspeed;
	}

	public void setXspeed(double xspeed) {
		this.xspeed = xspeed;
	}

	public double getYspeed() {
		return yspeed;
	}

	public void setYspeed(double yspeed) {
		this.yspeed = yspeed;
	}

	public double getX_coordinate() {
		return x_coordinate;
	}

	public void setX_coordinate(double x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	public double getY_coordinate() {
		return y_coordinate;
	}

	public void setY_coordinate(double y_coordinate) {
		this.y_coordinate = y_coordinate;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	
}
