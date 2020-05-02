package game.scene;

import game.game.Player;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerScene extends VBox{
	private final Image iv = new Image("background3.png");
	private Text selectTimeText;
	private Button oneMin;
	private Button threeMins;
	private Button fiveMins;
	private TextField p1Name;
	private TextField p2Name;
	private Text p1Text;
	private Text p2Text;
	private Button playButton;
	private Button cancelButton;

	


	public PlayerScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(500);
		this.setPrefHeight(400);
		this.setSpacing(50);
		this.setFillWidth(true);
//		this.setBackground(new Background(new BackgroundImage(this.iv, BackgroundRepeat.NO_REPEAT,
//				BackgroundRepeat.NO_REPEAT,
//				BackgroundPosition.DEFAULT,
//				BackgroundSize.DEFAULT)));
		
		selectTimeText = new Text("Select Play Time");
		selectTimeText.setFont(new Font(48));
		
		HBox h1 = new HBox(40);
		h1.setAlignment(Pos.CENTER);
		
		oneMin = new Button("1 Minute");
		oneMin.setPrefSize(100, 10);
		oneMin.setCursor(Cursor.HAND);
		oneMin.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				oneMin.setStyle("-fx-background-color: Green");
			}
		});
		oneMin.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				oneMin.setStyle("-fx-background-color: e0e0e0");
			}
		});
		
		threeMins = new Button("3 Minutes");
		threeMins.setPrefSize(100, 10);
		fiveMins = new Button("5 Minutes");
		fiveMins.setPrefSize(100, 10);
		
		h1.getChildren().addAll(oneMin, threeMins, fiveMins);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(60);
		grid.setPadding(new Insets(25));
		
		p1Text = new Text("Player 1 name: ");
		p1Text.setFont(new Font(20));
		p2Text = new Text("Player 2 name: ");
		p2Text.setFont(new Font(20));
		p1Name = new TextField();
		p2Name = new TextField();
		grid.add(p1Text, 0, 0);
		grid.add(p1Name, 0, 1);
		grid.add(p2Text, 1, 0);
		grid.add(p2Name, 1, 1);
		
		
		
		HBox h2 = new HBox(10);
		h2.setPadding(new Insets(10));
		h2.setAlignment(Pos.BOTTOM_RIGHT);
		playButton = new Button("PLAY GAME!");
		cancelButton = new Button("Cancel");
		h2.getChildren().addAll(cancelButton, playButton);
		
		
		
//		playButton.setOnMouseEntered(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event arg0) {
//				// TODO Auto-generated method stub
//				playButton.setStyle("-fx-background-color: Green");
//			}
//		});
//		playButton.setOnMouseExited(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event arg0) {
//				// TODO Auto-generated method stub
//				playButton.setStyle("-fx-background-color: e0e0e0");
//			}
//		});
		

		
		
		
		this.getChildren().addAll(selectTimeText, h1, grid, h2);
		
	}

	public Button getPlayButton() {
		return playButton;
	}

	public void setPlayButton(Button okButton) {
		this.playButton = okButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(Button cancelButton) {
		this.cancelButton = cancelButton;
	}
	
	public TextField getP1Name() {
		return p1Name;
	}

	public void setP1Name(TextField p1Name) {
		this.p1Name = p1Name;
	}

	public TextField getP2Name() {
		return p2Name;
	}

	public void setP2Name(TextField p2Name) {
		this.p2Name = p2Name;
	}

	
}
