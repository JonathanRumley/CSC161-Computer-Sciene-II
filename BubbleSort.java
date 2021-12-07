// Jonathan Rumley
// CSC161-101
// November 12, 2020
// Exercise 7 Bubble Sort
//

public class BubbleSort 
{

	public static void main(String[] args) 
	{
		int[] nums = new int[25];
		
		for(int i = 0; i<nums.length; i++)
			nums[i] = (int)(Math.random() * 12345);
	
		printArray(nums);
		bubbleSort(nums);
		printArray(nums);
		
	}

	static void bubbleSort(int arry[])
	{
		int n = arry.length;
		for(int i =0; i < n-1; i++)
			for(int j = 0; j < n-i-1; j++)
				if(arry[j] > arry[j+1])
				{
					int temp = arry[j];
					arry[j] = arry[j+1];
					arry[j+1] = temp;
				}
	}
	
	static void printArray(int arry[])
	{
		int n = arry.length;
		for(int i = 0; i < n; i ++)
			System.out.println(arry[i] + "");
		System.out.println();
	}
	
	
}
