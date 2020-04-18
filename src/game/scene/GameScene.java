package game.scene;

import javafx.geometry.Pos;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;


import game.game.*;

public class GameScene extends StackPane {
	final Image iv = new Image("background2.jpg");
	NormalBall ball;
	Stick stick;
	
	public GameScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(iv.getWidth());
		this.setPrefHeight(iv.getHeight());
		
		
		this.setBackground(new Background(new BackgroundImage(this.iv, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		
		
				
	}
	
}
