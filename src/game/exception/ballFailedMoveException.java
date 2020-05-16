package game.exception;

import java.util.ArrayList;

public class ballFailedMoveException extends Exception {
	public static ArrayList<Character> ball_movements = new ArrayList<>();
	public static String message = "failed movement occurs";
	
	static {
		ball_movements.add('?');
	}
	
	public static void isFailed() throws ballFailedMoveException {
		for(int i = 0 ; i < ball_movements.size()-1 ; i++ ) {
			if(ball_movements.get(i) == ball_movements.get(i+1)) {
				throw new ballFailedMoveException();
			}
		}
	}
	
	public void printMessage() {
		System.out.println(message);
	}
}
