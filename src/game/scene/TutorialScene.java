package game.scene;
import SceneController.SceneController;
import game.sharedObject.ResourceHolder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class TutorialScene extends VBox {
	private ImageView normalBallImageView = ResourceHolder.normalBallImageView;
	private ImageView bombBallImageView = ResourceHolder.bombBallImageView;
	private ImageView bombImageView = ResourceHolder.bombImageView;
	private Image backgroundImg = ResourceHolder.tutorialBackground;
	private Text tutorial;
	private Text welcomeTutorial1;
	private Text welcomeTutorial2;
	private Text welcomeTutorial3;
	private Text normalBallTextLabel;
	private Text bombTextLabel;
	private Text bombBallTextLabel;
	private Text bombDefText;
	private Text normalBallDefText;
	private Text bombBallDefText;
	private Text bombBallRules;
	private Text itemDetails;
	private Text specialRules;
	private Button backBtn;
	private Font headTextFont = ResourceHolder.headerFont;
	private Font gameFont = ResourceHolder.gameFont;
	private Font smallFont = ResourceHolder.smallGameFont;
	private Font buttonFont = ResourceHolder.buttonFont2;

	
	public TutorialScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(750);
		this.setPrefHeight(600);
		this.setSpacing(15);

		this.setBackground(new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		
		tutorial = new Text("Tutorial");
		tutorial.setFont(headTextFont);
		tutorial.setFill(Color.LIGHTGRAY);
		
		welcomeTutorial1 = new Text("Welcome to Hub99 hockey game tutorial.");
		welcomeTutorial1.setFont(gameFont);	
		welcomeTutorial1.setFill(Color.LIGHTGRAY);
		
		welcomeTutorial2 = new Text("There is 1 minute in each match.");
		welcomeTutorial2.setFont(gameFont);		
		welcomeTutorial2.setFill(Color.LIGHTGRAY);
		
		welcomeTutorial3  =  new Text("Player1 Controls : WASD + R(Perks) keys" + 
									"\n"+"Player2 Controls : arrow + space (Perks) keys");
		welcomeTutorial3.setFont(gameFont);
		welcomeTutorial3.setFill(Color.LIGHTGRAY);
		
		bombTextLabel = new Text("Bomb");
		bombTextLabel.setFont(gameFont);
		bombTextLabel.setFill(Color.LIGHTGRAY);
		
		normalBallTextLabel = new Text("Normalball");
		normalBallTextLabel.setFont(gameFont);
		normalBallTextLabel.setFill(Color.LIGHTGRAY);
		
		bombBallTextLabel = new Text("Bombball");
		bombBallTextLabel.setFont(gameFont);
		bombBallTextLabel.setFill(Color.LIGHTGRAY);
		
		bombDefText = new Text("Hit to have fun with a bombball");
		bombDefText.setFont(smallFont);
		bombDefText.setFill(Color.LIGHTGRAY);
		
		normalBallDefText = new Text(" \"Just a normal ball\" ");
		normalBallDefText.setFont(gameFont);
		normalBallDefText.setFill(Color.LIGHTGRAY);
		
		bombBallDefText = new Text(" \"XXX Watch out XXX\" ");
		bombBallDefText.setFont(gameFont);
		bombBallDefText.setFill(Color.LIGHTGRAY);
		
		
		
		
		
		bombBallRules = new Text("-Keep the bombball away from your side"
								+ "\n" + "If it's on your side when it explodes,"
								+ "\n" + "You lose a point XD"); 
		bombBallRules.setFont(gameFont);
		bombBallRules.setFill(Color.LIGHTGRAY);
		
		
		itemDetails = new Text("  -Choose your perks wisely. "
				+ "\n" + "	  There are 2 of them."
				+ "\n" + "More info at the perks buttons");
		itemDetails.setFont(gameFont);
		itemDetails.setFill(Color.LIGHTGRAY);
		
		
		specialRules = new Text("-Don't hit the ball at the very edge "
				+ "\n" + "	   You might break it.");
		specialRules.setFont(gameFont);
		specialRules.setFill(Color.LIGHTGRAY);
		
		

		backBtn = new Button("BACK TO MAIN");
		backBtn.setFont(buttonFont);
		
		this.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ResourceHolder.clickingSound.play();
				SceneController.setWelcomeScene();
				
			}
		});
		

		HBox hw1 = new HBox();
		HBox hw2 = new HBox();
		HBox hw3 = new HBox();
		GridPane g1 = new GridPane();
		HBox hBombballRules = new HBox();
		HBox hItemDetail = new HBox();
		HBox hSpecialRules = new HBox();
		HBox hBackBtn = new HBox();
		
		hw1.setAlignment(Pos.CENTER);
		hw2.setAlignment(Pos.CENTER);
		hw3.setAlignment(Pos.CENTER);
		g1.setAlignment(Pos.CENTER_LEFT);
		g1.setVgap(20);
		g1.setHgap(100);
		g1.setPadding(new Insets(10));
		hBombballRules.setAlignment(Pos.CENTER);
		hItemDetail.setAlignment(Pos.CENTER);
		hSpecialRules.setAlignment(Pos.CENTER);
		hBackBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hBackBtn.setPadding(new Insets(10));
		
		hw1.getChildren().addAll(welcomeTutorial1);
		hw2.getChildren().addAll(welcomeTutorial2);
		hw3.getChildren().addAll(welcomeTutorial3);
		g1.add(normalBallImageView, 0, 0);
		g1.add(normalBallTextLabel, 1,0);
		g1.add(normalBallDefText, 2, 0);
		g1.add(bombBallImageView, 0,1);
		g1.add(bombBallTextLabel, 1, 1);
		g1.add(bombBallDefText, 2, 1);
		g1.add(bombImageView, 0, 2);
		g1.add(bombTextLabel, 1, 2);
		g1.add(bombDefText, 2, 2);
		hBombballRules.getChildren().addAll(bombBallRules);
		hItemDetail.getChildren().addAll(itemDetails);
		hSpecialRules.getChildren().addAll(specialRules);
		hBackBtn.getChildren().addAll(backBtn);
		
		this.getChildren().addAll(tutorial, hw1, hw2, hw3, g1, hBombballRules, hItemDetail, hSpecialRules,hBackBtn);
		
	
	}
	
	

	public Button getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(Button backBtn) {
		this.backBtn = backBtn;
	}

	
}
