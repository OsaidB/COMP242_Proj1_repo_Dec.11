import DLists.*;

public class AVL extends BST {

	public AVL() {
		root = null;
	}
///////////////////////////////////////////////////////////////////////////////////////	

	/*
	 * public void insert(DNode key) { root = insert(root, key); }
	 */

	public void insertGrade(DNode key) {
		root = insertGrade(root, key);
	}

	public void insertSeatNumber(DNode key) {
		root = insertSeatNumber(root, key);
	}

	/*
	 * private Node insert(Node root, DNode key) { if (root == null) { return new Node(key); } if ((Integer) key.data < (Integer) root.getData().data) { root.setLeft(insert(root.getLeft(), key)); }
	 * else { root.setRight(insert(root.getRight(), key)); } return balance(root); }
	 */

	private Node insertGrade(Node root, DNode key) {// inserting a DNode(student) SORTED According to the Grade
		if (root == null) {
			return new Node(key);
		}
		if (key.data.getAvg() < root.getData().data.getAvg()) {
			root.setLeft(insertGrade(root.getLeft(), key));
		} else {
			root.setRight(insertGrade(root.getRight(), key));
		}
		return balance(root);
	}

	private Node insertSeatNumber(Node root, DNode key) {// inserting a DNode(student) SORTED According to the seat number
		if (root == null) {
			return new Node(key);
		}
		if (key.data.getSeatNumber() < root.getData().data.getSeatNumber()) {
			root.setLeft(insertSeatNumber(root.getLeft(), key));
		} else {
			root.setRight(insertSeatNumber(root.getRight(), key));
		}
		return balance(root);
	}

////////////////////////////////////////////
	/*
	 * public Node delete(DNode key) { Node ret = super.delete(key); root = balance(root); return ret; }
	 */

	public Node deleteGrade(DNode key) {
		Node ret = super.deleteGrade(key);
		root = balance(root);
		return ret;
	}

	public Node deleteSeat(DNode key) {
		Node ret = super.deleteSeatNum(key);
		root = balance(root);
		return ret;
	}

////////////////////////////////////////////////////////////////////////////	
	private Node balance(Node root) {
		if (root == null) {
			return root;
		}
		int balance = getBalance(root);
		if (balance > 1) {
			if (getBalance(root.getLeft()) > 0) {
				root = rotateRight(root);
			} else {
				root = rotateLeftRight(root);
			}
		} else if (balance < -1) {
			if (getBalance(root.getRight()) < 0) {
				root = rotateLeft(root);
			} else {
				root = rotateRightLeft(root);
			}
		}
		return root;
	}

	private Node rotateRightLeft(Node root) {
		Node temp = root.getRight();
		root.setRight(rotateRight(temp));
		return rotateLeft(root);
	}

	private Node rotateLeft(Node root) {
		Node temp = root.getRight();
		root.setRight(temp.getLeft());
		temp.setLeft(root);
		return temp;
	}

	private Node rotateLeftRight(Node root) {
		Node temp = root.getLeft();
		root.setLeft(rotateLeft(temp));
		return rotateRight(root);
	}

	private Node rotateRight(Node root) {
		Node temp = root.getLeft();
		root.setLeft(temp.getRight());
		temp.setRight(root);
		return temp;
	}

	private int getBalance(Node root) {
		if (root == null) {
			return 0;
		}
		return getHeight(root.getLeft()) - getHeight(root.getRight());
	}

	private int getHeight(Node curr) {
		if (curr == null)
			return 0;
		if (curr.isLeaf())
			return 1;
		else
			return Math.max(1 + getHeight(curr.getLeft()), 1 + getHeight(curr.getRight()));
	}

	public void print() {
		print(root);
	}

	private void print(Node root) {
		if (root == null) {
			return;
		}
		print(root.getLeft());
		System.out.print(root.getData() + " ");
		print(root.getRight());
	}

	public void traverseLevel() {
		int h = getHeight(root);
		int i;
		for (i = 0; i < h; i++) {
			System.out.println(printLevel(root, i, 0));
			System.out.println();
		}
	}

	private String printLevel(Node root, int i, int j) {

		if (root != null) {
			if (i == j)
				return root.getData() + " ";
			if (j > i)
				return "NULL";

			return printLevel(root.getLeft(), i, j + 1) + " " + printLevel(root.getRight(), i, j + 1);
		} else
			return "NULL";

	}

}
