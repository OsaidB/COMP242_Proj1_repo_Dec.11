import DLists.*;

public class BST {
	protected Node root;

	public BST() {
	}

	public Node getRoot() {
		return root;
	}

	/*
	 * public void insert(DNode student) { Node add = new Node(student); if (root == null) root = add; else { Node curr = root; while (curr != null) { if ((Integer) curr.getData().data > (Integer)
	 * student.data)/////// if (curr.hasLeft()) curr = curr.getLeft(); else { curr.setLeft(add); break; } else if ((Integer) curr.getData().data < (Integer) student.data) if (curr.hasRight()) curr =
	 * curr.getRight(); else { curr.setRight(add); break; } }
	 * 
	 * } }
	 */
	public void insertGrade(DNode student) {// inserting a DNode(student) SORTED According to the Grade

		Node toAdd = new Node(student);

		if (root == null)
			root = toAdd;
		else {
			double grade = student.data.getAvg();
			Node curr = root;
			double currGrade = root.getData().data.getAvg();

			while (curr != null) {

				if (currGrade > grade) { //////

					if (curr.hasLeft()) {
						curr = curr.getLeft();
						currGrade = root.getData().data.getAvg();
					} else {
						curr.setLeft(toAdd);
						break;
					}

				} else if (currGrade < grade) {

					if (curr.hasRight()) {
						curr = curr.getRight();
						currGrade = root.getData().data.getAvg();
					} else {
						curr.setRight(toAdd);
						break;
					}

				}
			}

		}
	}

	public void insertSeatNumber(DNode student) {// inserting a DNode(student) SORTED According to the seat number

		Node toAdd = new Node(student);

		if (root == null)
			root = toAdd;
		else {
			int seatNum = student.data.getSeatNumber();
			Node curr = root;
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

	public Node max() {
		Node curr = root;
		while (curr.hasRight())
			curr = curr.getRight();

		return curr;
	}

	public Node min() {
		Node curr = root;
		while (curr.hasLeft())
			curr = curr.getLeft();

		return curr;
	}

	public String inOrdar() {
		return inOrdar(root);
	}

	private String inOrdar(Node root) {
		if (root != null) {
			if (root.getLeft() != null && root.getRight() != null)
				return inOrdar(root.getLeft()) + "\n" + root.getData() + "\n" + inOrdar(root.getRight());
			else if (root.getRight() != null)
				return root.getData() + "\n" + inOrdar(root.getRight());
			else if (root.getRight() != null)
				return inOrdar(root.getLeft()) + "\n" + root.getData();
			else
				return root.getData().toString();
		} else
			return "";
	}

	public String toString() {
		return toStringLevels(root);
	}

	private String toStringLevels(Node curr) {
		int x = height();
		String soso = "";
		for (int i = 0; i < x; i++) {
			soso += printLevel(root, i, 0) + "\n";
		}
		return soso;
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

	/*
	 * public Node find(DNode student) { return find(student, root); }
	 */
	public Node findGrade(double grade) {
		return findGrade(grade, root);
	}

	public Node findSteatNum(int seatNum) {
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
	public Node findGrade(double grade, Node node) {// "student" is the Student i want to find...WRONG //BUT WHATS RIGHT IS that "node" is the root(I think so)

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

			if (node.getData().data.getAvg() == grade) {
				return node;
			} else if ((node.getData().data.getAvg() > grade) && node.hasLeft())////// 100% there is somthing wrong
				return findGrade(grade, node.getLeft());
			else if ((node.getData().data.getAvg() < grade) && node.hasRight())////// 100% there is somthing wrong
				return findGrade(grade, node.getRight());
		}
		return null;
	}

	public Node findSteatNum(int seatNum, Node node) {// "student" is the Student i want to find...WRONG //BUT WHATS RIGHT IS that "node" is the root(I think so)

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

	public int height() {
		return hieght(root);
	}

	private int hieght(Node curr) {
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
	public Node deleteGrade(DNode student) {// deleting a node from (the avl of grads) that is based on BST
		if (root == null)
			return null;

		Node dad = root;
		Node curr = root;
		boolean isLeft = false;

////////////////////////////////
		// int comp = curr.getData().compareTo(data); //replacing this line to the following
		int comp3 = -999;

		if (curr.getData() == student) {
			comp3 = 0;
		} else if ((curr.getData().data.getAvg() > student.data.getAvg()) && curr.hasLeft())////// 100% there is somthing wrong
			comp3 = 999;
		else if ((curr.getData().data.getAvg() < student.data.getAvg()) && curr.hasRight())////// 100% there is somthing wrong
			comp3 = -100;
////////////////////////////////

		// int comp = curr.getData().compareTo(data);
		while (curr != null) {

			//////////////////////////////////////////////////
			// comp = curr.getData().compareTo(data); //replacing this line to the following

			if (curr.getData() == student) {
				comp3 = 0;
			} else if ((curr.getData().data.getAvg() > student.data.getAvg()) && curr.hasLeft())////// 100% there is somthing wrong
				comp3 = 999;
			else if ((curr.getData().data.getAvg() < student.data.getAvg()) && curr.hasRight())////// 100% there is somthing wrong
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
				Node successor = gradeSuccessor(curr);//////////////
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

	public Node deleteSeatNum(DNode student) {// deleting a node from (the avl of SeatNums) that is based on BST
		if (root == null)
			return null;

		Node dad = root;
		Node curr = root;
		boolean isLeft = false;

////////////////////////////////
		// int comp = curr.getData().compareTo(data); //replacing this line to the following
		int comp3 = -999;

		if (curr.getData() == student) {
			comp3 = 0;
		} else if ((curr.getData().data.getSeatNumber() > student.data.getSeatNumber()) && curr.hasLeft())////// 100% there is somthing wrong
			comp3 = 999;
		else if ((curr.getData().data.getSeatNumber() < student.data.getSeatNumber()) && curr.hasRight())////// 100% there is somthing wrong
			comp3 = -100;
////////////////////////////////

		// int comp = curr.getData().compareTo(data);
		while (curr != null) {

			//////////////////////////////////////////////////
			// comp = curr.getData().compareTo(data); //replacing this line to the following

			if (curr.getData() == student) {
				comp3 = 0;
			} else if ((curr.getData().data.getSeatNumber() > student.data.getSeatNumber()) && curr.hasLeft())////// 100% there is somthing wrong
				comp3 = 999;
			else if ((curr.getData().data.getSeatNumber() < student.data.getSeatNumber()) && curr.hasRight())////// 100% there is somthing wrong
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
				Node successor = seatSuccessor(curr);/////////////////
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
	private Node gradeSuccessor(Node node) {
		Node parent = node;
		Node successor = node.getRight();
		while (successor.hasLeft()) {
			parent = successor;
			successor = successor.getLeft();
		}
///////////////////////////////////////////////////////		
		// if (successor.getData().compareTo(node.getRight().getData()) != 0) ///////// Replacing this line to the following:
		int status = 0;// dont need to get in
		if ((successor.getData().data.getAvg() > node.getRight().getData().data.getAvg()) || (successor.getData().data.getAvg() < node.getRight().getData().data.getAvg()))////// 100% there is
																																											////// somthing wrong
			status = 1;// need to get in
///////////////////////////////////////////////			

//		if (successor.getData().compareTo(node.getRight().getData()) != 0) {
		if (status == 1) {
			parent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}

	private Node seatSuccessor(Node node) {
		Node parent = node;
		Node successor = node.getRight();
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
