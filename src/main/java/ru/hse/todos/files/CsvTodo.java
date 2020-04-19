package ru.hse.todos.files;

import java.io.PrintStream;

/**
 * 
 * @author Alexander Ovchinnikov
 *
 */
@Deprecated
public final class CsvTodo implements Todo{
	private final String csv;
	
	/**
	 * Main ctor. Doesn't preform any validation on provided csv-string.
	 * @param csv - well-formed CSV representation of Todo
	 */
	public CsvTodo(String csv) {
		this.csv = csv;
	}

	@Override
	public void print(PrintStream out) {
		out.print(csv);
	}
	
	@Override
	public void println(PrintStream out) {
		this.print(out);
		out.println();
	}
}
