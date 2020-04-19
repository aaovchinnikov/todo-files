package ru.hse.todos.files;

import java.io.PrintStream;

public interface Todo {
	/**
	 * Prints as comma-separated values to provided {@link PrintStream}. Doesn't break the line after printing.
	 * 
	 * @param out - {@link PrintStream} to be printed to.
	 */
	void print(PrintStream out);
	
	/**
	 * Prints as comma-separated values to provided {@link PrintStream}. Doesn't break the line after printing.
	 * 
	 * @param out - {@link PrintStream} to be printed to.
	 * @implNote suggested way of implementation is:
	 * <pre>{@code void println(PrintStream out){
	 * this.print(out);
	 * out.println();
	 *}
	 * </pre>
	 */
	void println(PrintStream out);
}
