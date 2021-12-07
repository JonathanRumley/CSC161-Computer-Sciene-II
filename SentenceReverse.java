// Tracy Dobbs
// CSC 161-101
// October 12th, 2020
// Sentence Reverse - Stack Example
//

import java.util.Scanner;
import java.util.Stack;

public class SentenceReverse 
{

	public static void main(String[] args) 
	{
		Stack<Character> chStack = new Stack<>();
		Scanner input = new Scanner(System.in);
		String stringIn = "";
		String stringReversed = "";
		System.out.println("Enter a string to be reversed: ");
		stringIn = input.nextLine();
		for(int x=0; x < stringIn.length(); x++)
		{
			chStack.push(stringIn.charAt(x));
		}
		while(!chStack.isEmpty())
		{
			stringReversed = stringReversed + chStack.pop().toString();
		}
		System.out.println(stringReversed);
	}

}
