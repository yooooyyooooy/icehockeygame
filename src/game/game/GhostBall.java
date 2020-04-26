package game.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GhostBall extends Entity implements Movable {
	
	final int count = 2;
	
	public GhostBall(double x, double y) {
		super(x, y);
		super.setImg(new Image("ghostball.png"));
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
