package game.scene;

import game.input.*;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import game.game.*;

public class GameScene extends Pane {
	final Image iv = new Image("background2.png");
	NormalBall ball;
	Stick stick1;
	Stick stick2;
	Canvas canvas;
	
	public GameScene() {
		canvas = new Canvas(iv.getWidth(), iv.getHeight());
		canvas.setVisible(true);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		this.setPrefWidth(iv.getWidth());
		this.setPrefHeight(iv.getHeight());
		
		
		this.setBackground(new Background(new BackgroundImage(this.iv, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
				
		stick1 = new Stick(gc, "Player1");
		stick2 = new Stick(gc, "Player2");
		
		addListener();
		
		AnimationTimer animation = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				stick1.move(gc);
			}
		};
		
		animation.start();
		
		
		this.getChildren().add(canvas);

			
	}

	public Stick getStick1() {
		return stick1;
	}

	public void setStick1(Stick stick1) {
		this.stick1 = stick1;
	}

	public Stick getStick2() {
		return stick2;
	}

	public void setStick2(Stick stick2) {
		this.stick2 = stick2;
	}
	
	public void addListener() {
		
		canvas.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		canvas.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}

}
