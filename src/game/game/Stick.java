package game.game;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Stick extends Rectangle implements Movable, Runnable {

	
	public Stick(Color c) {
		super(10, 70);
		super.setFill(c);
	}
	
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		Stick me = this;
		me.setFocusTraversable(true);
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(me.getFill().equals(Color.RED)) {
					if(event.getCode().equals(KeyCode.W)) {
						me.setY(me.getY()-50);
					}else if(event.getCode().equals(KeyCode.S)) {
						me.setY(me.getY()+50);
					}
				}
				
				if(me.getFill().equals(Color.BLUE)) {
					if(event.getCode().equals(KeyCode.UP)) {
						me.setY(me.getY()-50);
					}else if(event.getCode().equals(KeyCode.DOWN)) {
						me.setY(me.getY()+50);
					}
				}
			}
		});
	}
	
	public void hit() {
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.move();
	}
	
}
