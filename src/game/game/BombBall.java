package game.game;

import game.exception.ballFailedMoveException;

import game.sharedObject.ResourceHolder;
import javafx.scene.canvas.GraphicsContext;

public class BombBall extends Entity implements IMovable{
	
	private int bombTicks;
	private boolean isExploded;
	
	public BombBall(double x, double y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		super.setImg(ResourceHolder.bombBall);
		this.setBombTicks(10);
		this.setExploded(false);
	}
	
	@Override
	public void move(GraphicsContext gc) {
		// TODO Auto-generated method stub
		draw(gc);
	}

	public void bounce(GraphicsContext gc) {
		if(collidewithWall_X(gc) == "TOP") {
			ResourceHolder.bounceSound.play();
			this.setYspeed(instant_speed);
			ballFailedMoveException.ball_movements.add('T');
		  }
		if(collidewithWall_X(gc) == "BOTTOM") {
			ResourceHolder.bounceSound.play();
			this.setYspeed(-instant_speed);
			ballFailedMoveException.ball_movements.add('B');
		}
		
		if(collidewithWall_Y(gc)){
			ResourceHolder.bounceSound.play();
			this.setXspeed(-(getXspeed()));
			ballFailedMoveException.ball_movements.add('S');
		}
		
	}
	
	public void updateBombTicks() {
		bombTicks--;
	}
	
	public void playExplodingSound() {
		if(!isExploded && bombTicks == 0) {
			ResourceHolder.bombExplosionSound.play();
			setExploded(true);
		}
	}

	@Override
	public boolean isWinning(GraphicsContext gc) {
		// TODO Auto-generated method stub
		return bombTicks <= 0 && bombTicks > -3;
	}

	public int getBombTicks() {
		return bombTicks;
	}

	public void setBombTicks(int bombTicks) {
		this.bombTicks = bombTicks;
	}

	public boolean isExploded() {
		return isExploded;
	}

	public void setExploded(boolean isExploded) {
		this.isExploded = isExploded;
	}
	
	
}
