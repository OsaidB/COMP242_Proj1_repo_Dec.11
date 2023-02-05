package S_Lists;

import DLists.*;

public class SLLNode {
	private DNode  student;
	private SLLNode next;
	
	SLLNode(DNode student){
		this.student=student;
	}

	public DNode getStudent() {
		return student;
	}

	public void setStudent(DNode student) {
		this.student = student;
	}

	public SLLNode getNext() {
		return next;
	}

	public void setNext(SLLNode next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return student+"";
	}
}