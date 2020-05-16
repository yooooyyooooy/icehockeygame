package game.game;

import game.sharedObject.ResourceHolder;

import javafx.scene.canvas.GraphicsContext;

public class Item extends Entity {
	
	
	public Item(GraphicsContext gc) {
		// TODO Auto-generated constructor stub
		super(-50, 0);
		super.setImg(ResourceHolder.bombItem);
		
	}

	public boolean collideWithBall(Entity other) {
		return other.getBoundary().intersects(this.getBoundary());
	}
	
	public void randomDraw(GraphicsContext gc) {
		setX_coordinate(gc);
		setY_coordinate(gc);
		gc.drawImage(getImg(), getX_coordinate(), getY_coordinate());
	}
	
	public void setX_coordinate(GraphicsContext gc) {
		this.x_coordinate = Math.random()*((gc.getCanvas().getWidth())-400)+200;
	}
	
	public void setY_coordinate(GraphicsContext gc) {
		this.y_coordinate = Math.random()*((gc.getCanvas().getHeight())-200)+100;
	}
	
	public void clearItem(GraphicsContext gc) {
		gc.clearRect(getX_coordinate(), getY_coordinate(), this.getImg().getWidth(), this.getImg().getHeight());
		setX_coordinate(-50);
		setY_coordinate(0);
	}

	@Override
	public void bounce(GraphicsContext gc) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public boolean isWinning(GraphicsContext gc) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
