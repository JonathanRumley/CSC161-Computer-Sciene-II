import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.stage.*;


public class RocketGif extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		Pane pane = new HBox();
		pane.setPadding(new Insets(5,5,5,5));
		Image image = new Image("RocketPiskel.gif");
		pane.getChildren().add(new ImageView(image));
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Display Rocket Gif");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) 
	{
		Application.launch();
	}
}
