package DLists;

public class DNode {

	public Student data;// student
	public DNode next, prev;

	public DNode(Student data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
