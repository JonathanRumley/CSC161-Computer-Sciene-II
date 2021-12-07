/*
 Jonathan Rumley
 CSC 161-101
 October 25th, 2020
  Lab #6 - Grouping Symbols
 Tracy Dobbs
*/

import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;


public class GroupingSymbols 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		Stack<Character> symbolStack = new Stack<>();
		Scanner fileInput = new Scanner(new File("MatchingSymbols.txt"));
		String str = "";
		
		while(fileInput.hasNext())
		{
			boolean matches = true;
			str = fileInput.nextLine();
			for(int x=0; x < str.length(); x++)
			{
				if(str.charAt(x) == '(' || str.charAt(x) == '[' || str.charAt(x) == '{')
				{
					symbolStack.push(str.charAt(x));
				}
				try
				{
					if(str.charAt(x) == ')')
					{
						if (symbolStack.pop() != '(') matches = false;
					}
					if(str.charAt(x) == ']')
					{
						if (symbolStack.pop() != '[') matches = false;
					}
					if(str.charAt(x) == '}')
					{
						if (symbolStack.pop() != '{') matches = false;
					}
				}
				catch(Exception e)
				{
					matches = false;
				}
			}
				System.out.println(matches);
		}
	}
}
			
		
