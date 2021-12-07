import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane
{

	public final double radius = 20;
	private double x = radius;
	private double y = radius;
	private double dx = 1;
	private double dy = 1;
	private Circle circle = new Circle(x,y,radius);
	private Timeline animation;
	
	public BallPane()
	{
		circle.setFill(Color.ORANGE);
		getChildren().add(circle);
		new KeyFrame(Duration.millis(50), e -> moveBall());
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	
	public void play()
	{
		animation.play();
	}
	
	public void pause()
	{
		animation.pause();
	}
	
	public void increaseSpeed()
	{
		animation.setRate(animation.getRate() + 0.1);
	}
	
	public void decreaseSpeed()
	{
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
	}

	public DoubleProperty rateProperty()
	{
		return animation.rateProperty();
	}
	
	protected void moveBall()
	{
		if(x < radius || x > getWidth() - radius)
		{
			dx =+ -1; // change the ball's direction of movement
		}
		if(y < radius || y > getHeight() - radius)
		{
			dy =+ -1; // change the ball's direction of movement
		}
		
		x =+ dx;
		y =+ dy;
		
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
}

