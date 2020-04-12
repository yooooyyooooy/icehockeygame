
public abstract class Ball {
	final float radius = 20; //to be edited
	protected float x_coordinate;
	protected float y_coordinate;
	protected float speed;
	
	public Ball(float x, float y, float speed) {
		this.setX_coordinate(x);
		this.setY_coordinate(y);
		this.setSpeed(speed);
	}
	
	public abstract void bounce();

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getX_coordinate() {
		return x_coordinate;
	}

	public void setX_coordinate(float x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	public float getY_coordinate() {
		return y_coordinate;
	}

	public void setY_coordinate(float y_coordinate) {
		this.y_coordinate = y_coordinate;
	}
}
