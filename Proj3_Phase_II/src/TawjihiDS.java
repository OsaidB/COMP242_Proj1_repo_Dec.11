import DLists.*;

public class TawjihiDS {

	DLinkedList allStudentsDList = new DLinkedList();
	GAVL gradesT = new GAVL();
	S_AVL seatsT = new S_AVL();

	public void insertStudent(int seatNumber, String branch, double avg) {

		// 1-inserting Student to the "Double Linked List"(allStudentsDList)
		Student s = new Student(seatNumber, branch, avg);
		allStudentsDList.insertFirst(s);

		///////////////////////////////////////////////////////////////////
		// 2-inserting Student(dnode) to the "Grades AVL"(gradesT)
		DNode dnode = new DNode(s);// IN ALL CASES we need to creat the dnode we want to add to the GAVL

		GNode ifExist = gradesT.findGrade(avg);
		if (ifExist == null) {
			gradesT.insertGrade(dnode);
		} else if (ifExist != null) {
			// " !=null " means that node already exist,
			// and we just need to add {the newStudent's Info(DNode)} to the Single linked list that exist
			// in the node that exist in gradesT, but we need to find it first
			// DNode dnode = new DNode(s);

			if (ifExist.getNextList().find(dnode) == true) {// if student we are tring to add is already exist///////Duplicate grade, and Duplicate student(same exact student)
				System.out.println("the student you are tring to add is already exist in the grades AVL!");
			} else {// Duplicate grade, but unique student
				ifExist.insertInNextList(dnode);
			}

		}
		///////////////////////////////////////////////////////////////////
		// 3-inserting Student to the "Seat Numbers AVL"(gradesT)
		// insertSeatNumber(DNode key)
		S_Node ifSeatExist = seatsT.findSteatNum(seatNumber);
		if (ifSeatExist != null) {
			// " !=null " means that node already exist. //Duplicate seatnum
			System.out.println("you cant add two students with same seat number,it seems like student you are tring to add is already exist in the seats AVL!");
		} else {
			seatsT.insertSeatNumber(dnode);
		}

	}


	public void deleteStudent(int seatNumber) {
		DNode dNodeToDelete =allStudentsDList.searchSeat(seatNumber);
		double avg=dNodeToDelete.data.getAvg();
		// 1-deleting Student from the "Double Linked List"(allStudentsDList)
		allStudentsDList.remove(seatNumber);

		///////////////////////////////////////////////////////////////////
		// 2-deleting Student(dnode) from the "Grades AVL"(gradesT)
		GNode gNodeToDelete = gradesT.findGrade(avg);
		
		if (gNodeToDelete == null) {
		System.out.println("You are trying to delete a student that is already not existing in the grades AVL!");
		} else if (gNodeToDelete != null) {//then gNodeToDelete is the node we want to delete
			
			gradesT.deleteGrade(dNodeToDelete);
			
			
			
			
			
			
			
			
			
			//if its alone in the SLL --> we need to delete it twice
			//first from the SLL (gradesT.nextList)
			//and second from the GAVL(gradesT) (we need to delete the "GNode" that ( GNode.AVLHeaderGrade==avg )
			
			//public GNode deleteGrade(DNode key)
			
			//or just delete the GAVL
			if (gNodeToDelete.getNextList().find(dNodeToDelete) == true) {//student exists
				System.out.println("the student you are tring to add is already exist in the grades AVL!");
			} else {// Duplicate grade, but unique student
				gNodeToDelete.insertInNextList(dnode);
			}

		}
		///////////////////////////////////////////////////////////////////
		// 3-inserting Student to the "Seat Numbers AVL"(gradesT)
		// insertSeatNumber(DNode key)
		S_Node ifSeatExist = seatsT.findSteatNum(seatNumber);
		if (ifSeatExist != null) {
			// " !=null " means that node already exist. //Duplicate seatnum
			System.out.println("you cant add two students with same seat number,it seems like student you are tring to add is already exist in the seats AVL!");
		} else {
			seatsT.insertSeatNumber(dnode);
		}

	}
}
