

public class Queue {
	
	private int[] elements;
	private int size;
	
	Queue()
	{
		this.elements = new int[8];
		this.size = 0;
	}
	
	Queue(int capacity, int size)
	{
		this.elements = new int[capacity];
		this.size = size;
	}
	
	public void enqueue(int v)
	{
		if(this.size == this.elements.length)
		{
			int[] temp = new int[this.elements.length * 2];
			System.arraycopy(this.elements, 0, temp, 0, this.elements.length);
			this.elements = temp;
			this.elements[this.size++] = v;
		}
		else
			this.elements[this.size++] = v;
	}
	
	public int dequeue()
	{
		int temp;
		
		if(this.size <= 0)
			System.out.println("Queue is empty...");
		else
		{
			temp = this.elements[0];
			for(int i = 1; i < this.size; i++)
				this.elements[i - 1] = this.elements[i];
			
			this.size--;
			return temp;
		}
		
		return 0;
	}
	
	public boolean empty()
	{
		if(this.size == 0)
			return true;
		
		return false;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int getElement(int i)
	{
		return this.elements[i];
	}
}

class TestQueue {
	
	public static void main(String[] args) {
		
		Queue queue = new Queue();
		
		for(int i = 0; i < 20; i++)
			queue.enqueue(i + 1);
		
		System.out.printf("Initial Queue Contents :  (Queue Size = %d)\n", queue.getSize());
		printQueue(queue);
		
		for(int i = queue.getSize() - 1; i != 0; i--)
		{
			queue.dequeue();
			if(i % 5 == 0)
			{
				System.out.printf("\nQueue contents after removing 5 elements :  (Queue Size = %d)\n", queue.getSize());
				printQueue(queue);
			}
		}
	}
	
	public static void printQueue(Queue queue)
	{
		for(int i = 0; i < queue.getSize(); i++)
			System.out.printf("%d ", queue.getElement(i));
	}
}
