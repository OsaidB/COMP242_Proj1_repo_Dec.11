package DB;

import DLists.*;

public class GAVL extends GBST {
	// SeatNumber AVL//

	public GAVL() {
		root = null;
	}
///////////////////////////////////////////////////////////////////////////////////////	

	/*
	 * public void insert(DNode key) { root = insert(root, key); }
	 */

	public void insertGrade(DNode key) {
		root = insertGrade(root, key);
	}

	/*
	 * private Node insert(Node root, DNode key) { if (root == null) { return new Node(key); } if ((Integer) key.data < (Integer) root.getData().data) { root.setLeft(insert(root.getLeft(), key)); }
	 * else { root.setRight(insert(root.getRight(), key)); } return balance(root); }
	 */

	private GNode insertGrade(GNode root, DNode key) {// inserting a DNode(student) SORTED According to the Grade

		if (root == null) {
			return new GNode(key);
		}
		if (key.data.getAvg() < root.getAVLHeaderGrade()) {
			root.setLeft(insertGrade(root.getLeft(), key));
		} else {
			root.setRight(insertGrade(root.getRight(), key));
		}
		return balance(root);
	}

////////////////////////////////////////////
	/*
	 * public Node delete(DNode key) { Node ret = super.delete(key); root = balance(root); return ret; }
	 */

	public GNode deleteGrade( double grade) {
		GNode ret = super.deleteGrade(grade);
		root = balance(root);
		return ret;
	}

////////////////////////////////////////////////////////////////////////////	
	private GNode balance(GNode root) {
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

	private GNode rotateRightLeft(GNode root) {
		GNode temp = root.getRight();
		root.setRight(rotateRight(temp));
		return rotateLeft(root);
	}

	private GNode rotateLeft(GNode root) {
		GNode temp = root.getRight();
		root.setRight(temp.getLeft());
		temp.setLeft(root);
		return temp;
	}

	private GNode rotateLeftRight(GNode root) {
		GNode temp = root.getLeft();
		root.setLeft(rotateLeft(temp));
		return rotateRight(root);
	}

	private GNode rotateRight(GNode root) {
		GNode temp = root.getLeft();
		root.setLeft(temp.getRight());
		temp.setRight(root);
		return temp;
	}

	private int getBalance(GNode root) {
		if (root == null) {
			return 0;
		}
		return getHeight(root.getLeft()) - getHeight(root.getRight());
	}

	private int getHeight(GNode curr) {
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

	public String newPrint() {
		BTreePrinter.result = "";
		return BTreePrinter.printNode(root);
	}

	private void print(GNode root) {
		if (root == null) {
			return;
		}
		print(root.getLeft());
		System.out.print(root.getAVLHeaderGrade() + " ");
		print(root.getRight());
	}

	public void reset() {
		reset(root);
		root = null;
	}

//	private void reset(GNode root) {
//		root = null;
//	}
	
	 public GNode reset(GNode root) {
	        if(null == root) {
	            return null;
	        }
	        root.setLeft(reset(root.getLeft()));
	        root.setRight(reset(root.getRight()));
	        root = null;
	        return root;
	    }

	public void traverseLevel() {
		int h = getHeight(root);
		int i;
		for (i = 0; i < h; i++) {
			System.out.println(printLevel(root, i, 0));
			System.out.println();
		}
	}

	private String printLevel(GNode root, int i, int j) {

		if (root != null) {
			if (i == j)
				return root.getAVLHeaderGrade() + " ";
			if (j > i)
				return "NULL";

			return printLevel(root.getLeft(), i, j + 1) + " " + printLevel(root.getRight(), i, j + 1);
		} else
			return "NULL";

	}

}
