package DB;
import DLists.*;

public class GBST {
	protected GNode root;

	public GBST() {
	}

	public GNode getRoot() {
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

		GNode toAdd = new GNode(student);

		if (root == null)
			root = toAdd;
		else {
			double grade = student.data.getAvg();
			GNode curr = root;
			double currGrade = root.getAVLHeaderGrade();

			while (curr != null) {

				if (currGrade > grade) { //////

					if (curr.hasLeft()) {
						curr = curr.getLeft();
						currGrade = root.getAVLHeaderGrade();
					} else {
						curr.setLeft(toAdd);
						break;
					}

				} else if (currGrade < grade) {

					if (curr.hasRight()) {
						curr = curr.getRight();
						currGrade = root.getAVLHeaderGrade();
					} else {
						curr.setRight(toAdd);
						break;
					}

				}
			}

		}
	}

	public GNode max() {
		GNode curr = root;
		while (curr.hasRight())
			curr = curr.getRight();

		return curr;
	}

	public GNode min() {
		GNode curr = root;
		while (curr.hasLeft())
			curr = curr.getLeft();

		return curr;
	}

	public String inOrdar() {
		return inOrdar(root);
	}

	private String inOrdar(GNode root) {
		if (root != null) {
			if (root.getLeft() != null && root.getRight() != null)
				return inOrdar(root.getLeft()) + "\n" + root.getAVLHeaderGrade() + "\n" + inOrdar(root.getRight());
			else if (root.getRight() != null)
				return root.getAVLHeaderGrade() + "\n" + inOrdar(root.getRight());
			else if (root.getRight() != null)
				return inOrdar(root.getLeft()) + "\n" + root.getAVLHeaderGrade();
			else
				return root.getAVLHeaderGrade() + "";
		} else
			return "";
	}

	public String toString() {
		return toStringLevels(root);
	}

	private String toStringLevels(GNode curr) {
		int x = height();
		String soso = "";
		for (int i = 0; i < x; i++) {
			soso += printLevel(root, i, 0) + "\n";
		}
		return soso;
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
/////////////////////////////////////////////////////

	/*
	 * public Node find(DNode student) { return find(student, root); }
	 */
	public GNode findGrade(double grade) {
		return findGrade(grade, root);
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
	public GNode findGrade(double grade, GNode node) {// "student" is the Student i want to find...WRONG //BUT WHATS RIGHT IS that "node" is the root(I think so)

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

			if (node.getAVLHeaderGrade() == grade) {
				return node;
			} else if ((node.getAVLHeaderGrade() > grade) && node.hasLeft())////// 100% there is somthing wrong
				return findGrade(grade, node.getLeft());
			else if ((node.getAVLHeaderGrade() < grade) && node.hasRight())////// 100% there is somthing wrong
				return findGrade(grade, node.getRight());
		}
		return null;
	}

//	public GNode findSteatNum(int seatNum) {
//		return findSteatNum(seatNum, root);
//	}
//	
//	public GNode findSteatNum(int seatNum, GNode node) {// "student" is the Student i want to find...WRONG //BUT WHATS RIGHT IS that "node" is the root(I think so)
//
////		DNode
//
//		if (node != null) {
//
//			// compareTo(data);
//			// 0 if this Integer is equal to the argument Integer;
//			// a value less than 0 if this Integer is numerically less than the argument Integer;
//			// and a value greater than 0 if this Integer is numerically greater than the argument Integer (signed comparison).
//
////			int comp = node.getData().compareTo(data);
////			if (comp == 0)
////				return node;
////			else if (comp > 0 && node.hasLeft())
////				return find(data, node.getLeft());
////			else if (comp < 0 && node.hasRight())
////				return find(data, node.getRight());
//			
////			find(DNode Student)
////			if (node.getData().data.getSeatNumber() == seatNum) {
//			
//			node.nextList.find(node.getNextList());
//			if (node.nextList.getData().data.getSeatNumber() == seatNum) {
//				return node;
//			} else if ((node.getData().data.getSeatNumber() > seatNum) && node.hasLeft())////// 100% there is somthing wrong
//				return findSteatNum(seatNum, node.getLeft());
//			else if ((node.getData().data.getSeatNumber() < seatNum) && node.hasRight())////// 100% there is somthing wrong
//				return findSteatNum(seatNum, node.getRight());
//		}
//		return null;
//	}


/////////////////////////////////////////////////////

	public int height() {
		return hieght(root);
	}

	private int hieght(GNode curr) {
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
	public GNode deleteGrade(DNode student) {// deleting a node from (the avl of grads) that is based on BST
		
		double studGrade=student.data.getAvg();
		
		if (root == null)
			return null;

		GNode dad = root;
		GNode curr = root;
		boolean isLeft = false;

////////////////////////////////
		// int comp = curr.getData().compareTo(data); //replacing this line to the following
		int comp3 = -999;

		if (curr.getAVLHeaderGrade() == studGrade) {
			comp3 = 0;
		} else if ((curr.getAVLHeaderGrade() > studGrade) && curr.hasLeft())////// 100% there is somthing wrong
			comp3 = 999;
		else if ((curr.getAVLHeaderGrade() < studGrade) && curr.hasRight())////// 100% there is somthing wrong
			comp3 = -100;
////////////////////////////////

		// int comp = curr.getData().compareTo(data);
		while (curr != null) {

			//////////////////////////////////////////////////
			// comp = curr.getData().compareTo(data); //replacing this line to the following

			if (curr.getAVLHeaderGrade() == studGrade) {
				comp3 = 0;
			} else if ((curr.getAVLHeaderGrade() > studGrade) && curr.hasLeft())////// 100% there is somthing wrong
				comp3 = 999;
			else if ((curr.getAVLHeaderGrade() < studGrade) && curr.hasRight())////// 100% there is somthing wrong
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
				GNode successor = gradeSuccessor(curr);//////////////
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
	private GNode gradeSuccessor(GNode node) {
		GNode parent = node;
		GNode successor = node.getRight();
		while (successor.hasLeft()) {
			parent = successor;
			successor = successor.getLeft();
		}
///////////////////////////////////////////////////////		
		// if (successor.getData().compareTo(node.getRight().getData()) != 0) ///////// Replacing this line to the following:
		int status = 0;// dont need to get in
		if ((successor.getAVLHeaderGrade() > node.getRight().getAVLHeaderGrade()) || (successor.getAVLHeaderGrade() < node.getRight().getAVLHeaderGrade()))////// 100% there is
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

//////////////////////////////////////////////////////////////	
}
