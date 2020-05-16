package game.board;

import game.sharedObject.ResourceHolder;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Clock {
	
	private int time = 60;
	private double x_coordinate;
	private double y_coordinate;
	private Font timeFont = ResourceHolder.timeFont;


	public Clock(GraphicsContext gc) {
		this.setX_coordinate(gc.getCanvas().getWidth()/2 - 60);
		this.setY_coordinate(45);
	}
	
	
	public void draw(GraphicsContext gc) {
		gc.setLineWidth(1.5);
		if(time <= 10) {
			gc.setStroke(Color.RED);
		}else {
			
			gc.setStroke(Color.BLACK);
		}
		
		gc.setFill(Color.WHITE);
		
		gc.setFont(timeFont);
		gc.clearRect(x_coordinate + 60, y_coordinate-30, 100, 100);
		gc.fillText("Time: " + String.valueOf(time), x_coordinate, y_coordinate);
		gc.strokeText( "Time: "+ String.valueOf(time), x_coordinate, y_coordinate);
	}
	
	public void updateCooldown(GraphicsContext gc, int maxCooldown1, int cooldown1, int maxCooldown2, int cooldown2) {
		int duration1 = maxCooldown1 - cooldown1;
		int duration2 = maxCooldown2 - cooldown2;
		
		gc.setLineWidth(2);
		gc.setFill(Color.WHITE);
		gc.setFont(timeFont);
		
		gc.clearRect(gc.getCanvas().getWidth()/4-50, y_coordinate-30, 140, 100);
		gc.clearRect(gc.getCanvas().getWidth()*3/4-50, y_coordinate-30, 140, 100);
		
		if (duration1 < 10) {
			gc.setStroke(Color.CHOCOLATE);
			gc.fillText("0" + String.valueOf(duration1), gc.getCanvas().getWidth()/4 , y_coordinate);
			gc.strokeText("0"+ String.valueOf(duration1), gc.getCanvas().getWidth()/4 , y_coordinate);	
		}
		else if(duration1 == maxCooldown1) {
			gc.setStroke(Color.GREEN);
			gc.fillText("READY!", gc.getCanvas().getWidth()/4-50 , y_coordinate);
			gc.strokeText("READY!", gc.getCanvas().getWidth()/4-50 , y_coordinate);
		}
		else {
			gc.setStroke(Color.CHOCOLATE);
			gc.fillText(String.valueOf(duration1), gc.getCanvas().getWidth()/4 , y_coordinate);
			gc.strokeText(String.valueOf(duration1), gc.getCanvas().getWidth()/4 , y_coordinate);
		}
		
		if (duration2 < 10) {
			gc.setStroke(Color.CHOCOLATE);
			gc.fillText( "0" + String.valueOf(duration2), gc.getCanvas().getWidth()*3/4 , y_coordinate);
			gc.strokeText("0" + String.valueOf(duration2), gc.getCanvas().getWidth()*3/4 , y_coordinate);
		}
		else if(duration2 == maxCooldown2) {
			gc.setStroke(Color.GREEN);
			gc.fillText("READY!", gc.getCanvas().getWidth()*3/4-50 , y_coordinate);
			gc.strokeText("READY!", gc.getCanvas().getWidth()*3/4-50 , y_coordinate);
		}
		else {
			gc.setStroke(Color.CHOCOLATE);
			gc.fillText(String.valueOf(duration2), gc.getCanvas().getWidth()*3/4 , y_coordinate);
			gc.strokeText(String.valueOf(duration2), gc.getCanvas().getWidth()*3/4 , y_coordinate);
		}
	}
	
	public void timeUpdate() {
		time -- ;
	}
	
	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public double getX_coordinate() {
		return x_coordinate;
	}


	public void setX_coordinate(double x_coordinate) {
		this.x_coordinate = x_coordinate;
	}


	public double getY_coordinate() {
		return y_coordinate;
	}


	public void setY_coordinate(double y_coordinate) {
		this.y_coordinate = y_coordinate;
	}



}

