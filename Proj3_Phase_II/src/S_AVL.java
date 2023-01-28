import DLists.*;

public class S_AVL extends S_BST {
	// SeatNumber AVL//

	public S_AVL() {
		root = null;
	}
///////////////////////////////////////////////////////////////////////////////////////	

	/*
	 * public void insert(DNode key) { root = insert(root, key); }
	 */

	public void insertSeatNumber(DNode key) {
		root = insertSeatNumber(root, key);
	}

	/*
	 * private Node insert(Node root, DNode key) { if (root == null) { return new Node(key); } if ((Integer) key.data < (Integer) root.getData().data) { root.setLeft(insert(root.getLeft(), key)); }
	 * else { root.setRight(insert(root.getRight(), key)); } return balance(root); }
	 */

	private S_Node insertSeatNumber(S_Node root, DNode key) {// inserting a DNode(student) SORTED According to the seat number
		if (root == null) {
			return new S_Node(key);
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

	public S_Node deleteSeat(DNode key) {
		S_Node ret = super.deleteSeatNum(key);
		root = balance(root);
		return ret;
	}

////////////////////////////////////////////////////////////////////////////	
	private S_Node balance(S_Node root) {
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

	private S_Node rotateRightLeft(S_Node root) {
		S_Node temp = root.getRight();
		root.setRight(rotateRight(temp));
		return rotateLeft(root);
	}

	private S_Node rotateLeft(S_Node root) {
		S_Node temp = root.getRight();
		root.setRight(temp.getLeft());
		temp.setLeft(root);
		return temp;
	}

	private S_Node rotateLeftRight(S_Node root) {
		S_Node temp = root.getLeft();
		root.setLeft(rotateLeft(temp));
		return rotateRight(root);
	}

	private S_Node rotateRight(S_Node root) {
		S_Node temp = root.getLeft();
		root.setLeft(temp.getRight());
		temp.setRight(root);
		return temp;
	}

	private int getBalance(S_Node root) {
		if (root == null) {
			return 0;
		}
		return getHeight(root.getLeft()) - getHeight(root.getRight());
	}

	private int getHeight(S_Node curr) {
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

	private void print(S_Node root) {
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

	private String printLevel(S_Node root, int i, int j) {

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
