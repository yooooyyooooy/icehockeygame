
public abstract class Oblect {
	final double radius = 20; //to be edited
	protected double x_coordinate;
	protected double y_coordinate;
	protected double speed;
	
	public Oblect(double x, double y) {
		this.setX_coordinate(x);
		this.setY_coordinate(y);
		this.setSpeed(0);
	}
	
	public abstract void bounce();
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
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
