package solar;

import java.util.ArrayList;

public class Application {
	private static ArrayList<Planet> planets;
	
	public static String printPlanet(Planet planet) {
		if (planet instanceof Earth) {
			Earth e = (Earth) planet;
			return "Earth's Waste Level is "+e.getWasteLevel();
		}
		else if (planet instanceof Saturn) {
			Saturn e = (Saturn) planet;
			return "Saturn's Speed is "+e.getSpeed();
		}else {
			return "";
		}
	}
	
	public static void main() {
		Earth a = new Earth(4,1);
		Saturn b = new Saturn(2,2);
		planets.add(a);
		planets.add(b);
		for (Planet e : planets) {
			printPlanet(e);
		}
	}
} 
