package austin.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 將所有的英文字換成小寫，有底線的去除並將後面的字母轉成大寫。
 * @author 2807
 */
public class TransforDB39 {

	File afterFile = new File("./CodeGen/TXT/After.txt");
	File beforeFile = new File("./CodeGen/TXT/Before.txt");
	
	public static void main(String[] args) throws IOException {
		TransforDB39 changer = new TransforDB39();
		FileReader fileReader = new FileReader(changer.beforeFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int idx = 0;
		String line="";
		String beanName = "pageBean";
		
		//append first
		FileWriter fileWriter = new FileWriter(changer.afterFile);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		line="";
		while((line=bufferedReader.readLine())!= null){
			System.out.println("typeString="+changer.typeString(line));
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			line = beanName+"."+javaWord+"="+value;//建立中文屬性檔
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append second
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			line = beanName+"."+javaWord+"="+javaWord;//建立英文屬性檔
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append third
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createTextFieldTag(javaWord, beanName, value);//建立Text欄位標籤檔
			//line += "\n"+changer.createButtonTag(javaWord, value);//建立submit按鈕
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append third-2
				bufferedWriter.newLine();

				fileReader = new FileReader(changer.beforeFile);
				bufferedReader = new BufferedReader(fileReader);
				line="";idx=0;
				while((line=bufferedReader.readLine())!= null){
					String key = changer.keyString(line);
					String javaWord = changer.cutUnderLine(key);
					String value = changer.valueString(line);
					//key = changer.cutUnderLine(key);
					line = changer.createHiddenTag(javaWord, beanName, value);//建立Text欄位標籤檔
					//line += "\n"+changer.createButtonTag(javaWord, value);//建立submit按鈕
					bufferedWriter.write(line);
					bufferedWriter.flush();
					bufferedWriter.newLine();
				};
		
		//append forth
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createGridColumnTag(key, javaWord, javaWord, value);//建立SJG欄位標籤檔
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};

		//append fifth
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			//key = changer.cutUnderLine(key);
			line = ",A."+key;	//建立Template select 名稱
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append sixth
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			//key = changer.cutUnderLine(key);
			line = changer.createTemplateCondition(key);//condition 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append sixth-2
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			//key = changer.cutUnderLine(key);
			line = changer.createTemplateConditionRange(key);//condition 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
				
		//append sixth-3
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			//key = changer.cutUnderLine(key);
			line = changer.createTemplateFieldTag(key);//condition 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append seventh
		
		
		//append eighth
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			//key = changer.cutUnderLine(key);
			line = changer.createJqueryAttributeCode(beanName, javaWord, key);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append nineth
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			//key = changer.cutUnderLine(key);
			line = changer.createJqueryAttributeClearCode(beanName, javaWord);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append tenth
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createDataObjectFromRow(key, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append eleventh
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createReportSetMethod(beanName, key, javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 12th
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createPdfBeanVariables(javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 12th(-1)=>  basis field comment setter
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			//key = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			line = changer.createCommontSetMethod(beanName, javaWord, value);//condition 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		
		
		//append 12th-0  =>  basic field name setter
		bufferedWriter.newLine();

		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			//key = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			line = changer.createSetMethod(beanName, javaWord, value);//condition 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 12th-1  =>  createPdfBeanSetter
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createPdfBeanSetter(beanName, javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 12th-2  =>  createPdfBeanSetter
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createPdfBeanSetter(javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 12th-3  =>  createPdfBeanGetter
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createPdfBeanGetter(beanName, javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 12th-4  =>  createDataObjectSetter
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createDataObjectSetter(beanName, key, javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 12th-5 => createCommonSetter
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createCommonSetter(beanName, key, javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		
		
		//append 13
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.getToString(beanName, javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 14
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createKeyCommonString(key);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};
		
		//append 15
		bufferedWriter.newLine();
		
		fileReader = new FileReader(changer.beforeFile);
		bufferedReader = new BufferedReader(fileReader);
		line="";idx=0;
		while((line=bufferedReader.readLine())!= null){
			String key = changer.keyString(line);
			String javaWord = changer.cutUnderLine(key);
			String value = changer.valueString(line);
			//key = changer.cutUnderLine(key);
			line = changer.createValueCommonString("", javaWord, value);//("randomBean", javaWord);//javaScript field 屬性
			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.newLine();
		};

				
		//end print
		System.out.println("...[END]");
		bufferedWriter.close();
	}

	public String createGridColumnTag(String name, String index, String i18n, String comment){
		String newLine = "";
		newLine += "<%--"+name+":"+comment+":"+index+"--%>";//加上中文說明，不然不知道這行是甚麼。
		newLine += "\n<sjg:gridColumn name=\""+name+"\"";
		newLine += " index=\""+name+"\"";
		newLine += " title=\"%{getText('"+i18n+"')}\"";//這邊是i18n的設定
		//newLine += " title=\""+comment+"\"";//這邊是寫死的中文說明
		newLine += " width=\"80\" align=\"center\" hidden=\"true\" ";
		newLine += " sortable=\"true\"";
		newLine += " />";
		System.out.println(newLine);
		return newLine;
		//<sjg:gridColumn name="paAuditNo" index="paAuditNo" title="%{getText('paAuditNo')}" width="80" align="center"/>
	}
	
	public String createTemplateCondition(String key){
		String ans = "";
			ans += "<condition key=\""+key+"\" ";
			ans += "ignoreEmpty=\"true\"";
//			ans += "quote=\"false\"";
			ans += ">";
			ans += key+" = ${"+key+"}";
			ans += "</condition>";
			System.out.println(ans);
		return ans;
	}
	
	public String createTemplateConditionRange(String key){
		String ans = ""; 
		
//		ans += "<condition key=\""+key+"\" ";
//		ans += "ignoreEmpty=\"true\"";
////		ans += "quote=\"false\"";
//		ans += ">";
//		ans += key+" = "+"${"+key+"}"+"";
//		ans += "</condition>";
		
		ans += "<condition key=\""+key+"_S\" ";
		ans += "ignoreEmpty=\"true\"";
//		ans += "quote=\"false\"";
		ans += ">";
		ans += key+" >= "+"${"+key+"_S}"+"";
		ans += "</condition>";
		
		ans +="<condition key=\""+key+"_E\" ";
		ans += "ignoreEmpty=\"true\"";
//		ans += "quote=\"false\"";
		ans += ">";
		ans += "${"+key+"_E}"+" >= "+key+"";
		ans += "</condition>";
		
		ans += "<condition key=\""+key+"_L\" ";
		ans += "ignoreEmpty=\"true\"";
//		ans += "quote=\"false\"";
		ans += ">";
		ans += key+" like "+"${"+key+"_L}"+"";
		ans += "</condition>";
		
		System.out.println(ans);
		
		return ans;
	}
	
	/**
	 *  <field key="NAME" name="NAME" ignoreEmpty="true"/>
	  * createTemplateFieldTag 說明： <br>
	  * @param key
	  * @return <br>
	  * @author game<br>
	 */
	public String createTemplateFieldTag(String key){
		String ans = ""; 
		
		ans += "<field";
		ans += " key=\""+key+"\"";
		ans += " name=\""+key+"\"";
		ans += " ignoreEmpty=\"true\"";
//		ans += " value=\"AGE+1\"";
//		ans += " quote=\"false\"";
		ans += "/>";
//		ans += key+" = "+"${"+key+"}"+"";
//		ans += "</condition>";
		
		System.out.println(ans);
		
		return ans;
	}
	
	public String createTextFieldTag(String textName, String beanName, String titleName){
		beanName = beanName.length()>0?beanName+".":beanName;
		String ans = ""; 
		ans+="<tr>\n\t<td>\n";
		ans+="\t\t<!--"+textName+":"+titleName+"-->\n";
		ans+="\t\t<s:text name=\"pageBean."+textName+"\"/>\n";
		ans+="\t</td>\n\t<td>\n";
		ans+="\t\t<s:textfield name=\""+beanName+textName+"\"";
		ans+="/>";
		ans+="\n";
		ans+="\t</td>\n</tr>\n";
		return ans;
	}
	
	public String createHiddenTag(String textName, String beanName, String titleName){
		String ans = "";
		
		ans+="<s:hidden name=\""+beanName+"."+textName+"\"/>";
		ans+="<!--"+textName+":"+titleName+"-->";
		
		return ans;
	}
	
	//<td><s:submit name="btnQueryPaMfgCode" cssClass="btnNormal" value="查詢(廠商統編)" action = "RP03!queryPaMfgCode" style="width:120px" onClick="return false;">paMfgCode=廠商統編</s:submit></td>
	public String createButtonTag(String fieldName, String comment){
		String ans="<td><s:submit ";
		ans += "name=\""+prefixString("btn", fieldName)+"\" ";
		ans += "cssClass=\"btnNormal\" ";
		ans += "value=\"查詢("+comment+")\" ";
		ans += "action=\""+prefixString("RP03!query", fieldName)+"\" ";
		ans += "onClick=\"return false;\"> ";
		ans += fieldName+"="+comment;
		ans += "</s:submit></td>";
		return ans;
	}
	
	//$('#paAuditSource').attr('value',obj.paAuditSource);
	public String createJqueryAttributeCode(String beanName, String selector, String fieldName){
		beanName = beanName.length()>0?beanName+"_":beanName;
		String ans = "$('#"+beanName+selector+"').attr('value',rowData."+fieldName+");";
		return ans;
	}
	
	//$('#paAuditSource').attr('value',obj.paAuditSource);
	public String createJqueryAttributeClearCode(String beanName, String selector){
		beanName = beanName.length()>0?beanName+"_":beanName;
		String ans = "$('#"+beanName+selector+"').attr(\"value\", \"\");";
		return ans;
	}
	
	//pageBean.setBan("comment");//委任人統編
		public String createCommontSetMethod(String beanName, String fieldName, String comment){
			String ans="";
			beanName = beanName.length()>0?beanName+".":beanName;
			ans+=beanName+prefixString("set", fieldName);//"set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1)+"();";
//			ans+="(randomBean."+prefixString("get", fieldName)+"());";
			ans+="(\""+comment+"\");";
			ans+="//"+comment;
			return ans;
		}
	
	//pageBean.setBan(ban);//委任人統編
	public String createSetMethod(String beanName, String fieldName, String comment){
		String ans="";
		beanName = beanName.length()>0?beanName+".":beanName;
		ans+=beanName+prefixString("set", fieldName);//"set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1)+"();";
//		ans+="(randomBean."+prefixString("get", fieldName)+"());";
		ans+="("+fieldName+");";
		ans+="//"+comment;
		return ans;
	}
	
	//comment+"(field)="+beanName.getField()+
	//"承辦員姓名"+"(paRsvName)="+pageBean.getPaRsvName()+
	public String getToString(String beanName, String fieldName, String comment){
		String ans="\","+comment+"\"+\"("+fieldName+")=\"+";
		beanName = beanName.length()>0?beanName+".":beanName;
		ans+=beanName+prefixString("get", fieldName);//"set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1)+"();";
		ans+="()+";
		return ans;
	}
	
	//bean.setCategoryId(dataObject.getString("categoryId"));
	public String createReportSetMethod(String beanName, String key, String fieldName, String comment){
		String ans="";
		beanName = beanName.length()>0?beanName+".":beanName;
		ans+=beanName+prefixString("set", fieldName);//"set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1)+"();";
		if(fieldName.contains("Date")||fieldName.contains("date")){
			ans+="((Date)dataObjects.getValue(\""+key+"\"));";
		}else if(
				fieldName.contains("price")||fieldName.contains("Price")
				||fieldName.contains("cnt")||fieldName.contains("Cnt")
				||fieldName.contains("rate")||fieldName.contains("Rate")
				||fieldName.contains("tax")||fieldName.contains("Tax")
				||fieldName.contains("qty")||fieldName.contains("Qty")
				||fieldName.contains("weight")||fieldName.contains("Weight")
				||fieldName.contains("fine")||fieldName.contains("Fine")
				){
			ans+="((BigDecimal)dataObjects.getValue(\""+key+"\"));";
		}else{			
			ans+="(dataObjects.getString(\""+key+"\"));";
		}
		ans+="//"+comment;
		return ans;
	}
	
	public String createDataObjectFromRow(String fieldName, String comment){
		//PA_RECV_NO:$('#rmprcmmBean_paRecvNo').val(),
		String ans="";
		ans+=fieldName+":$('#pageBean_"+cutUnderLine(fieldName)+"').val(),";
		ans+="//"+comment;
		return ans;
	}
	
	public String createPdfBeanVariables(String fieldName, String comment){
		//private String paRecvNo;
		String ans = "";
		if(fieldName.contains("Date")||fieldName.contains("date")){
			ans="private Date "+fieldName;
		}else if(fieldName.contains("price")||fieldName.contains("Price")
				||fieldName.contains("cnt")||fieldName.contains("Cnt")
				||fieldName.contains("rate")||fieldName.contains("Rate")
				||fieldName.contains("tax")||fieldName.contains("Tax")
				||fieldName.contains("qty")||fieldName.contains("Qty")
				||fieldName.contains("weight")||fieldName.contains("Weight")
				||fieldName.contains("fine")||fieldName.contains("Fine")){
			ans="private BigDecimal "+fieldName;
		}else{
			ans="private String "+fieldName;
		}
		ans+=" = null;//"+comment;
		return ans;
	}
	
	public String createPdfBeanSetter(String beanName, String javaWord, String comment){
		//setPaRecvDateAbcd(bean.getPaRecvDateAbcd);
		String ans="";
		ans+=prefixString(beanName+".set", javaWord)+"(randomBean."+prefixString("get", javaWord)+"());";
		ans+="//"+comment;
		return ans;
	}
	
	public String createPdfBeanSetter(String javaWord, String comment){
		//setPaRecvDateAbcd(bean.getPaRecvDateAbcd);
		String ans="";
		ans+=prefixString("set", javaWord)+"("+javaWord+");";
		ans+="//"+comment;
		return ans;
	}
	
	//
	public String createPdfBeanGetter(String beanName, String javaWord, String comment){
		//bean.getPaRecvDateAbcd(),
		String ans="";
		ans+=prefixString(beanName+".get", javaWord)+"(),";
		ans+="//"+comment;
		return ans;
	}
	
	//dataObject.setValue("TRANS_ID", getTransId());
	public String createDataObjectSetter(String beanName, String fieldName, String javaWord, String comment){
		//bean.getPaRecvDateAbcd(),
		String ans="";
		ans+= beanName +".setValue(\""+fieldName+"\", "+ prefixString("this.get", javaWord)+"());";
		ans+="//"+comment;
		return ans;
	}
	
	//dataObject.setValue("TRANS_ID", getTransId());
	public String createCommonSetter(String beanName, String fieldName, String javaWord, String comment){
		//bean.getPaRecvDateAbcd(),
		String ans="";
		ans+= beanName +".setValue(\""+fieldName+"\", \""+ comment+"\");";
		ans+="//"+comment;
		return ans;
	}
	
	public String createKeyCommonString(String fieldName){
		String ans="";
		ans += "+ \", "+fieldName+"\"";
		return ans;
	}
	
	/**
	 * 希望產生的樣式 + ", "+this.getSn()//序號
	 * @param beanName
	 * @param fieldName
	 * @param comment
	 * @return
	 */
	public String createValueCommonString(String beanName, String javaWord, String comment){
		String ans="";
		beanName = beanName.length()>0?beanName+".":beanName;
		ans+="+\", '\"+"+beanName+prefixString("this.get", javaWord);//"set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1)+"();";
		ans+="()+\"'\"";
		ans+="//"+comment;
		return ans;
	}

	public String keyString(String line){
		return getColumnFromLine(line, 0);
	}
	
	public String typeString(String line){
		return getColumnFromLine(line, 1);
	}
	
	public String isNullString(String line){
		return getColumnFromLine(line, 2);
	}
	
	public String indexString(String line){
		return getColumnFromLine(line, 3);
	}
	
	public String commentString(String line){
		return getColumnFromLine(line, 4);
	}
	
	public String prefixString(String prefix, String javaWord){
		String ans = "";
		ans += prefix;
		ans += javaWord.substring(0, 1).toUpperCase();
		ans += javaWord.substring(1);
		return ans;
	}
	
	public String valueString(String line){
		int tail = line.lastIndexOf("\t");
		if(tail<0){tail = line.indexOf(",");}
		return line.substring(tail+1);
	}
	
	
	/**
	 * 把Line的內容透過指定的column index來分段取值。
	 * 分段的依據為"\t", "," 這兩種。
	 * @param line 該行文字字串
	 * @param index	指定的位置:0, 1, 2, ...
	 * @return String 指定位置的字串
	 */
	public String getColumnFromLine(String line, int index){
		String[] lineArr = line.split("\t");
		if(lineArr.length==1){lineArr = line.split(",");}
		return lineArr[index];
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
}