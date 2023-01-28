import DLists.*;

public class S_Node {
	private DNode data;
	private S_Node left;
	private S_Node right;

	public S_Node(DNode data) {
		this.data = data;
	}

	public void setData(DNode data) {
		this.data = data;
	}

	public S_Node getLeft() {
		return left;
	}

	public void setLeft(S_Node left) {
		this.left = left;
	}

	public S_Node getRight() {
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

	public void setRight(S_Node right) {
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
