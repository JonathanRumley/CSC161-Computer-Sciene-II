import java.io.FileInputStream;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

/* Jonathan Rumley
 * CSC240 - Seely
 * 07/29/21
 * Term Project - 30 or Bust: GUI Version
 * 
 */

public class ProjectGUI30orBust extends Application
{
	int die1Value = 0;
	int die2Value = 0;
	String prompt;	
	int diceTotal = 0;
	int diceTotal2 = 0;
	int gameTotal = 0;				
	int gameTotal2 = 0;
	boolean player1Turn = true;
	Button keepValueButton;			
	Button rollButton;				
	Button exitButton;				
	
	
	public static void main(String[] args) 
	{
		Application.launch();

	}

	@Override
	public void start(Stage pStage) throws Exception 
	{
		try
		{
			String[] dieFace = { "DieFace1.gif", "DieFace2.gif", "DieFace3.gif", "DieFace4.gif", "DieFace5.gif","DieFace6.gif"};
			Text msgText = new Text();
			Text footerText = new Text();
			TextField nameField = new TextField("");
			TextField nameField2 = new TextField("");
			
			VBox root = new VBox();
			root.setSpacing(20);
			HBox heading = new HBox();
			HBox dieFaces = new HBox();
			HBox radioButtons = new HBox(25);
			HBox buttons = new HBox(5);
			VBox names = new VBox(5);
			HBox playerName = new HBox(5);
			HBox playerName2 = new HBox(5);
			HBox messages = new HBox();
			HBox footer = new HBox();
			
			Scene scene = new Scene(root, 700, 500);
			
			Text headingText = new Text();
			headingText.setText("Project: 30 or Bust");
			headingText.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, FontPosture.ITALIC, 60));
			heading.getChildren().add(headingText);
			heading.setAlignment(Pos.CENTER);
			
			int rSub = (int)(Math.random()*6);
			Image[] dieImages = new Image[6];
			for(int x = 0; x < 6; x++)
			{
				FileInputStream inputStream = new FileInputStream(dieFace[x]);
				dieImages[x] = new Image(inputStream);
			}
			
			rSub =(int)(Math.random()*6);
			die1Value = rSub +1;
			
			ImageView imageViewDie1 = new ImageView(dieImages[rSub]);
			rSub =(int)(Math.random()*6);
			die2Value = rSub +1;
			
			ImageView imageViewDie2 = new ImageView(dieImages[rSub]);
			diceTotal = (die1Value + die2Value);
			
			dieFaces.getChildren().add(imageViewDie1);
			dieFaces.getChildren().add(imageViewDie2);
			dieFaces.setAlignment(Pos.CENTER);
			
			ToggleGroup chooseAmountButtons = new ToggleGroup();
			
			RadioButton die1Button = new RadioButton("Die 1");  //+die1Value);
			die1Button.setTextFill(Color.WHITE);
			die1Button.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, 15));
			die1Button.setAlignment(Pos.CENTER_RIGHT);
			die1Button.setToggleGroup(chooseAmountButtons);
			
			RadioButton die2Button = new RadioButton("Die 2");  //+die2Value);
			die2Button.setTextFill(Color.WHITE);
			die2Button.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, 15));
			die2Button.setAlignment(Pos.CENTER_RIGHT);
			die2Button.setToggleGroup(chooseAmountButtons);
			
			RadioButton diceButton = new RadioButton("Both Dice"); //+diceTotal);
			diceButton.setTextFill(Color.WHITE);
			diceButton.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, 15));
			diceButton.setAlignment(Pos.CENTER_RIGHT);
			diceButton.setToggleGroup(chooseAmountButtons);
			
			radioButtons.getChildren().add(die1Button);
			radioButtons.getChildren().add(die2Button);
			radioButtons.getChildren().add(diceButton);
			radioButtons.setAlignment(Pos.CENTER);
			
			
			rollButton = new Button("Roll");
			rollButton.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, FontPosture.ITALIC, 15));
			EventHandler<ActionEvent> rollButtonPushed = new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
					root.getChildren().remove(footer);
					root.getChildren().remove(names);
					int newRSub = 0;
					newRSub = (int)(Math.random()*6);
					die1Value = newRSub +1;
					imageViewDie1.setImage(dieImages[newRSub]);
					newRSub = (int)(Math.random()*6);
					die2Value = newRSub + 1;
					imageViewDie2.setImage(dieImages[newRSub]);
					diceTotal = die1Value + die2Value;
					if(player1Turn)
					prompt = nameField.getText() + ", your game total: " + gameTotal;
					else
						prompt = nameField2.getText() + ", your game total: " + gameTotal2;
					prompt += "\n\nYou have rolled: " + die1Value + ", " + die2Value;
					prompt += "\n\nTotal of both dice: ";
					prompt += diceTotal;
					msgText.setText(prompt);
					if(keepValueButton.isDisabled())
					{
						enableDisableKeepValuesButton();
					}
					enableDisableRollButton();
				}
			};
			rollButton.setOnAction(rollButtonPushed);
			buttons.getChildren().add(rollButton);
			
			keepValueButton = new Button("Keep Selected Value");
			keepValueButton.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, FontPosture.ITALIC, 15));
			EventHandler<ActionEvent> keepValueButtonPushed = new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
					if(die1Button.isSelected())
					{
						if(player1Turn)
						gameTotal += die1Value;
						else
							gameTotal2 += die1Value;
					}
					if(die2Button.isSelected())
					{
						if(player1Turn)
						gameTotal += die2Value;
						else
							gameTotal2 += die2Value;
					}
					if(diceButton.isSelected())
					{
						if(player1Turn)
						gameTotal += (die1Value + die2Value);
						else
							gameTotal2 += (die1Value + die2Value);
					}
					if(player1Turn)
					{
						prompt = nameField.getText() + ", your new game total: " + gameTotal;
					}
					else
						prompt = nameField2.getText() + ", your new game total: " + gameTotal2;
					
					msgText.setText(prompt);
					
					if(player1Turn)
					{	
						if(gameTotal > 30)
						{
							gameTotal = 0;
							prompt = nameField.getText() + " you went over 30. YOU BUST!! " +
							      "\n\nYour game total has been reset to 0!";
							msgText.setText(prompt);
						}
						if(gameTotal == 30)
						{
							root.getChildren().remove(radioButtons);
							root.getChildren().remove(buttons);
							root.getChildren().remove(names);
	
							prompt = "Congratulations on hitting 30 " + nameField.getText() + 
									" ... YOU WIN....absolutely nothing, but a yeeeeeeeeehaw!!";
							headingText.setText(prompt);
						}
						
						enableDisablePlayer1Turn();
						enableDisableKeepValuesButton();
						if(rollButton.isDisabled())
						{
							enableDisableRollButton();
						}
					}
					else
					{	
						if(gameTotal2 > 30)
						{
							gameTotal2 = 0;
							prompt = nameField2.getText() + " you went over 30. YOU BUST!! " +
							      "\n\nYour game total has been reset to 0!";
							msgText.setText(prompt);
						}
						if(gameTotal2 == 30)
						{
							root.getChildren().remove(radioButtons);
							root.getChildren().remove(buttons);
							root.getChildren().remove(names);
	
							prompt = "Congratulations " + nameField2.getText() + 
									" ... YOU WIN!!";
							headingText.setText(prompt);
						}
						
						enableDisablePlayer1Turn();
						enableDisableKeepValuesButton();
						if(rollButton.isDisabled())
						{
							enableDisableRollButton();
						}
					}
				}
			};
			
			exitButton = new Button("Exit");
			exitButton.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, FontPosture.ITALIC, 15));
			EventHandler<ActionEvent> exitButtonPushed = new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
					Platform.exit();
				}
			};
						
			keepValueButton.setOnAction(keepValueButtonPushed);
			keepValueButton.setDisable(true);
			buttons.getChildren().add(keepValueButton);

			exitButton.setOnAction(exitButtonPushed);
			buttons.getChildren().add(exitButton);
			
			buttons.setAlignment(Pos.CENTER);
			
			Label nameLabel = new Label("1st Players Name: ");
			Label nameLabel2 = new Label("2nd Players Name: ");
			
			nameLabel.setTextFill(Color.WHITE);
			nameLabel.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, FontPosture.ITALIC, 15));
			playerName.getChildren().addAll(nameLabel, nameField);
			playerName.setAlignment(Pos.CENTER);
			
			nameLabel2.setTextFill(Color.WHITE);
			nameLabel2.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, FontPosture.ITALIC, 15));
			playerName2.getChildren().addAll(nameLabel2, nameField2);
			playerName2.setAlignment(Pos.CENTER);
			names.getChildren().add(playerName);
			names.getChildren().add(playerName2);
			
			msgText.setText("Welcome to the Game - 30 or Bust, Ready to Roll?");
			msgText.setFill(Color.WHITE);
			msgText.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, FontPosture.ITALIC, 20));
			messages.getChildren().add(msgText);
			messages.setAlignment(Pos.CENTER);
			
			footerText.setText("Luck is apart of life, how are you feeling?");
			footerText.setFill(Color.WHITE);
			footerText.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BLACK, FontPosture.ITALIC, 20));
			footer.getChildren().add(footerText);
			footer.setAlignment(Pos.CENTER);
			
			root.setBackground(new Background(new BackgroundFill(Color.GREEN,null, null)));
			root.getChildren().add(heading);
			root.getChildren().add(dieFaces);
			root.getChildren().add(radioButtons);
			root.getChildren().add(buttons);
			root.getChildren().add(names);
			root.getChildren().add(messages);
			root.getChildren().add(footer);
	
			pStage.setScene(scene);
			pStage.show();
			
		}
		catch(Exception e)
		{
			System.out.println("Error: Image files can't be found");
		}
	
	}
	public void enableDisableKeepValuesButton()
	{
		if(keepValueButton.isDisabled())
		{
			keepValueButton.setDisable(false);
		}
		else
		{
			keepValueButton.setDisable(true);
		}
		
	}
		
	public void enableDisableRollButton()
	{
		if(rollButton.isDisabled())
		{
			rollButton.setDisable(false);
		}
		else
		{
			rollButton.setDisable(true);
		}
			
	}
	
	private void enableDisablePlayer1Turn() 
	{
		if(player1Turn) player1Turn = false;
		else player1Turn = true;
	}
	
	public void enableDisableExitButton()
	{
		if(exitButton.isDisabled())
		{
			exitButton.setDisable(false);
		}
		else
		{
			exitButton.setDisable(true);
		}
			
	}
}
