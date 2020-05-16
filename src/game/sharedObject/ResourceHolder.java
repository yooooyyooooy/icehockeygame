package game.sharedObject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

public class ResourceHolder {
	
	public static Image normalBall;
	public static Image gameBackground;
	public static Image tutorialBackground;
	public static Image winningBackground;
	public static Image bombBall;
	public static Image bombItem;
	public static Image bombEffect;
	public static Image ballCracking;
	public static Image bombballCracking;
	public static Image welcomeBackground;
	public static Image playerSceneBackground;
	public static Image iceWall;
	public static ImageView freezingEffect;
	public static Image blockPerkImage;
	public static Image freezePerkImage;
	public static ImageView normalBallImageView;
	public static ImageView bombBallImageView;
	public static ImageView bombImageView;
	public static ImageView celebrateEffect1;
	public static ImageView celebrateEffect2;
	public static ImageView firework1;
	public static ImageView firework2;
	public static Font scoreFont;
	public static Font timeFont;
	public static Font gameTitleFont;
	public static Font buttonFont1;
	public static Font buttonFont2;
	public static Font buttonFont3;
	public static Font headerFont;
	public static Font gameFont;
	public static Font smallGameFont;
	public static Font winningFont;
	public static Font itemSelectionFont;
	public static MediaPlayer themeSongs;
	public static MediaPlayer gamethemeSongs;
	public static MediaPlayer winningSongs;
	public static AudioClip bounceSound;
	public static AudioClip clickingSound;
	public static AudioClip scoringSound;
	public static AudioClip bombExplosionSound;
	public static AudioClip alertSound;
	public static AudioClip blockSound;
	public static AudioClip freezeSound;

	
	static {
		loadResource();
	}
	
	public static void loadResource() {
		
		normalBall = new Image(ClassLoader.getSystemResource("normalball.png").toString() ,30 ,30 ,false, false);
		bombBall = new Image(ClassLoader.getSystemResource("bombball.png").toString(), 30 ,30 ,false, false);
		bombItem = new Image(ClassLoader.getSystemResource("bomb.png").toString(), 50 ,50 ,false, false);
		gameBackground = new Image(ClassLoader.getSystemResource("background2.png").toString());
		tutorialBackground = new Image(ClassLoader.getSystemResource("tutorialSceneBG.png").toString());
		playerSceneBackground = new Image(ClassLoader.getSystemResource("playerSceneBG.png").toString());
		winningBackground = new  Image(ClassLoader.getSystemResource("winningSceneBG.png").toString());
		welcomeBackground = new Image(ClassLoader.getSystemResource("background.png").toString());
		ballCracking = new Image(ClassLoader.getSystemResource("ballCracking.gif").toString() ,60 ,60 ,false, false);
		bombEffect = new Image(ClassLoader.getSystemResource("bombEffect.gif").toString(), 100 ,100 ,false, false);
		bombballCracking = new Image(ClassLoader.getSystemResource("bombballCracking.gif").toString() ,60 ,60 ,false, false);
		iceWall = new Image(ClassLoader.getSystemResource("iceWall.png").toString() ,50 ,348 ,false, false);
		freezingEffect = new ImageView( new Image(ClassLoader.getSystemResource("freezingEffect.gif").toString() ,600 ,600 ,false, false)); 
		blockPerkImage = new Image(ClassLoader.getSystemResource("blockItem.png").toString(),40,40,false,false);
		freezePerkImage = new Image(ClassLoader.getSystemResource("freezeItem.png").toString(),40,40,false,false);
		
		normalBallImageView = new ImageView(new Image(ClassLoader.getSystemResource("normalball.png").toString(),30,30,false,false));
		bombBallImageView = new ImageView(new Image(ClassLoader.getSystemResource("bombball.png").toString(),30,30,false,false));
		bombImageView = new ImageView(new Image(ClassLoader.getSystemResource("bomb.png").toString(),30,30,false,false));
		celebrateEffect1 = new ImageView(new Image(ClassLoader.getSystemResource("celebrateEffect1.gif").toString(), 150, 150, false, false));
		celebrateEffect2 = new ImageView(new Image(ClassLoader.getSystemResource("celebrateEffect2.gif").toString(), 150, 150, false, false));
		firework1 = new ImageView(new Image(ClassLoader.getSystemResource("firework1.gif").toString(), 150, 150, false, false));
		firework2 = new ImageView(new Image(ClassLoader.getSystemResource("firework2.gif").toString(), 150, 150, false, false));
		
		scoreFont = Font.loadFont(ClassLoader.getSystemResource("scoreAndTimeFont.ttf").toExternalForm(),  35);
		timeFont = Font.loadFont(ClassLoader.getSystemResource("scoreAndTimeFont.ttf").toExternalForm(),  45);
		gameTitleFont  = Font.loadFont(ClassLoader.getSystemResource("titleFont.ttf").toExternalForm(),  45);
		buttonFont1 =  Font.loadFont(ClassLoader.getSystemResource("gameFont.ttf").toExternalForm(),  18);
		buttonFont2 =  Font.loadFont(ClassLoader.getSystemResource("gameFont.ttf").toExternalForm(),  15);
		buttonFont3 =  Font.loadFont(ClassLoader.getSystemResource("gameFont.ttf").toExternalForm(),  12);
		
		headerFont = Font.loadFont(ClassLoader.getSystemResource("titleFont.ttf").toExternalForm(),  35);
		gameFont = Font.loadFont(ClassLoader.getSystemResource("gameFont.ttf").toExternalForm(),  16);
		smallGameFont = Font.loadFont(ClassLoader.getSystemResource("gameFont.ttf").toExternalForm(),  12.5);
		winningFont = Font.loadFont(ClassLoader.getSystemResource("gameFont.ttf").toExternalForm(),  38);
		itemSelectionFont = Font.loadFont(ClassLoader.getSystemResource("gameFont.ttf").toExternalForm(),  12);
		
		themeSongs = new MediaPlayer(new Media(ClassLoader.getSystemResource("themeSong.mp4").toString())) ;
		gamethemeSongs = new MediaPlayer(new Media(ClassLoader.getSystemResource("gameThemeSong.mp4").toString())) ;
		winningSongs = new MediaPlayer(new Media(ClassLoader.getSystemResource("winningSound.wav").toString())) ;
		
		bounceSound  =  new AudioClip(ClassLoader.getSystemResource("bouncingWall.mp4").toString());
		clickingSound = new AudioClip(ClassLoader.getSystemResource("clickingSound.mp4").toString());
		scoringSound = new  AudioClip(ClassLoader.getSystemResource("scoringSound.wav").toString());
		bombExplosionSound = new AudioClip(ClassLoader.getSystemResource("bombExplosion.wav").toString());
		alertSound = new AudioClip(ClassLoader.getSystemResource("alertSound.mp3").toString());
		blockSound = new AudioClip(ClassLoader.getSystemResource("blockSound.wav").toString());
		freezeSound = new AudioClip(ClassLoader.getSystemResource("freezeSound.wav").toString());
		
		
	}
	
	
}
