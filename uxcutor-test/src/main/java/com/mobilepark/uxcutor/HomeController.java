package com.mobilepark.uxcutor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.ibatis.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xml.sax.SAXException;

import com.mobilepark.uxcutor.dtdmodel.Uxcutor;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/validate.htm", method=RequestMethod.POST)
	public String validate(Locale locale, Model model) throws JAXBException, IOException {
		logger.info("Validate", locale);
	
		try {
		    String schemaLang = "http://www.w3.org/2001/XMLSchema";

		    SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
		    String xsdResource = "http://192.168.16.10:60101/uxcutor/resources/test.xsd";
		    File schemaLocation = Resources.getResourceAsFile(xsdResource);
		    
		    Schema schema = factory.newSchema(schemaLocation);
		    Validator validator = schema.newValidator();

		    validator.validate(new StreamSource("http://192.168.16.10:60101/uxcutor/resources/msc_cap.xml"));

		} catch (SAXException e) {
		    System.out.println(" sax exception :" + e.getMessage());
		} catch (Exception ex) {
		    System.out.println("excep :" + ex.getMessage());
		}
		
		JAXBContext jc = JAXBContext.newInstance("com.mobilepark.uxcutor.dtdmodel");
		 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        URL url = new URL("http://192.168.16.10:60101/uxcutor/resources/msc_cap.xml");
        InputStream xml = url.openStream();
        JAXBElement<Uxcutor> feed = unmarshaller.unmarshal(new StreamSource(xml), Uxcutor.class);
        xml.close();
        System.out.println("================="+feed.getValue());
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(feed, System.out);
        
        model.addAttribute("feed", feed );
        
		return "test";
	}
	
	
	
	protected int validate(String xml)
	{
		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
	 
		String xsdResource = "com/uangel/bmsc/report/schema/report.xsd";
		
		try
		{
			File schemaLocation = Resources.getResourceAsFile(xsdResource);
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(new StringReader(xml));
			validator.validate(source);
		}
		catch (Exception e)
		{
			logger.error("[RECEPTION REPORT] check xml validation..... fail : " + e.getMessage()); 
			return -1;
		}
		
		logger.info("[RECEPTION REPORT] check xml validation..... success");
		return 0;
	}
	
	
}
