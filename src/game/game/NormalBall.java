package game.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NormalBall extends Object implements Movable, Transitionable {

	public NormalBall(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bounce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImage(ImageView iv) {
		// TODO Auto-generated method stub
		iv = new ImageView(new Image("normalball.png"));
	}

}