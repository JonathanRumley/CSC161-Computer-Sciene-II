import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CSC161Lab8DisplayRandomDice extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			String[] dieFaceImageNames = {	"DieFace1.gif",
											"DieFace2.gif",
											"DieFace3.gif",
											"DieFace4.gif",
											"DieFace5.gif",
					  						"DieFace6.gif"};
			int die1Val = 0;
			int die2Val = 0;
			int playerTotal = 0;
			
			VBox root = new VBox();
			root.setSpacing(20);
			HBox heading = new HBox();
			HBox dieFaces = new HBox();
			HBox buttons = new HBox();
			HBox footer = new HBox();
			
			Scene scene = new Scene(root, 1200, 600);
		// Create Heading	
			Text headingText = new Text();
			headingText.setText("Lab 8 Display Random Dice");
			headingText.setFont(Font.font("verdana",FontWeight.BOLD, FontPosture.REGULAR, 40));
			heading.getChildren().add(headingText);
			heading.setAlignment(Pos.CENTER);
			

			
		// Create Die Faces to display
			int rSub = (int)(Math.random() * 6);
			Image[] dieImages = new Image[6];
			for (int x=0; x<6; x++)
			{
				FileInputStream inputStream = new FileInputStream(dieFaceImageNames[x]);
				dieImages[x] = new Image(inputStream);
			}
			
		// Choose 3 random Die Faces to display	
			rSub = (int)(Math.random() * 6);
			ImageView imageViewDie1 = new ImageView(dieImages[rSub]);
			rSub = (int)(Math.random() * 6);
			ImageView imageViewDie2 = new ImageView(dieImages[rSub]);
			rSub = (int)(Math.random() * 6);
			ImageView imageViewDie3 = new ImageView(dieImages[rSub]);
					
			dieFaces.getChildren().add(imageViewDie1);
			dieFaces.getChildren().add(imageViewDie2);
			dieFaces.getChildren().add(imageViewDie3);
			dieFaces.setAlignment(Pos.CENTER);
			
		// create roll button
			Button rollButton = new Button("Roll");
			EventHandler<ActionEvent> rollButtonPushed = new EventHandler<ActionEvent>()
					{
						@Override
						public void handle(ActionEvent e)
						{
							int newRSub = 0;
							newRSub = (int)(Math.random() * 6);
							imageViewDie1.setImage(dieImages[newRSub]);
							newRSub = (int)(Math.random() * 6);
							imageViewDie2.setImage(dieImages[newRSub]);
							newRSub = (int)(Math.random() * 6);
							imageViewDie3.setImage(dieImages[newRSub]);							
						}
					};
			rollButton.setOnAction(rollButtonPushed);
			buttons.getChildren().add(rollButton);
			buttons.setAlignment(Pos.CENTER);
			
		// Create Footer
			Text footerText = new Text();
			footerText.setText("Created 4/15/2020 during the great Corona-19 Pandemic!");
			footer.getChildren().add(footerText);
			footer.setAlignment(Pos.CENTER);
			
		// Add pieces to the scene
			root.getChildren().add(heading);
			root.getChildren().add(dieFaces);
			root.getChildren().add(buttons);
			root.getChildren().add(footer);
			
		// set Stage and display the scene
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		catch(Exception e)
		{
			System.out.println("Card image files not found");
		}
	}
		
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
