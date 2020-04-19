package ru.hse.todos.files;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.json.JSONWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		final List<Todo> todos = new JsonFile(
				Paths.get("todos.json")		
		).todos();
		final Output csvFile= new CsvPrintStreamOutput(
			new PrintStream(
				"output.csv",
				StandardCharsets.UTF_8
			)
		);
		for(Todo todo : todos) {
			todo.printTo(csvFile);
		}
		final Output std = new CsvPrintStreamOutput(
			System.out
		);
		for(Todo todo : todos) {
			todo.printTo(std);
		}
		
		final List<Todo> readOnlyTodos = Collections.unmodifiableList(todos);
		System.out.println(readOnlyTodos);
		todos.add(new SimpleTodo("Test3 name", "Test3 description"));
		System.out.println(readOnlyTodos);
		
		for(Todo todo : todos) {
			todo.printTo(
				new JsonWriterOutput(
					new JSONWriter(System.out)
				)		
			);
		}
	}
}
