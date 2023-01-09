public class DNode<T extends Comparable<T>> {

	public T data;
	DNode<T> next, prev;

	public DNode(T data) {

		this.data = data;
	}

	@Override
	public String toString() {
		return data + " ";
	}

}
