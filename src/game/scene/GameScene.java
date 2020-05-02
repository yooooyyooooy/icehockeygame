package game.scene;

import game.input.*;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
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
	private boolean isStarted = false;
	
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
		
		
		
		
		AnimationTimer animation = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				ball.move(gc);
				sticks.draw(gc);
				if(!isStarted) {
					try {
						Thread.sleep(3000);
						System.out.println("sleep");
						
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
					isStarted = true;
					
				}
				
				addListener();
				sticks.move(gc);
			
				sticks.hit(ball);		
				
				ball.bounce(gc);
				
				if(ball.isWinning(gc)) {
					reset(gc);
					isStarted = false;
				}
			}
		};
		
		animation.start();
		
		this.getChildren().add(canvas);
	
	}

	public void addListener() {
		
		canvas.setOnKeyPressed((KeyEvent event) -> {
				InputUtility.setKeyPressed(event.getCode(), true);
			});
		
		canvas.setOnKeyReleased((KeyEvent event) -> {
				InputUtility.setKeyPressed(event.getCode(), false);
			});
		
	}
	public void reset(GraphicsContext gc) {
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		
		sticks.setX_pos1(sticks.getX1_reset());
		sticks.setY_pos1(sticks.getY1_reset());
		sticks.setX_pos2(sticks.getX2_reset());
		sticks.setY_pos2(sticks.getY2_reset());
		
		ball.setX_coordinate(ball.getX_reset());
		ball.setY_coordinate(ball.getY_reset());
		
		ball.setXspeed(0);
		ball.setYspeed(0);
		
	}
	
}
