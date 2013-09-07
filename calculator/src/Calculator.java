public class Calculator
{
	public static final int UNSUPPORTED_OP=0;
	public static final int PLUS_OP=1;
	public static final int MIN_OP=2;
	public static final int MUL_OP=3;
	public static final int DIV_OP=4;
	public static final int SQRT_OP=5;
	public static final int MAX3_OP=6;
	
	private Number operand1, operand2, operand3;
	private boolean operand1Set=false, operand2Set=false, operand3Set=false;
	private int operation;
	private String[] opString={"+","-","*","/","sqrt","max"};
	
	public Calculator() {
	}
	
	public Calculator(Number operand1) {
		this();
		this.operand1=operand1;
		operand1Set=true;
	}
	
	public Calculator(Number operand1, Number operand2) {
		this();
		this.operand1=operand1;
		operand1Set=true;
		this.operand2=operand2;
		operand2Set=true;
	}
	
	public void reset() {
		operand1Set=false;
		operand2Set=false;
		operand3Set=false;
	}
	
	public void setOperand1(Number op) {
		operand1=op;
		operand1Set=true;
	}
	
	public void setOperand2(Number op) {
		operand2=op;
		operand2Set=true;
	}
	
	public void setOperand(int i, Number op) {
		switch (i) {
			case 1:
				operand1=op;
				operand1Set=true;
				break;
			case 2:
				operand2=op;
				operand2Set=true;
				break;
			case 3:
				operand3=op;
				operand3Set=true;
				break;
			default:
				break;
		}
	}
	
	public float getResult(int operation) throws UnsupportedOperationException {
		this.operation=operation;
		switch (operation) {
			case PLUS_OP:
				return sum();
			case MIN_OP:
				return subtraction();
			case MUL_OP:
				return multiplication();
			case DIV_OP:
				return division();
			case SQRT_OP:
				return (float) sqrt();
			case MAX3_OP:
				return (float) max3();
			default:
				throw new UnsupportedOperationException(operation+" is not supported by this calculator!");
		}
	}
	
	public float sum() throws IllegalArgumentException {
		if (!(operand1Set&&operand2Set))
			throw new IllegalArgumentException();
		operation=PLUS_OP;
		return operand1.floatValue()+operand2.floatValue();
	}
	
	public float subtraction() throws IllegalArgumentException {
		if (!(operand1Set&&operand2Set))
			throw new IllegalArgumentException();
		operation=MIN_OP;
		return operand1.floatValue()-operand2.floatValue();
	}
	
	public float multiplication() throws IllegalArgumentException {
		if (!(operand1Set&&operand2Set))
			throw new IllegalArgumentException();
		operation=MUL_OP;
		return operand1.floatValue()*operand2.floatValue();
	}
	
	public float division() throws IllegalArgumentException {
		if (!(operand1Set&&operand2Set))
			throw new IllegalArgumentException();
		operation=DIV_OP;
		return operand1.floatValue()/operand2.floatValue();
	}
	
	public double sqrt() throws IllegalArgumentException {
		if (!operand1Set)
			throw new IllegalArgumentException();
		operation=SQRT_OP;
		return Math.sqrt(operand1.doubleValue());
	}
	
	public double max3() throws IllegalArgumentException {
		if (!(operand1Set&&operand2Set&&operand3Set))
			throw new IllegalArgumentException();
		operation=MAX3_OP;
		return Math.max(operand1.doubleValue(), Math.max(operand2.doubleValue(),operand3.doubleValue()));
	}
	
	public String toString() {
		String calculation="";
		if (operand3Set) {
			calculation=opString[operation-1]+"("+operand1+","+operand2+","+operand3+")";
		} else if (operand2Set) {
			calculation=operand1+opString[operation-1]+operand2;
		} else if (operand1Set) {
			calculation=opString[operation-1]+"("+operand1+")";
		}
		return calculation;
	}
}