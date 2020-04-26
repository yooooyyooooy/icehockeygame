package game.input;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class InputUtility {
	private static ArrayList<KeyCode> keysPressed = new ArrayList<>();
	private static ArrayList<KeyCode> hitKeysPressed = new ArrayList<>();
	
	public static boolean getKeyPressed(KeyCode keycode) {
		return keysPressed.contains(keycode);
	}
	
	public static boolean getHitKeyPressed(KeyCode keycode) {
		return hitKeysPressed.contains(keycode);
	}
	
	public static void setKeyPressed(KeyCode keycode,boolean pressed) {
		if(pressed){
			if(!keysPressed.contains(keycode)){
				keysPressed.add(keycode);
			}
		}else{
			keysPressed.remove(keycode);
		}
//		System.out.println(keysPressed);
	}
	
	public static void sethitKeyPressed(KeyCode keycode,boolean pressed) {
		if(pressed){
			if(!hitKeysPressed.contains(keycode)){
				hitKeysPressed.add(keycode);
			}
		}else{
			hitKeysPressed.remove(keycode);
		}
		System.out.println(hitKeysPressed);
	}
}
