package game.game;

import java.lang.Math;
import game.input.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Sticks implements Movable{
	
	private final double x1_reset;
	private final double y1_reset;
	private final double x2_reset;
	private final double y2_reset;
	
	private double x_pos1;
	private double y_pos1;
	private double x_pos2;
	private double y_pos2;
	private double x_speed1;
	private double y_speed1;
	private double x_speed2;
	private double y_speed2;

	public Sticks(GraphicsContext gc) {
		x1_reset = 50;
		y1_reset = gc.getCanvas().getHeight()/2-35;
		x2_reset = gc.getCanvas().getWidth()-60;
		y2_reset = gc.getCanvas().getHeight()/2-35;
		
		this.setX_pos1(getX1_reset());
		this.setY_pos1(getY1_reset());
		this.setX_pos2(getX2_reset());
		this.setY_pos2(getY2_reset());
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
	}
	
	public boolean hit(Entity ball) {
		if(ball.collideWithSide1(this)) {
			if(ball.getXspeed() == 0){
				ball.setXspeed(3.5);
				ball.setYspeed(-3);
			}else {
				ball.setXspeed(-(ball.getXspeed()));
			}
			return true;
		}
		
		if(ball.collideWithSide2(this)) {
			if(ball.getXspeed() == 0){
				ball.setXspeed(-3.5);
				ball.setYspeed(-3.5);
			}else {
				ball.setXspeed(-(ball.getXspeed()));
			}
			return true;
		}
		
		if(ball.collideWithTopOrButtom1(this) == "TOP") {
			if(ball.getYspeed() == 0){
				ball.setXspeed(3.5);
				ball.setYspeed(-3.5);
			}else {
				ball.setYspeed(-(ball.getYspeed()));
			}
			return true;
		}
		
		if(ball.collideWithTopOrButtom1(this) == "BUTTOM") {
			if(ball.getYspeed() == 0){
				ball.setXspeed(3.5);
				ball.setYspeed(3.5);
			}else {
				ball.setYspeed(-(ball.getYspeed()));
			}
			return true;
		}
		
		if(ball.collideWithTopOrButtom2(this) == "TOP") {
			if(ball.getYspeed() == 0){
				ball.setXspeed(-3.5);
				ball.setYspeed(-3.5);
			}else {
				ball.setYspeed(-(ball.getYspeed()));
			}
			return true;
		}
		
		if(ball.collideWithTopOrButtom1(this) == "BUTTOM") {
			if(ball.getYspeed() == 0){
				ball.setXspeed(-3.5);
				ball.setYspeed(3.5);
			}else {
				ball.setYspeed(-(ball.getYspeed()));
			}
			return true;
		}
		
		return false;
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
	
	
	
	public double getX1_reset() {
		return x1_reset;
	}


	public double getY1_reset() {
		return y1_reset;
	}


	public double getX2_reset() {
		return x2_reset;
	}


	public double getY2_reset() {
		return y2_reset;
	}

	
	public void draw(GraphicsContext gc) {
		gc.clearRect(this.getX_pos1(), this.getY_pos1(), 10, 70);
		this.setX_pos1(this.getX_pos1()+this.getX_speed1());
		this.setY_pos1(this.getY_pos1()+this.getY_speed1());
		gc.setFill(Color.RED);
		gc.fillRoundRect(this.getX_pos1(), this.getY_pos1(), 10, 70, 20, 20);
		
		gc.clearRect(this.getX_pos2(), this.getY_pos2(), 10, 70);
		this.setX_pos2(this.getX_pos2()+this.getX_speed2());
		this.setY_pos2(this.getY_pos2()+this.getY_speed2());
		gc.setFill(Color.BLUE);
		gc.fillRoundRect(this.getX_pos2(), this.getY_pos2(), 10, 70, 20, 20);
		
		
	}
	
	public Rectangle2D getBoundarySide1() {
        return new Rectangle2D(getX_pos1(), getY_pos1(), 10, 70);
    }
	
	public Rectangle2D getBoundaryTop1() {
        return new Rectangle2D(getX_pos1(), getY_pos1()-5, 10, 5);
    }
	
	public Rectangle2D getBoundaryButtom1() {
        return new Rectangle2D(getX_pos1(), getY_pos1()+70, 10, 5);
    }

	public Rectangle2D getBoundarySide2() {
        return new Rectangle2D(getX_pos2(), getY_pos2(), 10, 70);
    }
	
	public Rectangle2D getBoundaryTop2() {
        return new Rectangle2D(getX_pos2(), getY_pos2()-5, 10, 5);
    }
	
	public Rectangle2D getBoundaryButtom2() {
        return new Rectangle2D(getX_pos2(), getY_pos2()+70, 10, 5);
    }
}
