import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class JavaFXIntro extends Application 
{

	public static void main(String[] args) 
	{
		Application.launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		TextField textfield = new TextField("Hello, World");
		Scene scene = new Scene(textfield,150,50);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	

}
