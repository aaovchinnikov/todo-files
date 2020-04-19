package ru.hse.todos.files;

import java.io.PrintStream;

import org.json.JSONObject;

@Deprecated
public final class JsonTodo implements Todo {
	private final String json;
	
	/**
	 * Main ctor. Doesn't preform any validation on provided json-string.
	 * @param json
	 */
	public JsonTodo(String json) {
		this.json = json;
	}

	@Override
	public void print(PrintStream out) {
		JSONObject obj = new JSONObject(this.json);
		out.print('\"');
		out.print(obj.get("name"));
		out.print("\",\"");
		out.print(obj.get("description"));
		out.print('\"');
	}
	
	@Override
	public void println(PrintStream out) {
		this.print(out);
		out.println();
	}
}
