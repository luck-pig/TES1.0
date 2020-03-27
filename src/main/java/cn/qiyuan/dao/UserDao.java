package cn.qiyuan.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



/**
 * mybatise���ݽӿ�
 */

public interface UserDao {
	
	@Select("select * from user where username=#{name}")
	public List<Map<String, Object>> findByName(String name);
	
}
