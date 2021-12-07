import java.util.Queue; // Built-in Java Queue Structure
import java.util.LinkedList;
public class QueueCommands 
{
	// Use the command offer() to add something to the Q
	// Use the command remove() to remove the first thing in the Q
	public static void main(String[] args) 
	{
		// The next line creates a Queue based on a LinkedList
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(23); // This is the first number to enter the Q
		queue.offer(17);
		queue.offer(28);
		queue.offer(19);
		queue.offer(31); // This is the last number to enter the Q
		System.out.println("Contents of Queue");
		System.out.println(queue);
		int qSize = queue.size();
		for(int x=0; x<qSize; x++)
		{
			int v = queue.remove();
			System.out.println(v + " was removed");
		}
		// Notice that the first number in was the first number out
		System.out.println("\n\nContents of Queue");
		System.out.println(queue);
	}
}
