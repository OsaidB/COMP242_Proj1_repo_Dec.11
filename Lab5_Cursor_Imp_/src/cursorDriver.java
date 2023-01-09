
public class cursorDriver {

	public static void main(String[] args) {
		CurserList list=new CurserList();
		
		
//////////////////////////////////////////////////////////////////////
		int L1=list.creatList();//the ineger stored in "L1" represent the index of the header of this list
		
		list.insert(10, L1);
		list.insert(20, L1);
		list.insert(30, L1);
		list.insert(40, L1);
		
		System.out.println("\n******     List #1 Elements:\n");
		list.printList(L1);
//////////////////////////////////////////////////////////////////////
		int L2=list.creatList();
		
		list.insert(1, L2);
		list.insert(2, L2);
		list.insert(3, L2);
		list.insert(4, L2);		
		
		System.out.println("\n******     List #2 Elements:\n");
		list.printList(L2);
//////////////////////////////////////////////////////////////////////

	}
}
