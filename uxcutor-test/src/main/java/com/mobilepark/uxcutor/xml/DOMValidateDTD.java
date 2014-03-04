package com.mobilepark.uxcutor.xml;


import java.io.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import com.mobilepark.uxcutor.common.Env;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOMValidateDTD {
  
	protected static String res = "";

	public static String DTDValidate(String xmlFile) { 
		 
		try{

		  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	  
		  factory.setValidating(true);
	  
		  DocumentBuilder builder = factory.newDocumentBuilder();
		  builder.setErrorHandler(new org.xml.sax.ErrorHandler() {
			 
			  
			  public void fatalError(SAXParseException exception) throws SAXException { }
			  
			  //Validation errors 
			  public void error(SAXParseException e) throws SAXParseException {
				 
				  res +="Error at " +e.getLineNumber() + " line.\n";
				  res +=e.getMessage();
				 
			  }
		  
			  //Show warnings
			  public void warning(SAXParseException err) throws SAXParseException{
				  res +=err.getMessage();
			  }
		  });
		  
		  Document xmlDocument = builder.parse(new FileInputStream(xmlFile));
	  	  DOMSource source = new DOMSource(xmlDocument);
	  	  StreamResult result = new StreamResult(System.out);
	  	  TransformerFactory tf = TransformerFactory.newInstance();
	  	  Transformer transformer = tf.newTransformer();
	  	  transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, Env.get("xml.fileupload")+"/xcpt.dtd");
	  	  transformer.transform(source, result);
	  	  	  	  
  	}
  	catch (Exception e) {
	  //System.out.println(e.getMessage());
  		res = e.getMessage();
	  
  	}
		 return res;
  }
}
