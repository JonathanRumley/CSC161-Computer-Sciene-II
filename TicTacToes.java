
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

	public class TicTacToes extends Application
{

	// Indicate which player has a turn, initially it is the X player
	private char whoseTurn = 'X';
	
	// Create and initialize cell
	private Cell[][] cell = new Cell[3][3];
	
	// Create and initialize a status label
	private Label lblStatus = new Label("X's turn to play");
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage pStage) throws Exception 
	{
		// Hold Nine Cells
		GridPane pane = new GridPane(); // Pane to hold cell
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				pane.add(cell[i][j] = new Cell(), j , i); //  Create a cell
		
		//TicTacToe cells in center label at bottom
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(lblStatus);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 1000, 650);
		pStage.setTitle("TicTacToe");
		pStage.setScene(scene);
		pStage.show();
		
	}
	
	// Determine if the cell are all occupied
	
	public boolean isFull() {
		for(int i = 0; i <3; i++)
			for(int j = 0; j < 3; j++)
				if(cell[i][j].getToken() == ' ')
					return false;
		return true;	
	}

	// Determine if the player with the specific token wins
	public boolean isWon(char token) 
	{
		// Check rows
		for(int i = 0; i < 3; i++)
			if(cell[i][0].getToken() == token && cell[i][1].getToken() == token && cell[i][2].getToken() == token) 
			{
				return true;
			}
			
		// Check columns
		for(int j = 0; j<3; j++)
			if(cell[0][j].getToken() == token && cell[1][j].getToken() == token && cell[2][j].getToken() == token) 
			{
				return true;
			}
			if(cell[0][0].getToken() == token && cell[1][1].getToken() == token && cell[2][2].getToken() == token) 
			{
				return true;
			}
			if(cell[0][2].getToken() == token && cell[1][1].getToken() == token && cell[2][0].getToken() == token) 
			{
				return true;
			}
		
			return false;
		
	}
	
	// An inner class for a cell
	public class Cell extends Pane 
	{
		// Token used for this cell
		private char token = ' ';
		
		public Cell() 
		{
			setStyle("-fx-border-color: black");
			this.setPrefSize(2000,2000);
			this.setOnMouseClicked(e->handleMouseClick());
	
		}
		 // Return token // GETTER
		public char getToken() 
		{
			return token;
		}
		
		// Set a new token // SETTER
		public void setToken(char c) 
		{
			token = c;
			
			if(token == 'X') 
			{
				Line line1 = new Line(10,10,this.getWidth() - 10, this.getHeight() - 10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				Line line2 = new Line(10, this.getHeight()-10, this.getWidth() - 10, 10);
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));
			
			// Add the lines to the pane
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
				
				// Add the ellipse to the pane
				getChildren().add(ellipse);
			
			}
		}
		
		// Handle a mouse click event
		private void handleMouseClick() 
		{
			// If cell is empty and game is not over
			if (token == ' ' && whoseTurn != ' ') 
			{
				setToken(whoseTurn);
				
			// Check Game Status
				if(isWon(whoseTurn)) 
				{
					lblStatus.setText(whoseTurn + " won! The game is over");
					whoseTurn = ' '; // Game is over
				}
				else if(isFull()) 
				{
					lblStatus.setText("Draw! The game is over");
					whoseTurn = ' '; // Game is over
				}
				else
				{
					// Change turn
					whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
					// Display whose turn
					lblStatus.setText(whoseTurn + "'s turn");
					
				}	
			}
		}
	}
		
}

