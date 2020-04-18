package game.game;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Stick extends Rectangle{
	
	public Stick(int width, int height, Color color){
		super(width,height);
		setFill(color);
	}
	public void move() {
		  // TODO Auto-generated method stub
		Stick me = this;
		if(me.getFill().equals(Color.RED)) {
			this.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					// TODO Auto-generated method stub
					if(event.getCode().equals(KeyCode.W)) {
						me.setY(me.getY()-4);
					}else if(event.getCode().equals(KeyCode.S)) {
					    me.setY(me.getY()+4);
					}else if(event.getCode().equals(KeyCode.A)) {
					    me.setX(me.getX()-4);
					}else if(event.getCode().equals(KeyCode.D)) {
					    me.setX(me.getX()+4);
					    }
					}
			});
		}
		if(me.getFill().equals(Color.BROWN)) {
			this.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					// TODO Auto-generated method stub
					if(event.getCode().equals(KeyCode.UP)) {
						me.setY(me.getY()-4);
					}else if(event.getCode().equals(KeyCode.DOWN)) {
						me.setY(me.getY()+4);
					}else if(event.getCode().equals(KeyCode.LEFT)) {
						me.setX(me.getX()-4);
					}else if(event.getCode().equals(KeyCode.RIGHT)) {
						me.setX(me.getX()+4);
					}
				}
			});
		}
	
	}
}
	