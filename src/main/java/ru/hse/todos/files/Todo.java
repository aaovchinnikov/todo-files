package ru.hse.todos.files;

public interface Todo {
	/**
	 * Prints itself in terms of {@link Output} operations.
	 * 
	 * @param out - {@link Output} to be printed to.
	 */
	void printTo(Output out);
}
