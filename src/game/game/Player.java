package game.game;

public class Player {
	private String name;
	private int scores = 0;
	
	public Player(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}
	
}
