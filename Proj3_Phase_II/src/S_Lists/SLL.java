package S_Lists;

import DLists.*;

public class SLL {
	private SLLNode head;

	public SLL(DNode student) {
		insertAtHead(student);
	}

	public void insertAtHead(DNode Student) {
		SLLNode node = new SLLNode(Student);
		if (head == null) {
			head = node;
		}
	}

	public boolean find(DNode Student) {
		SLLNode curr = head;
		while (curr != null) {
			if (curr.getStudent() == Student) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	public boolean delete(DNode Student) {
		if (head == null) {
			return false;
		}
		SLLNode curr = head;
		SLLNode prev = null;
		if (curr.getStudent() == Student) {
			head = head.getNext();
			return true;
		}

		double wantedGrade = Student.data.getAvg();
		while (curr != null && curr.getStudent().data.getAvg() < wantedGrade) {
			prev = curr;
			curr = curr.getNext();

		}
		if (curr.getStudent() == Student) {
			prev.setNext(curr.getNext());
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String s = "Head --> ";
		SLLNode curr = head;
		while (curr != null) {
			s += curr.toString();
			curr = curr.getNext();
		}
		return s + " " + "--> Null";
	}

}