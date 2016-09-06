package austin.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import austin.bean.SQLBean;

public class CodeGenerator {

	FileController fileIO = new FileController();
	String patternPath = "./CodeGen/Pattern/";
	String syntaxPath = "./CodeGen/Syntax/";
	
	CodeSyntaxJavaPattern javaSyntax = new CodeSyntaxJavaPattern();
	CodeSyntaxSQLPattern sqlSyntax = new CodeSyntaxSQLPattern();
	CodeSyntaxJSPPattern jspSyntax = new CodeSyntaxJSPPattern();
	CodeSyntaxXMLPattern xmlSyntax = new CodeSyntaxXMLPattern();
	CodeSyntaxPropertiesPattern propertiesSyntax = new CodeSyntaxPropertiesPattern();
	
	/**
	 * 建立Bean的相關方法，這邊主要會以JavaCode的方式為主。
	 * @param beanName
	 * @throws IOException
	 */
	public void createJava(String beanName) throws IOException{
		//File beforeFile = new File("./CodeGen/Before.txt");
		List<SQLBean> sqlBeanList = getSQLBeans(new File(patternPath+beanName+".ptn"));
		List<String> outList = new ArrayList<String>();
		
		outList.add(javaSyntax.getClassHeader(beanName));
		
		outList.add(javaSyntax.getDeclareString("DataObject", "dto", "//該Bean的固定命名"));
		
		outList.addAll(javaSyntax.toParameterDeclare(sqlBeanList));
		
		outList.add(javaSyntax.getConstructorHeader(beanName));
		outList.add(javaSyntax.getConstructorTailer());

		outList.add(javaSyntax.getMethodHeader("getValue"));
		outList.add("\t\tDataObject dto = new DataObject()");
		outList.addAll(javaSyntax.toDataObjectGetValue(sqlBeanList));
		outList.add(javaSyntax.getMethodTailer("dto"));
		
		outList.add(javaSyntax.getMethodHeader("getDataObject"));
		outList.add("\t\tDataObject dto = new DataObject()");
		outList.addAll(javaSyntax.toDataObjectGetMethod(sqlBeanList));
		outList.add(javaSyntax.getMethodTailer("dto"));

		outList.add(javaSyntax.setMethodHeader("setValue", "DataObject", "dto"));
		outList.addAll(javaSyntax.toDataObjectSetValue(sqlBeanList));
		outList.add(javaSyntax.setMethodTailer());
		
		outList.add(javaSyntax.getMapHeader());
		outList.addAll(javaSyntax.getMapDetail(sqlBeanList));
		outList.add(javaSyntax.getMapTailer());
		
		outList.add(javaSyntax.getToStringHeader());
		outList.addAll(javaSyntax.getToStringDetail(sqlBeanList));
		outList.add(javaSyntax.getToStringTailer());
		
		outList.add(javaSyntax.getClassTailer());
		
		fileIO.writeFileByLine(outList, new File(syntaxPath+beanName+".java"));
		
		System.out.println("createBean("+beanName+")|[END]");
	}
	
	/**
	 * 建立Bean的相關方法，這邊主要會以JavaCode的方式為主。
	 * @param beanName
	 * @throws IOException
	 */
	public void createRecords(String beanName) throws IOException{
		//File beforeFile = new File("./CodeGen/Before.txt");
		List<SQLBean> sqlBeanList = getSQLBeans(new File(patternPath+beanName+".ptn"));
		List<String> outList = new ArrayList<String>();
		
		outList.add(sqlSyntax.getPackageHeader(beanName));

		outList.add(sqlSyntax.getRecordHeader(beanName+"_TYPE"));
		outList.addAll(sqlSyntax.getRecordFields(sqlBeanList, beanName));
		outList.add(sqlSyntax.getRecordTailer());
		
		outList.add(sqlSyntax.getPackageTailer(beanName));
		
		fileIO.writeFileByLine(outList, new File(syntaxPath+beanName+".sql"));
		
		System.out.println("createRecords("+beanName+")|[END]");
	}
	
	public void createBody(String beanName) throws IOException{
		List<SQLBean> sqlBeanList = getSQLBeans(new File(patternPath+beanName+".ptn"));
		List<String> outList = new ArrayList<String>();
		
		outList.add("SELECT");
		outList.addAll(sqlSyntax.getFields(sqlBeanList));
		outList.add("FROM " +beanName );
		outList.add("WHERE");
		outList.addAll(sqlSyntax.getWhereFields(sqlBeanList, beanName));
		
		fileIO.writeFileByLine(outList, new File(syntaxPath+beanName+"body.sql"));
		
		System.out.println("createBody("+beanName+")|[END]");
	}
	
	/**
	 * 
	 * @param beanName
	 * @throws IOException
	 */
	public void createJSP(String beanName) throws IOException{
		List<SQLBean> sqlBeanList = getSQLBeans(new File(patternPath+beanName+".ptn"));
		List<String> outList = new ArrayList<String>();
		
		outList.add(jspSyntax.getFormHeader());
		outList.addAll(jspSyntax.getHiddenField(sqlBeanList, beanName));
		
		outList.add(jspSyntax.getTableHeader());
		outList.addAll(jspSyntax.getTextField(sqlBeanList, beanName));
		outList.add(jspSyntax.getTableTailer());
		
		outList.add(jspSyntax.getGridHeader(beanName));
		outList.addAll(jspSyntax.getGridColumn(sqlBeanList));
		outList.add(jspSyntax.getGridTailer());

		outList.add("\r\n");
		
		outList.add(jspSyntax.getGridCommonHeader());
		outList.addAll(jspSyntax.getGridCommonTitle(sqlBeanList));
		outList.add(jspSyntax.getGridCommonMiddle());
		outList.addAll(jspSyntax.getGridCommonDetail(sqlBeanList));
		outList.add(jspSyntax.getGridCommonTailer());
		
		outList.add(jspSyntax.getFormTailer());
		
		
		fileIO.writeFileByLine(outList, new File(syntaxPath+beanName+".jsp"));
		
		System.out.println("createJSP("+beanName+")|[END]");
	}
	
	/**
	 * 
	 * @param beanName
	 * @throws IOException
	 */
	public void createProperties(String beanName) throws IOException{
		List<SQLBean> sqlBeanList = getSQLBeans(new File(patternPath+beanName+".ptn"));
		List<String> outList = new ArrayList<String>();
		
		outList.addAll(propertiesSyntax.getProperties(sqlBeanList, "", true));
		outList.add("\r\n");
		outList.addAll(propertiesSyntax.getProperties(sqlBeanList, "", false));
		outList.add("\r\n");
		outList.addAll(propertiesSyntax.getProperties(sqlBeanList, beanName, true));
		outList.add("\r\n");
		outList.addAll(propertiesSyntax.getProperties(sqlBeanList, beanName, false));
		outList.add("\r\n");
		
		fileIO.writeFileByLine(outList, new File(syntaxPath+beanName+".properties"));
		
		System.out.println("createProperties("+beanName+")|[END]");
	}
	
	/**
	 * 取得SQLBean的資料
	 * @return
	 * @throws IOException
	 */
	public List<SQLBean> getSQLBeans() throws IOException{
		List<SQLBean> sqlBeanList = new ArrayList<SQLBean>();
		for(String lines : fileIO.readFileByLine()){
			sqlBeanList.add(new SQLBean(lines));
		}
		return sqlBeanList;
	}
	
	/**
	 * 取得SQLBean的資料
	 * @return
	 * @throws IOException
	 */
	public List<SQLBean> getSQLBeans(File beforeFile) throws IOException{
		List<SQLBean> sqlBeanList = new ArrayList<SQLBean>();
		for(String lines : fileIO.readFileByLine(beforeFile)){
			sqlBeanList.add(new SQLBean(lines));
		}
		return sqlBeanList;
	}
	
	public Set<String> listBeanNames(){
		File[] files = new File(patternPath).listFiles();
		Set<String> fileNames = new HashSet<String>();
		for(File fileObjs:files){
			String fileNameString = fileObjs.getName();
			if("After".equals(fileNameString) ||"Before".equals(fileNameString)){
				//After.txt || Before.txt 排除Code Gen
			}else if(fileNameString.contains(".ptn")){
				//僅處理.txt副檔名的檔案
				fileNames.add(fileNameString.replace(".ptn", ""));
			}
		}
		return fileNames;
	}
	
	/**
	 * 全部的檔案進行CodeGen
	 * @throws IOException
	 */
	public void create() throws IOException{
		Set<String> fileNams = listBeanNames();
		for(String fileName:fileNams){
			createJava(fileName);
			createRecords(fileName);
			createBody(fileName);
			createJSP(fileName);
			createProperties(fileName);
//			System.out.println(fileName);
		}
	}
}
