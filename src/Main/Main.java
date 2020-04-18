package Main;

import game.game.NormalBall;
import game.game.Stick;
import game.scene.GameScene;
import game.scene.PlayerScene;
import game.scene.TutorialScene;
import game.scene.WelcomeScene;
import game.scene.WinningScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stg) throws Exception {
		// TODO Auto-generated method stub
		WelcomeScene welcomescene = new WelcomeScene();
		PlayerScene playerscene = new PlayerScene();
		GameScene gamescene = new GameScene();
		TutorialScene tutorialscene = new TutorialScene();
		
		Scene Wscene = new Scene(welcomescene);
		Scene Pscene = new Scene(playerscene);
		Scene Gscene = new Scene(gamescene);
		Scene TScene = new Scene(tutorialscene);
		
		welcomescene.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				playerscene.getP1Name().setText("");
				playerscene.getP2Name().setText("");
				stg.setScene(Pscene);
			}
		});
		
		welcomescene.getTutorialButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stg.setScene(TScene);
			}
		});
		
		playerscene.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stg.setScene(Wscene);
			}
		});
		
		playerscene.getOkButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stg.setScene(Gscene);
			}
		});
		
		tutorialscene.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stg.setScene(Wscene);
			}
		});
		
		tutorialscene.getplayBtn().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stg.setScene(Gscene);
			}
		});
		 
		Group g = new Group(); //hold puck and stick
		gamescene.getChildren().add(g);
		
		// Player1 Stick
		Stick player1Stick  = new Stick(10,70,Color.RED);
			player1Stick.setX(30-player1Stick.getWidth()/2);
			player1Stick.setY(gamescene.getPrefHeight()/2-player1Stick.getHeight()/2);
			player1Stick.move();
			player1Stick.setFocusTraversable(true);
		// Player2 Stick
		Stick player2Stick  = new Stick(10,70, Color.BROWN);
			player2Stick.setX(gamescene.getPrefWidth()-30-player2Stick.getWidth()/2);
			player2Stick.setY(gamescene.getPrefHeight()/2-player2Stick.getHeight()/2);
			player2Stick.move();
			player2Stick.setFocusTraversable(true);
//		NormalBall normalBall = new NormalBall(x, y)
		
		g.getChildren().addAll(player2Stick,player1Stick);
		
		stg.setTitle("Hockey Game");
		stg.setScene(Wscene);
		stg.setResizable(false);
		stg.show();
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	

}
