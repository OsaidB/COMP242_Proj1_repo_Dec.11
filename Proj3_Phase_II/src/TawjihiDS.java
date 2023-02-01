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
		// 3-inserting Student to the "Seat Numbers AVL"(seatsT)
		// insertSeatNumber(DNode key)
		S_Node seat = seatsT.findSteatNum(seatNumber);
		if (seat != null) {
			// " !=null " means that node already exist. //Duplicate seatnum
			System.out.println("you cant add two students with same seat number,it seems like student you are tring to add is already exist in the seats AVL!");
		} else {
			seatsT.insertSeatNumber(dnode);
		}

	}

	public void deleteStudent(int seatNumber) {
		DNode dNodeToDelete = allStudentsDList.searchSeat(seatNumber);

		if (dNodeToDelete != null) {

			// 2-deleting Student(dnode) from the "Grades AVL"(gradesT)
			double avg = dNodeToDelete.data.getAvg();
			GNode gNodeToDelete = gradesT.findGrade(avg);

			if (gNodeToDelete == null) {
				System.out.println("You are trying to delete a student that is already not existing in the grades AVL!");
			} else if (gNodeToDelete != null) {// there is at least one student that have the grade that student we want to delete having.

				if (!(gNodeToDelete.getNextList().haveOnlyOne())) {// there are more than one student having that specific grade ---> so we delete ONLY THE DNode FROM THE SLL.
					gNodeToDelete.getNextList().delete(dNodeToDelete);
				} else {// the student we want to delete is THE ONLY ONE that have that grade ---> WE DELETE THE WHOLE GNODE.
					gradesT.deleteGrade(dNodeToDelete);
				}

			}
			///////////////////////////////////////////////////////////////////
			// 3-deleting Student from the "Seat Numbers AVL"(seatsT)
			S_Node seat = seatsT.findSteatNum(seatNumber);
			if (seat == null) {
				System.out.println("there is no student with this seat number in seatsT");
			} else {// seat ready to delete
				seatsT.deleteSeat(dNodeToDelete);
			}

			// 1-deleting Student from the "Double Linked List"(allStudentsDList)
			allStudentsDList.remove(seatNumber);

		} else {
			System.out.println("seatNum not found in DList");
		}
	}

	public void updateStudent(int oldSeat, int seatNumber, String branch, double avg) {

		DNode oldDNode = allStudentsDList.searchSeat(oldSeat);

		if (oldDNode != null) {

			// 2-updating Student in the "Grades AVL"(gradesT)
//			double avg = dNodeToUpdate.data.getAvg();
			GNode gNodeToUpdate = gradesT.findGrade(oldDNode.data.getAvg());

			if (gNodeToUpdate == null) {
				System.out.println("you are tring to update a student that does not exist in the gradesT");
			} else if (gNodeToUpdate != null) {// there is at least one student that have the grade that student we want to update having.

				DNode toUpdate = gNodeToUpdate.getNextList().findAndReturn(oldDNode);

				if (!(gNodeToUpdate.getNextList().haveOnlyOne()) && oldDNode.data.getAvg() == avg) {// there are more than one student having that specific grade ---> so we update ONLY THE DNode
																									// FROM THE SLL. unless the grade does not change
					// Old grade = new grade, so we just change seat and branch
//					DNode toUpdate = gNodeToUpdate.getNextList().findAndReturn(dNodeToUpdate);

					if (toUpdate != null) {
						toUpdate.data.setSeatNumber(seatNumber);
						toUpdate.data.setBranch(branch);
						// toUpdate.data.setAvg(avg); //same

					} else {
						System.out.println("ERORR! toUpdate=null   (Student nut found in SLL)");
					}

				} else if (gNodeToUpdate.getNextList().haveOnlyOne()) {
					// the student we want to update is THE ONLY ONE that have that grade
					// ---> WE delete THE WHOLE GNODE and re insert the node with new grade. NO NO NO NO!!!
					// we just update everything

//					DNode toUpdate = gNodeToUpdate.getNextList().findAndReturn(dNodeToUpdate);					

					toUpdate.data.setSeatNumber(seatNumber);
					toUpdate.data.setBranch(branch);
					toUpdate.data.setAvg(avg);

					gNodeToUpdate.setAVLHeaderGrade(toUpdate);

				} else if (oldDNode.data.getAvg() != avg) {// it could be !=avg but its the only student in the sll!
															// thats why we put this condition after the "haveOnlyOne()" condition
					// now // Old grade != new grade, so we need to delete the record from the SLL Only!
					// and re insert it to gradesT

					gNodeToUpdate.getNextList().delete(toUpdate);

					// inserting it updated
					Student s = new Student(seatNumber, branch, avg);
					DNode dnode = new DNode(s);// IN ALL CASES we need to creat the dnode we want to add to the GAVL

					gradesT.insertGrade(dnode);

				}

			}
/////////////////////////////////////////////////////////////////////////////////
			// 3-updating Student in the "Seat Numbers AVL"(seatsT)

			S_Node seat = seatsT.findSteatNum(oldSeat);

			if (seat == null) {
				System.out.println("there is no student with this seat number in seatsT AVL");
			} else {// seat ready to update

				if (seat.getData().data.getSeatNumber() == seatNumber) {// old seat number is SAME as new one
																		// so we dont need to (delete and re insert) the whole S_Node from and to the S_AVL
					seat.getData().data.setSeatNumber(seatNumber);
					seat.getData().data.setBranch(branch);
					// toUpdate.data.setAvg(avg); //same

				} else {// seat number changed
						// so delete and re insert

					seatsT.deleteSeat(seat.getData());

					// inserting it updated
					Student s = new Student(seatNumber, branch, avg);
					DNode dnode = new DNode(s);// IN ALL CASES we need to creat the dnode we want to add to the GAVL

					seatsT.insertSeatNumber(dnode);
				}

			}

			// 1-updating Student from the "Double Linked List"(allStudentsDList)

			oldDNode.data.setSeatNumber(seatNumber);
			oldDNode.data.setBranch(branch);
			oldDNode.data.setAvg(avg);

		} else {
			System.out.println("you are tring to update a student that does not exist in the DList");
		}

	}

	public DNode findStudent(int seatNumber) {
		S_Node s = seatsT.findSteatNum(seatNumber);

		return s.getData();

	}

	public String allStudentsGot(double grade) {

		GNode g = gradesT.findGrade(grade);

		return g.getNextList() + "";

	}
}