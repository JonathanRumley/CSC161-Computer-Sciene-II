// Jonathan Rumley
// CSC_161-101
// September 2020
// Exercise 4 - Java FX

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShowImages extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException
	{
		Pane pane = new HBox(10);
		pane.setPadding(new Insets(5,5,5,5));
		
		Image image = new Image(new FileInputStream("G:\\csc_161\\HappyHalloween1.jpg"));
		
		Image image2 = new Image(new FileInputStream("G:\\csc_161\\HappyHalloween2.png"));
		pane.getChildren().add(new ImageView(image));
		
		ImageView imageView3 = new ImageView(image2);
		pane.getChildren().add(imageView3);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Show Image");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
