package ru.hse.todos.files.outputs;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import ru.hse.todos.files.Output;

/**
 * Not concurrency-safe 
 * @author Alexander Ovchinnikov
 *
 */
public class XmlPrintStreamOutput implements Output {
	private final PrintStream out;
	private final String tag;
	private final Map<String, String> map = new LinkedHashMap<>();
	
	/**
	 * @param out
	 */
	public XmlPrintStreamOutput(PrintStream out, String objectTag) {
		this.out = out;
		this.tag = objectTag;
	}

	@Override
	public void write(String name, String value) {
		this.map.put(name, value);
	}

	@Override
	public void flush() {
		this.out.print("<");
		this.out.print(this.tag);
		this.out.println(">");
		for(Entry<String, String> entry: this.map.entrySet()) {
			this.out.print("<");
			this.out.print(entry.getKey());
			this.out.print(">");
			this.out.print(entry.getValue());
			this.out.print("</");
			this.out.print(entry.getKey());
			this.out.println(">");
		}
		this.out.print("</");
		this.out.print(this.tag);
		this.out.println(">");
		this.map.clear();
		this.out.flush();
	}
}
