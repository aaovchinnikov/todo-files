package ru.hse.todos.files.sources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import ru.hse.todos.files.SimpleTodo;
import ru.hse.todos.files.Todo;
import ru.hse.todos.files.TodosSource;

public final class JsonFile implements TodosSource {
	private final Path path;
	
	/**
	 * Main ctor.
	 * @param path
	 */
	public JsonFile(Path path) {
		this.path = path;
	}


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
}
