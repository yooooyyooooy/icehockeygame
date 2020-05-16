package Main;


import SceneController.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


	@Override
	public void start(Stage stg) {
		// TODO Auto-generated method stub
		
		stg.setTitle("Hockey Game");
		stg.setResizable(false);
		SceneController.setStage(stg);
		SceneController.setWelcomeScene();
		stg.show();
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			launch(args);
	}
	

}
