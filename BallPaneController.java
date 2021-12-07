import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BallPaneController extends Application
{
	
	public static void main(String[] args) 
	{
		launch();

	}

	@Override
	public void start(Stage pStage) throws Exception 
	{
		BallPane ballPane = new BallPane();
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		ballPane.setOnKeyPressed(e ->
		{
			if(e.getCode() == KeyCode.UP)
			{
				ballPane.increaseSpeed();
			}
			else
			{
				if(e.getCode() == KeyCode.DOWN)
				{
					ballPane.decreaseSpeed();
				}
			}
		});
		
		Scene scene = new Scene(ballPane, 250, 150);
		pStage.setTitle("Halloween Bouncing Balls");
		pStage.setScene(scene);
		pStage.show();
		ballPane.requestFocus();
	}

}
