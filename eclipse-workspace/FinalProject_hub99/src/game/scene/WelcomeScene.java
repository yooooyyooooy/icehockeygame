package game.scene;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WelcomeScene extends VBox {
	private Label name;
	private Button playButton;
	private Button tutorialButton;
	private Image backgroundImg;
	
	public WelcomeScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(400);
		this.setSpacing(50);
		this.setFillWidth(true);
		
		name = new Label("Hackey Game");
		name.setFont(new Font(48));
		
		playButton = new Button("PLAY");
		playButton.setPrefWidth(150);
		
		tutorialButton = new Button("TUTORIAL");
		tutorialButton.setPrefWidth(150);
		
		backgroundImg = new Image();
		
		this.setBackground(new Background(backgroundImg));
		
		
	}
}
