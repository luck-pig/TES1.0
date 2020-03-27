package cn.qiyuan;

import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.el.Name;

public class TitleLevelFour {

	@Name("numLevel4")
	String  numLevel4;
	@Name("level4Title")
	String  level4Title;
	String  content;
	MiniTableRenderData table;
	public String getLevel4Title() {
		return level4Title;
	}
	public void setLevel4Title(String level4Title) {
		this.level4Title = level4Title;
	}
	public String getNumLevel4() {
		return numLevel4;
	}
	public void setNumLevel4(String numLevel4) {
		this.numLevel4 = numLevel4;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MiniTableRenderData getTable() {
		return table;
	}
	public void setTable(MiniTableRenderData table) {
		this.table = table;
	}
	
}
