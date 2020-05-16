package game.game;

import game.exception.ballFailedMoveException;
import game.sharedObject.ResourceHolder;
import javafx.scene.canvas.GraphicsContext;

public class NormalBall extends Entity implements IMovable, ITransitionable {
	
	private final double x_reset;
	private final double y_reset;

	public NormalBall(GraphicsContext gc) {
		super(gc.getCanvas().getWidth()/2-15 , gc.getCanvas().getHeight()/2-15);
		
		x_reset = gc.getCanvas().getWidth()/2-15;
		y_reset = gc.getCanvas().getHeight()/2-15;
		
		this.setImg(ResourceHolder.normalBall);
		draw(gc);
//		gc.drawImage(this.getImg(), this.getX_coordinate(), this.getY_coordinate());
		// TODO Auto-generated constructor stub
	}
	
	public void bounce(GraphicsContext gc) {
		if(collidewithWall_X(gc) == "TOP") {
			ResourceHolder.bounceSound.play();
			this.setYspeed(-(getYspeed()));
			ballFailedMoveException.ball_movements.add('T');
		  }
		if(collidewithWall_X(gc) == "BOTTOM") {
			ResourceHolder.bounceSound.play();
			this.setYspeed(-(getYspeed()));
			ballFailedMoveException.ball_movements.add('B');
		}
	}

	@Override
	public void move(GraphicsContext gc) {
		// TODO Auto-generated method stub
		draw(gc);
	}
		
	@Override
	public BombBall transition(Item item) {
		// TODO Auto-generated method stub
		
		BombBall bombball = new BombBall(super.getX_coordinate(), super.getY_coordinate());
		bombball.setXspeed(getXspeed());
		bombball.setYspeed(getYspeed());
		
		return  bombball;
	}

	public double getX_reset() {
		return x_reset;
	}

	public double getY_reset() {
		return y_reset;
	}

	@Override
	public boolean isWinning(GraphicsContext gc) {
		// TODO Auto-generated method stub
		return collidewithWall_Y(gc);
	}
	
	

}
