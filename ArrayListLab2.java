// Jonathan Rumley
// CSC161-101
// September 11, 2020
// Lab 2 - ArrayLists
//

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListLab2 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter five numbers: ");
		
		
		ArrayList<Integer> userNumbers = new ArrayList<>();
		
	    for(int x=0; x<5; x++)
	    {
	    	userNumbers.add(input.nextInt());
	    }
		
		sortNums(userNumbers);
		
		System.out.println(userNumbers);

		
	}
	public static void sortNums(ArrayList<Integer> list) 
	{
		for (int value = 0; value < list.size(); value++)
		{
			//System.out.println(userNumbers.get(value));
			java.util.Collections.sort(list);
		}
	}
}
