package ru.hse.todos.files;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Not concurrency-safe 
 * @author Alexander Ovchinnikov
 *
 */
public class CsvPrintStreamOutput implements Output {
	private final PrintStream out;
	private final Map<String, String> map = new LinkedHashMap<>();
	
	/**
	 * @param out
	 */
	public CsvPrintStreamOutput(PrintStream out) {
		this.out = out;
	}

	@Override
	public void write(String name, String value) {
		this.map.put(name, value);
	}

	@Override
	public void flush() {
		Iterator<Entry<String, String>> iterator = this.map.entrySet().iterator();
		Entry<String, String> entry;
		while (iterator.hasNext()) {
			entry = iterator.next();
			out.print("\"");
			out.print(entry.getValue());
			out.print("\"");
			if (iterator.hasNext()) {
				out.print(",");
			} else {
				out.println();
			}
		}
		this.map.clear();
		this.out.flush();
	}
}
