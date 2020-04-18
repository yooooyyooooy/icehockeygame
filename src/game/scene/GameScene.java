package game.scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import game.game.*;

public class GameScene {
	ImageView iv;
	NormalBall ball;
	Stick stick;
	
	GameScene(){
		this.iv = new ImageView(new Image("background2.jpg"));
		
	}
	
}
