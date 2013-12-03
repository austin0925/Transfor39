package austin.tool;

import java.util.ArrayList;
import java.util.List;

import austin.bean.SQLBean;

public class CodeSyntaxPropertiesPattern {

	/**
	 * fieldName = "comment";
	 * @return
	 */
	public String getProperties(SQLBean sqlBean, String beanName, boolean isNull){
		String beanHeader = beanName.isEmpty()?"":sqlBean.toCamalWord(beanName)+"Bean.";
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String columnName = sqlBean.getColumnName();
		String ans = "";
		if(isNull){			
			ans += beanHeader+javaWord+"="+sqlBean.getComments();
		}else{
			ans += beanHeader+columnName+"="+sqlBean.getComments();
		}
		return ans;
	}

	/**
	 * 提供List的方法 fieldName = "comment";
	 * @param sqlBeanList
	 * @param beanName
	 * @return
	 */
	public List<String> getProperties(List<SQLBean> sqlBeanList, String beanName, boolean isNull){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getProperties(sqlBeans, beanName, isNull));
		}
		return outList;
	}
	
}
