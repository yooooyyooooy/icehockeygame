package game.scene;

import game.scene.WinningScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class WelcomeScene extends VBox {
	private Label name;
	private Button playButton;
	private Button tutorialButton;
	private Image backgroundImg;
	
	public WelcomeScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(500);
		this.setPrefHeight(400);
		this.setSpacing(50);
		this.setFillWidth(true);
		
		name = new Label("Hockey Game");
		name.setFont(new Font(48));
		
		playButton = new Button("PLAY");
		playButton.setPrefWidth(150);
		
		tutorialButton = new Button("TUTORIAL");
		tutorialButton.setPrefWidth(150);
	
		
		backgroundImg = new Image("background.jpg");
		
		this.setBackground(new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		
		this.getChildren().addAll(name, playButton, tutorialButton);
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
