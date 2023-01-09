
public class CurserList {

	cNode[] cs;
	final static int DEF_SIZE = 100;

/////////////////////////////////////////////////	
//constructors

	public CurserList() {
		this(DEF_SIZE);// calling the another constructor
	}

	public CurserList(int size) {
//		cNode[] cs = new cNode[size];
		cs = new cNode[size];// creating the first node of the list//creating the whoooole list

		for (int i = 0; i < cs.length; i++) {// بمشي على كامل الارري
			cs[i] = new cNode(null, i + 1);// creating the node itself(pay attention to the type of the brackets)
		}
		cs[size - 1].next = 0;
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

/////////////////////////////////////////////////

	public void insert(Object x, int header) { // inserting at the end of a specific list(given header)

		int curr = cs[header].next;
		int prev = header;

		int temp = cursorAlloc();

		if (temp != 0) {// if temp = cursorAlloc() = 0// then the whole sursor list is full
			cs[temp].key = x;

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

	public int find(Object x, int header) {// returns the index of the wanted node

		int curr = cs[header].next;
		if (isEmpty(header)) {
			System.out.println("List is empty!");
			return -1;
		}
		while (curr != 0 && !cs[curr].key.equals(x))
			curr = cs[curr].next;

		if (curr == 0) {
			System.out.println("Element not found!");
			return -1;
		}

		return curr;
	}

/////////////////////////////////////////////////

	public void delete(Object x, int header) {

		if (isEmpty(header)) {
			System.out.println("you are tring to delet from an empty List!");
			return;
		}

		int prev = findPrev(x, header);

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

	public int findPrev(Object x, int header) {

		int curr = header;

		if (isEmpty(header)) {
			System.out.println("List is empty!");
			return -1;
		}

		while (cs[curr].next != 0 && !cs[cs[curr].next].key.equals(x))// caaaaaaaaaanttttt unnndderrrstaaandddddd!!!!!!!
			curr = cs[curr].next;

		if (cs[curr].next == 0) {
			System.out.println("Element not found!");
			return -1;
		}

		return curr;
	}

	public void cursorFree(int cell) {// deleting a cell //مثل مبدأ ال addFirst// adding a node back to the available nodes

		// "cell" is the index of the node i want to free
		cs[cell].key = null; // حذفنا محتوى السيل المراد حذفها

		int temp = cs[0].next; // taking the last thing that was in the freelist

		cs[0].next = cell; // updating the freelist(freelist means the list of the available nodes)// بتصير الفري لست تحكي انه السيل الفاضية هي اللي هسا انحذفت

		cs[cell].next = temp;

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
//			p = cs[p].next;
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
