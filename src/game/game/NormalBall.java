package game.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NormalBall extends Puck implements Movable, Transitionable {

	public NormalBall(GraphicsContext gc) {
		super(gc.getCanvas().getWidth()/2, gc.getCanvas().getHeight()/2);
		this.setImg(new Image("normalball.png",30 ,30, false, false));
		this.setSpeed(5);
		gc.drawImage(this.getImg(), this.getX_coordinate()-this.getImg().getWidth()/2, this.getY_coordinate()-this.getImg().getHeight()/2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bounce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Puck transition(Item item) {
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
