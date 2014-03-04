package com.mobilepark.uxcutor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UxcutorController {
	private static final Logger logger = LoggerFactory.getLogger(UxcutorController.class);
	
	@RequestMapping(value = "/view.htm", method = RequestMethod.POST)
	public String view(Locale locale, Model model) {

		return "view";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/make.json", method=RequestMethod.GET)
	@ResponseBody 
	public Map<String, Object> make(Locale locale, Model model,
			@RequestParam(value = "cName", required=false, defaultValue="Uxcutor") String className) throws ClassNotFoundException {
		logger.info("uxcutor start.", locale);

		Class<?> c = Class.forName("com.mobilepark.uxcutor.dtdmodel."+ className);

		Field[] fields = c.getDeclaredFields();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		List<String> eleList = new ArrayList<String>();
		for( int i=0;i<fields.length;i++){
			
			if(fields[i].getAnnotations().length>0){
				for(Annotation annotation : fields[i].getAnnotations()){
					
					if("XmlAttribute".equals(annotation.annotationType().getSimpleName())){
						
						//attList.add(fields[i].getName());
					}else if("XmlElement".equals(annotation.annotationType().getSimpleName())){
							
							eleList.add(fields[i].getName());
					}else if("XmlElements".equals(annotation.annotationType().getSimpleName())){
						String[] element = fields[i].getName().split("Or");
						for(String cha : element){
							
							eleList.add(cha);
						}
					}
				}
			}else{
				
				eleList.add(fields[i].getName());
			}
						
		}
		
		ArrayList attList = new ArrayList();
		
		for(int k=0;k<eleList.size();k++){
			String element = eleList.get(k);
			element = element.substring(0,1).toUpperCase() + element.substring(1,element.length());
			
			System.out.println("element==="+element);
			
			Class<?> ec = Class.forName("com.mobilepark.uxcutor.dtdmodel."+ element);
			Field[] elefields = ec.getDeclaredFields();
			
			@SuppressWarnings("rawtypes")
			ArrayList attList1 = new ArrayList();
			
			for( int i=0;i<elefields.length;i++){
				
				if(elefields[i].getAnnotations().length>0){
					
					for(Annotation annotation : elefields[i].getAnnotations()){
						
						if("XmlAttribute".equals(annotation.annotationType().getSimpleName())){
							
							attList1.add(elefields[i].getName());
						}
					}
				}		
			}
		
			attList.add(attList1);
			
		}

		map.put("attrList", attList);
		map.put("eleList", eleList);
		
		System.out.println("======================"+className);
		return map;
	}
	
	/**
	 * 트리 화면 호출
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/uxcutor/view_ps.htm")
	public String test(Model model) {

		return "/user/view_ps";
	}

	/**
	 * 트리 데이터 호출
	 * 
	 * @param model
	 * @param className
	 * @param parentId
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/uxcutor/tree_data.json")
	@ResponseBody
	public List<Object> tree_data(
			Model model,
			@RequestParam(value = "cName", required = false, defaultValue = "Uxcutor") String className,
			@RequestParam(value = "parentId", required = false, defaultValue = "#") String parentId)
			throws ClassNotFoundException {

		Class<?> c = Class.forName("com.mobilepark.uxcutor.dtdmodel."
				+ className);

		Field[] fields = c.getDeclaredFields();

		List<Object> data = new ArrayList<Object>();

		List<String> attList = new ArrayList<String>();
		List<String> eleList = new ArrayList<String>();

		for (int i = 0; i < fields.length; i++) {

			if (fields[i].getAnnotations().length > 0) {
				for (Annotation annotation : fields[i].getAnnotations()) {

					if ("XmlAttribute".equals(annotation.annotationType()
							.getSimpleName())) {

						attList.add(fields[i].getName());
					} else if ("XmlElement".equals(annotation.annotationType()
							.getSimpleName())) {

						eleList.add(fields[i].getName());
					} else if ("XmlElements".equals(annotation.annotationType()
							.getSimpleName())) {
						String[] element = fields[i].getName().split("Or");
						for (String cha : element) {

							eleList.add(cha);
						}
					}
				}
			} else {

				eleList.add(fields[i].getName());
			}
		}

		HashMap<String, Object> deptMap = new HashMap<String, Object>();
		deptMap.put("parentId", parentId);
		deptMap.put("text", className);
		deptMap.put("children", eleList);
		deptMap.put("li_attr", attList);
		data.add(deptMap);

		System.out.println("======================" + deptMap.toString());

		return data;
	}

	/**
	 * autocomplete 데이터 호출
	 * 
	 * @return List<Object>
	 */
	@RequestMapping(value = "/uxcutor/autocomplete.json")
	@ResponseBody
	public List<Object> autocomplete() {

		List<Object> data = new ArrayList<Object>();

		try {
			BufferedReader in = new BufferedReader(new FileReader(this
					.getClass().getResource("").getPath()
					+ "/prop/autocomplete.prop"));

			String word = "";

			while ((word = in.readLine()) != null) {
				data.add(word);
			}
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}
}
