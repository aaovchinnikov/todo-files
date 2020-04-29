package ru.hse.todos.files.outputs;

import java.util.LinkedHashMap;
import java.util.Map;

import ru.hse.todos.files.TodosOutput;

public class PrintStreamTodosOutput implements TodosOutput {
	private final Map<Object, String> map = new LinkedHashMap<>();
	
	@Override
	public void write(String name, String value) {
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginObject() {
		//do nothing
	}

	@Override
	public void endObject() {
		
		
	}
}
