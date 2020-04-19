package ru.hse.todos.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CsvFile implements Todos {
	private final Path path;
	
	/**
	 * @param path
	 */
	public CsvFile(Path path) {
		this.path = path;
	}

	@Override
	public List<Todo> todos(){
		List<Todo> list = new ArrayList<Todo>();
		try {
			List<String> lines = Files.readAllLines(this.path);
			for(String line: lines) {
				list.add(new CsvTodo(line));
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
