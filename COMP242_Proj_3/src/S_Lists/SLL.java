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

	public void insertAtFirst(DNode Student) {
		SLLNode newNode = new SLLNode(Student);

		if (head == null) {
			head = newNode;

		} else {
			newNode.setNext(head);
			head = newNode;

		}

	}

	public boolean haveOnlyOne() {

		if (head.getNext() == null) // null --> head --> null //alone
			return true; // yes,SLL haveOnlyOne record

		return false;// null --> head --> record(nut Null) --> null
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

	public DNode findAndReturn(DNode Student) {
		SLLNode curr = head;

		while (curr != null) {
			if (curr.getStudent() == Student) {
				return curr.getStudent();
			}
			curr = curr.getNext();
		}
		return null;
	}

	public void delete(DNode Student) {
		SLLNode ptr = head, prev = head;
		if (ptr == null) {
			System.out.println("List is emptey");
			return;
		}
		if (ptr.getStudent().equals(Student)) {
			head = head.getNext();
			ptr.setNext(null);

		}
		while (ptr != null && ptr.getStudent().equals(Student)) {
			prev = ptr;
			ptr = ptr.getNext();
		}
		if (ptr == null) {
			System.out.println("Student not found");
			return;
		}
//		if (ptr == tail) {
//			tail = prev;
//			tail.next = null;
//		}
		prev.setNext(ptr.getNext());
		ptr.setNext(null);
	}

	/*
	 * public boolean delete(DNode Student) { if (head == null) { return false; }
	 * 
	 * SLLNode curr = head; SLLNode prev = null;
	 * 
	 * if (curr.getStudent() == Student) { head = head.getNext(); return true; }
	 * 
	 * // double wantedGrade = Student.data.getAvg(); while (curr != null && curr.getStudent().data.getAvg() < wantedGrade) { prev = curr; curr = curr.getNext();
	 * 
	 * } if (curr.getStudent() == Student)
	 * 
	 * { prev.setNext(curr.getNext()); return true; } return false; }
	 */
	@Override
	public String toString() {
		String s = "";
		SLLNode curr = head;
		while (curr != null) {
			s += curr.toString();
			curr = curr.getNext();
		}
		return s + " " + "\n";
	}

}