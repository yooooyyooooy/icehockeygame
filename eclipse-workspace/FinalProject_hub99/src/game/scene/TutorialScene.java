package game.scene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TutorialScene extends VBox {
	private ImageView normalBall;
	private ImageView bombBall;
	private ImageView ghostBall;
	private ImageView bomb;
	private ImageView ghost;
	private Image backgroundImg;
	private Label tutorial;
	private Label welcomeTutorial;
	private Label normalBallLabel;
	private Label bombLabel;
	private Label ghostLabel;
	private Label bombBallLabel;
	private Label ghostBallLabel;
	private Label normalBallDefLabel;
	private Label bombBallDefLabel;
	private Label ghostBallDefLabel;
	private Button backBtn;
	private Button startBtn;
	
	public TutorialScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(600);
		this.setPrefHeight(600);
		this.setSpacing(35);
		
		this.normalBall = new ImageView("Blueberry.png");
		this.bombBall = new ImageView("Blueberry.png");
		this.ghostBall = new ImageView("Blueberry.png");
		this.bomb = new ImageView("Coffee.png");
		this.ghost = new ImageView("Coffee.png");
		
		this.backgroundImg = new Image("background.jpg");
		this.setBackground(new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		
		this.tutorial = new Label("Tutorial");
		this.tutorial.setFont(new Font(48));
		
		this.welcomeTutorial = new Label("Welcome to Hub99 hockey game tutorial. There are 3 minutes in each match."
				+ "\n"+"Player1 Control: arrow keys" + "\n"+"Player2 Control: WASD keys");
		this.welcomeTutorial.setFont(new Font(16));
		
		this.bombLabel = new Label("Bomb");
		this.bombLabel.setFont(new Font(16));
		
		this.normalBallLabel = new Label("Normal Ball");
		this.normalBallLabel.setFont(new Font(16));
		
		this.ghostLabel = new Label("Ghost");
		this.ghostLabel.setFont(new Font(16));
		
		this.bombBallLabel = new Label("Bombball");
		this.bombBallLabel.setFont(new Font(16));
		
		this.ghostBallLabel = new Label("Ghostball");
		this.ghostBallLabel.setFont(new Font(16));
		
		this.normalBallDefLabel = new Label("This is a normal ball.");
		this.normalBallDefLabel.setFont(new Font(16));
		
		this.bombBallDefLabel = new Label("When you or your opponent hits the normal ball to the Bomb, the ball "
				+ "\n"+"turns into a Bombball.The  Bombball will explode in 10 seconds if not  "
				+ "\n"+"being scored by either side and whichever side the ball is at, "
						+ "\nthat player loses a point.");
		this.bombBallDefLabel.setFont(new Font(16));
		
		this.ghostBallDefLabel = new Label(" When you or your opponent hits the normal ball to the Ghost, "
				+ "\n"+"the ball turns into a Ghostball. The Ghostball will pass through the club "
				+ "\n"+"and will return to Normal all only if it hits the wall.");
		this.ghostBallDefLabel.setFont(new Font(16));
		
		this.backBtn = new Button("BACK TO MAIN");
		this.startBtn = new Button("START GAME");
		 
		HBox h1 = new HBox();
		HBox h2 = new HBox();
		HBox h3 = new HBox();
		HBox h4 = new HBox(10);
		h4.setAlignment(Pos.BOTTOM_RIGHT);
		h4.setPadding(new Insets(10));
		
		h1.getChildren().addAll(this.normalBall, this.normalBallDefLabel);
		h2.getChildren().addAll(this.bomb, this.bombBallDefLabel, this.bombBall);
		h3.getChildren().addAll(this.ghost, this.ghostBallDefLabel, this.ghostBall);
		h4.getChildren().addAll(this.backBtn, this.startBtn);
		
		this.getChildren().addAll(this.tutorial, this.welcomeTutorial, h1, h2, h3, h4);
		
	}
	
	
	

}
