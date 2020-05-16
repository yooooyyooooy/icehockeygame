package game.scene;

import SceneController.SceneController;
import game.sharedObject.ResourceHolder;
import game.skill.Perk;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class PlayerScene extends VBox{
	private final Image backgroundImg = ResourceHolder.playerSceneBackground;
	private Text headText;
	private TextField p1Name;
	private TextField p2Name;
	private Text p1Text;
	private Text p2Text;
	private Text p1PerkText;
	private Text p2PerkText;
	private Button p1BlockItemButton;
	private Button p1FreezeItemButton;
	private Button p2BlockItemButton;
	private Button p2FreezeItemButton;
	private Button playButton;
	private Button cancelButton;
	private Font headTextFont = ResourceHolder.headerFont;
	private Font detailFont = ResourceHolder.gameFont;
	private Font itemFont = ResourceHolder.itemSelectionFont;
	private Font buttonFont = ResourceHolder.buttonFont3;
	
	private static Perk p1Perk = Perk.NONE;
	private  static Perk p2Perk = Perk.NONE;

	public PlayerScene() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(730);
		this.setPrefHeight(420);
		this.setSpacing(20);
		this.setFillWidth(true);
		
		this.setBackground(new Background(new BackgroundImage(this.backgroundImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
	
		headText = new Text("Enter Your Name");
		headText.setFont(headTextFont);
		headText.setFill(Color.LIGHTGRAY);
	
		HBox h1 = new HBox(100);
		h1.setAlignment(Pos.CENTER);
		
	
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(40);
		grid.setHgap(150);
		grid.setPadding(new Insets(25));
		
		p1Text = new Text("Player 1 name");
		p1Text.setFont(detailFont);
		p1Text.setFill(Color.LIGHTGRAY);
		
		p2Text = new Text("Player 2 name");
		p2Text.setFont(detailFont);
		p2Text.setFill(Color.LIGHTGRAY);
		
		p1Name = new TextField();
		p2Name = new TextField();
		
		grid.add(p1Text, 0, 0);
		grid.add(p1Name, 0, 1);
		grid.add(p2Text, 1, 0);
		grid.add(p2Name, 1, 1);
		
		
		GridPane mainBtnGrid = new GridPane();
		mainBtnGrid.setVgap(20);
		mainBtnGrid.setHgap(30);
		mainBtnGrid.setPadding(new Insets(25));
		
		VBox p1VBox = new VBox();
		p1VBox.setAlignment(Pos.CENTER);
		p1VBox.setSpacing(10);
		p1VBox.setPadding(new Insets(8));

		VBox p2VBox = new VBox();
		p2VBox.setAlignment(Pos.CENTER);
		p2VBox.setSpacing(10);
		p2VBox.setPadding(new Insets(8));

		GridPane itemBtnGrid1 = new GridPane();
		itemBtnGrid1.setHgap(20);
		itemBtnGrid1.setVgap(20);
		itemBtnGrid1.setPadding(new Insets(25));
		
		
		GridPane itemBtnGrid2 = new GridPane();
		itemBtnGrid2.setHgap(20);
		itemBtnGrid2.setVgap(20);
		itemBtnGrid2.setPadding(new Insets(25));
		
		
		HBox controlButtonBox = new HBox();
		controlButtonBox.setAlignment(Pos.CENTER);
		controlButtonBox.setSpacing(20);
		
		
		playButton = new Button("PLAY GAME");
		playButton.setFont(buttonFont);
		
		this.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ResourceHolder.clickingSound.play();
				if( PlayerScene.this.getP1Name().getText().isEmpty() ||
					PlayerScene.this.getP2Name().getText().isEmpty()
						) {
					ResourceHolder.alertSound.play();
					noNameError();
				
				}else if( PlayerScene.this.getP1Name().getText().length() >8 ||
					PlayerScene.this.getP2Name().getText().length() >= 8
						) {
					ResourceHolder.alertSound.play();
					longNameError();
					
				
				}else if( PlayerScene.this.getP1Name().getText().equals(PlayerScene.this.getP2Name().getText())
						) {
					ResourceHolder.alertSound.play();
					sameNameError();
					
				
				}else if(PlayerScene.p1Perk == Perk.NONE || PlayerScene.p2Perk == Perk.NONE) {
					ResourceHolder.alertSound.play();
					noPerkError();
				}
				
				else  {
					System.out.println("Welcome " + PlayerScene.this.getP1Name().getText() + "!");
					System.out.println("Welcome " + PlayerScene.this.getP2Name().getText() + "!");
					SceneController.setGameScene(PlayerScene.this);
					}
				}

		});
		
		cancelButton = new Button("Cancel");
		cancelButton.setFont(buttonFont);
	
		
		this.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ResourceHolder.clickingSound.play();
				SceneController.setWelcomeScene();
			}
		});
		
		
		controlButtonBox.getChildren().addAll(cancelButton,playButton);
		
	
		p1PerkText = new Text("P1 Choose Perk");
		p1PerkText.setFont(itemFont);
		p1PerkText.setFill(Color.LIGHTGRAY);
		
		p2PerkText = new Text("P2 Choose Perk");
		p2PerkText.setFont(itemFont);
		p2PerkText.setFill(Color.LIGHTGRAY);
	
        
        ImageView  blockImg1= new ImageView(ResourceHolder.blockPerkImage);
        blockImg1.setFitWidth(30);
        blockImg1.setFitHeight(30);
        
        ImageView  freezeImg1= new ImageView(ResourceHolder.freezePerkImage);
        freezeImg1.setFitWidth(30);
        freezeImg1.setFitHeight(30);
        
        ImageView  blockImg2= new ImageView(ResourceHolder.blockPerkImage);
        blockImg2.setFitWidth(30);
        blockImg2.setFitHeight(30);
        
        ImageView  freezeImg2= new ImageView(ResourceHolder.freezePerkImage);
        freezeImg2.setFitWidth(30);
        freezeImg2.setFitHeight(30);
	
        Tooltip	blockTooltip = new Tooltip();
		blockTooltip.setFont(new Font(12));
		blockTooltip.setText("Block Item: "
								+ "\n" + "	- Prevents ball from scoring." +
								"\n" + "	- 20 secs cooldown.");
		
		Tooltip	freezeTooltip = new Tooltip();
		freezeTooltip.setFont(new Font(12));
		freezeTooltip.setText("Freeze Item: "
									+ "\n" + "	- Slows down the ball." +
									"\n" + "	- 15 secs cooldown.");
		
		
        
        p1BlockItemButton = new Button();
		p1BlockItemButton.setGraphic(blockImg1);;
		p1BlockItemButton.setPrefSize(30,30);
		p1BlockItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
		p1BlockItemButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!(p1Perk == Perk.BLOCKING) ) {
					ResourceHolder.blockSound.play();
					setP1Perk(Perk.BLOCKING);
					p1BlockItemButton.setBackground(new Background(new BackgroundFill(Color.KHAKI, new CornerRadii(5), Insets.EMPTY)));
					p1FreezeItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
				}else {
					ResourceHolder.blockSound.play();
					setP1Perk(Perk.NONE);
					p1BlockItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
				}
			}
		});
		p1BlockItemButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				blockTooltip.show(p1BlockItemButton, arg0.getScreenX(), arg0.getScreenY()+10);
			}
		});
		p1BlockItemButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				blockTooltip.hide();
			}
		});
		
		
		
		p1FreezeItemButton = new Button();
		p1FreezeItemButton.setGraphic(freezeImg1);;
		p1FreezeItemButton.setPrefSize(30,30);
		p1FreezeItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
		p1FreezeItemButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!(p1Perk == Perk.FREEZING) ) {
					ResourceHolder.freezeSound.play();
					setP1Perk(Perk.FREEZING);
					p1FreezeItemButton.setBackground(new Background(new BackgroundFill(Color.KHAKI, new CornerRadii(5), Insets.EMPTY)));
					p1BlockItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
				}else {
					ResourceHolder.blockSound.play();
					setP1Perk(Perk.NONE);
					p1FreezeItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
				}
			}
		});
		p1FreezeItemButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				freezeTooltip.show(p1FreezeItemButton, arg0.getScreenX(), arg0.getScreenY()+10);
			}
		});
		p1FreezeItemButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				freezeTooltip.hide();
			}
		});
		
		
		
		
		itemBtnGrid1.add(p1BlockItemButton, 0, 0);
		itemBtnGrid1.add(p1FreezeItemButton, 1, 0);
		
		
		
		p2BlockItemButton = new Button();
		p2BlockItemButton.setGraphic(blockImg2);
		p2BlockItemButton.setPrefSize(30,30);
		p2BlockItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
		p2BlockItemButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!(p2Perk == Perk.BLOCKING) ) {
					ResourceHolder.blockSound.play();
					setP2Perk(Perk.BLOCKING);
					p2BlockItemButton.setBackground(new Background(new BackgroundFill(Color.KHAKI, new CornerRadii(5), Insets.EMPTY)));
					p2FreezeItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
				}else {
					ResourceHolder.blockSound.play();
					setP2Perk(Perk.NONE);
					p2BlockItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
				}
			}
		});
		p2BlockItemButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				blockTooltip.show(p2FreezeItemButton, arg0.getScreenX(), arg0.getScreenY()+10);
			}
		});
		p2BlockItemButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				blockTooltip.hide();
			}
		});
		
			
		p2FreezeItemButton = new Button();
		p2FreezeItemButton.setGraphic(freezeImg2);
		p2FreezeItemButton.setPrefSize(30,30);
		p2FreezeItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
		p2FreezeItemButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!(p2Perk == Perk.FREEZING) ) {
					ResourceHolder.freezeSound.play();
					setP2Perk(Perk.FREEZING);
					p2FreezeItemButton.setBackground(new Background(new BackgroundFill(Color.KHAKI, new CornerRadii(5), Insets.EMPTY)));
					p2BlockItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
				}else {
					ResourceHolder.blockSound.play();
					setP2Perk(Perk.NONE);
					p2FreezeItemButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
				}
			}
		});
		p2FreezeItemButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				freezeTooltip.show(p2FreezeItemButton, arg0.getScreenX(), arg0.getScreenY()+10);
			}
		});
		p2FreezeItemButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				freezeTooltip.hide();
			}
		});
		
		
		
		
		
		itemBtnGrid2.add(p2BlockItemButton, 0, 0);
		itemBtnGrid2.add(p2FreezeItemButton, 1, 0);
		
		p1VBox.getChildren().addAll(p1PerkText,itemBtnGrid1);
	
		p2VBox.getChildren().addAll(p2PerkText,itemBtnGrid2);
		
		mainBtnGrid.add(p1VBox, 0, 0);
		mainBtnGrid.add(p2VBox, 1, 0);
		mainBtnGrid.add(controlButtonBox, 3, 0);

		this.getChildren().addAll(headText, h1, grid, mainBtnGrid);
		
	}
	
	public void longNameError() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Your name(s) is/are too long!");
		alert.showAndWait();
	}
	
	
	public void noNameError() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Please enter your name(s).");
		alert.showAndWait();
	}
	
	public void sameNameError() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Your names cannot be the same.");
		alert.showAndWait();
	}
	
	
	public void noPerkError() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Please select your perk(s).");
		alert.showAndWait();
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

	public static Perk getP1Perk() {
		return p1Perk;
	}

	public static void setP1Perk(Perk p1Perk) {
		PlayerScene.p1Perk = p1Perk;
	}

	public static Perk getP2Perk() {
		return p2Perk;
	}

	public static void setP2Perk(Perk p2Perk) {
		PlayerScene.p2Perk = p2Perk;
	}

	
}
