import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public abstract class CalculatorInput {
	protected Stack actions=new Stack();
	private ArrayList unaryOperators=new ArrayList();
	private ArrayList binaryOperators=new ArrayList();
	private ArrayList ternaryOperators=new ArrayList();
	
	public CalculatorInput() {
		unaryOperators.add("sqrt");
		
		binaryOperators.add("+");
		binaryOperators.add("-");
		binaryOperators.add("*");
		binaryOperators.add("/");
		binaryOperators.add("pow");
		
		ternaryOperators.add("max");
	}
	
	public abstract Number getOperand(int nbr, String message) throws
		IllegalArgumentException;
	public abstract int getOperator(String message) throws 
		UnsupportedOperationException;
	public abstract boolean getNext(String message);
	
	public int isValidOperator(String op) throws
		UnsupportedOperationException
	{
		if (unaryOperators.contains(op)) {
			if (op.equals("sqrt")) {
				return Calculator.SQRT_OP;
			} else
				throw new UnsupportedOperationException(op+" is not a supported unary operation!");
		} else if (binaryOperators.contains(op)) {
			if (op.equals("+")) {
				return Calculator.PLUS_OP;
			} else if (op.equals("-")) {
				return Calculator.MIN_OP;
			} if (op.equals("*")) {
				return Calculator.MUL_OP;
			} if (op.equals("/")) {
				return Calculator.DIV_OP;
			} else
				throw new UnsupportedOperationException(op+" is not a supported binary operation!");
		} else if (ternaryOperators.contains(op)) {
			if (op.equals("max")) {
				return Calculator.MAX3_OP;
			} else
				throw new UnsupportedOperationException(op+" is not a supported ternary operation!");
		} else
			throw new UnsupportedOperationException(op+" is not a valid operation!");
	}
}
