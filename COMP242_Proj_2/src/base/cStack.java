package base;

public class cStack<T extends Comparable<T>> {
	CurserList<T> cursor = new CurserList<>(50);
	
	int header;

	public cStack() {
		header = cursor.creatList();
	}

	public void push(T data) throws IndexOutOfBoundsException {
		cursor.insertFirst(data, header);
	}

	public cNode<T> pop() {
		return cursor.deleteFirst(header);
	}

	public cNode<T> peek() {
		return cursor.returnFirst(header);
	}

	public boolean isEmpty() {
		return cursor.isEmpty(header);
	}

	public void clear() {
		cursor = new CurserList<>(header);

	}

}