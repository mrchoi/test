package com.mobilepark.uxcutor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class JavaClassLoader {
	
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	public static String TEXT_XML_STRING = "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";
	
	public static void main(String[] args) {
		try{
			
			
			String className = "Uxcutor";

			Class<?> c = Class.forName("com.mobilepark.uxcutor.dtdmodel."
					+ className);

			Field[] fields = c.getDeclaredFields();
			
			/*for( Annotation annotation : cls.getClass().getAnnotations()){
				System.out.println(" Class getAnnotaions : "+annotation);
			}
			
			for( Annotation annotation : cls.getClass().getDeclaredAnnotations()){
				System.out.println(" Class getDeclaredAnnotations : "+annotation);
			}
			*/
			for( int i=0;i<fields.length;i++){
				
				
				
				for(Annotation annotation : fields[i].getAnnotations()){
					//System.out.println(" Field getAnnotaions : "+annotation.annotationType().getSimpleName());
					if("XmlAttribute".equals(annotation.annotationType().getSimpleName())){
						System.out.println(" name1  == "+fields[i].getName());
						System.out.println(" type1  == "+fields[i].getType());
					}else if("XmlElement".equals(annotation.annotationType().getSimpleName())){
						System.out.println(" name2  == "+fields[i].getName());
						System.out.println(" type2  == "+fields[i].getType());
					}else if("XmlElements".equals(annotation.annotationType().getSimpleName())){
						String[] element = fields[i].getName().split("Or");
						for(String cha : element){
						System.out.println(" name3  == "+cha);
						System.out.println(" type3  == "+fields[i].getType().getSimpleName());
						}
					}
				}
				
				
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
			
	} 
	

}
