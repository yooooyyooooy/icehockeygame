package Main;

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
		WelcomeScene a = new WelcomeScene();
		a.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PlayerScene b = new PlayerScene();
				Scene newScene = new Scene(b);
				stg.setScene(newScene);
			}
		});
		Scene scene = new Scene(a);
		stg.setTitle("Hockey Game");
		stg.setScene(scene);
		stg.setResizable(false);
		stg.show();
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	

}
