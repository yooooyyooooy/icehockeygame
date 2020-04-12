
public class Item extends Marble {
	protected String name;
	
	public Item(double x, double y, String name) {
		// TODO Auto-generated constructor stub
		super(x,y);
		switch(name) {
			case "Bomb":
				this.setName("Bomb");
			case "Illusion":
				this.setName("Illusion");
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
