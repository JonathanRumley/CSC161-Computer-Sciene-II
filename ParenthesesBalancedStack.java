// Jonathan Rumley
// CSC 161-101
// October 12th, 2020
// Exercise #6 - Are parentheses balanced? Using Stack
// Tracy Dobbs
//

import java.util.Scanner;
import java.util.Stack;
import java.io.File;


public class ParenthesesBalancedStack
{

	public static void main(String[] args) throws Exception
	{
		Stack<Character> chStack = new Stack<>();	
		Scanner fileInput = new Scanner(new File("Parens.txt"));
		String str = "";
		boolean balanced = true;
		
		while(fileInput.hasNext())
		{
			balanced = true;
			str = fileInput.nextLine();
			
			for(int x=0; x < str.length(); x++)
			{
				if(str.charAt(x) == '(')
				chStack.push(str.charAt(x));
				
				try
				{
				
				if(str.charAt(x) == ')')
				chStack.pop();
				}
				catch(java.util.EmptyStackException ESE)
				{
					balanced = false;
				}
				
			}
			if(!chStack.isEmpty())
			{
				balanced = false;
			}
			
			if(balanced)
				System.out.println("Balanced");
			else
				System.out.println("Unbalanced");
				
		}
	}
}

