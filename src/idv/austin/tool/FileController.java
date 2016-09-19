package austin.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileController {

	
	File beforeFile = new File("./CodeGen/Before.txt");
	File afterFile = new File("./CodeGen/After.txt");
	
	/**
	 * 此處提供預設的File方法
	 * @param input
	 * @throws IOException
	 */
	public void writeFileByLine(List<String> input) throws IOException{
		writeFileByLine(input, afterFile);
	}
	/**
	 * 提供自訂File方法
	 * @param input
	 * @param afterFile
	 * @throws IOException
	 */
	public void writeFileByLine(List<String> input, File afterFile) throws IOException{
		FileWriter fileWriter = new FileWriter(afterFile);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for(Object keys:input.toArray()){
			String key = (String)keys;
			bufferedWriter.write(key);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
	
	/**
	 * 提供預設的FILE進行讀取
	 * @return
	 * @throws IOException
	 */
	public List<String> readFileByLine() throws IOException{
		return readFileByLine(beforeFile);
	}
	/**
	 * 提供方法讀取File內資料，以List<String>的方式提供
	 * @param beforeFile
	 * @return
	 * @throws IOException
	 */
	public List<String> readFileByLine(File beforeFile) throws IOException{
		FileReader fileReader = new FileReader(beforeFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> ans = new ArrayList<String>();
		String line = "";
		while((line=bufferedReader.readLine())!= null){
			ans.add(line);
		};
		bufferedReader.close();
		return ans;
	}
}
