package game.game;

import java.lang.Math;
import game.input.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Sticks implements Movable{
	
	private double x_pos1;
	private double y_pos1;
	private double x_pos2;
	private double y_pos2;
	private double x_speed1;
	private double y_speed1;
	private double x_speed2;
	private double y_speed2;

	public Sticks(GraphicsContext gc) {
		this.setX_pos1(50);
		this.setY_pos1(gc.getCanvas().getHeight()/2-35);
		this.setX_pos2(gc.getCanvas().getWidth()-60);
		this.setY_pos2(gc.getCanvas().getHeight()/2-35);
		gc.setFill(Color.RED);
		gc.fillRoundRect(this.getX_pos1(), this.getY_pos1(), 10, 70, 20, 20);
		gc.setFill(Color.BLUE);
		gc.fillRoundRect(this.getX_pos2(), this.getY_pos2(), 10, 70, 20, 20);
	}
	
	
	@Override
	public void move(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		//Red Sticks
		this.setX_speed1(0);
		this.setY_speed1(0);
		if(InputUtility.getKeyPressed(KeyCode.W) && this.getY_pos1() > 10) {
			this.setY_speed1(-3);
			
		}if(InputUtility.getKeyPressed(KeyCode.S) && this.getY_pos1() < gc.getCanvas().getHeight()-80 ) {
			this.setY_speed1(3);

		}if(InputUtility.getKeyPressed(KeyCode.A) && this.getX_pos1() > 50 ) {
			this.setX_speed1(-3);
			
		}if(InputUtility.getKeyPressed(KeyCode.D) && this.getX_pos1() < gc.getCanvas().getWidth()/2-13 ) {
			this.setX_speed1(3);
		}
		
		gc.clearRect(this.getX_pos1(), this.getY_pos1(), 10, 70);
		this.setX_pos1(this.getX_pos1()+this.getX_speed1());
		this.setY_pos1(this.getY_pos1()+this.getY_speed1());
		gc.setFill(Color.RED);
		gc.fillRoundRect(this.getX_pos1(), this.getY_pos1(), 10, 70, 20, 20);
		
		//Blue Stick
		this.setX_speed2(0);
		this.setY_speed2(0);
		if(InputUtility.getKeyPressed(KeyCode.UP) && this.getY_pos2() > 10 ) {
			this.setY_speed2(-3);
			
		}if(InputUtility.getKeyPressed(KeyCode.DOWN) && this.getY_pos2() < gc.getCanvas().getHeight()-80 ) {
			this.setY_speed2(3);

			
		}if(InputUtility.getKeyPressed(KeyCode.LEFT) && this.getX_pos2() > gc.getCanvas().getWidth()/2+3 ) {
			this.setX_speed2(-3);
			
		}if(InputUtility.getKeyPressed(KeyCode.RIGHT) && this.getX_pos2() < gc.getCanvas().getWidth()-60) {
			this.setX_speed2(3);
			
		}
		
		gc.clearRect(this.getX_pos2(), this.getY_pos2(), 10, 70);
		this.setX_pos2(this.getX_pos2()+this.getX_speed2());
		this.setY_pos2(this.getY_pos2()+this.getY_speed2());
		gc.setFill(Color.BLUE);
		gc.fillRoundRect(this.getX_pos2(), this.getY_pos2(), 10, 70, 20, 20);
	}
	
	public boolean hit(Entity ball) {
		
		if((Math.abs(ball.getX_coordinate() - this.getX_pos1()+10) <= 7 || ball.getX_coordinate()+ball.getImg().getWidth() == this.getX_pos1() ||
				ball.getY_coordinate()+ball.getImg().getHeight() == this.getY_pos1() || ball.getY_coordinate() == this.getY_pos1()+70) || (Math.abs(ball.getX_coordinate() - this.getX_pos2()+10) <= 7 || ball.getX_coordinate()+ball.getImg().getWidth() == this.getX_pos2() ||
				ball.getY_coordinate()+ball.getImg().getHeight() == this.getY_pos2() || ball.getY_coordinate() == this.getY_pos2()+70)) {
			ball.setMoving(true);
			return true;
			
		}else {
			return false;
			
		}
		
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


	public double getX_speed1() {
		return x_speed1;
	}


	public void setX_speed1(double x_speed1) {
		this.x_speed1 = x_speed1;
	}


	public double getY_speed1() {
		return y_speed1;
	}


	public void setY_speed1(double y_speed1) {
		this.y_speed1 = y_speed1;
	}


	public double getX_speed2() {
		return x_speed2;
	}


	public void setX_speed2(double x_speed2) {
		this.x_speed2 = x_speed2;
	}


	public double getY_speed2() {
		return y_speed2;
	}


	public void setY_speed2(double y_speed2) {
		this.y_speed2 = y_speed2;
	}
	
	
}
