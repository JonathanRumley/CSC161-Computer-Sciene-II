
public class Doorbell extends Camera implements Device  
{
	private String color = "Black";
	private static String ID = "Doorbell01";
	

	void ring()
	{
		System.out.println("Ring Ring Ring");
	}
	
	void converse() 
	{
		System.out.println("Mike and Speaker are now on");
	}
	
	@Override
	public String getID() 
	{
		return ID;
	}

	@Override
	public String sendReport() 
	{
		String prompt = "Activity Report";
		System.out.println(prompt);
		return prompt;
	}

	@Override
	void focus(int feet) 
	{
		setFocusRange(feet);
	}

	@Override
	void record() 
	{
		System.out.println("Now recording");
		
	}
	
	

}
