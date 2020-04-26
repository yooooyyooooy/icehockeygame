package game.game;

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
			if(InputUtility.getHitKeyPressed(KeyCode.W)) {
				this.setYspeed(-2);
			}
			
			if(InputUtility.getHitKeyPressed(KeyCode.S)) {
				this.setYspeed(2);
			}
			
			if(InputUtility.getHitKeyPressed(KeyCode.A)) {
				this.setXspeed(-2.5);
			}
			
			if(InputUtility.getHitKeyPressed(KeyCode.D)) {
				this.setXspeed(2.5);
			}
			
			gc.clearRect(this.getX_coordinate(), this.getY_coordinate(), this.getImg().getWidth(), this.getImg().getHeight());
			this.setY_coordinate(this.getY_coordinate()+this.getYspeed());
			this.setX_coordinate(this.getX_coordinate()+this.getXspeed());
			gc.drawImage(this.getImg(), this.getX_coordinate(), this.getY_coordinate());
			
			this.bounce(gc);
			
		}
	}

	@Override
	public void bounce(GraphicsContext gc) {
		// TODO Auto-generated method stub		
		if(this.getY_coordinate() == gc.getCanvas().getHeight() - 25 || this.getY_coordinate() == 25) {
				this.setYspeed(-(this.getYspeed()));
		  }
		
		if (this.getX_coordinate() == gc.getCanvas().getWidth() - 75 || this.getX_coordinate() == 75 ) {
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
