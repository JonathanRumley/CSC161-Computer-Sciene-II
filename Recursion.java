// Jonathan Rumley
// CSC161-101
// November 11th, 2020
// Exercise 8 Recursion
//
import java.io.*;

public class Recursion 
{

	public static void main(String[] args) 
	{
		int x = 5;
		pattern(x,1);

	}
	
	static void printn(int num)
	{
		if(num==0)
			return;
		System.out.print("* ");
		printn(num - 1);
	}
	
	static void pattern(int x, int y)
	{
		if(x==0)
			return;
		printn(y);
		System.out.println();
		pattern(x-1,y+1);
	}
}