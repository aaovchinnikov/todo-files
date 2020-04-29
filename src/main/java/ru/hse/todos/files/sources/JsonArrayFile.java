package ru.hse.todos.files.sources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONArray;
import org.json.JSONObject;

import ru.hse.todos.files.Todos;
import ru.hse.todos.files.TodosOutput;

public final class JsonArrayFile implements Todos {
	private final Path path;
	
	/**
	 * Main ctor.
	 * @param path
	 */
	public JsonArrayFile(Path path) {
		this.path = path;
	}

	@Override
	public void printTo(TodosOutput output) {
		try {
			String json = Files.readString(this.path);
			JSONArray array = new JSONArray(json);
			JSONObject obj;
			for(int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				output.beginObject();
				output.write("name", obj.getString("name"));
				output.write("description", obj.getString("description"));
				output.endObject();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

/*
	@Override
	public List<Todo> todos() {
		try {
			String json = Files.readString(this.path);
			JSONArray array = new JSONArray(json);
			List<Todo> list = new ArrayList<Todo>();
			JSONObject obj;
			for(int i = 0 ; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				list.add(new SimpleTodo(
						obj.getString("name"),
						obj.getString("description")
				));
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
*/
}
