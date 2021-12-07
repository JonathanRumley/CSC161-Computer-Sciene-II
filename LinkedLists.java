// Jonathan Rumley
// CSC 161-101
// October 10th, 2020
// Lab #5 Grocery List
// Tracy Dobbs
//

import java.util.*;

public class LinkedLists
{

	public static void main(String[] args) 
	{
		LinkedList<String> groceryList = new LinkedList<String>();
		System.out.println("Grocery List: " + groceryList);
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;
		
		while(keepGoing)
		{
			System.out.println("\nWould you like to add(a) to the grocery list or (d)elete an item from the list?\nOr (p)rint the grocery list?\n");
			String gListChoice = input.nextLine();
			if(gListChoice.equals("q") || gListChoice.equals("Q"))
			{
				System.out.println("Goodbye now.");
				keepGoing = false;
			}
			else
			{
				if(gListChoice.equals("a") || gListChoice.equals("A"))
				{
					System.out.println("\nPlease enter the item the desired item to be added to the grocery list: ");
					String addItem = input.nextLine();
					groceryList.add(addItem);
				}
				else if(gListChoice.equals("d") || gListChoice.equals("D"))
				{
					System.out.println("\nPlease enter an item to delete: ");
					String deleteItem = input.nextLine();
					groceryList.remove(deleteItem);
				}
				else if(gListChoice.equals("p") || gListChoice.equals("P"))
				{
					System.out.println("\nHere is the grocery list: " + groceryList);
				}
				else
				{
					System.out.println("\nInvalid entry, please try again.");
				}
			}
		}	
	}
}
