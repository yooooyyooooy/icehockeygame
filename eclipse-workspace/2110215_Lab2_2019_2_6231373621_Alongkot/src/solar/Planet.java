package solar;

public class Planet {
	protected Coordinate coordinate;
	protected Coordinate orbitCenterCoordinate;
	protected int orbitRadius;
	
	public Planet(int orbitRadius) {
		if (orbitRadius < 1) {
			this.orbitRadius = 1;
		} else {
		this.orbitRadius = orbitRadius;
		}
		orbitCenterCoordinate = new Coordinate();
		coordinate = new Coordinate(this.orbitRadius,0);
	}
	
	public Planet() {
		orbitRadius = 1;
		orbitCenterCoordinate = new Coordinate();
		coordinate = new Coordinate(this.orbitRadius,0);
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}

	public Coordinate getOrbitCenterCoordinate() {
		return this.orbitCenterCoordinate;
	}
	
	public int getOrbitRadius() {
		return orbitRadius;
	}
	
	public boolean orbit() {
		if (coordinate.getX() - orbitCenterCoordinate.getX() == orbitRadius) {
			coordinate.setX(orbitCenterCoordinate.getX());
			coordinate.setY(orbitCenterCoordinate.getY()-orbitRadius);
			return true;
		}
		else if (coordinate.getY() - orbitCenterCoordinate.getY() == -orbitRadius) {
			coordinate.setX(orbitCenterCoordinate.getX()-orbitRadius);
			coordinate.setY(orbitCenterCoordinate.getY());
			return true;
		}
		else if (coordinate.getX() - orbitCenterCoordinate.getX() == -orbitRadius) {
			coordinate.setX(orbitCenterCoordinate.getX());
			coordinate.setY(orbitCenterCoordinate.getY()+orbitRadius);
			return true;
		}
		else if (coordinate.getY() - orbitCenterCoordinate.getY() == orbitRadius) {
			coordinate.setX(orbitCenterCoordinate.getX()+orbitRadius);
			coordinate.setY(orbitCenterCoordinate.getY());
			return true;
		}else {
			return false;
		}
			
	}
}
