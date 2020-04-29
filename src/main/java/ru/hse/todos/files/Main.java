package ru.hse.todos.files;

import java.io.IOException;
import java.nio.file.Paths;

import org.json.JSONWriter;

import ru.hse.todos.files.outputs.CsvPrintStreamOutput;
import ru.hse.todos.files.outputs.JsonWriterOutput;
import ru.hse.todos.files.outputs.XmlPrintStreamOutput;
import ru.hse.todos.files.sources.JsonArrayFile;

public class Main {

	public static void main(String[] args) throws IOException {
		Todo todo = new JsonTodo("	{\n" + 
				"		\"name\" : \"Test name\",\n" + 
				"		\"description\" : \"Test description\"\n" + 
				"	}");
		todo.printTo(new CsvPrintStreamOutput(System.out));
		todo.printTo(new JsonWriterOutput(new JSONWriter(System.out)));
		todo.printTo(new XmlPrintStreamOutput(System.out, "todo"));
	}
}
