
public class Stick implements Movable {
	
	final double radius = 20; //to be edited
	protected double x_coordinate;
	protected double y_coordinate;
	
	public Stick(double x, double y) {
		this.setX_coordinate(x);
		this.setY_coordinate(y);
	}
	@Override
	public void move(double x, double y) {
		// TODO Auto-generated method stub
		
	}
	
	public void hit() {
		
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
