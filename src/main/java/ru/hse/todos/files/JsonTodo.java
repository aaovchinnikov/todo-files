package ru.hse.todos.files;

import org.json.JSONObject;

public final class JsonTodo implements Todo{
	private final String json;
	
	/**
	 * @param json
	 */
	public JsonTodo(String json) {
		this.json = json;
	}

	@Override
	public void printTo(Output out) {
		JSONObject obj = new JSONObject(this.json);
		out.write("name", obj.getString("name"));
		out.write("description", obj.getString("description"));
		out.flush();
	}
}
