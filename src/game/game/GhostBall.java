package game.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GhostBall extends Object implements Movable {
	
	final int count = 2;
	
	public GhostBall(double x, double y) {
		super(x, y);
		super.setSpeed(super.getSpeed());
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
	public void setImage(ImageView iv) {
		// TODO Auto-generated method stub
		iv = new ImageView(new Image("ghostball.png"));
	}
	
}
