package game.board;

import game.sharedObject.ResourceHolder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreBoard {
	private double x_p1score;
	private double x_p2score;
	private double y_score;
	private int player1Score;
	private int player2Score;
	private Font scoreFont = ResourceHolder.scoreFont ;
	
	
	public ScoreBoard(GraphicsContext gc, Player player1, Player player2) {
		player1Score = player1.getScore();
		player2Score = player2.getScore();
		this.setX_p1score(12);
		this.setX_p2score(gc.getCanvas().getWidth()-42);
		this.setY_score(gc.getCanvas().getHeight()/2 + 10);
	}
	
	public void draw(GraphicsContext gc, Player player1, Player player2) {
		gc.setLineWidth(1.5);
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.BLACK);
		gc.setFont(scoreFont);
		
		if (player1.getScore() < 10) {
			gc.fillText("0" + String.valueOf(player1.getScore()), x_p1score, y_score);
			gc.strokeText("0"+ String.valueOf(player1.getScore()), x_p1score, y_score);	
		}else {
			gc.fillText(String.valueOf(player1.getScore()), x_p1score, y_score);
			gc.strokeText(String.valueOf(player1.getScore()), x_p1score, y_score);
		}
		
		if (player2.getScore() < 10) {
			gc.fillText( "0" + String.valueOf(player2.getScore()), x_p2score, y_score);
			gc.strokeText("0" + String.valueOf(player2.getScore()), x_p2score, y_score);
		}else {
			gc.fillText(String.valueOf(player2.getScore()), x_p2score, y_score);
			gc.strokeText(String.valueOf(player2.getScore()), x_p2score, y_score);
		}
		
	}
	
	public void scoreUpdate() {
		
		
	}
	
	
	
	public int getPlayer1Score() {
		return player1Score;
	}
	
	
	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}
	
	
	public int getPlayer2Score() {
		return player2Score;
	}
	
	
	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}


	public double getX_p1score() {
		return x_p1score;
	}


	public void setX_p1score(double x_p1score) {
		this.x_p1score = x_p1score;
	}



	public double getX_p2score() {
		return x_p2score;
	}

	
	public void setX_p2score(double x_p2score) {
		this.x_p2score = x_p2score;
	}



	public double getY_score() {
		return y_score;
	}



	public void setY_score(double y_score) {
		this.y_score = y_score;
	}
	
	
}
