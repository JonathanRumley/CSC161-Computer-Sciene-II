// Jonathan Rumley
// CSC161-101
// September 11, 2020
// Exercise 2 - Testing Objects with Asserts
//

public class TestSpeedWithAsserts 
{

	public static void main(String[] args) 
	{
		// assert booleanExpr 
		// assert booleanExpr : errorMessageExpr
		
		Speed theSpeed =  new Speed();
		Speed theSpeed2 = new Speed("meters","second"); //second speed object for more assertion checking
		
		assert theSpeed.getSpeed().equals("0 miles per hour");
		//assert theSpeed.getSpeed().equals("10 miles per hour");
		
		assert theSpeed.getVelocity() == 0;
		
		assert theSpeed.getTimeUnits().equals("hour");
		
		assert theSpeed2.getSpeed().equals("0 meters per second"); // second object not first
		
		theSpeed.setTimeUnits("second");				//set time units to seconds
		assert theSpeed.getTimeUnits().equals("second");//check if the time units are measured in seconds
		
		theSpeed.setUnits("meters");					//set units to meters
		assert theSpeed.getUnits().equals("meters");	//check if units is measured in meters
		
		theSpeed.setVelocity(200);						//set velocity to 200 
		assert theSpeed.getVelocity() <= 200; 			//checking if veolicty is <= 200
		assert theSpeed.getVelocity() == 1000; 			//checking if velocity is equal to 1000
		
		//ended with an AssertionError to show that the other methods are working and that the last one isn't right.

	}

}
