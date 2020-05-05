package cn.qiyuan.dao;

import java.util.List;
import java.util.Map;

public interface TitleListDao {
	
	public int insertTitle(Map<String, Object> data);
	
	public List<Map<String, Object>> qryTitleList();

}
