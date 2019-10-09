/* Name: Zackery Kyle Crews
 * Student ID: n00826481
 * Description: This is a Queue class that accepts generic elements into the queue.
 * It can queue, dequeue, print the queue, return if the queue is empty or not,
 * and also return the size of the queue. 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GenericQueue<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;
	private ArrayList<E> elements = new ArrayList<>();
	private int size;
	
	//This is the no-args constructor for the GenericQueue class
	GenericQueue()
	{
		this.size = 0;
	}
	
	//This adds an element to the GenericQueue as well as incrementing the size by 1
	public void enqueue(E v)
	{
		this.elements.add(this.size, v);	
		this.size++;
	}
	
	//This removes an element at the front of the GenericQueue and pushes all elements to the left
	//It also returns the element if needed, while decrementing the size by 1
	public E dequeue()
	{		
		E temp;
		
		if(this.size <= 0)
			System.out.println("Queue is empty...");
		else
		{
			temp = this.elements.get(0);
			this.elements.remove(0);
			this.size--;
			return temp;
		}
		
		return null;
	}
	
	//This method will print the entire queue
	public void printQueue()
	{
		for(int i = 0; i < this.size; i++)
			System.out.print(this.elements.get(i) + " ");

		System.out.println();
	}
	
	//This will return true if the queue is empty and false if not
	public boolean empty()
	{
		if(this.size == 0)
			return true;
		
		return false;
	}
	
	//This will return the size of the queue
	public int getSize()
	{
		return this.size;
	}
}

class TestGenericQueue {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		//This creates the GenericQueue object as a type String
		GenericQueue<String> queue1 = new GenericQueue<String>();
		
		//This initializes the GenericQueue object with String information from a file named people.dat
		Scanner input = new Scanner(new File("src/people.dat"));
		while(input.hasNextLine())
			queue1.enqueue(input.nextLine());
		input.close();
		
		//This prints the initial queue contents of the first queue
		System.out.println("Initial Queue Contents");
		queue1.printQueue();
		
		//This will dequeue each element in the GenericQueue and after 5 elements have been removed each time
		//it will print the queue in its current state
		for(int i = queue1.getSize() - 1, j = 0; i != 0; i--)
		{
			j++;
			queue1.dequeue();
			if(j % 5 == 0)
			{
				System.out.printf("\nQueue contents after removing 5 elements :  (Queue Size = %d)\n", queue1.getSize());
				queue1.printQueue();
			}
		}
		
		//This creates the GenericQueue object as a wrapper type Integer
		GenericQueue<Integer> queue2 = new GenericQueue<Integer>();
		
		//This initializes the GenericQueue object with int information from a file named numbers.dat
		input = new Scanner(new File("src/numbers.dat"));
		while(input.hasNextLine())
			queue2.enqueue(input.nextInt());
		input.close();
		
		//This prints the initial queue contents of the second queue
		System.out.println("\nInitial Queue Contents");
		queue2.printQueue();
		
		//This will dequeue each element in the GenericQueue and after 5 elements have been removed each time
		//it will print the queue in its current state
		for(int i = queue2.getSize() - 1, j = 0; i != 0; i--)
		{
			j++;
			queue2.dequeue();
			if(j % 5 == 0)
			{
				System.out.printf("\nQueue contents after removing 5 elements :  (Queue Size = %d)\n", queue2.getSize());
				queue2.printQueue();
			}
		}
	}
	
}

