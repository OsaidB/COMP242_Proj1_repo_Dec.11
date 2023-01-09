
package application;

public class NodeOld<T> {

	T element;
	NodeOld<T> next;

	public NodeOld() {

	}

	public NodeOld(T element) {
		this.element = element;

	}

	@Override
	public String toString() {
		return "" + element;
	}

}
