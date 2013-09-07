import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileCalculatorOutput extends CalculatorOutput
{
	private PrintWriter out;
	
	public FileCalculatorOutput() {
	}
	
	public void setOutputFile(File f) {
		try {
			out=new PrintWriter(new FileWriter(f));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void showResult(String result) {
		if (null!=out) {
			out.println(result);
		} else {
			System.out.println(result);
		}
	}
	
	protected void finalize() {
		close();
	}
	
	public void close() {
		out.close();
	}
}