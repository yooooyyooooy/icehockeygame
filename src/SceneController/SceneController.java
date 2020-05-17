package SceneController;


import game.input.InputUtility;
import game.scene.GameScene;
import game.scene.PlayerScene;
import game.scene.TutorialScene;
import game.scene.WelcomeScene;
import game.scene.WinningScene;
import game.sharedObject.ResourceHolder;
import game.skill.Perk;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SceneController {
	
	private static Stage stage;
	
	
	public static void setTutorialScene() {
		TutorialScene tutorialScene = new TutorialScene();
		Scene TScene = new Scene(tutorialScene);
		stage.setScene(TScene);
	}
	
	
	public static void setPlayerScene() {
		PlayerScene playerScene = new PlayerScene();
		Scene PScene = new Scene(playerScene);
		
		stage.setScene(PScene);
		
	}
	
	public static void setGameScene(PlayerScene playerScene) {
		GameScene gameScene = new GameScene(playerScene.getP1Name().getText(),
				playerScene.getP2Name().getText(), PlayerScene.getP1Perk(), PlayerScene.getP2Perk());
		Scene GScene = new Scene(gameScene);
		ResourceHolder.themeSongs.stop();
		ResourceHolder.gamethemeSongs.setCycleCount(MediaPlayer.INDEFINITE);
		ResourceHolder.gamethemeSongs.setVolume(0.5);
		ResourceHolder.gamethemeSongs.play();
		stage.setScene(GScene);
		
	}
	
	public static void setWinningScene(String name) {
		InputUtility.getKeysPressed().clear();
		WinningScene winningScene = new WinningScene(name);
		Scene WScene = new Scene(winningScene);
		ResourceHolder.gamethemeSongs.stop();
		ResourceHolder.winningSongs.setVolume(0.5);
		ResourceHolder.winningSongs.play();
		stage.setScene(WScene);
	
	}

	public static void setWelcomeScene() {
		// TODO Auto-generated method stub
		WelcomeScene welcomeScene = new WelcomeScene();
		Scene WScene = new Scene(welcomeScene);
		ResourceHolder.winningSongs.stop();
		ResourceHolder.themeSongs.setCycleCount(MediaPlayer.INDEFINITE);
		ResourceHolder.themeSongs.setVolume(0.2);
		ResourceHolder.themeSongs.play();
		stage.setScene(WScene);
	}
	
	
	
	public static void setStage(Stage stage) {
		   SceneController.stage = stage;
		   
	}

}
