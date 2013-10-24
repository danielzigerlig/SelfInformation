package ch.hsr.bll;

import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public abstract class SelfInformation {
	protected LinkedHashMap<String, String> information;
	
	/**
	 * @returns name of information as string
	 */
	public abstract String toString();
	
	/**
	 * @return json formatted string
	 * @throws JSONException
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public String getJSON() throws JSONException, ParserConfigurationException, TransformerException {
		JSONObject jsonObj = XML.toJSONObject(getXML());
		String json = jsonObj.toString();
		return json;
	}
	
	/**
	 * @return html formatted title string
	 */
	protected String getTitle() {
		return "<h1>" + this.toString() + "</h1>";
	}
	
	/**
	 * @param entry<String,String>
	 * @return html formatted li string
	 */
	protected String getLi(Entry<String, String> entry) {
		return "<li>" + entry.getKey() + ": " + entry.getValue() + "</li>";
	}
	
	/**
	 * @return html formatted listing
	 */
	public String getHTML() {
		StringBuilder sb = new StringBuilder();
		sb.append(getTitle());
		sb.append("<ul>");
		for (Map.Entry<String, String> entry : information.entrySet()) {
			sb.append(this.getLi(entry));
		}
		sb.append("</ul>");
		return sb.toString();
	}
	
	/**
	 * @param doc XMxmlL document
	 * @param rootElement xml root Element
	 * @param name xml element name
	 * @param value xml element value
	 */
	protected void addElement(Document doc, Element rootElement, String name,
			String value) {
		Element variableElement = doc.createElement(this.toString());
		rootElement.appendChild(variableElement);

		Element nameElement = doc.createElement("name");
		nameElement.appendChild(doc.createTextNode(name));
		variableElement.appendChild(nameElement);

		Element valueElement = doc.createElement("value");
		valueElement.appendChild(doc.createTextNode(value));
		variableElement.appendChild(valueElement);
	}
	
	
	/**
	 * @return xml formatted string
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public String getXML() throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement(this.toString());
		doc.appendChild(rootElement);

		for (Map.Entry<String, String> entry : information.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();
			addElement(doc, rootElement, name, value);
		}

		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
		return writer.toString();
	}
}
