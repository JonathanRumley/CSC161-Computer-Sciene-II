
public class MyInteger 
{
	// Data Fields
	private int value;
	
	//Construct class object
	public MyInteger(int v)
	{
		v = value;
	}
	
	public int getInteger()
	{
		return value;
	}
	
	
	public boolean isEven()
	{
		boolean odd = false;
		int even = value % 2; 
		if(value == even) return true; //help determining if variable is even by
		else return false;
	}
	
	public boolean isOdd()		
	{
		boolean even = false;
		int odd = (value % 2); ////////////STUCK
		
		if(value == odd) return true; //help determining if variable is even by
		else return false;
	}

	public boolean isPrime()
	{
		return true; //help determining if variable is even by
	}
	
	/// SHOULD I HAVE LIKE ANOTHER 6 or so METHODS????????
	
	public static int parseInt(char[] c)
	{
		return 0;

	}
	
	public static int parseInt(String s)
	{
		return 0;
	
	}
	
	
	
}
