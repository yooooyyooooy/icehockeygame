package game.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PlayerScene extends VBox{
	private Label selectTimeText;
	private Button oneMin;
	private Button threeMins;
	private Button fiveMins;
	private TextField p1Name;
	private TextField p2Name;
	private Label p1Label;
	private Label p2Label;
	private Button okButton;
	private Button cancelButton;
	
	public PlayerScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(500);
		this.setPrefHeight(400);
		this.setSpacing(50);
		this.setFillWidth(true);
		
		selectTimeText = new Label("Select Play Time");
		selectTimeText.setFont(new Font(48));
		
		HBox h1 = new HBox(40);
		h1.setAlignment(Pos.CENTER);
		
		oneMin = new Button("1 Minute");
		oneMin.setPrefSize(100, 10);
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
		
		p1Label = new Label("Player 1 name: ");
		p1Label.setFont(new Font(20));
		p2Label = new Label("Player 2 name: ");
		p2Label.setFont(new Font(20));
		p1Name = new TextField();
		p2Name = new TextField();
		grid.add(p1Label, 0, 0);
		grid.add(p1Name, 0, 1);
		grid.add(p2Label, 1, 0);
		grid.add(p2Name, 1, 1);
		
		HBox h2 = new HBox(10);
		h2.setPadding(new Insets(10));
		h2.setAlignment(Pos.BOTTOM_RIGHT);
		okButton = new Button("PLAY GAME!");
		cancelButton = new Button("Cancel");
		h2.getChildren().addAll(cancelButton, okButton);
		
		this.getChildren().addAll(selectTimeText, h1, grid, h2);
		
	}

	public Button getOkButton() {
		return okButton;
	}

	public void setOkButton(Button okButton) {
		this.okButton = okButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(Button cancelButton) {
		this.cancelButton = cancelButton;
	}
	
}
