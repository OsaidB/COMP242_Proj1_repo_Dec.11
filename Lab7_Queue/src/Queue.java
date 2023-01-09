
public class Queue {
	private DLinkedList<Integer> queueList;

	public Queue() {

		queueList = new DLinkedList<>();
	}

	public void enqueue(int data) {
		queueList.insertFirst(data);
	}

	public int dequeue() {

		return queueList.deleteLast();
	}

	public boolean isEmpty() {

		return (queueList.isEmpty());
	}

}
