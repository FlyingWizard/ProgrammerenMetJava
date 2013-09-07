import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Controller
{
	public static void main(final String[] args)
	{
		final String input = JOptionPane.showInputDialog("GUI (1) or File (2) input?");
		CalculatorInput i = null;
		CalculatorOutput o = null;
		if (input.equals("1"))
		{
			i = new GUICalculatorInput();
			o = new GUICalculatorOutput();
		}
		else if (input.equals("2"))
		{
			final JFileChooser chooser = new JFileChooser(".");
			chooser.showOpenDialog(null);
			i = new FileCalculatorInput(chooser.getSelectedFile());
			final FileCalculatorOutput fo = new FileCalculatorOutput();
			chooser.showOpenDialog(null);
			fo.setOutputFile(chooser.getSelectedFile());
			o = fo;
		}
		else
		{
			System.exit(0);
		}
		final Calculator calc = new Calculator();
		final Controller c = new Controller(i, o, calc);
	}

	public Controller(final CalculatorInput i, final CalculatorOutput o, final Calculator c)
	{
		Number op1, op2, op3;
		int op;
		while (true)
		{
			final String calculation = "";
			op1 = i.getOperand(1, "Voer eerste operand in:");
			op = i.getOperator("Welke bewerking wil je uitvoeren (+,-,*, /, sqrt of max)?");
			c.setOperand1(op1);

			switch (op)
			{
			// All unary operations
			case Calculator.SQRT_OP:
				break;
			// All binary operations
			case Calculator.PLUS_OP:
			case Calculator.MIN_OP:
			case Calculator.MUL_OP:
			case Calculator.DIV_OP:
				op2 = i.getOperand(2, "Voer tweede operand in:");
				c.setOperand2(op2);
				break;
			// All ternary operations
			case Calculator.MAX3_OP:
				op2 = i.getOperand(2, "Give the first operand:");
				c.setOperand2(op2);
				op3 = i.getOperand(3, "Give the second operand:");
				c.setOperand(3, op3);
				break;
			default:
				break;
			}
			final float result = c.getResult(op);
			if (o instanceof GUICalculatorOutput)
			{
				o.showResult("The result of " + c + " is: " + result);
			}
			else
			{
				o.showResult("" + result);
			}
			c.reset();

			if (!i.getNext("More calculations?"))
				break;
		}
		o.close();
	}
}