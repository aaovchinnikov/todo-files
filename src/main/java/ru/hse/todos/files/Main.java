package ru.hse.todos.files;

import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Todo> todos = new JsonFile(
				Paths.get("todos.json")		
		).todos();
		for(Todo todo : todos) {
			todo.println(System.out);
		}
	}
}
