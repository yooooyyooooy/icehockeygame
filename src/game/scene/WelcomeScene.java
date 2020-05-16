package game.scene;

import SceneController.SceneController;
import game.sharedObject.ResourceHolder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class WelcomeScene extends VBox {
	private Label headLabel;
	private Button playButton;
	private Button tutorialButton;
	private final Image backgroundImg = ResourceHolder.welcomeBackground;
	private Font headLabelFont = ResourceHolder.gameTitleFont;
	private Font buttonFont =  ResourceHolder.buttonFont1;
	
	
	public WelcomeScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(500);
		this.setPrefHeight(400);
		this.setSpacing(50);
		this.setFillWidth(true);
		
		headLabel = new Label("Hockey Game");
		headLabel.setFont(headLabelFont);
		
		
		
		playButton = new Button("PLAY");
		playButton.setPrefWidth(150);
		playButton.setFont(buttonFont);
		this.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ResourceHolder.clickingSound.play();
				SceneController.setPlayerScene();
			}
		});

		
		tutorialButton = new Button("TUTORIAL");
		tutorialButton.setPrefWidth(150);
		tutorialButton.setFont(buttonFont);
		this.getTutorialButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ResourceHolder.clickingSound.play();
				SceneController.setTutorialScene();
			}
		});
		
		
	
		this.setBackground(new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		
		this.getChildren().addAll(headLabel, playButton, tutorialButton);
	}

	public Button getPlayButton() {
		return playButton;
	}

	public void setPlayButton(Button playButton) {
		this.playButton = playButton;
	}

	public Button getTutorialButton() {
		return tutorialButton;
	}

	public void setTutorialButton(Button tutorialButton) {
		this.tutorialButton = tutorialButton;
	}
}
