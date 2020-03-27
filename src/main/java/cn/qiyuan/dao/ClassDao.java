package cn.qiyuan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ClassDao {
	
	@Insert("insert into class_to_function values('${className}','${functionName}')")
	public int insertFunction(String className,String functionName);
	
	@Select("select interface,method from class_to_function")
	public List<Map<String,String>>  qryFunction();

}

