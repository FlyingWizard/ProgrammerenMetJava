package view;

/**
 * @author Mathy Paesen
 * @version 2013/10/06
 */

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import business.Employee;

public class TestEmployee {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final ArrayList<Employee> list = new ArrayList<Employee>();
		boolean correct = false;
		do {
			String choice = getInput("Input? (M)anual, (G)enerate :");
			if (choice.equalsIgnoreCase("M")) {
				mainIteration(list);
				correct = true;
			}
			if (choice.equalsIgnoreCase("G")) {
				generateTestData(list);
				correct = true;
			}
		} while (!correct);
		showOutput(list);
		showOneEmployee(list);
	}

	/**
	 * Display 1 employee
	 * 
	 * @param list
	 */
	public static void showOneEmployee(final ArrayList<Employee> list) {
		String input;
		int i;
		String range = "1 - ";
		range += list.size();
		do {
			do {
				input = getInput("Give a employee Number ( " + range + "): ");
			} while (input.isEmpty());

			i = Integer.parseInt(input);
			i -= 1;
		} while ((i < 0) || (i > list.size() - 1));
		System.out.println(list.get(i));
	}

	/**
	 * @param list
	 */
	private static void showOutput(final ArrayList<Employee> list) {
		for (final Employee employees : list) {
			System.out.println(employees);
		}
		System.out.println("We have created: " + Employee.getSequence()
				+ " employees.");

	}

	/**
	 * @param list
	 */
	private static void mainIteration(final ArrayList<Employee> list) {
		String input;
		String first;
		String name;
		Employee employee;
		do {
			input = getInput("Give firstname (Q to quit, anything else to continue");
			if (!input.equalsIgnoreCase("Q")) {
				first = input;
				input = getInput("Give the name :");
				name = input;
				employee = new Employee(name, first);
				list.add(employee);
			}
		} while (!input.equalsIgnoreCase("Q"));
	}

	private static String getInput(final String message) {
		return JOptionPane.showInputDialog(message);
	}

	private static void generateTestData(final ArrayList<Employee> list) {
		final String[] FIRST_NAME = { "Mathy", "Frank", "Frederik", "Ludo",
				"Hans", "Louis" };
		final String[] LAST_NAME = { "Paesen", "Dingenen", "Vanastbrouk",
				"Coppens", "Vandievel", "Vanoosterhout", "Jaeken", "Leterme",
				"Hulshout", "Vanbrussel" };

		Random random = new Random();

		for (int i = 0; i < LAST_NAME.length; i++) {
			list.add(new Employee(LAST_NAME[random.nextInt(LAST_NAME.length)],
					FIRST_NAME[random.nextInt(FIRST_NAME.length)]));
		}
	}
}
