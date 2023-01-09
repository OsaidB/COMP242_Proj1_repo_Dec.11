package base;

public class cursorDriver {

	public static void main(String[] args) {
		CurserList<Integer> list = new CurserList<Integer>();

//////////////////////////////////////////////////////////////////////
		int L1 = list.creatList();// the ineger stored in "L1" represent the index of the header of this list

		list.insertLast(10, L1);
		list.insertLast(20, L1);
		list.insertLast(30, L1);
		list.insertLast(40, L1);

		System.out.println("\n******     List #1 Elements:\n");
		list.printList(L1);
//////////////////////////////////////////////////////////////////////
		int L2 = list.creatList();

		list.insertFirst(1, L2);
		list.insertFirst(2, L2);
		list.insertFirst(3, L2);
		list.insertFirst(4, L2);

		System.out.println("\n******     List #2 Elements:\n");
		list.printList(L2);
//////////////////////////////////////////////////////////////////////

	}
}
