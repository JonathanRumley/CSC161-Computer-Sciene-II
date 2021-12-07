// Jonathan Rumley
// CSC 161-101
// September 16, 2020
// Exercise #3 InputMismatchException

import java.util.*;
import java.util.Scanner;



public class InputMismatchExceptionDemo 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		boolean continueOn = true;
		
		do {
			try 
			{
				System.out.println("Please enter two integers: ");
				
				int number1 = input.nextInt();
				int number2 = input.nextInt();
				
				int sumOfNumbers = number1 + number2;
				
				
				System.out.println("\nPerfect, the sum of the numbers entered, " + number1 + " and " + number2 + " is " + sumOfNumbers + ".\nCheers!");
				
				continueOn = false;
				
			}
			catch (InputMismatchException ex)
			{
				System.out.println("Invalid input, please try again by entering only integers\n");
				input.nextLine();
			}
			
			} while (continueOn);
	}

}
