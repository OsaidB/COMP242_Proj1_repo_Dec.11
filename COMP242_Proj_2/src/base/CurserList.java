package base;

public class CurserList<T extends Comparable<T>> {

	cNode<T>[] cs;
	final static int DEF_SIZE = 100;

/////////////////////////////////////////////////	
//constructors

	public CurserList() {
		this(DEF_SIZE);// calling the another constructor
	}

	@SuppressWarnings("unchecked")
	public CurserList(int size) {
//		cNode[] cs = new cNode[size];
		cs = new cNode[size];// creating the first node of the list//creating the whoooole list

//		for (int i = 0; i < cs.length; i++) {// بمشي على كامل الارري
//			cs[i] = new cNode<T>(null, i + 1);// creating the node itself(pay attention to the type of the brackets)
//		}
//		cs[size - 1].next = 0;

		for (int i = 0; i < cs.length - 1; i++)
			cs[i] = new cNode<T>(null, i + 1);

		cs[cs.length - 1] = new cNode<>(null, 0);

	}

/////////////////////////////////////////////////

	public int cursorAlloc() {// فعلياً مثود لحجز نود//returns first empty cell //IDK(in freelist) //we take it to use it! //so its not a method to return just a piece of info!!
		int p = cs[0].next;// p is *the location* of the first available node

		if (p == 0) {
			System.out.println("list is full");
			return 0;
		}
		cs[0].next = cs[p].next;
		cs[p].next = 0;

		return p;

	}

	public int creatList() {
		return cursorAlloc();
	}

	public cNode<T> returnFirst(int header) {

		int c = cs[header].next;
		cNode<T> temp = cs[c];

		return temp;
	}

/////////////////////////////////////////////////
	public void insertFirst(T key, int header) {
		if (cs[header] == null) {
			System.out.println("List not exist.");
			return;
		}
		int temp = cursorAlloc();
		if (temp != 0) {
			cs[temp] = new cNode<>(key, cs[header].next);
			cs[header].next = temp;
		}
	}

	public void insertLast(T key, int header) { // inserting at the end of a specific list(given header)

		int curr = cs[header].next;
		int prev = header;

		int temp = cursorAlloc();

		if (temp != 0) {// if temp = cursorAlloc() = 0// then the whole sursor list is full
			cs[temp].key = key;

			while (curr != 0) {
				prev = curr;
				curr = cs[curr].next;
			} // when i get out of this loop-->"curr" gonna be =0!! aaaaaaaaaannnnnddd "prev" gonna be =the last node existing in the wanted list(header), so we add our new node after it...
				// so "prev" is the node that i wanna add after it

			cs[temp].next = cs[prev].next;// cs[prev].next بتكون صفر في طبيعة الحال
			cs[prev].next = temp;

		}
	}

	public boolean isEmpty(int header) {// chicking if a specific list(with a given index of its head) is empty
		return cs[header].next == 0;
	}

	public int find(T key, int header) {// returns the index of the wanted node

		int curr = cs[header].next;
		if (isEmpty(header)) {
			System.out.println("List is empty!");
			return -1;
		}
		while (curr != 0 && !cs[curr].key.equals(key))
			curr = cs[curr].next;

		if (curr == 0) {
			System.out.println("Element not found!");
			return -1;
		}

		return curr;
	}

/////////////////////////////////////////////////

	public void delete(T key, int header) {// deleting a specific node in a specific list

		if (isEmpty(header)) {
			System.out.println("you are tring to delet from an empty List!");
			return;
		}

		int prev = findPrev(key, header);

		if (prev == -1) {
			System.out.println("Element not found");
			return;
		}

		if (cs[prev].next != 0) {

			int temp = cs[prev].next;// saving the index of "the element that we want to delete"(cs[prev].next)
			cs[prev].next = cs[temp].next;
			cursorFree(temp);
			// يعنييييييييي// we have for example ( 9 -> 2 -> 4 ) and we want to delete "2" so its become ( 9 -> 4 )

		} else {// the cell that we want to delet existing in the end of the list
			System.out.println("nothing to delete(element not found)");// بسس اصلا اذا الايليمنت نت فاوند بتكون الفايند بريفيس مرجهة سال واحد
		}

	}

//	public cNode<T> deleteFirst(int header) {// deleting the first node in a specific list
//		if (cs[header] == null) {
//			System.out.println("List not exist.");
//			return null;
//		}
//
//		if (isEmpty(header)) {
//			System.out.println("you are tring to delet from an empty List!");
//			return null;
//		}
//
//		int cell = cs[header].next;
//		cNode<T> temp = cs[cell];
//		cs[header].next = temp.next;
//
//		cursorFree(cell);
//		return temp;
//
//	}
	public cNode<T> deleteFirst(int header) {// deleting the first node in a specific list
		if (cs[header] != null && !isEmpty(header)) {
			int cell = cs[header].next;
			cNode<T> temp = cs[cell];
			cs[header].next = temp.next;
			cursorFree(cell);
			return temp;
		}
		return null;

	}

	public int findPrev(T key, int header) {

		int curr = header;

		if (isEmpty(header)) {
			System.out.println("List is empty!");
			return -1;
		}

		while (cs[curr].next != 0 && !cs[cs[curr].next].key.equals(key))// caaaaaaaaaanttttt unnndderrrstaaandddddd!!!!!!!
			curr = cs[curr].next;

		if (cs[curr].next == 0) {
			System.out.println("Element not found!");
			return -1;
		}

		return curr;
	}

	public void cursorFree(int cell) {// deleting a cell //مثل مبدأ ال addFirst// adding a node back to the available nodes

		// "cell" is the index of the node i want to free
//		cs[cell].key = null; // حذفنا محتوى السيل المراد حذفها
//
//		int temp = cs[0].next; // taking the last thing that was in the freelist
//
//		cs[0].next = cell; // updating the freelist(freelist means the list of the available nodes)// بتصير الفري لست تحكي انه السيل الفاضية هي اللي هسا انحذفت
//
//		cs[cell].next = temp;

		cs[cell] = new cNode<T>(null, cs[0].next);
		cs[0].next = cell;
		// OR// حل اخر
		/*
		 * cs[cell].key = null;
		 * 
		 * cs[cell].next=cs[0].next;
		 * 
		 * cs[0].next = cell;
		 */
	}

	public void freeList(int header) {// make list empty

		int p = cs[header].next;// getting the index of the first element in the list

		while (!isEmpty(header)) {
			cursorFree(p);
			p = cs[header].next;

		}
	}

/////////////////////////////////////////////////

	public void printList(int header) {

		if (isEmpty(header)) {
			System.out.println("List is empty!");
			return;
		}
		int curr = cs[header].next;
		while (curr != 0) {
			System.out.println(cs[curr].toString());
			curr = cs[curr].next;
		}

	}
}
