package application;

import base.cStack;

public class Equation {

	private boolean isBalanced_var = false;
	private boolean isValid_var = false;
	private String postFix = null;
	private String evaluation = null;
	private String equation = null;

////////////////////////////////////////////////////////////////////////////////////////////////
//constractors

	public Equation() {

	}

	public Equation(String equation) {

		equation = equation.replaceAll(" ", "");
		this.equation = equation;

		this.isValid_var = isValid(equation);// +*

		if (this.isValid_var) {
			this.isBalanced_var = isBalanced(equation);// (1+2))
		}

		if (this.isBalanced_var) {
			this.postFix = toPostfix(this.equation);
		}

		if (!(this.postFix == null)) {
			this.evaluation = evaluate(this.postFix);
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////
//getters & setters

	public boolean isBalanced_var() {
		return isBalanced_var;
	}

	public void setIsBalanced_var(boolean iisBalanced_var) {
		this.isBalanced_var = iisBalanced_var;
	}

	public String getPostFix() {
		return postFix;
	}

	public void setPostFix(String postFix) {
		this.postFix = postFix;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

////////////////////////////////////////////////////////////////////////////////////////////////
//main 4 methods

	// check if equation is in valid form
	public boolean isValid(String equation) {
		boolean isValid = true;

		int length = equation.length();
		int i = length - 1;

		while (isValid == true && length - 1 != 0) {

			char char1 = equation.charAt(i);

			if (Character.isAlphabetic(equation.charAt(i))) {
				return false;
			}

			char nextChar = equation.charAt(i - 1);

			String check = "" + char1 + nextChar;

			if (/* check.equals("+-") || */check.equals("-+")) {
				return false;
			}
			if (check.equals("*+") || check.equals("+*")) {
				return false;
			}
			if (check.equals("/+") || check.equals("+/")) {
				return false;
			}
			if (check.equals("-*") /* || check.equals("*-") */) {
				return false;
			}
			if (check.equals("-/") /* || check.equals("/-") */) {
				return false;
			}

			i--;
			length--;
		}
		if (equation.startsWith("*") || equation.startsWith("/")) {
			return false;
		}

		if (equation.endsWith("*") || equation.endsWith("/") || equation.endsWith("+") || equation.endsWith("-")) {

			return false;
		}

		if (equation.contains("*)") || equation.contains("/)") || equation.contains("+)") || equation.contains("-)")) {
			return false;
		}

		if (equation.contains("**") || equation.contains("*/") || equation.contains("/*") || equation.contains("//")) {
			return false;
		}

		if (equation.contains("+*") || equation.contains("+/") || equation.contains("-*") || equation.contains("-/")) {
			return false;
		}

		if (equation.contains("?") || equation.contains("|") || equation.contains("&") || equation.contains("!") || equation.contains("#") || equation.contains("%") || equation.contains("_")
				|| equation.contains("=") || equation.contains("$") || equation.contains("@")) {
			return false;
		}

		return isValid;
	}

	// check if equation is Balanced
	public boolean isBalanced(String equation) {

		boolean isBalanced = true;

		cStack<Character> stack = new cStack<>();

		int length = equation.length();
		int i = 0;

		while (isBalanced == true && length != 0) {

			char currPar = equation.charAt(i);// current parenthesis

			switch (currPar) {
			case '{':
			case '[':
			case '(':
				stack.push(currPar);
				break;
			case '}':
			case ']':
			case ')':

				if (stack.isEmpty()) {
					isBalanced = false;

				} else {
					// chicking if they are correct pair
					char openChar = (char) stack.pop().key;
					char openMUSTPar = currPar;// Open parenthesis MUST be this

					switch (currPar) {
					case '}':// if the close= }
						openMUSTPar = '{';// the open MUST = {
						break;
					case ']':
						openMUSTPar = '[';
						break;
					case ')':
						openMUSTPar = '(';
						break;

					}
					// is the real openChar = openMUSTPar -->then they are correct pair Parentheses
					if (openChar != openMUSTPar) {
						isBalanced = false;

					}

				}

			}

			i++;
			length--;
		}

		if (!stack.isEmpty()) {
			isBalanced = false;
		}
		if (equation.contains("()")) {
			isBalanced = false;
		}

		return isBalanced;
	}

	//@formatter:off
	public String toPostfix(String infix) {

		System.out.println("infix:" + infix);

		for (int i = 0; i < infix.length(); i++) {

			if (Character.isDigit(infix.charAt(i)) && i + 1 != infix.length() && infix.charAt(i + 1) == '(') {// 2( = 2*(

				infix = infix.replace(infix.charAt(i) + "(", infix.charAt(i) + "*(");

			}
		}

//		if (infix.charAt(i) == '+' || infix.charAt(i) == '-') {
//			result = result + infix.charAt(i++);
//		}
///////////////////////////////////////////////////////////////////	
		cStack<Character> operators = new cStack<>();

		String result = "";
		for (int i = 0; i < infix.length(); i++) {

			char currChar = infix.charAt(i);
			/*
			 * there are 5 cases
			 * 
			 * 1-currChar = number OR point(3.5) 	--> ready to result
			 * 
			 * 2-currChar = '(' 					--> push + if (-
			 * 
			 * 3-currChar = ')' 					--> pop until '('
			 * 
			 * 4-currChar = '^' 					--> push
			 * 
			 * 5-currChar = 'all operators' 		--> push if stack is empty , and Dealing with other cases according to priority.
			 * 
			 */

			if (Character.isDigit(currChar) || currChar == '.') { 	// 1 -->
				result = result + currChar;
			}

			else if (currChar == '(') { 							// 2 -->

				operators.push(currChar);

				if (infix.charAt(i + 1) == '-') {
					result = result + infix.charAt(i + 1);
					i++;
				}
			}

			else if (currChar == ')') { 							// 3 -->

				while (operators.peek().key != '(') {
					result = result + ("," + operators.pop().key);

				}
				operators.pop();// pop for '('
			}

			else if (currChar == '^') { 							// 4 -->

				operators.push(currChar);
				result = result + ",";

			}

			else if (currChar == '+' || currChar == '/' || currChar == '*' || currChar == '-') {// 5 -->
				result = result + ",";

				if (operators.isEmpty()) {
					operators.push(currChar);
				} else {
					// stack is not empty, so we need to make a comparison between the current operator and the last operator existing in the stack
					while (!operators.isEmpty() && priorityCheck(operators.peek().key) >= priorityCheck(currChar)) {// as long as top is "greater or equals" the new one -> pop it(top)
						result = result + operators.pop().key + ",";
					}
					// now new is greater(or stack is empty)
					operators.push(currChar);// so -> push it(new)
				}

				// This last check point belongs to the fifth case.
				if (infix.charAt(i + 1) == '-') {// 5*-3
					result = result + (infix.charAt(i + 1));
					i++;
				}

			}
		}
///////////////////////////////////////////////////////////////////
		// preparing the final result(poping every thing remaining in the stack)
		while (!operators.isEmpty()) {
			result = result + "," + operators.pop().key;
		}
		return result;

	}
	//@formatter:on
	public String evaluate(String postfix) {

		cStack<Double> operands = new cStack<>();

		double firstNum, secNum;
//		double result = 0;
		System.out.println(postfix);

		String[] s = postfix.split(",");

		for (int i = 0; i < s.length; i++) {
			String curr = s[i];
			/*
			 * if curr = number -> push
			 * 
			 * if curr = operator ->1-set first and second operands(numbers) 2-perform the process 3-rePUSH the result
			 */
			if (isNumber(curr)) {
				operands.push(Double.parseDouble(curr));

			} else if (operands.peek() != null) {// curr=Operator or Parentheses +-*/)(
				/////////////// setting first and second numbers///////////////
				secNum = operands.pop().key;

				if (operands.peek() != null) {
					firstNum = operands.pop().key;
				} else {
					System.out.println("stack.peek()=null --> cant pop for secOperand not set");
					break;
				}
				/////////////// setting first and second numbers///////////////
				// first and second operands are ready
				if (curr.equals("^")) {
					operands.push((Math.pow(firstNum, secNum)));

				} else if (curr.equals("+")) {
					operands.push(firstNum + secNum);

				} else if (curr.equals("-")) {
					operands.push(firstNum - secNum);

				} else if (curr.equals("*")) {
					operands.push(firstNum * secNum);

				} else if (curr.equals("/")) {

					if (secNum == 0) {
						System.out.println("Error: division by zero.");
					}
					operands.push(firstNum / secNum);

				} else {
					operands.push(Double.parseDouble(curr));

				}

			} else {
				System.out.println("stack.peek()=null  -->  line336");
			}

		}

		return operands.pop() + "";

	}

////////////////////////////////////////////////////////////////////////////////////////////////
//Helper method
	public boolean isNumber(String str) {
		try {
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private int priorityCheck(char c) {

		int precedence = 0;

		switch (c) {
		case '+':
		case '-':
			precedence = 1;
			break;
		case '*':
		case '/':
			precedence = 2;
			break;

		case '^':
			precedence = 3;
			break;

		default:
			return 0;
		}

		return precedence;
	}

////////////////////////////////////////////////////////////////////////////////////////////////
//Result

	@Override
	public String toString() {

		if (equation == null) { // "[ INVALID Equation ]"
			return "no equation";
		} else if (isValid_var == false) { // "[ INVALID Equation ]"
			return equation + " => [ invalid equation ]";
		} else if (isBalanced_var == false) {
			return equation + " => [ unbalanced equation ]";

		} else {// every thing is okay
			return equation + " => " + postFix.replaceAll(",", "") + " => " + evaluation;

		}

	}
}
