package DB;
import DLists.*;
import S_Lists.*;

public class GNode {
	private double AVLHeaderGrade;
	private GNode left;
	private GNode right;

	private SLL nextList;

//	/*
//	 * before this method, and whenever i need to add a "grade"
//	 * 
//	 * i need to check if this grade is already exist or not...
//	 * 
//	 * so i need to say:
//	 * 
//	 * if(newGrade "does not exist in" GAVL){
//	 * (GAVL)insertGrade;
//	 * theNode=find(GNode.AVLHeaderGrade);
//	 * then: theNode.nextList.insertFirst(newGrade);
//	 * }
//	 * 
//	 * if(newGrade "exist in" GAVL){
//	 * find GNode.AVLHeaderGrade in the GAVL
//	 * so we can say that: theNode=find(newGrade);
//	 * then: theNode.nextList.insertFirst(newGrade);
//	 * }
//	 * 
//	 */
	public GNode(DNode student) {

//		int length = word.length();
//
//		if (dList.searchList(length)) {// already there is a node that with the index that mean the number of letters
//			dList.insert(length, word);
//		} else {// a word with new length
//			dList.insertSorrted(length);
//			dList.link(length, word);
//		}

		this.AVLHeaderGrade = student.data.getAvg();// beshakel maabbbbdaaa2eeee
		this.nextList = new SLL(student);
	}

	public void insertInNextList(DNode student) {
		this.nextList.insertAtFirst(student);
	}
	
	

	public SLL getNextList() {
		return nextList;
	}

	public void setAVLHeaderGrade(double grade) {
		this.AVLHeaderGrade =grade;
	}

	public GNode getLeft() {
		return left;
	}

	public void setLeft(GNode left) {
		this.left = left;
	}

	public GNode getRight() {
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

	public void setRight(GNode right) {
		this.right = right;
	}

	public double getAVLHeaderGrade() {////////// make SURE!! DNode OR Object!
		return AVLHeaderGrade;
	}

	@Override
	public String toString() {
		return AVLHeaderGrade + ":" + nextList;
	}
}
