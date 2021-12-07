import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class JavaFXButtons extends Application 
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
		Button gButton = new Button("Green");
		pane.getChildren().add(gButton);
		Button bButton = new Button("Blue");
		pane.getChildren().add(bButton);
		Scene scene = new Scene(pane,150,150);
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		pStage.setTitle("Button Demo");
		pStage.setScene(scene);
		pStage.show();
		gButton.setOnAction(e -> pane.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null))));
		bButton.setOnAction(e -> pane.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null))));
	}

}
