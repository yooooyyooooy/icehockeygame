
public class Item extends Oblect {
	protected String name;
	
	public Item(double x, double y, String name) {
		// TODO Auto-generated constructor stub
		super(x,y);
		switch(name) {
			case "Bomb":
				this.setName("Bomb");
			case "Ghost":
				this.setName("Ghost");
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void bounce() {
		// TODO Auto-generated method stub
		
	}
	
}
