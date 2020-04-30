package game.game;

import java.lang.Math;
import game.input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class NormalBall extends Entity implements Movable, Transitionable {

	public NormalBall(GraphicsContext gc) {
		super(gc.getCanvas().getWidth()/2-15 , gc.getCanvas().getHeight()/2-15);
		this.setImg(new Image("normalball.png",30 ,30, false, false));
		gc.drawImage(this.getImg(), this.getX_coordinate(), this.getY_coordinate());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		if(isMoving()) {
			
			if(InputUtility.getHitKeyPressed(KeyCode.W) || InputUtility.getHitKeyPressed(KeyCode.UP)) {
				this.setYspeed(-4);
			}
			
			if(InputUtility.getHitKeyPressed(KeyCode.S) || InputUtility.getHitKeyPressed(KeyCode.DOWN)) {
				this.setYspeed(4);
				
			}
			
			if(InputUtility.getHitKeyPressed(KeyCode.A) || InputUtility.getHitKeyPressed(KeyCode.LEFT)) {
				this.setXspeed(-4);
				
			}
			
			if(InputUtility.getHitKeyPressed(KeyCode.D) || InputUtility.getHitKeyPressed(KeyCode.RIGHT)) {
				this.setXspeed(4);
			}
			
			if(InputUtility.isGetHit()) {
				
				return;
			}
			
			this.bounce(gc);
	
			gc.clearRect(this.getX_coordinate(), this.getY_coordinate(), this.getImg().getWidth(), this.getImg().getHeight());
			this.setY_coordinate((int)(this.getY_coordinate()+this.getYspeed()));
			this.setX_coordinate((int)(this.getX_coordinate()+this.getXspeed()));
			gc.drawImage(this.getImg(), this.getX_coordinate(), this.getY_coordinate());
		}
			
	}

	@Override
	public void bounce(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		if(Math.abs(this.getY_coordinate() - gc.getCanvas().getHeight() + 30) <= 2  || this.getY_coordinate() <= 11) {
				this.setYspeed(-(this.getYspeed()));
		  }
		
		if (Math.abs(this.getX_coordinate() - gc.getCanvas().getWidth() + 89) <= 2 || this.getX_coordinate() <= 62 ) {
				this.setXspeed(-(this.getXspeed()));
		  }
		
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

}
