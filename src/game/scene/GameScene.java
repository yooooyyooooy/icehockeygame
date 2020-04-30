package game.scene;

import game.input.*;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import game.game.*;

public class GameScene extends StackPane {
	private final Image iv = new Image("background2.png");
	private NormalBall ball;
	private Sticks sticks;
	private Canvas canvas;
	
	public GameScene() {
		canvas = new Canvas(iv.getWidth(), iv.getHeight());
		canvas.setVisible(true);
		canvas.setFocusTraversable(true);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		this.setPrefWidth(iv.getWidth());
		this.setPrefHeight(iv.getHeight());
		
		this.setBackground(new Background(new BackgroundImage(this.iv, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
				
		sticks = new Sticks(gc);
		ball = new NormalBall(gc);
		
		addListener();
		
		
		AnimationTimer animation = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				sticks.move(gc);
				if(!sticks.hit(ball)) {
					ball.move(gc);
					InputUtility.getHitKeysPressed().clear();
				}
				
				if(sticks.hit(ball) && !InputUtility.getHitKeysPressed().isEmpty()) {
					sticks.hit(ball);
				}
				ball.bounce(gc);
				ball.draw(gc);
				System.out.println(ball.getXspeed()+"   "+sticks.hit(ball));
			}
		};
		
		animation.start();
		
		this.getChildren().add(canvas);
	
	}

	public void addListener() {
		
		canvas.setOnKeyPressed((KeyEvent event) -> {
				InputUtility.setKeyPressed(event.getCode(), true);
				if(sticks.hit(ball)) {
					InputUtility.sethitKeyPressed(event.getCode(), true);
				}
			});
		
		canvas.setOnKeyReleased((KeyEvent event) -> {
				InputUtility.setKeyPressed(event.getCode(), false);
			});
		
	}

}
