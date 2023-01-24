package base;

public class cStack<T extends Comparable<T>> {
	CurserList<T> cursor;

	int header;

	public cStack() {
		cursor = new CurserList<>(50);
		header = cursor.creatList();
	}

	public cStack(int size) {
		cursor = new CurserList<>(size);
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