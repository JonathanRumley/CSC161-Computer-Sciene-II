import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayRandomDice extends Application
{

	public static void main(String[] args) 
	{
		launch(args);

	}

	@Override
	public void start(Stage pStage) 
	{
		try
		{
		String[] dieImages = {"DieFace1.gif","DieFace2.gif","DieFace3.gif","DieFace4.gif","DieFace5.gif","DieFace6.gif"};
		//int d1Val , d2Val, playerTotal = 0;
		
		VBox root = new VBox();
		root.setSpacing(40);
		HBox heading = new HBox();
		HBox dieFaces = new HBox();
		HBox buttons = new HBox();
		HBox footer = new HBox();
		Scene scene = new Scene(root, 600, 400);
		Text headingText = new Text();
		headingText.setText("Display Random Dice: Lab 8");
		headingText.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, FontPosture.ITALIC, 40));
		heading.getChildren().add(headingText);
		heading.setAlignment(Pos.CENTER);
		
		int random = (int)(Math.random()*6);
		Image[] dieFaceImages = new Image[6];
		for(int x = 0; x < 6; x++)
		{
			FileInputStream inputFile = new FileInputStream(dieImages[x]);
			dieFaceImages[x] = new Image(inputFile);
		}
		
		random = (int)(Math.random() * 6);
		ImageView imageViewDie1 = new ImageView(dieFaceImages[random]);
		random = (int)(Math.random() * 6);
		ImageView imageViewDie2 = new ImageView(dieFaceImages[random]);
		random = (int)(Math.random() * 6);
		ImageView imageViewDie3 = new ImageView(dieFaceImages[random]);
		
		dieFaces.getChildren().add(imageViewDie1);
		dieFaces.getChildren().add(imageViewDie2);
		dieFaces.getChildren().add(imageViewDie3);
		dieFaces.setAlignment(Pos.CENTER);	
		
		
		Button rollButton = new Button("Roll");
		EventHandler<ActionEvent> rollButtonPushed = new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent e)
					{
						int newRandom = 0;
						newRandom = (int)(Math.random()* 6);
						imageViewDie1.setImage(dieFaceImages[newRandom]);
						newRandom = (int)(Math.random()* 6);
						imageViewDie2.setImage(dieFaceImages[newRandom]);
						newRandom = (int)(Math.random()* 6);
						imageViewDie3.setImage(dieFaceImages[newRandom]);
					}
				};
		rollButton.setOnAction(rollButtonPushed);
		buttons.getChildren().add(rollButton);
		buttons.setAlignment(Pos.CENTER);
		
		Text footerText = new Text();
		footerText.setText("Roll your life away, it's 2020, and we have a vaccine on the way...Yay or Nay?");
		footerText.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.NORMAL, FontPosture.ITALIC, 15));
		footer.getChildren().add(footerText);
		footer.setAlignment(Pos.CENTER);
		
		root.setBackground(new Background(new BackgroundFill(Color.GREEN,null, null)));
		
		root.getChildren().add(heading);
		root.getChildren().add(dieFaces);
		root.getChildren().add(buttons);
		root.getChildren().add(footer);
		
		pStage.setScene(scene);
		pStage.show();
			
		}
		catch(Exception e)
		{
			System.out.println("Error: Image files can't be found");
		}
	}
}

