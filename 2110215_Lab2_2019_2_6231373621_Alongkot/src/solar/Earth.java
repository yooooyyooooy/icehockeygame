package solar;

public class Earth extends Planet{
	private int wasteLevel;

	public Earth(int orbitRadius, int wasteLevel) {
		super(orbitRadius);
		if (wasteLevel < 0) {
			this.wasteLevel = 0;
		} else {
		this.wasteLevel = wasteLevel;
		}
	}
	
	public Earth() {
		super();
		this.wasteLevel = 0;
	}
	
	public int getWasteLevel() {
		return this.wasteLevel;
	}
	
	public boolean  orbit() {
		if (this.wasteLevel <= 5 && super.orbit()) {
			return true;
		}else {
			return false;
		}
		
	}
}
