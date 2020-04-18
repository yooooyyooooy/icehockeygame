package game.scene;

import javafx.scene.Group;
import javafx.scene.image.Image;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import game.game.*;

public class GameScene extends Pane {
	final Image iv = new Image("background2.png");
	NormalBall ball;
	Stick stick1;
	Stick stick2;
	
	public GameScene() {
		Group group = new Group();
		
		this.setPrefWidth(iv.getWidth());
		this.setPrefHeight(iv.getHeight());
		
		
		this.setBackground(new Background(new BackgroundImage(this.iv, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
				
		stick1 = new Stick(Color.RED);
		stick1.setX(30-stick1.getWidth()/2);
		stick1.setY(this.getPrefHeight()/2-stick1.getHeight()/2);
		
		stick2 = new Stick(Color.BLUE);
		stick2.setX(this.getPrefWidth()-30-stick2.getWidth()/2);
		stick2.setY(this.getPrefHeight()/2-stick2.getHeight()/2);
		
		new Thread((Runnable) stick1).start();
		new Thread((Runnable) stick2).start();
		
		
		
		group.getChildren().addAll(stick1, stick2);
		
		this.getChildren().add(group);
				
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
	
	
}
