package parser;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String xmlFilePath = "C:/datos_prueba/tap/convertidos/archivo_enorme_prueba.xml";
		ParseStAX parseStax = new ParseStAX();
		ParserXPath parserXPath = new ParserXPath();
		
		System.out.println("Procesamiento con StAX");
		long fechaInicio = System.currentTimeMillis();
		parseStax.processFile(xmlFilePath);
		long fechaFin = System.currentTimeMillis();
		long tiempoStax = fechaFin - fechaInicio;
		
		System.out.println("Procesamiento con XPath");
		fechaInicio = System.currentTimeMillis();
		parserXPath.processFile(xmlFilePath);
		fechaFin = System.currentTimeMillis();
		long tiempoXpath = fechaFin - fechaInicio;
		
		System.out.println("Tiempo StAX: " + String.valueOf(tiempoStax) + " ms.");
		System.out.println("Tiempo XPath: " + String.valueOf(tiempoXpath) + " ms.");
	}

}
