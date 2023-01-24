package DLists;

public class DNode {

	Object data;//student
	DNode next, prev;

	public DNode(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
