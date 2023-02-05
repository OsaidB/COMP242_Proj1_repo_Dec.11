package DB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {

	static String result = "";

	public static String printNode(GNode root) {
		result = "";
		int maxLevel = BTreePrinter.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
		return result;
	}

	public static String printNode(S_Node root) {
		result = "";
		int maxLevel = BTreePrinter.maxLevel(root);

		S_NodePrintNodeInternal(Collections.singletonList(root), 1, maxLevel);
		return result;
	}

	private static void printNodeInternal(List<GNode> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter.printWhitespaces(firstSpaces);

		List<GNode> newNodes = new ArrayList<GNode>();

		for (GNode node : nodes) {
			if (node != null) {
				result = result + node.getAVLHeaderGrade() + "";
//				System.out.print(node.getAVLHeaderGrade());

				newNodes.add(node.getLeft());
				newNodes.add(node.getRight());
//				result = result + "]";
			} else {
				newNodes.add(null);
				newNodes.add(null);

				result = result + " ";
//				System.out.print(" ");
			}

			BTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");
//		result = result + "\n";

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BTreePrinter.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).getLeft() != null) {
//					System.out.print("/");
//					result = result + "/";
				} else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(i + i - 1);

				if (nodes.get(j).getRight() != null) {
//					result = result + "\\";
//					System.out.print("\\");
				} else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

//			System.out.println("");
//			result = result + "\n";
		}
		result = result + "\n\n";
		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void S_NodePrintNodeInternal(List<S_Node> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter.printWhitespaces2(firstSpaces);

		List<S_Node> newNodes = new ArrayList<S_Node>();

		for (S_Node node : nodes) {
			if (node != null) {
				result = result + "["+node.getData().data.getSeatNumber() + "]";
//				System.out.print(node.getAVLHeaderGrade());

				newNodes.add(node.getLeft());
				newNodes.add(node.getRight());
//				result = result + "]";
			} else {
				newNodes.add(null);
				newNodes.add(null);

				result = result + " ";
//				System.out.print(" ");
			}

			BTreePrinter.printWhitespaces2(betweenSpaces);
		}
		System.out.println("");
//		result = result + "\n";

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BTreePrinter.printWhitespaces2(firstSpaces - i);
				if (nodes.get(j) == null) {
					BTreePrinter.printWhitespaces2(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).getLeft() != null) {
//					System.out.print("/");
//					result = result + "/";
				} else
					BTreePrinter.printWhitespaces2(1);

				BTreePrinter.printWhitespaces2(i + i - 1);

				if (nodes.get(j).getRight() != null) {
//					result = result + "\\";
//					System.out.print("\\");
				} else
					BTreePrinter.printWhitespaces2(1);

				BTreePrinter.printWhitespaces2(endgeLines + endgeLines - i);
			}

//			System.out.println("");
//			result = result + "\n";
		}
		result = result + "\n\n";
		S_NodePrintNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++) {
//			System.out.print(" ");
			result = result + " ";
		}
//		result = result + "[";
	}
	
	private static void printWhitespaces2(int count) {
		for (int i = 0; i < count; i++) {
//			System.out.print(" ");
			result = result + "----";
		}
//		result = result + "[";
	}

	private static int maxLevel(GNode node) {
		if (node == null)
			return 0;

		return Math.max(BTreePrinter.maxLevel(node.getLeft()), BTreePrinter.maxLevel(node.getRight())) + 1;
	}

	private static int maxLevel(S_Node node) {
		if (node == null)
			return 0;

		return Math.max(BTreePrinter.maxLevel(node.getLeft()), BTreePrinter.maxLevel(node.getRight())) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}

}
