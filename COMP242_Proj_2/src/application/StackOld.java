package application;
//
//public class StackOld<T> {
//
//	Node<T> top;
//
//	public void push(T data) {
//
//		Node<T> newNode = new Node<T>(data);
//		newNode.next = top;
//		top = newNode;
//
//	}
//
//	public Node<T> pop() {// in SLL: (deleteFirst)
//
//		if (top == null) {
//			System.out.println("list is already empty!!");
//			return null;
//		}
//		Node<T> ptr = top;
//		top = top.next;
//
//		ptr.next = null;
////		ptr = null;
//		return ptr;
//	}
//
//	public Node<T> peek() {
//
//		return top;
//	}
//
//	public int length() {
//		int length = 0;
//		Node<T> curr = top;
//		while (curr != null) {
//			length++;
//			curr = curr.next;
//
//		}
//		return length;
//
//	}
//
//	public boolean isEmpty() {
//		return (top == null);
//
//	}
//
//	public void clear() {
//		top = null;
//
//	}
//
//	@Override
//	public String toString() {
//		return "Stack [" + top + "]\n";
//	}
//
//}
