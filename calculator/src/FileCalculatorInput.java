import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class FileCalculatorInput extends CalculatorInput {
	public static final int UNSUPPORTED_TYPE=0;
	public static final int FLOAT_TYPE=1;
	public static final int DOUBLE_TYPE=2;
	public static final int INT_TYPE=3;

	private File f;
	BufferedReader input;
	ArrayList calculation=new ArrayList();
	
	public FileCalculatorInput(File f) {
		this.f=f;
		try {
			input=new BufferedReader(new FileReader(f));
			getNext("");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}
	
	public Number getOperand(int i, String message) throws
		IllegalArgumentException
	{
		if (calculation.isEmpty())
			throw new IllegalArgumentException("Empty input line");
		String operand;
		try {
			if (i==1) {
				operand=(String)calculation.get(1);
			} else {
				operand=(String)calculation.get(i+1);
			}
		} catch (IndexOutOfBoundsException iobe) {
			throw new IllegalArgumentException(i+" argument does not exist!");
		}

		int type=getType();
		switch (type) {
			case FLOAT_TYPE: 
				return new Float(Float.parseFloat(operand));
			case DOUBLE_TYPE: 
				return new Double(Double.parseDouble(operand));
			case INT_TYPE: 
				return new Integer(Integer.parseInt(operand));
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public int getOperator(String message) throws 
		UnsupportedOperationException 
	{
		if (calculation.isEmpty())
			throw new UnsupportedOperationException();
		
		return isValidOperator((String)calculation.get(2));
	}
	
	public boolean getNext(String message) {
		// line is formatted as: type operand operator [operator] [operator]
		String currentLine;
		try {
			currentLine=input.readLine();
			if (null==currentLine)
				return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		StringTokenizer st=new StringTokenizer(currentLine);
		calculation.clear();
		while (st.hasMoreTokens()) {
			calculation.add(st.nextToken());
		}
		
		return true;
	}
	
	public int getType() {
		String type;
		try {
			type=(String) calculation.get(0);
		} catch (IndexOutOfBoundsException iobe) {
			return UNSUPPORTED_TYPE;
		}
		if (type.equals("float")) {
			return FLOAT_TYPE;
		} else if (type.equals("double")) {
			return DOUBLE_TYPE;
		} else if (type.equals("int")) {
			return INT_TYPE;
		} else {
			return UNSUPPORTED_TYPE;
		}
	}
}