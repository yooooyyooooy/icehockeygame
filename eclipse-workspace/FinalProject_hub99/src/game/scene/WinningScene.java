package game.scene;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WinningScene extends VBox {
	private String name;
	private Label winninglabel;
	
	public WinningScene(String name) {
		this.setName(name);
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(500);
		this.setPrefHeight(400);
		this.setFillWidth(true);
		
		winninglabel = new Label(this.getName());
		winninglabel.setFont(new Font(48));
		
		this.getChildren().add(winninglabel);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
