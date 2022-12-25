//singly LinkeList Based! (SLL)
public class StackList {

//	StackNode head, tail;
	StackNode top;

	public StackList() {

		this.top = null;
	}

	public void push(Object newKey) {// in SLL: (insertFirst)
		StackNode newNode = new StackNode(newKey);

		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	public void pop() {// in SLL: (deleteFirst)

		if (top == null) {
			System.out.println("list is already empty!!");
			return;
		}
		StackNode ptr = top;
		top = top.next;

		ptr.next = null;
		ptr = null;

	}

	public void searchList(Object newKey) {
		StackNode ptr = top;

		if (ptr == null) {
			System.out.println("list is empty!!");
			return;
		}
		while (ptr != null) {
			if (ptr.getKey() == newKey) {
				System.out.println("key is found");
				return;
			}
			ptr = ptr.next;
		}
		// talma wesel lhatha alsatar! so name not found
		System.out.println("key not found");
	}

	public void freeList() {
		StackNode ptr = top;

		if (ptr == null) {
			System.out.println("list is already empty");
			return;
		}
		while (ptr != null) {
			top = top.next;
			ptr = null;
			ptr = top;
		}
		System.out.println("list deleted succesfully");
	}

/////////////////////////////////////////////////
	public boolean isEmpty() {
		return (top == null);
	}

	public Object peek() {
		Object x = null;
		if (top == null) {
			System.out.println("Stack Under Flow (Empty Stack)!!");
		} else {
			x = top.key;
		}

		return x;
	}
/////////////////////////////////////////////////

	public void printList() {
		StackNode ptr = top;
		while (ptr != null) {
			System.out.println(ptr.toString());
			ptr = ptr.next;
		}
	}

}
