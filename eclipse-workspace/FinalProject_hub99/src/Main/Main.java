package Main;

import game.scene.WelcomeScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stg) throws Exception {
		// TODO Auto-generated method stub
		WelcomeScene a = new WelcomeScene();
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
