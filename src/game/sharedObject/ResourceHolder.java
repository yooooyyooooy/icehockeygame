package game.sharedObject;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ResourceHolder {
	
	
	
//	public static Image normalBall;
//	public static Image gameBackground;
//	public static Image tutorialBackground;
	public static MediaView threeSecWaiting;
//	public static Image ghostBall;
//	public static Image bombBall;
//	public static Image welcomeBackground;

	static {
		loadResource();
	}
	
	public static void loadResource() {
		
//		normalBall = new Image(ClassLoader.getSystemResource("normalball.png").toString());
//		bombBall = new Image(ClassLoader.getSystemResource("bombball.png").toString());
//		ghostBall = new Image(ClassLoader.getSystemResource("ghostball.png").toString());
//		gameBackground = new Image(ClassLoader.getSystemResource("background2.png").toString());
		threeSecWaiting = new MediaView(new MediaPlayer(new Media(ClassLoader.getSystemResource("3SecWaiting.mp4").toString())));
//		tutorialBackground = new Image(ClassLoader.getSystemResource("tutobackground.png").toString());
//		welcomeBackground = new Image(ClassLoader.getSystemResource("background.png").toString());
	
	}
	
	
}
