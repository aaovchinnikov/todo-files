package ru.hse.todos.files;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Deprecated
public final class XmlTodo implements Todo {
	private final String xml;

	/**
	 * Main ctor. Doesn't preform any validation on provided xml-string.
	 * 
	 * @param xml
	 */
	public XmlTodo(String xml) {
		this.xml = xml;
	}

	@Override
	public void print(PrintStream out) {
		
		InputSource is = new InputSource(new StringReader(this.xml));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		XPathFactory xPathFactory = XPathFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);
			XPath xpath = xPathFactory.newXPath();
			String name = xpath.evaluateExpression("/todo/name/text()", document, String.class);
			String description = xpath.evaluateExpression("/todo/description/text()", document, String.class);
			out.print('\"');
			out.print(name);
			out.print("\",\"");
			out.print(description);
			out.print('\"');
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void println(PrintStream out) {
		this.print(out);
		out.println();
	}
}
