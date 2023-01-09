package base;

public class cNode<T extends Comparable<T>> {

	public T key;
	int next;

	public cNode(T key, int next) {
		this.key = key;
		this.next = next;
	}

	@Override
	public String toString() {
		return key + "";
	}

}
