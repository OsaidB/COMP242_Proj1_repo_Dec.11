import DLists.*;

public class BST<T extends Comparable<T>> {
	protected Node root;

	public BST() {
	}

	public Node getRoot() {
		return root;
	}

	public void insert(DNode data) {
		Node add = new Node(data);
		if (root == null)
			root = add;
		else {
			Node curr = root;
			while (curr != null) {
				if ((Integer) curr.getData().data > (Integer) data.data)///////
					if (curr.hasLeft())
						curr = curr.getLeft();
					else {
						curr.setLeft(add);
						break;
					}
				else if ((Integer) curr.getData().data < (Integer) data.data)
					if (curr.hasRight())
						curr = curr.getRight();
					else {
						curr.setRight(add);
						break;
					}
			}

		}
	}

	public Node max() {
		Node curr = root;
		while (curr.hasRight())
			curr = curr.getRight();

		return curr;
	}

	public Node min() {
		Node curr = root;
		while (curr.hasLeft())
			curr = curr.getLeft();

		return curr;
	}

	public String inOrdar() {
		return inOrdar(root);
	}

	private String inOrdar(Node root) {
		if (root != null) {
			if (root.getLeft() != null && root.getRight() != null)
				return inOrdar(root.getLeft()) + "\n" + root.getData() + "\n" + inOrdar(root.getRight());
			else if (root.getRight() != null)
				return root.getData() + "\n" + inOrdar(root.getRight());
			else if (root.getRight() != null)
				return inOrdar(root.getLeft()) + "\n" + root.getData();
			else
				return root.getData().toString();
		} else
			return "";
	}

	public String toString() {
		return toStringLevels(root);
	}

	private String toStringLevels(Node curr) {
		int x = height();
		String soso = "";
		for (int i = 0; i < x; i++) {
			soso += printLevel(root, i, 0) + "\n";
		}
		return soso;
	}

	private String printLevel(Node root, int i, int j) {

		if (root != null) {
			if (i == j)
				return root.getData() + " ";
			if (j > i)
				return "NULL";

			return printLevel(root.getLeft(), i, j + 1) + " " + printLevel(root.getRight(), i, j + 1);
		} else
			return "NULL";

	}

	public Node find(T data) {
		return find(data, root);
	}

	public Node find(T data, Node node) {

//		DNode

		if (node != null) {

			// compareTo(data);
			// 0 if this Integer is equal to the argument Integer;
			// a value less than 0 if this Integer is numerically less than the argument Integer;
			// and a value greater than 0 if this Integer is numerically greater than the argument Integer (signed comparison).

//			int comp = node.getData().compareTo(data);
//			if (comp == 0)
//				return node;
//			else if (comp > 0 && node.hasLeft())
//				return find(data, node.getLeft());
//			else if (comp < 0 && node.hasRight())
//				return find(data, node.getRight());

			if (node.getData() == data) {
				return node;
			} else if (((Integer) node.getData().data > (Integer) data) && node.hasLeft())////// 100% there is somthing wrong
				return find(data, node.getLeft());
			else if (((Integer) node.getData().data < (Integer) data) && node.hasRight())////// 100% there is somthing wrong
				return find(data, node.getRight());
		}
		return null;
	}

	public int height() {
		return hieght(root);
	}

	private int hieght(Node curr) {
		if (curr == null)
			return 0;
		if (curr.isLeaf())
			return 1;
		else
			return Math.max(1 + hieght(curr.getLeft()), 1 + hieght(curr.getRight()));
	}

	public Node delete(T data) {
		if (root == null)
			return null;

		Node dad = root;
		Node curr = root;
		boolean isLeft = false;

////////////////////////////////
		// int comp = curr.getData().compareTo(data); //replacing this line to the following
		int comp3 = -999;

		if (curr.getData() == data) {
			comp3 = 0;
		} else if (((Integer) curr.getData().data > (Integer) data) && curr.hasLeft())////// 100% there is somthing wrong
			comp3 = 999;
		else if (((Integer) curr.getData().data < (Integer) data) && curr.hasRight())////// 100% there is somthing wrong
			comp3 = -100;
////////////////////////////////

		// int comp = curr.getData().compareTo(data);
		while (curr != null) {

			//////////////////////////////////////////////////
			// comp = curr.getData().compareTo(data); //replacing this line to the following

			if (curr.getData() == data) {
				comp3 = 0;
			} else if (((Integer) curr.getData().data > (Integer) data) && curr.hasLeft())////// 100% there is somthing wrong
				comp3 = 999;
			else if (((Integer) curr.getData().data < (Integer) data) && curr.hasRight())////// 100% there is somthing wrong
				comp3 = -100;
			//////////////////////////////////////////////////

			if (comp3 == 0)
				break;
			dad = curr;
			if (comp3 > 0) {
				isLeft = true;
				curr = curr.getLeft();
			} else {
				isLeft = false;
				curr = curr.getRight();
			}
		}

		if (comp3 != 0)
			return null;
		else {
			if (curr.isLeaf()) {
				if (curr == root)
					root = null;
				else if (isLeft)
					dad.setLeft(null);
				else
					dad.setRight(null);
			} else if (curr.hasLeft() && !curr.hasRight()) {

				if (root == curr)
					root = curr.getLeft();
				else if (isLeft)
					dad.setLeft(curr.getLeft());
				else
					dad.setRight(curr.getLeft());
			} else if (curr.hasRight() && !curr.hasLeft()) {

				if (curr == root)
					root = curr.getRight();
				else if (isLeft)
					dad.setLeft(curr.getRight());
				else
					dad.setRight(curr.getRight());
			} else {
				Node successor = successor(curr);
				if (curr == root)
					root = successor;
				else if (isLeft)
					dad.setLeft(successor);
				else
					dad.setRight(successor);
				successor.setLeft(curr.getLeft());
			}
			return curr;
		}
	}

	// murad's delete
	// forget

	private Node successor(Node node) {
		Node parent = node;
		Node successor = node.getRight();
		while (successor.hasLeft()) {
			parent = successor;
			successor = successor.getLeft();
		}
///////////////////////////////////////////////////////		
		// if (successor.getData().compareTo(node.getRight().getData()) != 0) ///////// Replacing this line to the following:
		int status = 0;// dont need to get in
		if (((Integer) successor.getData().data > (Integer) node.getRight().getData().data) || ((Integer) successor.getData().data < (Integer) node.getRight().getData().data))////// 100% there is
																																												////// somthing wrong
			status = 1;// need to get in
///////////////////////////////////////////////			

//		if (successor.getData().compareTo(node.getRight().getData()) != 0) {
		if (status == 1) {
			parent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}
}
