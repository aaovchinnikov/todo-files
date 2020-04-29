package ru.hse.todos.files;

public interface TodosOutput {
	/**
	 * Adds named portion of data to be accumulated for outputting. Invoke
	 * {@link #flush()} after last call of this method to indicate that all
	 * necessary data is written.
	 * 
	 * @param name
	 * @param value
	 */
	void write(String name, String value);

	void beginObject();
	void endObject();
	
	/**
	 * Flushes content to target destination in destination-appropriate form.
	 */
	void flush();
}
