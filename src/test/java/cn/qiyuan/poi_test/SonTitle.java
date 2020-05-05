package cn.qiyuan.poi_test;

import java.util.List;

import com.deepoove.poi.data.MiniTableRenderData;

public class SonTitle extends ParentTitle{
	public String content;
	public MiniTableRenderData table;
	public String className;
	public List<Param> params;
	public String classDesc;
	public String returnType;
	public TableData tableData;
	public TableData getTableData() {
		return tableData;
	}
	public void setTableData(TableData tableData) {
		this.tableData = tableData;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String conent) {
		this.content = conent;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Param> getParams() {
		return params;
	}
	public void setParams(List<Param> params) {
		this.params = params;
	}
	
	public String getClassDesc() {
		return classDesc;
	}
	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public MiniTableRenderData getTable() {
		return table;
	}
	public void setTable(MiniTableRenderData table) {
		this.table = table;
	}
	@Override
	public String toString() {
		return "SonTitle [content=" + content + ", table=" + table + ", className=" + className + ", params=" + params
				+ ", classDesc=" + classDesc + ", returnType=" + returnType + "]";
	}
}
