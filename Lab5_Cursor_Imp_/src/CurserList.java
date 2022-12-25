
public class CurserList {
	cNode[] cs;
	final static int DEF_SIZE = 100;

	public CurserList() {
		this(DEF_SIZE);// calling the another constructor
	}

	public CurserList(int size) {
//		cNode[] cs = new cNode[size];
		cs = new cNode[size];

		for (int i = 0; i < cs.length; i++) {
			cs[i] = new cNode(null, i + 1);
		}
		cs[size - 1].next = 0;
	}

	public int cursorAlloc() {// first empty cell(in freelist)
		int p = cs[0].next;
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

	public void cursorFree(int cell) {// deleting a cell

		cs[cell].key = null; // حذفنا محتوى السيل المراد حذفها

		int temp = cs[0].next; // taking the last thing that was in the freelist

		cs[0].next = cell; // updating the freelist// بتصير الفري لست تحكي انه السيل الفاضية هي اللي هسا
							// انحذفت

		cs[cell].next = temp;
	}

	public boolean isEmpty(int header) {// chicking if list is empty
		return cs[header].next == 0;
	}

	public int find(Object x, int header) {

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

	public void insert(Object x, int header) { // inserting at the end of a specific list(given header)
		int curr = cs[header].next;

		int prev = header;
		int temp = cursorAlloc();

		if (temp != 0) {
			while (curr != 0) {
				prev = curr;
				curr = cs[curr].next;
			}

			cs[temp].key = x;
			cs[temp].next = cs[prev].next;// cs[prev].next بتكون صفر في طبيعة الحال
			cs[prev].next = temp;

		}
	}

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
			int temp = cs[prev].next;
			cs[prev].next = cs[temp].next;
			cursorFree(temp);
		} else {// the cell that we want to delet existing in the end of the list

		}

	}

	public void freeList(int header) {

	}

}
