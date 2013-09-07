import javax.swing.JOptionPane;

public class GUICalculatorOutput extends CalculatorOutput
{
	public GUICalculatorOutput() {
	}
	
	public void showResult(String result) {
		JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void close() {
	}
}