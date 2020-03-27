package cn.qiyuan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.el.Name;

public class TitleLevelThree {

	@Name("numLevel3")
	String  numLevel3;
	@Name("level3Title")
	String  level3Title;
	String  content;
	MiniTableRenderData table;
	List<TitleLevelFour> titles=new ArrayList<TitleLevelFour>();
	public MiniTableRenderData getTable() {
		return table;
	}
	
	public List<TitleLevelFour> getTitles() {
		return titles;
	}

	public void setTitles(List<TitleLevelFour> titles) {
		this.titles = titles;
	}

	public void setTable(MiniTableRenderData table) {
		this.table = table;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNumLevel3() {
		return numLevel3;
	}
	public void setNumLevel3(String numLevel3) {
		this.numLevel3 = numLevel3;
	}
	public String getLevel3Title() {
		return level3Title;
	}
	public void setLevel3Title(String level3Title) {
		this.level3Title = level3Title;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	@Name("methodName")
	String methodName;
	
}
