import DLists.*;

public class Node {
	private DNode data;
	private Node left;
	private Node right;

	public Node(DNode data) {
		this.data = data;
	}

	public void setData(DNode data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public boolean isLeaf() {
		return !hasLeft() && !hasRight();
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public DNode getData() {////////// make SURE!! DNode OR Object!
		return data;
	}

	@Override
	public String toString() {
		return data + "";
	}
}
