package solar;

public class Saturn extends Planet{
	private int speed;

	public Saturn(int orbitRadius, int speed) {
		super(orbitRadius);
		if (speed < 0) {
			this.speed = 0;
		}else {
			this.speed = speed;
		}
	}
	 public Saturn() {
		 super();
		 this.speed = 0;
	}
	
	 public int getSpeed() {
		 return this.speed;
	 }
	 
	 public boolean orbit() {
		 for (int i = 0 ;i<this.getSpeed();i++) {
			 super.orbit();
		 }
		 return this.getSpeed() > 0 ;
	 }	 
}
