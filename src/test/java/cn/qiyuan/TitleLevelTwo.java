package cn.qiyuan;

import java.util.ArrayList;
import java.util.List;

import com.deepoove.poi.el.Name;

public class TitleLevelTwo {
	@Name("numLevel2")
	String  numLevel2;
	@Name("level2Title")
	String  level2Title;
	@Name("className")
	String className;
	
	List<TitleLevelThree> titles=new ArrayList<TitleLevelThree>();

	public String getNumLevel2() {
		return numLevel2;
	}

	public void setNumLevel2(String numLevel2) {
		this.numLevel2 = numLevel2;
	}

	public String getLevel2Title() {
		return level2Title;
	}

	public void setLevel2Title(String level2Title) {
		this.level2Title = level2Title;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<TitleLevelThree> getTitles() {
		return titles;
	}

	public void setTitles(List<TitleLevelThree> titles) {
		this.titles = titles;
	}
	
	
 
}
