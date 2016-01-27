package parser;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class ParseStAX {
	XMLInputFactory inputFactory = XMLInputFactory.newInstance();

	public void processFile(String xmlFilePath) throws Exception {
		InputStream in = new FileInputStream(xmlFilePath);
		XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
		while (eventReader.hasNext()) {
	        XMLEvent event = eventReader.nextEvent();

	        if (event.isStartElement()) {
	          StartElement startElement = event.asStartElement();
	          // If we have an item element, we create a new item
	          System.out.println("<" + startElement.getName().getLocalPart() + ">");
	          if(startElement.isCharacters())
	        	  System.out.println(startElement.asCharacters());
	        }
	        if(event.isCharacters()){
	        	Characters chars = event.asCharacters();
	        	if(!chars.isWhiteSpace())
	        		System.out.println(event.asCharacters().getData()); 
	        }
	        
		}
	}
}
