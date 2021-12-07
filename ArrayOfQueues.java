// Tracy Dobbs
// CSC161 
// Apr 8, 2020 (Covid-19 era)

import java.util.Queue; 
import java.util.LinkedList;
import java.util.ArrayList;
public class ArrayOfQueues 
{
	public static void main(String[] args) 
	{
		// create an array of 25 3-digit values to be sorted
		int[] vals = new int[25];
		for(int x=0; x<25; x++)
		{
			int rVal = (int)(Math.random() * 1000);
			while(rVal < 100)
				rVal = (int)(Math.random() * 1000);
			vals[x] = rVal;
		}
		System.out.println("Values before sorting:");
		for(int x=0; x<24; x++)
		{
			System.out.print(vals[x] + ", ");
		}
		System.out.println(vals[24]);
		
		// Create the ten buckets for the radix sort
		ArrayList<Queue<Integer>> qArray = new ArrayList<>();
		for(int x=0; x<10; x++)
		{
			Queue<Integer> q = new LinkedList<>();
			qArray.add(q);
		}

		// Begin sort
		for(int x=0; x<3; x++)  // For each of the three digits
		{
			for(int y=0; y<25; y++) // in all 25 integers
			{
				// put numbers in buckets based on digit value
				// Determine digit value
				int v = vals[y];
				int hold = (int)(v / Math.pow((double)(10),  (double)(x)));
				int d = hold % 10;
				// place in bucket determined by d
				int w = 0;
				for(Queue<Integer> q :qArray)
				{
					if(w == d)
					{
						q.offer(v);
					}
					w++;
				}
			}
			// Pull values from buckets and place in vals array
			int y=0;
			for(Queue<Integer> q :qArray)
			{
				int qSize = q.size();
				for(int z=0; z<qSize; z++)
				{
					vals[y] = q.remove();
					y++;
				}
			}			
		}

		System.out.println("\n\nValues after sorting:");
		for(int x=0; x<24; x++)
		{
			System.out.print(vals[x] + ", ");
		}
		System.out.println(vals[24]);		
	}	
}
