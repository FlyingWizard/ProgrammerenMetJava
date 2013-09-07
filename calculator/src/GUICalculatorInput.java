import javax.swing.JOptionPane;

public class GUICalculatorInput extends CalculatorInput {
	
	public GUICalculatorInput() {
	}
	
	public Number getOperand(int i, String message) {
		String input="";
		Number operand=null;
		try {
			input=JOptionPane.showInputDialog(message);
			operand=new Float(Float.parseFloat(input));
		} catch (Exception e) {
			getOperand(i, input+" is not a valid number\n"+message);
		}
		return operand;
	}
	
	public int getOperator(String message) {
		String operator=JOptionPane.showInputDialog(message);
		
		return isValidOperator(operator);
	}
	
	public boolean getNext(String message) {
		int option=JOptionPane.showConfirmDialog(null, message, "", JOptionPane.YES_NO_OPTION);
		return (option!=1);
	}
}