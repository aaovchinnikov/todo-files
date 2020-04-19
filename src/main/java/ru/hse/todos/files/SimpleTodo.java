package ru.hse.todos.files;

import java.io.PrintStream;

public final class SimpleTodo implements Todo {

	private final String name;
	private final String description;
	
	/**
	 * Main ctor
	 * @param name
	 * @param description
	 */
	public SimpleTodo(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	public void print(PrintStream out) {
		out.print('\"');
		out.print(this.name);
		out.print("\",\"");
		out.print(this.description);
		out.print('\"');
	}

	@Override
	public void println(PrintStream out) {
		this.print(out);
		out.println();
	}
}
