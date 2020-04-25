package game.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BombBall extends Puck implements Movable{
	
	final int timer = 10;
	
	public BombBall(double x, double y) {
		super(x, y);
		super.setIv((new ImageView(new Image("bombball.png"))));
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

}
