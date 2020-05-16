package game.scene;

import SceneController.SceneController;
import game.sharedObject.ResourceHolder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WinningScene extends StackPane {
	private Image winningSceneBackgroud = ResourceHolder.winningBackground;
	private String name;
	private Text winningLabel;
	private Button backToMain;
	private Font buttonFont = ResourceHolder.buttonFont2;
	private Font winningFont = ResourceHolder.winningFont;
	
	
	public WinningScene(String name) {
		
		this.setName(name);
		this.setBackground(new Background(new BackgroundImage(winningSceneBackgroud, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		this.setPrefHeight(340);
		this.setPrefWidth(700);
		this.setPadding(new Insets(10));
		
		VBox v1 = new VBox();
		v1.setAlignment(Pos.CENTER);
		v1.setSpacing(100);
		
		
		winningLabel = new Text(this.getName());
		winningLabel.setFont(winningFont);
		winningLabel.setStrokeWidth(2);
		winningLabel.setStroke(Color.BLACK);
		winningLabel.setFill(Color.LIGHTGRAY);
		
		
		backToMain = new Button("Back to main");
		backToMain.setFont(buttonFont);
		backToMain.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SceneController.setWelcomeScene();
			}
		});
		
		
		HBox h1 = new HBox();
		h1.setAlignment(Pos.CENTER);
		
		HBox h2 = new HBox();
		h2.setAlignment(Pos.BOTTOM_RIGHT);
		h2.setPadding(new Insets(20));
		
		HBox buttomEffects = new HBox();
		buttomEffects.setAlignment(Pos.BOTTOM_CENTER);
		buttomEffects.setSpacing(100);
		buttomEffects.getChildren().addAll(ResourceHolder.celebrateEffect1, ResourceHolder.celebrateEffect2);
		
		HBox topEffects = new HBox();
		topEffects.setAlignment(Pos.TOP_CENTER);
		topEffects.setSpacing(200);
		topEffects.getChildren().addAll(ResourceHolder.firework1, ResourceHolder.firework2);
		
		VBox allEffects = new VBox();
		allEffects.setSpacing(5);
		allEffects.getChildren().addAll(topEffects, buttomEffects);
		
		h1.getChildren().add(winningLabel);
		h2.getChildren().add(backToMain);
		
		v1.getChildren().add(h1);
				
		this.getChildren().addAll(v1, allEffects, h2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}