package cn.qiyuan.poi_test;

public class Param {
	public String paramName;
	public String paramType;
	public int eq;
	public int getEq() {
		return eq;
	}
	public void setEq(int eq) {
		this.eq = eq;
	}
	@Override
	public String toString() {
		return "Param [paramName=" + paramName + ", paramType=" + paramType + ", eq=" + eq + "]";
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	
}
