package game.game;

import java.lang.Math;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class NormalBall extends Entity implements Movable, Transitionable {
	
	private final double x_reset;
	private final double y_reset;

	public NormalBall(GraphicsContext gc) {
		super(gc.getCanvas().getWidth()/2-15 , gc.getCanvas().getHeight()/2-15);
		
		x_reset = gc.getCanvas().getWidth()/2-15;
		y_reset = gc.getCanvas().getHeight()/2-15;
		
		this.setImg(new Image("normalball.png",30 ,30, false, false));
		gc.drawImage(this.getImg(), this.getX_coordinate(), this.getY_coordinate());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(GraphicsContext gc) {
		// TODO Auto-generated method stub
		draw(gc);
	}
	
	
	@Override
	public void bounce(GraphicsContext gc) {
		// TODO Auto-generated method stub

		if(collidewithWall_X(gc)) {
				this.setYspeed(-(this.getYspeed()));
		  }
		
//		if(collidewithWall_Y(gc)) {
//				this.setXspeed(-(this.getXspeed()));
//		  }
	
	}
	
	public boolean isWinning(GraphicsContext gc) {
		if(collidewithWall_Y(gc)) {
			return true;
	  }
		return false;
	}
	
	
	@Override
	public Entity transition(Item item) {
		// TODO Auto-generated method stub
		if(item.getName().equals("Bomb")) {
			BombBall bombball = new BombBall(super.getX_coordinate(), super.getY_coordinate());
			return bombball;
		}else { 
			GhostBall ghostball = new GhostBall(super.getX_coordinate(), super.getY_coordinate());
			return ghostball;
		}
		
	}

	public double getX_reset() {
		return x_reset;
	}

	public double getY_reset() {
		return y_reset;
	}
	
	

}
