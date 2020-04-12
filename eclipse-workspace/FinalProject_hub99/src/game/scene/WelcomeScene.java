package game.scene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
		this.setPrefWidth(400);
		this.setPrefHeight(300);
		this.setSpacing(50);
		this.setFillWidth(true);
		
		name = new Label("Hockey Game");
		name.setFont(new Font(48));
		
		playButton = new Button("PLAY");
		playButton.setPrefWidth(150);
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tutorialButton = new Button("TUTORIAL");
		tutorialButton.setPrefWidth(150);
		tutorialButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		backgroundImg = new Image("background.png");
		
		this.setBackground(new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		
		this.getChildren().addAll(name, playButton, tutorialButton);
	}
}
