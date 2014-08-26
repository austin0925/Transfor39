package austin.bean;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Dom4jPractice {

	public static void main(String[] args) throws UnsupportedEncodingException, DocumentException {
		System.out.println("[START]");
		String requestXML = "<?xml version='1.0' encoding='UTF-8' ?>\r\n<ERA_DISP>\r\n<CASE_ID>2014070013</CASE_ID>\r\n<REPORT_CODE>LIFELINES_DAMAGES</REPORT_CODE><MASTER>A4<NAME>Austin</NAME><AGE>40</AGE></MASTER>\r\n</ERA_DISP>";
		org.dom4j.Document document4j = new SAXReader().read(new ByteArrayInputStream(requestXML.getBytes("UTF-8")));
		org.dom4j.Element rootElm = document4j.getRootElement();
		
		Iterator<org.dom4j.Element> iterator = rootElm.elementIterator();
		for(; iterator.hasNext();){
			org.dom4j.Element ele = (org.dom4j.Element)iterator.next();
			System.out.println(ele.getName());
			System.out.println(ele.getData());
			System.out.println(ele.getQName());
			System.out.println(ele.getParent().getText());
			System.out.println(ele.getText());
			System.out.println(ele.getNamespacePrefix());
		}
		
		System.out.println("-----------");
		
		System.out.println("CASE_ID:");
		org.dom4j.Element element = rootElm.element("CASE_ID");
		element.addAttribute("KEY", "123");
		element.addComment("comment123");
		element.addText("addText");
		element.addEntity("foo", "bar");
		System.out.println(rootElm.element("CASE_ID"));
		System.out.println(rootElm.element("CASE_ID").getText());
		
		System.out.println("MASTER:");
		System.out.println(rootElm.element("MASTER").getText());
		System.out.println(rootElm.element("MASTER").element("NAME").getText());
		
		System.out.println("RootElement.TEXT:");
		System.out.println(document4j.getRootElement().getText());
		System.out.println("XMLEncoding:");
		System.out.println(document4j.getXMLEncoding());
		System.out.println("NodeTypeName:");
		System.out.println(document4j.getNodeTypeName());
		System.out.println("asXML:");
		System.out.println(document4j.asXML());
		System.out.println("[END]");
		
	}

	
}
