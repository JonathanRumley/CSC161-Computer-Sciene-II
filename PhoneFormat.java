// Jonathan Rumley

// CSC161-101
// Lab 1 - String Manipulation

import java.util.Scanner;

public class PhoneFormat 
{
	static Scanner userInput = new Scanner(System.in);
	
	private static String pNum1;
	
	public static void main(String[] args) 
	{	
		System.out.println("Greetings Earthling,\n\nPlease enter your phone number below in the following format (XXX)-XXX-XXXX.\n");
		getPNum();
		
	}
	
	public void setPNum(String pN) {
		
		pNum1 = pN;
		
	}
	
	public static String getPNum() {
		
		String pNum1 = userInput.nextLine();
														//String[] pNumFormat = "".split("");
		
		if(pNum1.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
			//pFormat();
			cDown(10);
			System.out.println("Valid Phone Number. Thank you.");
		}
		else {
			System.out.println("\nInvalid Phone Number Formatting: Follow (XXX)-XXX-XXXX\n");
			
		}
		
		return pNum1;
	}
	
	//public static String[] pFormat() {
		//String[] pLoop = pNum1.split("($1)-$2-$3");
		//for(int i = 0; i < pLoop.length; i++)
			//System.out.println(pLoop[i]);
		//return pLoop;
	//}
	
	public static void cDown(int n) {
		if(n <= 0)
			System.out.println("You're a winner!!!\nBe proud you're a winner.\n\n");
		else
		{
			System.out.println(n);
			cDown(n - 1);
		}
	}
}
