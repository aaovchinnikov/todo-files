package ru.hse.todos.files;

/**
 * Output for single plain object.
 * @author Alexander Ovchinnikov
 *
 */
public interface Output {
	/**
	 * Adds named portion of data to be accumulated for outputting. Invoke
	 * {@link #flush()} after last call of this method to indicate that all
	 * necessary data is written.
	 * 
	 * @param name
	 * @param value
	 */
	void write(String name, String value);

	/**
	 * Flushes content to target destination in destination-appropriate form.
	 */
	void flush();
}
