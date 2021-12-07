
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ConnectFour extends Application 
{
	
	private char turn = 'R';
	private Label lbl = new Label("Player 1's Turn");
	private Cell[][] cell = new Cell[4][4];
	
	
	public static void main(String[] args)
	{
		Application.launch();
	}

	@Override
	public void start(Stage pStage) throws Exception 
	{
		GridPane pane = new GridPane();
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				pane.add(cell[i][j] = new Cell(), j , i);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(lbl);
		
		Scene scene = new Scene(borderPane, 1500, 1000);
		pStage.setTitle("Connect Four");
		pStage.setScene(scene);
		pStage.show();
	}
	
	public boolean spotTaken() 
	{
		for(int i = 0; i <4; i++)
			for(int j = 0; j < 4; j++)
				if(cell[i][j].getToken() == ' ')
					return false;
		return true;	
	}

	public boolean isWon(char token) 
	{
		
		for(int i = 0; i < 4; i++)
			if(cell[i][0].getToken() == token && cell[i][1].getToken() == token && cell[i][2].getToken() == token && cell[i][3].getToken() == token) 
			{
				return true;
			}
		
		for(int j = 0; j<4; j++)
			if(cell[0][j].getToken() == token && cell[1][j].getToken() == token && cell[2][j].getToken() == token && cell[3][j].getToken() == token) 
			{
				return true;
			}
			if(cell[0][0].getToken() == token && cell[1][1].getToken() == token && cell[2][2].getToken() == token && cell[3][3].getToken() == token)
			{
				return true;
			}
			if(cell[0][3].getToken() == token && cell[1][2].getToken() == token && cell[2][1].getToken() == token && cell[3][0].getToken() == token)
			{
				return true;
			}
			if(cell[0][1].getToken() == token && cell[1][1].getToken() == token && cell[2][1].getToken() == token && cell[3][1].getToken() == token) 
			{
				return true;
			}
			if(cell[0][2].getToken() == token && cell[1][2].getToken() == token && cell[2][2].getToken() == token && cell[3][2].getToken() == token) 
			{
				return true;
			}
			if(cell[0][3].getToken() == token && cell[1][3].getToken() == token && cell[2][3].getToken() == token && cell[3][3].getToken() == token) 
			{
				return true;
			}
		
			return false;	
	}

	public class Cell extends Pane 
	{
		private char token = ' ';
		
		public Cell() 
		{
			setStyle("-fx-border-color: black");
			this.setPrefSize(2000,2000);
			this.setOnMouseClicked(e->handleMouseClick());
	
		}
		
		public char getToken() 
		{
			return token;
		}

		public void setToken(char x) 
		{
			token = x;
			
			if(token == 'R') 
			{
				Line line1 = new Line(10,10,this.getWidth() - 10, this.getHeight() - 10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				Line line2 = new Line(10, this.getHeight()-10, this.getWidth() - 10, 10);
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));
			
			this.getChildren().addAll(line1,line2);
			}
			else if(token == 0); 
			{
				Ellipse ellipse = new Ellipse(this.getWidth()/2,this.getHeight()/2,this.getWidth()/2-10,this.getHeight()/2-10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);
				getChildren().add(ellipse);
				
			}
		}
		
		private void handleMouseClick() 
		{
			if (token == ' ' && turn != ' ') 
			{
				setToken(turn);
				
				if(isWon(turn)) 
				{
					lbl.setText(turn + " won! The game is over");
					turn = ' '; 
				}
				else if(spotTaken()) 
				{
					lbl.setText("Draw! The game is over");
					turn = ' '; 
				}
				else
				{
					turn = (turn == 'R') ? 'B' : 'R';
					
					lbl.setText(turn + "'s turn");
					
				}	
			}
		}
	}
}
