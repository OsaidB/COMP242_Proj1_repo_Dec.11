package application;

public class DLinkedList<T> {

	DNode<T> head;

	public void insertFirst(T data) {
		DNode<T> newNode = new DNode<>(data);

		if (head != null) {

			// newNode.next = head;
			newNode.setNext(head);

			// head.prev = newNode;
			head.setPrev(newNode);

		}
		head = newNode;
	}

	public void insertLast(T data) {
		DNode<T> newNode = new DNode<>(data);

		DNode<T> curr = head;

		while (curr != null && curr.getNext() != null) {
			curr = curr.getNext();

		}

		if (curr == null) {// empty list
			head = newNode;
		} else {// curr at last node
			newNode.setPrev(curr);
			curr.setNext(newNode);
		}

	}

//=========================================================
	public GazaTawjihi searchGazaList(int seatNum) {// the searsh is ccourding to seat number!!
		DNode<T> curr = head;

		if (head == null) {
			System.out.println("you are trying to search in an empty list!");
			return null;
		}
		int currSeatNum = ((GazaTawjihi) curr.getData()).getSeatNumber();

		while (curr != null) {
			// if (ptr.getData().compareTo(data) == 0) {
			// currSeatNum == seatNum
			if (currSeatNum == seatNum) {
				System.out.println("name is found");

				return (GazaTawjihi) curr.getData();
			}
			curr = curr.getNext();

			if (curr != null) {
				currSeatNum = ((GazaTawjihi) curr.getData()).getSeatNumber();
			}
		}
		System.out.println("name not found");
		return null;

	}

	public W_B_Tawjihi searchWBList(int seatNum) {// the searsh is ccourding to seat number!!
		DNode<T> curr = head;

		if (head == null) {
			System.out.println("you are trying to search in an empty list!");
			return null;
		}
		int currSeatNum = ((W_B_Tawjihi) curr.getData()).getSeatNumber();

		while (curr != null) {
			// if (ptr.getData().compareTo(data) == 0) {
			// currSeatNum == seatNum
			if (currSeatNum == seatNum) {
				System.out.println("name is found");

				return (W_B_Tawjihi) curr.getData();
			}
			curr = curr.getNext();

			if (curr != null) {
				currSeatNum = ((W_B_Tawjihi) curr.getData()).getSeatNumber();
			}
		}
		System.out.println("name not found");
		return null;

	}

//=========================================================
	public void insertWBSorrted(T data) {// data is the tawjihi object(a node)// (((((UPDATED: descending
											// order)))))tanazula

		DNode<T> newNode = new DNode<>(data);
		double newNodeAvg = ((W_B_Tawjihi) newNode.getData()).getAvg();// the avg of the student that im trying to
																		// insert

		if (head == null) {
			insertFirst(data);

		}
		DNode<T> curr = head;
		double currAvg = ((W_B_Tawjihi) curr.getData()).getAvg();

		// while (curr != null && (currAvg < newNodeAvg)) {// i want to rech the node
		// with higher avg to add new node before it(newNode before curr)
		while (curr != null && (currAvg > newNodeAvg)) {// i want to rech the node with lower avg to add new node after
														// it(newNode after curr)

			if (curr.getNext() == null) {
				break;
			}

			curr = curr.getNext();

			if (curr != null) {
				currAvg = ((W_B_Tawjihi) curr.getData()).getAvg();
			}
		}

		// now: currAvg < newNodeAvg
//		System.out.println(curr);
		if (curr == null) {// case 0:insert at empty list
			head = newNode;
		} else if (curr.getPrev() == null) {// case 1: insert at head (currAvg < newNodeAvg)
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		// else if (curr.getData().compareTo(data) < 0 && curr.getNext() == null) {
//		else if (currAvg < newNodeAvg && curr.getNext() == null) { // case 3: insert at last
		else if (currAvg > newNodeAvg && curr.getNext() == null) { // case 3: insert at last(currAvg > newNodeAvg)
			newNode.setPrev(curr);
			curr.setNext(newNode);

			newNode.setNext(null);
		} else {// case 2: insert between(before curr)//now: currAvg < newNodeAvg
			newNode.setNext(curr);
			newNode.setPrev(curr.getPrev());// wow
			curr.getPrev().setNext(newNode);
			curr.setPrev(newNode);
		}

	}

	public void insertGazaSorrted(T data) {// data is the tawjihi object(a node)// (((((UPDATED: descending
											// order)))))tanazula

		DNode<T> newNode = new DNode<>(data);
		double newNodeAvg = ((GazaTawjihi) newNode.getData()).getAvg();// the avg of the student that im trying to
																		// insert

		if (head == null) {
			insertFirst(data);

		}
		DNode<T> curr = head;
		double currAvg = ((GazaTawjihi) curr.getData()).getAvg();

		// while (curr != null && (currAvg < newNodeAvg)) {// i want to rech the node
		// with higher avg to add new node before it(newNode before curr)
		while (curr != null && (currAvg > newNodeAvg)) {// i want to rech the node with lower avg to add new node after
														// it(newNode after curr)

			if (curr.getNext() == null) {
				break;
			}

			curr = curr.getNext();

			if (curr != null) {
				currAvg = ((GazaTawjihi) curr.getData()).getAvg();
			}
		}

		// now: currAvg < newNodeAvg
//		System.out.println(curr);
		if (curr == null) {// case 0:insert at empty list
			head = newNode;
		} else if (curr.getPrev() == null) {// case 1: insert at head (currAvg < newNodeAvg)
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		// else if (curr.getData().compareTo(data) < 0 && curr.getNext() == null) {
//		else if (currAvg < newNodeAvg && curr.getNext() == null) { // case 3: insert at last
		else if (currAvg > newNodeAvg && curr.getNext() == null) { // case 3: insert at last(currAvg > newNodeAvg)
			newNode.setPrev(curr);
			curr.setNext(newNode);

			newNode.setNext(null);
		} else {// case 2: insert between(before curr)//now: currAvg < newNodeAvg
			newNode.setNext(curr);
			newNode.setPrev(curr.getPrev());// wow
			curr.getPrev().setNext(newNode);
			curr.setPrev(newNode);
		}

	}

	public void OLDinsertGazaSorrted(T data) {// data is the tawjihi object(a node) // ((((OLD:ascending order))))

		DNode<T> newNode = new DNode<>(data);
		double newNodeAvg = ((GazaTawjihi) newNode.getData()).getAvg();// the avg of the student that im trying to
																		// insert

		if (head == null) {
			insertFirst(data);

		}
		DNode<T> curr = head;
		double currAvg = ((GazaTawjihi) curr.getData()).getAvg();

		while (curr != null && (currAvg < newNodeAvg)) {// i want to rech the node with higher avg to add new node
														// before it(newNode before curr)

			if (curr.getNext() == null) {
				break;
			}

			curr = curr.getNext();

			if (curr != null) {
				currAvg = ((GazaTawjihi) curr.getData()).getAvg();
			}
		}

//		System.out.println(curr);
		if (curr == null) {// case 0:insert at empty list
			head = newNode;
		} else if (curr.getPrev() == null) {// case 1: insert at head
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		// else if (curr.getData().compareTo(data) < 0 && curr.getNext() == null) {
		else if (currAvg < newNodeAvg && curr.getNext() == null) { // case 3: insert at last
			newNode.setPrev(curr);
			curr.setNext(newNode);
		} else {// case 2: insert between(before curr)
			newNode.setNext(curr);
			newNode.setPrev(curr.getPrev());// wow
			curr.getPrev().setNext(newNode);
			curr.setPrev(newNode);
		}

	}

	public boolean deleteGazaSorted(int seatNum) {// the delete is ccourding to seat number!!
		DNode<T> curr = head;
		if (head == null) {
			System.out.println("you are trying to delete from an empty list!");
			return false;
		}
		int currSeatNum = ((GazaTawjihi) curr.getData()).getSeatNumber();

		// while (curr != null && curr.getData().equals(data)) {
//		while (curr != null && (currSeatNum < seatNum)) {
		while (curr != null && (currSeatNum > seatNum)) {
			curr = curr.getNext();// the next is smaller

			if (curr != null) {
				currSeatNum = ((GazaTawjihi) curr.getData()).getSeatNumber();
			}
		}

		System.out.println(curr);
		/*
		 * curr: Three cases
		 * 
		 * 1-null
		 * 
		 * 2-same as the node we want(== seatNum)
		 * 
		 * 3-smaller than the node we want(currSeatNum<seatNum)
		 * 
		 */
		if (curr == null || currSeatNum < seatNum) {
			System.out.println("element not found!");
			return false;
		}
//if(currSeatNum < seatNum)
//		if (!(currSeatNum == seatNum)) {

		if (curr.getPrev() == null && curr.getNext() == null) // case 0 : one node
			head = null;
		else if (curr.getPrev() == null) { // case 1 : delete 1st node
			head = curr.getNext();
			// head.prev = null;
			head.setPrev(null);
		} else if (curr.getNext() == null) // case 2 : delete last
			// curr.prev.next = null;
			curr.getPrev().setNext(null);
		else { // case 3 : delete between
				// curr.prev.next = curr.next;
			curr.getPrev().setNext(curr.getNext());

			// curr.next.prev = curr.prev;
			curr.getNext().setPrev(curr.getPrev());
		}

//		}else {//currSeatNum == seatNum

//		}

		return true;
	}

	public boolean deleteWBSorted(int seatNum) {// the delete is ccourding to seat number!!
		DNode<T> curr = head;

		if (head == null) {
			System.out.println("you are trying to delete from an empty list!");
			return false;
		}

		int currSeatNum = ((W_B_Tawjihi) curr.getData()).getSeatNumber();

		// while (curr != null && curr.getData().equals(data)) {
		while (curr != null && (currSeatNum > seatNum)) {
			curr = curr.getNext();// the next is smaller

			if (curr != null) {
				currSeatNum = ((W_B_Tawjihi) curr.getData()).getSeatNumber();
			}
		}

		System.out.println(curr);
		/*
		 * curr: Three cases
		 * 
		 * 1-null
		 * 
		 * 2-same as the node we want(== seatNum)
		 * 
		 * 3-smaller than the node we want(currSeatNum<seatNum)
		 * 
		 */
		if (curr == null || currSeatNum < seatNum) {
			System.out.println("element not found!");
			return false;
		}

		if (curr.getPrev() == null && curr.getNext() == null) // case 0 : one node
			head = null;
		else if (curr.getPrev() == null) { // case 1 : delete 1st node
			head = curr.getNext();
			// head.prev = null;
			head.setPrev(null);
		} else if (curr.getNext() == null) // case 2 : delete last
			// curr.prev.next = null;
			curr.getPrev().setNext(null);
		else { // case 3 : delete between
				// curr.prev.next = curr.next;
			curr.getPrev().setNext(curr.getNext());

			// curr.next.prev = curr.prev;
			curr.getNext().setPrev(curr.getPrev());
		}

		return true;
	}

//=========================================================
	public double wbMean() {
		DNode<T> curr = head;

		if (head == null) {
			System.out.println("empty list");
			return -1;

		}

		double currAvg = ((W_B_Tawjihi) curr.getData()).getAvg();

		int count = 0;
		double sum = 0;

		while (curr != null) {
			count++;
			sum = sum + currAvg;

			curr = curr.getNext();

			if (curr != null) {
				currAvg = ((W_B_Tawjihi) curr.getData()).getAvg();
			}

		}

		double mean = 0.0;
		mean = sum / count;

		return mean;
	}

	public double gazaMean() {

		DNode<T> curr = head;

		if (head == null) {
			System.out.println("empty list");
			return -1;

		}

		double currAvg = ((GazaTawjihi) curr.getData()).getAvg();

		int count = 0;
		double sum = 0;

		while (curr != null) {
			count++;
			sum = sum + currAvg;

			curr = curr.getNext();

			if (curr != null) {
				currAvg = ((GazaTawjihi) curr.getData()).getAvg();
			}

		}

		double mean = 0.0;
		mean = sum / count;

		return mean;
	}

//	@Override
//	public String toString() {
//=========================================================
	public double modeGaza() {// take three
//		currAvg = ((GazaTawjihi) curr.getData()).getAvg();
		double maxValue = ((GazaTawjihi) head.getData()).getAvg();
		double lastValue = maxValue;

		int count = 1;
		int maxCount = 1;

		DNode<T> curr = head;

		if (head == null) {
			System.out.println("empty list");
			return -1;

		}
		double currAvg = ((GazaTawjihi) curr.getData()).getAvg();

		while (curr != null) {

			if (currAvg == lastValue) {
				count++;
			} else {
				count = 1;
				lastValue = currAvg;
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = lastValue;
			}

			curr = curr.getNext();

			if (curr != null) {
				currAvg = ((GazaTawjihi) curr.getData()).getAvg();
			}
		}
		System.out.println("( " + maxCount + " Times )");
		return maxValue;

	}

	public double modeWB() {// take three
//		currAvg = ((GazaTawjihi) curr.getData()).getAvg();
		double maxValue = ((W_B_Tawjihi) head.getData()).getAvg();
		double lastValue = maxValue;

		int count = 1;
		int maxCount = 1;

		DNode<T> curr = head;

		if (head == null) {
			System.out.println("empty list");
			return -1;

		}
		double currAvg = ((W_B_Tawjihi) curr.getData()).getAvg();

		while (curr != null) {

			if (currAvg == lastValue) {
				count++;
			} else {
				count = 1;
				lastValue = currAvg;
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = lastValue;
			}

			curr = curr.getNext();

			if (curr != null) {
				currAvg = ((W_B_Tawjihi) curr.getData()).getAvg();
			}
		}
		System.out.println("( " + maxCount + " Times )");
		return maxValue;

	}

//=========================================================
	public String gazaFindAbove(double specGrade) {// students whom (grade > = specific grade)
		DNode<T> curr = head;

		if (head == null) {
			System.out.println("empty list!");
			return "empty list!";
		}
		double currGrade = ((GazaTawjihi) curr.getData()).getAvg();

		int counter = 0;
		int allCounter = 0;

		while (curr != null) {
			allCounter++;
			// if (ptr.getData().compareTo(data) == 0) {
			// currSeatNum == seatNum
			if (currGrade >= specGrade) {
				System.out.println("One found");
				counter++;
			}
			curr = curr.getNext();

			if (curr != null) {
				currGrade = ((GazaTawjihi) curr.getData()).getAvg();
			}
		}
		double percentage = (counter * 100.0) / allCounter;

		System.out.println("\nthere are " + counter + " Students that are equals or greater than " + specGrade);
		System.out.println("\nallCounter : " + allCounter);
		System.out.println("\nand the percentage of them are :" + percentage + "%");

		String result = "there are " + counter + " Students that are equals or greater than " + specGrade
				+ "\nand the percentage of them are :" + percentage + "%";
		return result;

	}

	public String wbFindAbove(double specGrade) {// students whom (grade > = specific grade)
		DNode<T> curr = head;

		if (head == null) {
			System.out.println("empty list!");
			return "empty list!";
		}
		double currGrade = ((W_B_Tawjihi) curr.getData()).getAvg();

		int counter = 0;
		int allCounter = 0;

		while (curr != null) {
			allCounter++;
			// if (ptr.getData().compareTo(data) == 0) {
			// currSeatNum == seatNum
			if (currGrade >= specGrade) {
				System.out.println("One found");
				counter++;
			}
			curr = curr.getNext();

			if (curr != null) {
				currGrade = ((W_B_Tawjihi) curr.getData()).getAvg();
			}
		}
		double percentage = (counter * 100.0) / allCounter;

		System.out.println("\nthere are " + counter + " Students that are equals or greater than " + specGrade);
		System.out.println("\nallCounter : " + allCounter);
		System.out.println("\nand the percentage of them are :" + percentage + "%");

		String result = "there are " + counter + " Students that are equals or greater than " + specGrade
				+ "\nand the percentage of them are :" + percentage + "%";
		return result;

	}

//=========================================================
	public DLinkedList<GazaTawjihi> gazaDisplayTopTen() {
		DLinkedList<GazaTawjihi> gazaTop10 = new DLinkedList<>();
		DNode<T> curr = head;

		for (int i = 0; i < 9; i++) {

			gazaTop10.insertGazaSorrted((GazaTawjihi) curr.getData());
			if (curr.getNext() == null) {
				break;
			}
			curr = curr.getNext();

		}
		return gazaTop10;
	}

	public DLinkedList<W_B_Tawjihi> wbDisplayTopTen() {
		DLinkedList<W_B_Tawjihi> wbTop10 = new DLinkedList<>();
		DNode<T> curr = head;

		for (int i = 0; i < 9; i++) {

			wbTop10.insertWBSorrted((W_B_Tawjihi) curr.getData());
			if (curr.getNext() == null) {
				break;
			}
			curr = curr.getNext();

		}
		return wbTop10;
	}

	@Override
	public String toString() {
		DNode<T> curr = head;
		String s = "Head -->\n";

		while (curr != null) {
			s += curr + "-->\n";
			curr = curr.getNext();
		}
		return s + "Null";
	}

}
