package view;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;

import utilities.Constants;

import model.Board;

//import model.Cell;
/**
 * @author Mathy
 * 
 */
public class TestBoard {

	/**
	 * @param args
	 */
	public static void main(String... args) {
		BasicConfigurator.configure();
		Constants.logger.setLevel(Level.ALL );
		Board board = new Board();
		board.generateBoard();
		Constants.logger.info(board);

		Board copy = Board.clone(board);
		if (args.length > 0) {
			// force an error
			copy.setCell(
					Constants.getRandom().nextInt(
							(int) Math.pow(Constants.DIMENSION, 2.0)),// i
					Constants.getRandom().nextInt(
							(int) Math.pow(Constants.DIMENSION, 2.0)), // j
					Constants.getRandom().nextInt(
							(int) Math.pow(Constants.DIMENSION, 2.0))); // value
		}
		Constants.logger.info(copy);
		System.out.print("\nBoard and Copy are different : "
				+ board.compareTo(copy));
		System.out.print("\nBoard and Copy are equal : " + board.equals(copy));
	}
}
