package game.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NormalBall extends Puck implements Movable, Transitionable {

	public NormalBall(double x, double y) {
		super(x, y);
		super.setIv((new ImageView(new Image("normalball.png"))));
		super.setSpeed(super.getSpeed());
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
