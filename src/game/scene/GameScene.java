package game.scene;

import javafx.geometry.Pos;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;



import game.game.*;

public class GameScene extends Pane {
	final Image iv = new Image("background2.png");
	private double width;
	private double height;
	NormalBall ball;
	Stick stick;
	
	public GameScene() {
		this.setPrefWidth(iv.getWidth());
		this.setPrefHeight(iv.getHeight());
		
		
		this.setBackground(new Background(new BackgroundImage(this.iv, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));	
	}
	
}
