public class DLinkedList<T extends Comparable<T>> {
	private DNode<T> head; // ref to first item on list

	public boolean isEmpty() {

		return (head == null);
	}

	public void insertFirst(T data) {
		DNode<T> newNode = new DNode<>(data);

		if (head != null) {

			newNode.next = head;
			head.prev = newNode;

		}
		head = newNode;
	}

	public T deleteLast() {
		T temp;

		DNode<T> current = head;

		if (head == null)
			return null;

		if (head.next == null) {
			temp = head.data;
			head = null;
			return temp;
		}

		while (current.next.next != null)
			current = current.next;

		temp = current.next.data;
		current.next = null;
		return temp;
	}

	@Override
	public String toString() {
		DNode<T> curr = head;
		String s = "Head -->";

		while (curr != null) {
			s += curr + "-->";
			curr = curr.next;
		}
		return s + "Null";
	}

}