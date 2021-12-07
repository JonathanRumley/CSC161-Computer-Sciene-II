
public class Speed 
{
	private String units = "miles";
	private String timeUnits = "hour";
	private int velocity = 0;
	
	Speed()
	{
	}
	
	Speed(String u, String tu)
	{
		setUnits(u);
		setTimeUnits(tu);
	}
	
	public String getSpeed()
	{
		String vString = Integer.toString(velocity);
		return vString + " " + units + " per " + timeUnits;
	}
	
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		if(units.equals("miles") || units.equals("kilometers") || units.equals("meters"))
			this.units = units;
		else
		{
			System.out.println(units + " is an invalid type of units");
		}
	}
	public String getTimeUnits() {
		return timeUnits;
	}
	public void setTimeUnits(String timeUnits) {
		if(timeUnits.equals("hour") || timeUnits.equals("minute") || timeUnits.equals("second"))
			this.timeUnits = timeUnits;
		else
		{
			System.out.println(timeUnits + " is an invalid type of timeUnits");
		}
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
}
