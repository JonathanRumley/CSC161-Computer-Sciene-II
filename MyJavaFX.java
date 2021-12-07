import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class MyJavaFX extends Application {
	@Override
	public void start(Stage mainStage)
	{
		Button btContinue = new Button("Continue?");
		Scene window = new Scene(btContinue,400,450);
		mainStage.setTitle("My JavaFX Yo");;
		mainStage.setScene(window);
		mainStage.show();
	}
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

}
