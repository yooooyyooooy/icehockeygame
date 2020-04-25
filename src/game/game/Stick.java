package game.game;

import game.input.*;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Stick implements Movable{
	
	private double x_pos1;
	private double y_pos1;
	private double x_pos2;
	private double y_pos2;
	
	public Stick(GraphicsContext gc, String player) {
		this.setX_pos1(30);
		this.setY_pos1(gc.getCanvas().getHeight()/2-35);
		this.setX_pos2(gc.getCanvas().getWidth()-30);
		this.setY_pos2(gc.getCanvas().getHeight()/2-35);
		if(player.equals("Player1")) {
			gc.setFill(Color.RED);
			gc.fillRoundRect(this.getX_pos1(), this.getY_pos1(), 10, 70, 20, 20);
		}else {
			gc.setFill(Color.BLUE);
			gc.fillRoundRect(this.getX_pos2(), this.getY_pos2(), 10, 70, 20, 20);
		}
	}
	
	
	@Override
	public void move(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(InputUtility.getKeyPressed(KeyCode.W) && this.getY_pos1() > 0 ) {
			gc.clearRect(this.getX_pos1(), this.getY_pos1(), 10, 70);
			this.setY_pos1(this.getY_pos1()-3);
			gc.setFill(Color.RED);
			gc.fillRoundRect(this.getX_pos1(), this.getY_pos1(), 10, 70, 20, 20);
			
		}if(InputUtility.getKeyPressed(KeyCode.S) && this.getY_pos1() < gc.getCanvas().getHeight()-70 ) {
			gc.clearRect(this.getX_pos1(), this.getY_pos1(), 10, 70);
			this.setY_pos1(this.getY_pos1()+3);
			gc.setFill(Color.RED);
			gc.fillRoundRect(this.getX_pos1(), this.getY_pos1(), 10, 70, 20, 20);
			
		}if(InputUtility.getKeyPressed(KeyCode.A) && this.getX_pos1() > 0 ) {
			gc.clearRect(this.getX_pos1(), this.getY_pos1(), 10, 70);
			this.setX_pos1(this.getX_pos1()-3);
			gc.setFill(Color.RED);
			gc.fillRoundRect(this.getX_pos1(), this.getY_pos1(), 10, 70, 20, 20);
			
		}if(InputUtility.getKeyPressed(KeyCode.D) && this.getX_pos1() < gc.getCanvas().getWidth()/2-10 ) {
			gc.clearRect(this.getX_pos1(), this.getY_pos1(), 10, 70);
			this.setX_pos1(this.getX_pos1()+3);
			gc.setFill(Color.RED);
			gc.fillRoundRect(this.getX_pos1(), this.getY_pos1(), 10, 70, 20, 20);
		}
		
		if(InputUtility.getKeyPressed(KeyCode.UP) && this.getY_pos2() > 0 ) {
			gc.clearRect(this.getX_pos2(), this.getY_pos2(), 10, 70);
			this.setY_pos2(this.getY_pos2()-3);
			gc.setFill(Color.BLUE);
			gc.fillRoundRect(this.getX_pos2(), this.getY_pos2(), 10, 70, 20, 20);
			
		}if(InputUtility.getKeyPressed(KeyCode.DOWN) && this.getY_pos2() < gc.getCanvas().getHeight()-70 ) {
			gc.clearRect(this.getX_pos2(), this.getY_pos2(), 10, 70);
			this.setY_pos2(this.getY_pos2()+3);
			gc.setFill(Color.BLUE);
			gc.fillRoundRect(this.getX_pos2(), this.getY_pos2(), 10, 70, 20, 20);
			
		}if(InputUtility.getKeyPressed(KeyCode.LEFT) && this.getX_pos2() > gc.getCanvas().getWidth()/2 ) {
			gc.clearRect(this.getX_pos2(), this.getY_pos2(), 10, 70);
			this.setX_pos2(this.getX_pos2()-3);
			gc.setFill(Color.BLUE);
			gc.fillRoundRect(this.getX_pos2(), this.getY_pos2(), 10, 70, 20, 20);
			
		}if(InputUtility.getKeyPressed(KeyCode.RIGHT) && this.getX_pos2() < gc.getCanvas().getWidth()-10  ) {
			gc.clearRect(this.getX_pos2(), this.getY_pos2(), 10, 70);
			this.setX_pos2(this.getX_pos2()+3);
			gc.setFill(Color.BLUE);
			gc.fillRoundRect(this.getX_pos2(), this.getY_pos2(), 10, 70, 20, 20);
		}
	}
	
	public void hit() {
		
	}

	public double getX_pos1() {
		return x_pos1;
	}


	public void setX_pos1(double x_pos1) {
		this.x_pos1 = x_pos1;
	}


	public double getY_pos1() {
		return y_pos1;
	}


	public void setY_pos1(double y_pos1) {
		this.y_pos1 = y_pos1;
	}


	public double getX_pos2() {
		return x_pos2;
	}


	public void setX_pos2(double x_pos2) {
		this.x_pos2 = x_pos2;
	}


	public double getY_pos2() {
		return y_pos2;
	}


	public void setY_pos2(double y_pos2) {
		this.y_pos2 = y_pos2;
	}
	
}
