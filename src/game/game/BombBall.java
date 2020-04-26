package game.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BombBall extends Entity implements Movable{
	
	final int timer = 10;
	
	public BombBall(double x, double y) {
		super(x, y);
		super.setImg(new Image("bombball.png"));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bounce(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

}
