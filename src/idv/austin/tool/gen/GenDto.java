package idv.austin.tool.gen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenDto {
	
	DiskTool diskTool = new DiskTool();
	
	static Schema schema = new Schema();
	static GenDto test = new GenDto();
	
	static String TABLE = "GN_R004";						//	GnScheduleDto.java
	
	static String TEMPLATE = "./storage/gen/TemplateDto.java";	//	"./CodeGen/TXT/SampleDto.java"
	static String DB_SCHEMA_HOME = "./storage/gen/schema/";
	static String DB_SCHEMA = DB_SCHEMA_HOME+TABLE+".txt";		//	"./CodeGen/TXT/Before.txt"
	static String TABLE_NAME = schema.upperFirst(schema.cutUnderLine(TABLE));
	static String GEN_PATH = "./storage/gen/dto/"+TABLE_NAME+"Dto.java";//	"./CodeGen/TXT/"+tableName+"Dto.java"
	
	int lineCnt = 0;
	
	public static void main(String[] args) throws IOException{

		GenDto genDto = new GenDto();
		DiskTool diskTool = new DiskTool();
		
		List<String> schemaList = diskTool.showFile(DB_SCHEMA_HOME);
		for(String schema:schemaList){
			String tableName = diskTool.filterFileName(schema);
			tableName = diskTool.filterFileMainName(tableName);
			
			genDto.changeTableName(tableName);
			genDto.genDtoFile();
		}
		
		System.out.println("[END]");
		
	}
	
	public void changeTableName(String tableName){
		TABLE = tableName;						//	GnScheduleDto.java
		
		TEMPLATE = "./storage/gen/TemplateDto.java";	//	"./CodeGen/TXT/SampleDto.java"
		DB_SCHEMA = "./storage/gen/schema/"+TABLE+".txt";		//	"./CodeGen/TXT/Before.txt"
		TABLE_NAME = schema.upperFirst(schema.cutUnderLine(TABLE));
		GEN_PATH = "./storage/gen/dto/"+TABLE_NAME+"Dto.java";//	"./CodeGen/TXT/"+tableName+"Dto.java"
		
		lineCnt = 0;
	}
	
	public void genDtoFile() throws IOException{
		
		//讀取SCHEMA & TEMPLATE 檔
		List<String> schemaList = diskTool.readFile(DB_SCHEMA);
		List<String> templateList = diskTool.readFile(TEMPLATE);
		
		//置換動作
		templateList = test.replaceColumn(templateList, parse(schemaList));
		templateList = test.replaceOnce(templateList, "~Table", TABLE_NAME);
//		srcList = test.fileterString("~~", srcList);	//	檔案產出前的過濾
		
		//產出DTO結果檔
		diskTool.writeFile(GEN_PATH, templateList);
		
		System.out.println("[建立DTO]>>>"+GEN_PATH);
	}
	
	public List<String> replaceColumn(List<String> srcList, List<Schema> schemaList){
		List<String> returnList = new ArrayList<String>();
		for(String strs:srcList){
			returnList.add(replaceColumn(strs, schemaList));
		}
		return returnList;
	}
	
	public String replaceColumn(String line, List<Schema> schemaList){
		String ans = "";
		for(Schema schemas:schemaList){
			if(line.indexOf("~~")>=0){				
				ans += replaceColumn(line, schemas)+"\r\n";
			}else{
				ans=line;
			}
		}
		return ans;
	}
	
	public String replaceColumn(String line, Schema schema){
		
		String key, value;
		
		
		key = "~~NAME";
		value = schema.column;
		if(line.indexOf(key)>=0)line = line.replaceAll(key, value);
		
		
		key = "~~name";
		value = schema.cutUnderLine(schema.column);
		if(line.indexOf(key)>=0)line = line.replaceAll(key, value);
		
		
		key = "~~Name";
		value = schema.upperFirst(value);
		if(line.indexOf(key)>=0)line = line.replaceAll(key, value);
		
		
		key = "~~type";
		value = schema.type.toUpperCase();
		if(value.indexOf(",0)")>=0)value="Long";
		if(value.indexOf(", 0)")>=0)value="Long";
		if(value.indexOf("NUMBER")>=0)value="Double";
		if(value.indexOf("NUMERIC")>=0)value="Double";
		if(value.indexOf("NCHAR")>=0)value="String";
		if(value.indexOf("VARCHAR")>=0)value="String";
		if(value.indexOf("DATE")>=0)value="Timestamp";
		if(line.indexOf(key)>=0)line = line.replaceAll(key, value);
		
		
		key = "~~Type";
		value = schema.type.toUpperCase();
		if(value.indexOf(",0)")>=0)value="Long";
		if(value.indexOf(", 0)")>=0)value="Long";
		if(value.indexOf("NUMBER")>=0)value="Double";
		if(value.indexOf("NUMERIC")>=0)value="Double";
		if(value.indexOf("NCHAR")>=0)value="String";
		if(value.indexOf("VARCHAR")>=0)value="String";
		if(value.indexOf("DATE")>=0)value="Timestamp";
		if(line.indexOf(key)>=0)line = line.replaceAll(key, value);


		key = "~~order";
		value = schema.id;
		if(line.indexOf(key)>=0)line = line.replaceAll(key, value);
		
		
		key = "~~comment";
		value = schema.comment;
		if(line.indexOf(key)>=0)line = line.replaceAll(key, value);

		
		return line;
	}
	
	
	public List<String> replaceOnce(List<String> srcList, String key, String value){
		List<String> ansList = new ArrayList<String>();
		for(String line:srcList){	
			if(line.indexOf(key)>=0){				
				ansList.add(replaceOnce(line, key, value));
			}else{
				ansList.add(line);
			}
		}
		return ansList;
	}
	
	public String replaceOnce(String line, String key, String value){
		line = line.replaceAll(key, value);
		return line;
	}
	
	
	
	/**
	 * 只要出現filter的字樣，就濾掉不加入。
	 * @param filter
	 * @param srcList
	 * @return List<String>
	 */
	public List<String> fileterString(String filter, List<String> srcList){
		List<String> ansList = new ArrayList<String>();
		for(String str:srcList){
			if(str.indexOf(filter)<0){ansList.add(str);}
		}
		return ansList;
	}
	
	public List<Schema> parse(List<String> schemaList){
		List<Schema> ansList = new ArrayList<Schema>();
		for(String schemaStr:schemaList){
			ansList.add(parse(schemaStr));
		}
		return ansList;
	}
	
	public Schema parse(String line){
		
		String[] key = line.split("\t");
		int keyIdx = key.length-1;
		
		Schema schema = new Schema();
		
		schema.column = key[0];
		schema.type = key[1];
		schema.length = 4>keyIdx?"LENGTH(noValue)":key[4];
		schema.precision = 4>keyIdx?"PRECISION(noValue)":key[4];
		
		schema.id = 4>keyIdx?String.valueOf(++lineCnt):key[4];
		
		schema.comment = 5>keyIdx?"COMMENT(noValue)":key[5];//setting ... when out of range
		
//		System.out.println(schema.toString());
		
		return schema;
	}
	
	
}

class Schema{
	public String column;
	public String type;
	public String length;
	public String precision;
	public String id;
	public String comment;
	
	public Schema getRandom(){
		return setRandom();
		
	}
	
	public Schema setRandom(){
		Long random = (long) (Math.ceil(Math.random()*1000.0));
		this.column = "COLUMN"+random;
		this.type = "varchar("+random+")";
		this.length = ""+random;
		this.precision = ""+random;
		this.id = ""+random;
		this.comment = "COMMENT"+random;
		return this;
	}
	
	public List<Schema> setRandomList(int length){
		List<Schema> list = new ArrayList<Schema>();
		for(int i=0; i<length; i++){			
			list.add(setRandom());
		}
		return list;
	}

	@Override
	public String toString() {
		return "Schema ["+ "column=" + column + ", type=" + type + ", length=" + length
				+ ", precision=" + precision + ", id=" + id + ", comment=" + comment + "]";
	}
	
	
	/**
	 * 將所有字母轉成小寫，去除底線以及將底線後的字母轉成大寫。
	 * @param line
	 * @return  把新的line傳出
	 */
	public String cutUnderLine(String line){
		String newLine = line.toLowerCase();
		
		while(newLine.contains("_")){
			int index = newLine.indexOf("_");
			int length = newLine.length();
			
//			System.out.println("index = "+index+"& length="+length);
			
			String headString = (index==0)?"":newLine.substring(0, index);
			String midString = (index==length)?"":newLine.substring(index+1,index+2).toUpperCase();
			String tailString = (index+1>length)?"":newLine.substring(index+2);
			
//			System.out.println("newLine = "+newLine);
//			System.out.println("headString = "+headString);
//			System.out.println("midString = "+midString);
//			System.out.println("tailString = "+tailString);
			
			newLine = headString.concat(midString).concat(tailString);
		}
		
//		System.out.println("["+line + "] => ["+ newLine+"]");
		return newLine;
	}
	
	public String upperFirst(String line){
		line = line.substring(0, 1).toUpperCase()+line.substring(1);
		return line;
	}
	
	
}