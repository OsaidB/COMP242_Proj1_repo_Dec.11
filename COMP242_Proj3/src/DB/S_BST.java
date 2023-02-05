package DB;

import DLists.DNode;

public class S_BST {
	protected S_Node root;

	public S_BST() {
	}

	public S_Node getRoot() {
		return root;
	}

	/*
	 * public void insert(DNode student) { Node add = new Node(student); if (root == null) root = add; else { Node curr = root; while (curr != null) { if ((Integer) curr.getData().data > (Integer)
	 * student.data)/////// if (curr.hasLeft()) curr = curr.getLeft(); else { curr.setLeft(add); break; } else if ((Integer) curr.getData().data < (Integer) student.data) if (curr.hasRight()) curr =
	 * curr.getRight(); else { curr.setRight(add); break; } }
	 * 
	 * } }
	 */

	public void insertSeatNumber(DNode student) {// inserting a DNode(student) SORTED According to the seat number

		S_Node toAdd = new S_Node(student);

		if (root == null)
			root = toAdd;
		else {
			int seatNum = student.data.getSeatNumber();
			S_Node curr = root;
			int currSeat = root.getData().data.getSeatNumber();

			while (curr != null) {

				if (currSeat > seatNum) { //////

					if (curr.hasLeft()) {
						curr = curr.getLeft();
						currSeat = curr.getData().data.getSeatNumber();
					} else {
						curr.setLeft(toAdd);
						break;
					}

				} else if (currSeat < seatNum) {

					if (curr.hasRight()) {
						curr = curr.getRight();
						currSeat = curr.getData().data.getSeatNumber();
					} else {
						curr.setRight(toAdd);
						break;
					}

				}
			}

		}
	}

	public S_Node max() {
		S_Node curr = root;
		while (curr.hasRight())
			curr = curr.getRight();

		return curr;
	}

	public S_Node min() {
		S_Node curr = root;
		while (curr.hasLeft())
			curr = curr.getLeft();

		return curr;
	}

//	public String inOrdar() {
//		return inOrdar(root);
//	}
//
//	private String inOrdar(S_Node root) {
//		if (root != null) {
//
//			if (root.getLeft() != null && root.getRight() != null) {
//				return inOrdar(root.getLeft()) + "\n" + root.getData() + "\n" + inOrdar(root.getRight());
//			}
//
//			else if (root.getRight() != null) {// root.getLeft() = null
//				return root.getData() + "\n" + inOrdar(root.getRight());
//			}
//
//			else if (root.getLeft() != null) {// root.getLeft() = null
//				return inOrdar(root.getLeft()) + "\n" + root.getData();
//			}
//
//			else// leafe
//				return root.getData() + "";
//
//		} else
//			return "";
//	}

	public String toString() {
		return toStringLevels(root);
	}

	private String toStringLevels(S_Node curr) {
		int x = height();
		String soso = "";
		for (int i = 0; i < x; i++) {
			soso += printLevel(root, i, 0) + "\n";
		}
		return soso;
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
/////////////////////////////////////////////////////
	/*
	 * public Node find(DNode student) { return find(student, root); }
	 */

	public S_Node findSteatNum(int seatNum) {
		return findSteatNum(seatNum, root);
	}

	/*
	 * public Node find(DNode student, Node node) {
	 * 
	 * // DNode
	 * 
	 * if (node != null) {
	 * 
	 * // compareTo(data); // 0 if this Integer is equal to the argument Integer; // a value less than 0 if this Integer is numerically less than the argument Integer; // and a value greater than 0 if
	 * this Integer is numerically greater than the argument Integer (signed comparison).
	 * 
	 * // int comp = node.getData().compareTo(data); // if (comp == 0) // return node; // else if (comp > 0 && node.hasLeft()) // return find(data, node.getLeft()); // else if (comp < 0 &&
	 * node.hasRight()) // return find(data, node.getRight());
	 * 
	 * if (node.getData() == student) { return node; } else if (((Integer) node.getData().data > (Integer) student.data) && node.hasLeft())////// 100% there is somthing wrong return find(data,
	 * node.getLeft()); else if (((Integer) node.getData().data < (Integer) student.data) && node.hasRight())////// 100% there is somthing wrong return find(student, node.getRight()); } return null; }
	 */

	public S_Node findSteatNum(int seatNum, S_Node node) {// "student" is the Student i want to find...WRONG //BUT WHATS RIGHT IS that "node" is the root(I think so)

//		DNode

		if (node != null) {

			// compareTo(data);
			// 0 if this Integer is equal to the argument Integer;
			// a value less than 0 if this Integer is numerically less than the argument Integer;
			// and a value greater than 0 if this Integer is numerically greater than the argument Integer (signed comparison).

//			int comp = node.getData().compareTo(data);
//			if (comp == 0)
//				return node;
//			else if (comp > 0 && node.hasLeft())
//				return find(data, node.getLeft());
//			else if (comp < 0 && node.hasRight())
//				return find(data, node.getRight());

			if (node.getData().data.getSeatNumber() == seatNum) {
				return node;
			} else if ((node.getData().data.getSeatNumber() > seatNum) && node.hasLeft())////// 100% there is somthing wrong
				return findSteatNum(seatNum, node.getLeft());
			else if ((node.getData().data.getSeatNumber() < seatNum) && node.hasRight())////// 100% there is somthing wrong
				return findSteatNum(seatNum, node.getRight());
		}
		return null;
	}

/////////////////////////////////////////////////////////
	public int height() {
		return hieght(root);
	}

	private int hieght(S_Node curr) {
		if (curr == null)
			return 0;
		if (curr.isLeaf())
			return 1;
		else
			return Math.max(1 + hieght(curr.getLeft()), 1 + hieght(curr.getRight()));
	}

//////////////////////////////////////////////////////////////

	/*
	 * public Node delete(DNode student) { if (root == null) return null;
	 * 
	 * Node dad = root; Node curr = root; boolean isLeft = false;
	 * 
	 * //////////////////////////////// // int comp = curr.getData().compareTo(data); //replacing this line to the following int comp3 = -999;
	 * 
	 * if (curr.getData() == student) { comp3 = 0; } else if (((Integer) curr.getData().data > (Integer) student.data) && curr.hasLeft())////// 100% there is somthing wrong comp3 = 999; else if
	 * (((Integer) curr.getData().data < (Integer) student.data) && curr.hasRight())////// 100% there is somthing wrong comp3 = -100; ////////////////////////////////
	 * 
	 * // int comp = curr.getData().compareTo(data); while (curr != null) {
	 * 
	 * ////////////////////////////////////////////////// // comp = curr.getData().compareTo(data); //replacing this line to the following
	 * 
	 * if (curr.getData() == student) { comp3 = 0; } else if (((Integer) curr.getData().data > (Integer) student.data) && curr.hasLeft())////// 100% there is somthing wrong comp3 = 999; else if
	 * (((Integer) curr.getData().data < (Integer) student.data) && curr.hasRight())////// 100% there is somthing wrong comp3 = -100; //////////////////////////////////////////////////
	 * 
	 * if (comp3 == 0) break; dad = curr; if (comp3 > 0) { isLeft = true; curr = curr.getLeft(); } else { isLeft = false; curr = curr.getRight(); } }
	 * 
	 * if (comp3 != 0) return null; else { if (curr.isLeaf()) { if (curr == root) root = null; else if (isLeft) dad.setLeft(null); else dad.setRight(null); } else if (curr.hasLeft() &&
	 * !curr.hasRight()) {
	 * 
	 * if (root == curr) root = curr.getLeft(); else if (isLeft) dad.setLeft(curr.getLeft()); else dad.setRight(curr.getLeft()); } else if (curr.hasRight() && !curr.hasLeft()) {
	 * 
	 * if (curr == root) root = curr.getRight(); else if (isLeft) dad.setLeft(curr.getRight()); else dad.setRight(curr.getRight()); } else { Node successor = successor(curr); if (curr == root) root =
	 * successor; else if (isLeft) dad.setLeft(successor); else dad.setRight(successor); successor.setLeft(curr.getLeft()); } return curr; } }
	 */

	public S_Node deleteBST(DNode student) {
		return root = deleteBST(root, student);
	}

	public S_Node deleteBST(S_Node T, DNode student) {

		int studSeat = student.data.getSeatNumber();

		S_Node tmp_cell, child = null;

		if (T == null) {
			System.out.printf("Element not found\n");
		} else if (studSeat < T.getData().data.getSeatNumber()) {
			T.setLeft(deleteBST(T.getLeft(), student));

		} else if (studSeat > T.getData().data.getSeatNumber()) {
			T.setRight(deleteBST(T.getRight(), student));

		} else if ((T.getLeft()) != null && T.getRight() != null) {// foundelement andhas (right ,left)elements
			tmp_cell = findMin(T.getRight());
			T.setData(tmp_cell.getData());
			T.setRight(deleteBST(T.getRight(), T.getData()));

		} else {
			tmp_cell = T;

			if (T.getLeft() == null)
				child = T.getRight();
			if (T.getRight() == null)
				child = T.getLeft();
			return child;
		}
		return T;
	}

	S_Node findMin(S_Node T) {
		if (T == null) // empty tree
			return null;
		else if (T.getLeft() == null) // node itself
			return (T);
		else
			return (findMin(T.getLeft())); // find minrecursive
	}

	public S_Node deleteSeatNum(DNode student) {// deleting a node from (the avl of SeatNums) that is based on BST

		int studSeat = student.data.getSeatNumber();

		if (root == null)
			return null;

		S_Node dad = root;
		S_Node curr = root;
		boolean isLeft = false;

////////////////////////////////
		// int comp = curr.getData().compareTo(data); //replacing this line to the following
		int comp3 = -999;

		if (curr.getData() == student) {
			comp3 = 0;
		} else if ((curr.getData().data.getSeatNumber() > studSeat) && curr.hasLeft())////// 100% there is somthing wrong
			comp3 = 999;
		else if ((curr.getData().data.getSeatNumber() < studSeat) && curr.hasRight())////// 100% there is somthing wrong
			comp3 = -100;
////////////////////////////////

		// int comp = curr.getData().compareTo(data);
		while (curr != null) {

			//////////////////////////////////////////////////
			// comp = curr.getData().compareTo(data); //replacing this line to the following

			if (curr.getData() == student) {
				comp3 = 0;
			} else if ((curr.getData().data.getSeatNumber() > studSeat) && curr.hasLeft())////// 100% there is somthing wrong
				comp3 = 999;
			else if ((curr.getData().data.getSeatNumber() < studSeat) && curr.hasRight())////// 100% there is somthing wrong
				comp3 = -100;
			//////////////////////////////////////////////////

			if (comp3 == 0)
				break;
			dad = curr;
			if (comp3 > 0) {
				isLeft = true;
				curr = curr.getLeft();
			} else {
				isLeft = false;
				curr = curr.getRight();
			}
		}

		if (comp3 != 0)
			return null;
		else {
			if (curr.isLeaf()) {
				if (curr == root)
					root = null;
				else if (isLeft)
					dad.setLeft(null);
				else
					dad.setRight(null);
			} else if (curr.hasLeft() && !curr.hasRight()) {

				if (root == curr)
					root = curr.getLeft();
				else if (isLeft)
					dad.setLeft(curr.getLeft());
				else
					dad.setRight(curr.getLeft());
			} else if (curr.hasRight() && !curr.hasLeft()) {

				if (curr == root)
					root = curr.getRight();
				else if (isLeft)
					dad.setLeft(curr.getRight());
				else
					dad.setRight(curr.getRight());
			} else {
				S_Node successor = seatSuccessor(curr);/////////////////
				if (curr == root)
					root = successor;
				else if (isLeft)
					dad.setLeft(successor);
				else
					dad.setRight(successor);
				successor.setLeft(curr.getLeft());
			}
			return curr;
		}
	}

	// murad's delete
	// forget
	/*
	 * private Node successor(Node node) { Node parent = node; Node successor = node.getRight(); while (successor.hasLeft()) { parent = successor; successor = successor.getLeft(); }
	 * /////////////////////////////////////////////////////// // if (successor.getData().compareTo(node.getRight().getData()) != 0) ///////// Replacing this line to the following: int status = 0;//
	 * dont need to get in if (((Integer) successor.getData().data > (Integer) node.getRight().getData().data) || ((Integer) successor.getData().data < (Integer) node.getRight().getData().data))//////
	 * 100% there is ////// somthing wrong status = 1;// need to get in ///////////////////////////////////////////////
	 * 
	 * // if (successor.getData().compareTo(node.getRight().getData()) != 0) { if (status == 1) { parent.setLeft(successor.getRight()); successor.setRight(node.getRight()); } return successor; }
	 */

	private S_Node seatSuccessor(S_Node node) {
		S_Node parent = node;
		S_Node successor = node.getRight();
		while (successor.hasLeft()) {
			parent = successor;
			successor = successor.getLeft();
		}
///////////////////////////////
		// if (successor.getData().compareTo(node.getRight().getData()) != 0) ///////// Replacing this line to the following:
		int status = 0;// dont need to get in
		if ((successor.getData().data.getSeatNumber() > node.getRight().getData().data.getSeatNumber()) || (successor.getData().data.getSeatNumber() < node.getRight().getData().data.getSeatNumber()))////// 100%
																																																		////// there
																																																		////// is
			////// somthing wrong
			status = 1;// need to get in
//////////////////////////////		

//		if (successor.getData().compareTo(node.getRight().getData()) != 0) {
		if (status == 1) {
			parent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}

//////////////////////////////////////////////////////////////	
}
