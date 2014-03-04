package com.mobilepark.uxcutor.xml;


import java.io.File;  

import javax.xml.parsers.*;  

import org.w3c.dom.Document;  
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;  
  
/** 
 * XMLParserTest 
 */  
public class XMLParser {  
   
 /** 
  *  
  * @param args 
  * @throws Exception 
  */  
 public static void main(String[] args) throws Exception {  
	 XMLParser xpt = new XMLParser();  
	 xpt.xmlParserString();
	
 }
 

 
 
 public void xmlParserString(){
	 try {
		 	
		 	 
			File fXmlFile = new File("tel.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			doc.getDocumentElement().normalize();
		 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					 
			NodeList nList = doc.getElementsByTagName("service");
			
			System.out.println("\nCurrent Length :" + nList.getLength());
		 
					 
			System.out.println("\nCurrent Element :" + nList.item(0).getChildNodes().getLength());
			
			for(int j=0;j<nList.item(0).getChildNodes().getLength();j++){
				
				if(!nList.item(0).getChildNodes().item(j).getNodeName().equals("#text")){
					
					NodeList lenList = doc.getElementsByTagName(nList.item(0).getChildNodes().item(j).getNodeName());
					this.print(lenList);
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  }
 
 	public void print(NodeList node){
 		
		System.out.println(node.item(0).getChildNodes().item(1).getNodeName()+":"+node.item(0).getChildNodes().getLength());
		for(int i=0;i<node.item(0).getChildNodes().getLength();i++){
			if(!node.item(0).getChildNodes().item(i).getNodeName().equals("#text")){
				//System.out.println(node.item(0).getChildNodes().item(i).getNodeName());
				System.out.println(node.item(0).getChildNodes().item(i).getNodeName());
				NamedNodeMap map = node.item(0).getChildNodes().item(i).getAttributes();
				for(int jj=0;jj<map.getLength();jj++){
					System.out.println("node map : "+map.item(jj).getNodeName()+" = value :"+map.item(jj).getNodeValue());
				}
			}
			
		}
 
 	}
 }
