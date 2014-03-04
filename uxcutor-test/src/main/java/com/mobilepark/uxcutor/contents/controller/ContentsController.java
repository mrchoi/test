package com.mobilepark.uxcutor.contents.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mobilepark.uxcutor.common.Env;
import com.mobilepark.uxcutor.contents.model.Contents;
import com.mobilepark.uxcutor.contents.service.ContentsService;
import com.mobilepark.uxcutor.framework.web.PageHandler;
import com.mobilepark.uxcutor.userContentsMap.model.UserContentsMap;
import com.mobilepark.uxcutor.userContentsMap.service.UserContentsMapService;
import com.mobilepark.uxcutor.xml.DOMValidateDTD;
/**
 * Handles requests for the application home page.
 */
@Controller
public class ContentsController {

	private static final Logger logger = LoggerFactory
			.getLogger(ContentsController.class);

	@Autowired
	private ContentsService contentsService;
	@Autowired
	private UserContentsMapService userContentsMapService;
	
	/**
	 * contents 리스트 호출
	 * 
	 * @param model
	 * @param session
	 * @return viewName
	 */
	@RequestMapping(value = "/contents/list.htm")
	public String list(Model model, HttpSession session,
			@RequestParam(value = "curPage", defaultValue = "") String curPage) {

		HashMap<String, Object> hash = new HashMap<String, Object>();

		int currentPage = 1;

		if (!(curPage == null || curPage.equals(""))) {
			currentPage = Integer.parseInt(curPage);
		}

		int totalRecord = contentsService.count(hash);
		
		PageHandler pg = new PageHandler(currentPage, totalRecord, 10, 10);
		hash.put("pg", pg);

		model.addAttribute("list", contentsService.list(hash));
		model.addAttribute("pageHandler", pg);
		model.addAttribute("ADMIN_ID", session.getAttribute("ADMIN_ID"));

		return "contents/list";
	}

	/**
	 * contents 상세보기 호출
	 * 
	 * @param model
	 * @param id
	 *            (contents Id)
	 * @return viewName
	 */
	@RequestMapping(value = "/contents/view.htm")
	public String view(Model model, HttpSession session,
			@RequestParam(value = "id", required = true) int id) {

		Contents contents = new Contents();
		contents.setId(id);

		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("contents_id", id);

		Contents view_contents = contentsService.view(contents);

		String status = "0";
		contents.setStatus(status);
		//상태값 업데이트
		contentsService.update(contents);

		String admin_id = (String) session.getAttribute("ADMIN_ID");
		// 매핑테이블 업데이트
		UserContentsMap userContentsMap = new UserContentsMap();
		userContentsMap.setContents_id(id);
		userContentsMap.setUser_id(admin_id);

		userContentsMapService.update(userContentsMap);
		
		model.addAttribute("view", view_contents);
		model.addAttribute("user_id", userContentsMapService.getUser_id(hash));
		model.addAttribute("ADMIN_ID", session.getAttribute("ADMIN_ID"));

		return "contents/view";
	}

	/**
	 * contents 입력 화면 호출
	 * 
	 * @param model
	 * @param session
	 * @return viewName
	 */
	@RequestMapping(value = "/contents/insertForm.htm")
	public String insertForm(Model model, HttpSession session) {
		model.addAttribute("ADMIN_ID", session.getAttribute("ADMIN_ID"));
		return "contents/insert";
	}

	/**
	 * contents 입력
	 * 
	 * @param model
	 * @param contents
	 * @param user_id
	 * @return 성공/실패 msg
	 * @throws Exception
	 */
	@RequestMapping(value = "/contents/insert.htm", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String insert(Model model,
			@ModelAttribute("contents") Contents contents,
			@RequestParam(value = "user_id", required = true) String user_id,
			@RequestParam(value = "xmlData", required = true) String xmlData,
			HttpServletRequest request)
			throws Exception {

		String msg = Env.get("msg.contents.insert.fail");
		int ret = 0;

		Date uploadDate = new java.util.Date();
		uploadDate.setTime(System.currentTimeMillis());

		String filePath = Env.get("xml.fileupload") + "/"
				+ uploadDate.getTime() / 1000 * 1000 + "_";

		String xmlName = contents.getName() + ".xml";
		String xml_url = filePath + xmlName;

		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(xml_url));
			out.write(xmlData);
			out.close();

			String validateMsg = DOMValidateDTD.DTDValidate(xml_url);
			
			if (validateMsg.equals("") || validateMsg == null) {
				contents.setXml_url(xml_url);

				ret = contentsService.insert(contents);

				// contents insert 성공시 userServiceMap insert
				if (ret == 1) {
					// insert userServiceMap 설정
					UserContentsMap userContentsMap = new UserContentsMap();
					userContentsMap.setContents_id(contents.getId());
					userContentsMap.setUser_id(user_id);

					ret = userContentsMapService.insert(userContentsMap);

					if (ret == 1)
						msg = Env.get("msg.contents.insert.succ");
					else
						msg = Env.get("msg.contents.insert.mapping.fail");
				}
			} else {
				msg = "1;" + validateMsg;
			}
			
			

		} catch (Exception e) {
			msg = Env.get("msg.contents.exception");
			e.printStackTrace();
		} finally {
		}
		return msg;
	}

	/**
	 * contents 수정
	 * 
	 * @param model
	 * @param contents
	 * @return 성공/실패 msg
	 * @throws Exception
	 */
	@RequestMapping(value = "/contents/update.htm", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String update(Model model,
			@ModelAttribute("contents") Contents contents,
			@RequestParam(value = "xmlData", required = true) String xmlData)
			throws Exception {

		String msg = Env.get("msg.contents.update.fail");
		int ret = 0;

		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(
					contents.getXml_url()));
			out.write(xmlData);
			out.close();

			String validateMsg = "";
			if (validateMsg.equals("") || validateMsg == null) {
				String status = "1";
				contents.setStatus(status);

				ret = contentsService.update(contents);

				if (ret == 1)
					msg = Env.get("msg.contents.update.succ");
			} else {
				msg = "1;" + validateMsg;
			}
			
			
		} catch (Exception e) {
			msg = Env.get("msg.contents.exception");
			e.printStackTrace();
		} finally {
		}
		return msg;
	}

	/**
	 * contents 삭제
	 * 
	 * @param model
	 * @param contents
	 * @return 성공/실패 msg
	 * @throws Exception
	 */
	@RequestMapping(value = "/contents/delete.htm", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String delete(Model model,
			@ModelAttribute("contents") Contents contents, HttpSession session)
			throws Exception {

		String msg = Env.get("msg.contents.delete.fail");
		int ret = 0;

		try {

			ret = contentsService.delete(contents);

			if (ret == 1) {
				// insert userServiceMap 설정
				UserContentsMap userContentsMap = new UserContentsMap();
				userContentsMap.setContents_id(contents.getId());
				userContentsMap.setUser_id((String) session
						.getAttribute("ADMIN_ID"));

				ret = userContentsMapService.delete(userContentsMap);

				if (ret == 1)
					msg = Env.get("msg.contents.delete.succ");
				else
					msg = Env.get("msg.contents.delete.mapping.fail");

			}

		} catch (Exception e) {
			msg = Env.get("msg.contents.exception");
			e.printStackTrace();
		} finally {
		}
		return msg;
	}

	@RequestMapping(value = "/contents/download.htm", method = RequestMethod.POST)
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "filename", defaultValue = "") String filename)
			throws Exception {

		File downloadFile = new File(filename);
		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	/**
	 * contents 입력 화면 호출
	 * 
	 * @param model
	 * @param session
	 * @return viewName
	 */
	@RequestMapping(value = "contents/test.htm")
	public String test(Model model) {

		return "contents/test";
	}

	/**
	 * xml_url로 xml파일생성 후 html tag로 변환
	 * 
	 * @param xml_url
	 * @return (String)htmlTag
	 */
	@RequestMapping(value = "/contents/xmltoHtml.htm", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String xmltoHtml(String xml_url) {
		String htmlTag = "";
		int depth = 0;
		int elementCnt = 0;
		
		 BufferedReader bufferedReader = null;

		try {
			
			File xmlFile = new File(xml_url);
			
			if (xmlFile.length() > 0) {

				bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(xmlFile)));
				
				StringBuffer str = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					
					if(!line.equals("<!DOCTYPE uxcutor SYSTEM 'xcpt.dtd'>")){
						str.append(line);
					}
				}
				
				bufferedReader.close();
				
				InputStream is = new ByteArrayInputStream(str.toString().getBytes());
				
				SAXBuilder builder = new SAXBuilder();
				Document doc = builder.build(is);
				
				Element root = doc.getRootElement();
	
				List<Element> elements = root.getChildren();
	
				htmlTag = ulMaker(elements, depth, elementCnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return htmlTag;
	}

	/**
	 * xml 데이터로 ul tag 만들기
	 * 
	 * @param elements
	 *            (하위 element 리스트)
	 * @param depth
	 *            (id 이름 생성을 위한 depth 변수)
	 * @param elementCnt
	 *            (id 이름 생성을 위한 elementCnt 변수)
	 * @return (String)htmlTag
	 * @throws Exception 
	 */
	public String ulMaker(List<Element> elements, int depth, int elementCnt) throws Exception {
		String htmlTag = "";
		depth++;	

		htmlTag += "<ul>\n";
		htmlTag += liMaker(elements, depth, elementCnt);
		htmlTag += "\n</ul>";

		return htmlTag;
	}

	/**
	 * xml 데이터로 li tag 만들기
	 * 
	 * @param elements
	 *            (하위 element 리스트)
	 * @param depth
	 *            (id 이름 생성을 위한 depth 변수)
	 * @param elementCnt
	 *            (id 이름 생성을 위한 elementCnt 변수)
	 * @return (String)htmlTag
	 * @throws Exception 
	 */
	public String liMaker(List<Element> elements, int depth, int elementCnt) throws Exception {
		String htmlTag = "";

		int i = 0;

		for (Element element : elements) {

			elementCnt++;

			String id = element.getName() + "_" + depth + "_" + i + "_"+ elementCnt;
			
			htmlTag += "\n\t<li id=\'" + id + "' class='minusimageapply'>";

			htmlTag += onclickMaker(element, id);
			htmlTag += attrMaker(element, id);

			if (element.getChildren().size() > 0) {
				List<Element> subElements = element.getChildren();
				htmlTag += ulMaker(subElements, depth, elementCnt);
				
				elementCnt = elementCnt + element.getChildren().size();
			}

			htmlTag += "\n\t</li>";

			i++;
		}

		return htmlTag;
	}

	/**
	 * xml 데이터로 onClick a tag 만들기
	 * 
	 * @param element
	 *            (생성될 element)
	 * @param id
	 *            (element id)
	 * @return (String)htmlTag
	 */
	public String onclickMaker(Element element, String id) {

		String attrObj = "";
		List<Attribute> attributes = element.getAttributes();

		if (element.getAttributes().size() > 0) {

			for (Attribute attribute : attributes) {
				attrObj += attribute.getName() + ",";
			}
			attrObj = attrObj.substring(0, attrObj.length() - 1);

		}

		String htmlTag = "\n\t<a onclick='javascript:nextFunction(&quot;" + id
				+ "&quot;);return false;'>" + element.getName() + "</a>";

		htmlTag += "\n\t<a onclick='javascript:addFunction(&quot;" + id
				+ "&quot;,&quot;" + attrObj + "&quot;);return false;'>[추가]</a>";

		htmlTag += "\n\t<a onclick='javascript:delFunction(&quot;" + id
				+ "&quot;);return false;'>[삭제]</a>";

		return htmlTag;
	}

	/**
	 * xml 데이터로 attr 관련 tag 만들기
	 * 
	 * @param element
	 *            (생성될 element)
	 * @param id
	 *            (element id)
	 * @return (String)htmlTag
	 * @throws Exception 
	 */
	public String attrMaker(Element element, String id) throws Exception {
		String htmlTag = "";
		String onkeyup = "";
		
		ArrayList<String> arrayList = this.getClassAttribute(element);
		
		if(arrayList.size() > 0 ) {
			
			htmlTag += "\n\t<div class='attr'>";
			
			for(int i=0;i<arrayList.size();i++){
				boolean atrBoolean = false;
				
				htmlTag += "\n\t- " + arrayList.get(i);
				htmlTag += "\n\t<input type='text' id='" + id + "_" + arrayList.get(i) + "' value='";

				if (element.getAttributes().size() > 0) {
					List<Attribute> attributes = element.getAttributes();
							
					for (Attribute attribute : attributes) {

						if(attribute.getName().equals(arrayList.get(i))){
							atrBoolean = false;
						
							if (attribute.getName().equals("acttype") && attribute.getValue().equals("LUA")){
								onkeyup = "onkeyup='TextareaShow(&quot;" + id + "&quot;);'";
							}
							
							htmlTag += attribute.getValue().replaceAll("'", "&#039;") + "' " + onkeyup + "><br/>";
			
							if (attribute.getName().equals("acttype") && attribute.getValue().equals("LUA")){
								htmlTag += textareaMaker(element, id);
								htmlTag += "<br/>";
							}
							
							break;
						}else{
							atrBoolean = true;
						}
					}
		
				}else{
					htmlTag +="'><br/>";
					atrBoolean = false;
				}
				
				if(atrBoolean) htmlTag += "'><br/>";
			}
			htmlTag += "\n\t</div>";
		}

		return htmlTag;
	}
	
	/**
	 * xml 데이터로 textarea tag 만들기
	 * 
	 * @param element
	 *            (생성될 element)
	 * @param id
	 *            (element id)
	 * @return (String)htmlTag
	 */
	public String textareaMaker(Element element, String id) {
		String htmlTag = "";
		String style = "display:none;";

		if (element.getText().equals(""))
			style = "display:none";

		htmlTag += "<textarea id='" + id + "_acttype_textarea'" + style + " >";
		htmlTag += element.getText().trim();
		htmlTag += "</textarea>";

		return htmlTag;
	}
	
	public ArrayList<String> getClassAttribute(Element element) throws Exception{
		
		ArrayList<String> attList = new ArrayList<String>();
		
		try{
			String strEle = element.getName().substring(0,1).toUpperCase() + element.getName().substring(1,element.getName().length());
						
			Class<?> ec = Class.forName("com.mobilepark.uxcutor.dtdmodel."+ strEle);
			Field[] elefields = ec.getDeclaredFields();
				
			for( int i=0;i<elefields.length;i++){
				
				if(elefields[i].getAnnotations().length>0){
					
					for(Annotation annotation : elefields[i].getAnnotations()){
						
						if("XmlAttribute".equals(annotation.annotationType().getSimpleName())){
							attList.add(elefields[i].getName());
						}
					}
				}		
			}
		}catch(Exception e){
			logger.debug(e.getMessage());
		}

		return attList;
	
	}
}
