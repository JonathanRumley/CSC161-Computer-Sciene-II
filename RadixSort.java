// Jonathan Rumley
// CSC161-101
// November 30, 2020
// Lab 7 Radix Sort
// Code sent from Dobbs via Zoom for help of understanding content


import java.util.Random;

public class RadixSort 
{

	public static void main(String[] args) 
	{
		Random num = new Random();
		int[] arr = new int[25];
		final int min = 1000;
		final int max = 9999;
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = num.nextInt();
			System.out.println(arr[i]);
		}
	}
	// RADIX SORT FUNCTION
	public static void sort(int[] arr)
	{
		if(arr.length == 0)
			return;
		int[][] np = new int[arr.length][2];
		int[] q = new int[0x100];
		int i,j,k,l,f = 0;
		for(k=0;k<4;k++)
		{
			for(i=0;i<(np.length-1);i++)
				np[i][1] = i +1;
			np[i][1] = -1;
			for(i=0;i<q.length;i++)
				q[i] = -1;
			for(f=i=0;i<arr.length;i++)
			{
				j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
				if(q[j] == -1)
					l =q[j] = f;
				else
				{
					l = q[j];
					while(np[l][1] != -1)
						l = np[l][1];
					np[l][1] =f;
					l = np[l][1];
				}
				f = np[f][1];
				np[l][0] = arr[i];
				np[l][1] = -1;
			}
			for(l=q[i=j=0];i<0x100;i++)
				for(l=q[i];l!=-1;l=np[l][1])
					arr[j++] = np[l][0];
			
			for(int ii =0; ii<arr.length; ii++)
			{
				System.out.println(arr[ii]+", ");
			}
			System.out.println("");
		}
	}
}
