package game.board;


import game.skill.*;


public class Player {
	private String name;
	private Perk perk = Perk.NONE;
	private int score = 0;

	public Player(String name, Perk perk) {
		setName(name);
		setPerk(perk);
		
	}
	
	public IActivatable getSkill() {
		switch (getPerk()) 
		{
		case FREEZING :
			return new FreezingSkill();
			
		case BLOCKING :
			return new BlockingSkill();
		default:
			return null;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Perk getPerk() {
		return perk;
	}

	public void setPerk(Perk perk) {
		this.perk = perk;
	}

}
