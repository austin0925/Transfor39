package idv.austin.gen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenCode {

	File afterFile = new File("./CodeGen/TXT/After.txt");
	File beforeFile = new File("./CodeGen/TXT/Before.txt");
	
	static final String TABLE = "GN_SCHEDULE";//GnScheduleDto.java
	
	public static void main(String[] args) throws IOException{

		Schema schema = new Schema();
		
		String tableName = schema.upperFirst(schema.cutUnderLine(TABLE));
		
		GenCode test = new GenCode();
		
		List<String> schemaList = test.readFile("./CodeGen/TXT/Before.txt");
		
		//先測試一下讀檔的功能
		List<String> srcList = test.readFile("./CodeGen/TXT/SampleDto.java");
		//sample 轉換
		srcList = test.replaceColumn(srcList, test.parse(schemaList));
		srcList = test.replaceOnce(srcList, "~Table", tableName);
//		srcList = test.fileterString("~~", srcList);
		
		test.writeFile("./CodeGen/TXT/"+tableName+"Dto.java", srcList);
		
		System.out.println("[END]");
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
		
		key = "~~name";
		value = schema.cutUnderLine(schema.column);
		if(line.indexOf(key)>=0)line = line.replace(key, value);
		
		key = "~~Name";
		value = schema.upperFirst(value);
		if(line.indexOf(key)>=0)line = line.replace(key, value);
		
		key = "~~type";
		value = schema.type.toUpperCase();
		if(value.indexOf("NUMBER")>=0)value="Double";
		if(value.indexOf("VARCHAR")>=0)value="String";
		if(value.indexOf("DATE")>=0)value="Timestamp";
		if(line.indexOf(key)>=0)line = line.replace(key, value);
		
		key = "~~comment";
		value = schema.comment;
		if(line.indexOf(key)>=0)line = line.replace(key, value);

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
		line = line.replace(key, value);
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
	
	public List<String> readFile(String filePath) throws IOException{
		
		List<String> srcList = new ArrayList<String>();
		
		File file = new File(filePath);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String line = "";
		while((line=bufferedReader.readLine())!=null){
			srcList.add(line);
//			System.out.println(line);
		}
		
		bufferedReader.close();
		
		return srcList;
	}
	
	
	/**
	 * 寫入檔案，透過List<String>和檔名動態的產生文字檔
	 * @param filePath
	 * @param srcList
	 * @throws IOException
	 */
	public void writeFile(String filePath, List<String> srcList) throws IOException{
		
		File file = new File(filePath);
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		for(String lines:srcList){
			bufferedWriter.write(lines);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		
		bufferedWriter.flush();
		bufferedWriter.close();
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
		
		Schema schema = new Schema();
		
		schema.column = key[0];
		schema.type = key[1];
		schema.length = key[4];
		schema.precision = key[4];
		schema.id = key[4];
		schema.comment = key[5];
		
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
		
		System.out.println("["+line + "] => ["+ newLine+"]");
		return newLine;
	}
	
	public String upperFirst(String line){
		line = line.substring(0, 1).toUpperCase()+line.substring(1);
		return line;
	}
	
	
}