package game.game;

public class Player {
	private String name1;
	private String name2;
	private int score1 = 0;
	private int score2 = 0;
	public Player(String name1, String name2) {
		super();
		this.name1 = name1;
		this.name2 = name2;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	
	
	
}
