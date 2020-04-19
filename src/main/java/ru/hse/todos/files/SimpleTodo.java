package ru.hse.todos.files;

public final class SimpleTodo implements Todo {

	private final String name;
	private final String description;
	
	/**
	 * Main ctor
	 * @param name
	 * @param description
	 */
	public SimpleTodo(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void printTo(Output out) {
		out.write("name", this.name);
		out.write("description", this.description);
		out.flush();
	}

	@Override
	public String toString() {
		return "SimpleTodo [name=" + name + ", description=" + description + "]";
	}
}
