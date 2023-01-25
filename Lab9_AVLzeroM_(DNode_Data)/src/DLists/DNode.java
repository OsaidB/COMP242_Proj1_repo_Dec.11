package DLists;

public class DNode {

	public Object data;//student
	public DNode next, prev;

	public DNode(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
