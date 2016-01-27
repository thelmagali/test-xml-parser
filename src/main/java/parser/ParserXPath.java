package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserXPath {
	
	@Inject
	XPath xpath;
	
	private Document getXmlDocument(File xmlFile) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputStream is = new FileInputStream(xmlFile);
		Document doc = dBuilder.parse(is);
		doc.getDocumentElement().normalize();
		return doc;
	}
	
	public void processFile(String xmlFilePath) throws Exception {
		File xmlFile = new File(xmlFilePath);
		Document doc = getXmlDocument(xmlFile);
		Element element = doc.getDocumentElement();
		printElementAndChildren(element);
	}
	
	private void printElementAndChildren(Node node){
		Element element = null;
		try{
			element = (Element) node;			
		} catch(ClassCastException e){
			//si no se puede castear a Element era un texto
			String text = node.getTextContent();
			if(!(text.trim().isEmpty())){
				System.out.println(node.getTextContent());
			}
			return;
		}
		System.out.println("<" + element.getNodeName() + ">");
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			printElementAndChildren(children.item(i));
		}
	}
}
