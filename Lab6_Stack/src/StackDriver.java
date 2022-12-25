
public class StackDriver {

	public static void main(String[] args) {
		
		StackList list=new StackList();
		
		list.push("ali");
		list.push(110);
		list.push(200);
		list.push("Ahmad");
		list.push(300);
		
		System.out.println("Before:-");
		list.printList();
		
		list.pop();
		System.out.println("\nAfter:-");
		list.printList();

		System.out.println("\nsearsh test:");
		list.searchList("loae");
		
		
//		list.insertAfterPosition( "ali", "newName", "newid");
//		System.out.println("\nAfter:-");
//		list.printList();
		
//		System.out.println("\n at last test:");
//		list.insertLast("newName2","newid2");
//		list.printList();
	}

}
