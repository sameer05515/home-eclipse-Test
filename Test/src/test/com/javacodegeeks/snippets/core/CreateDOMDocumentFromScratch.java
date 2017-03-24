package test.com.javacodegeeks.snippets.core;

import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateDOMDocumentFromScratch {
	
	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		// create the root element node
		Element element = doc.createElement("root");
		doc.appendChild(element);

		// create a comment node given the specified string
		Comment comment = doc.createComment("This is a comment");
		doc.insertBefore(comment, element);

		// add element after the first child of the root element
		Element itemElement = doc.createElement("item");
		element.appendChild(itemElement);
		
		// add an attribute to the node
		itemElement.setAttribute("myattr", "attrvalue");
		
		// create text for the node
		itemElement.insertBefore(doc.createTextNode("text"), itemElement.getLastChild());
		
		prettyPrint(doc);
		
	}
	
	public static final void prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		System.out.println(out.toString());
	}

}