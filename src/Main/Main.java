package Main;

import game.scene.GameScene;
import game.scene.PlayerScene;
import game.scene.WelcomeScene;
import game.scene.WinningScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stg) throws Exception {
		// TODO Auto-generated method stub
		WelcomeScene welcomescene = new WelcomeScene();
		PlayerScene playerscene = new PlayerScene();
		GameScene gamescene = new GameScene();
		
		Scene Wscene = new Scene(welcomescene);
		Scene Pscene = new Scene(playerscene);
		Scene Gscene = new Scene(gamescene);
		
		welcomescene.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				playerscene.getP1Name().setText("");
				playerscene.getP2Name().setText("");
				stg.setScene(Pscene);
			}
		});
		
		playerscene.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stg.setScene(Wscene);
			}
		});
		
		playerscene.getOkButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stg.setScene(Gscene);
			}
		});
		
		stg.setTitle("Hockey Game");
		stg.setScene(Wscene);
		stg.setResizable(false);
		stg.show();
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	

}
