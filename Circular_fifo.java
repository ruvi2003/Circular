package FIFO;

public class Circular_fifo {

		    private int[] queueArray;
		    private int front, rear, size, capacity;

		    public Circular_fifo(int capacity) {
		        this.capacity = capacity;
		        queueArray = new int[capacity];
		        front = 0;
		        rear = -1;
		        size = 0;
		    }

		    public void enqueue(int item) {
		        if (isFull()) {
		            System.out.println("Queue is full. Cannot enqueue.");
		            return;
		        }
		        rear = (rear + 1) % capacity;
		        queueArray[rear] = item;
		        size++;
		    }

		    public int dequeue() {
		        if (isEmpty()) {
		            System.out.println("Queue is empty. Cannot dequeue.");
		            return -1; // or throw an exception
		        }
		        int dequeuedItem = queueArray[front];
		        front = (front + 1) % capacity;
		        size--;
		        return dequeuedItem;
		    }

		    public boolean isEmpty() {
		        return size == 0;
		    }

		    public boolean isFull() {
		        return size == capacity;
		    }

		    public int size() {
		        return size;
		    }

		    public static void main(String[] args) {
		    	Circular_fifo queue = new Circular_fifo(5);
		        queue.enqueue(10);
		        queue.enqueue(20);
		        queue.enqueue(30);
		        queue.enqueue(40);
		        queue.enqueue(50);

		        System.out.println("Queue size: " + queue.size());

		        System.out.println("Dequeue: " + queue.dequeue());
		        System.out.println("Dequeue: " + queue.dequeue());

		        System.out.println("Queue size after dequeue: " + queue.size());

		        queue.enqueue(60);
		        queue.enqueue(70);

		        System.out.println("Dequeue: " + queue.dequeue());
		        System.out.println("Dequeue: " + queue.dequeue());
		        System.out.println("Dequeue: " + queue.dequeue());
		        System.out.println("Dequeue: " + queue.dequeue());

		        System.out.println("Queue size after dequeues: " + queue.size());
		    }

}
