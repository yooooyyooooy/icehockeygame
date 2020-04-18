package game.game;

public class ScoreBoard {
	public int player1Score;
	public int player2Score;
	
	
	public ScoreBoard() {
		this.player1Score = 0;
		this.player2Score = 0;
	}
	
//	public addScore(){
//		
//	}
//	
	
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
		
	
	
}
