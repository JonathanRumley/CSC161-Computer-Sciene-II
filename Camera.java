
public abstract class Camera 
{
	private String lensType = "Standard";
	private int focusRange = 5;
	
	abstract void focus(int feet);
	
	abstract void record();
	
	public String getLensType()
	{
		return lensType;
	}
	
	public void setLensType(String lens)
	{
		lensType = lens;
	}
	
	public int getFocusRange()
	{
		return focusRange;
	}
	
	public void setFocusRange(int range)
	{
		focusRange = range;
	}
	
	
}
