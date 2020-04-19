package ru.hse.todos.files;

import org.json.JSONWriter;

/**
 * Encapsulated JSONWriter is not reusable. 
 * @author Alexander Ovchinnikov
 *
 */
public final class JsonWriterOutput implements Output {
	private final JSONWriter writer;
	
	/**
	 * @param writer
	 */
	public JsonWriterOutput(JSONWriter writer) {
		this.writer = writer.object();
	}

	@Override
	public void write(String name, String value) {
		this.writer.key(name).value(value);
	}

	@Override
	public void flush() {
		this.writer.endObject();
	}
}
