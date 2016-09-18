package idv.austin.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiskTool {

	public static void main(String args[]) throws IOException{
		DiskTool tool = new DiskTool();
//		tool.showFile("./storage/gen/schema/");
//		tool.readFile("./storage/gen/schema/GN_BENV.txt");
		tool.filterFileName("./storage/gen/schema/GN_BENV.txt");
		System.out.println("[END]");
	}
	
	public String filterFileName(String fileAbsolutePath){
		String ans = fileAbsolutePath;
		
		int lastIdx = fileAbsolutePath.lastIndexOf("/");
		if(lastIdx<0) return ans;
		
		ans = fileAbsolutePath.substring(lastIdx+1);
//		System.out.println("ans="+ans);
		
		return ans;
	}
	
	public String filterFileMainName(String fileName){
		String ans = fileName;
		
		int commaIdx = fileName.lastIndexOf(".");
		if(commaIdx<0)return fileName;
		
		ans = ans.substring(0, commaIdx);
//		System.out.println("ans="+ans);
		
		return ans;
	}
	
	
	public List<String> showFile(String fullPath){
		
		List<String> fileList = new ArrayList<String>();
		
		File filePath = new File(fullPath);
		boolean isDir = filePath.isDirectory();
		boolean isExist = filePath.exists();
		
		System.out.println(filePath+"|isDir="+isDir);
		if(isDir==false) return fileList;
		
		System.out.println(filePath+"|isExist="+isExist);
		if(isExist==false) return fileList;
		
		
		File[] files = filePath.listFiles();
		System.out.println(filePath+"|files.length="+files.length);
		
		for(File file:files){
//			System.out.println(file);
//			System.out.println(file.getAbsolutePath());
//			System.out.println(file.getPath());
			System.out.println(file.getName());
//			fileList.add(file.getAbsolutePath());
			fileList.add(file.getName());
		}
		
		return fileList;
	}
	
	
	/**
	 * 
	 * @param fullPath
	 * @return List<String> ArrayList<String>
	 * @throws IOException
	 */
	public List<String> readFile(String fullPath) throws IOException{
		
		List<String> srcList = new ArrayList<String>();
		
		File file = new File(fullPath);
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
	
}
