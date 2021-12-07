import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayImages extends Application
{

	public static void main(String[] args) 
	{
		Application.launch();

	}

	@Override
	public void start(Stage pStage) throws Exception 
	{
		Pane pane = new HBox();
		pane.setPadding(new Insets(5,5,5,5));
		
		Image image = new Image("RocketPiskel.gif");
		pane.getChildren().add(new ImageView(image));
		
		Scene scene = new Scene(pane);
		pStage.setScene(scene);
		pStage.show();
		
	}

}
