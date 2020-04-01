package cn.qiyuan.poi_test;

import java.util.List;
import java.util.Map;

public class ParentTitle {
	public String titleNum;
	public String titleDesc;
	private List<SonTitle> sonTitles;
	public String getTitleNum() {
		return titleNum;
	}
	public void setTitleNum(String titleNum) {
		this.titleNum = titleNum;
	}
	public String getTitleDesc() {
		return titleDesc;
	}
	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}
	public List<SonTitle> getSonTitles() {
		return sonTitles;
	}
	public void setSonTitles(List<SonTitle> sonTitles) {
		this.sonTitles = sonTitles;
	}
	@Override
	public String toString() {
		return "ParentTitle [titleNum=" + titleNum + ", titleDesc=" + titleDesc + ", sonTitles=" + sonTitles + "]";
	}
	
	
}
