package cn.qiyuan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qiyuan.dao.UserDao;

@Controller 
@RequestMapping("/login")
public class LoginCtr {
	
	@Autowired
	UserDao userDao;
	
	public Logger logger=LoggerFactory.getLogger(getClass());
	
	@ResponseBody
	@RequestMapping("/login.do")
	public Map<String, Object> login(String username,String password) {
		List<Map<String, Object>> user=userDao.findByName(username);
		Map<String, Object> result=new HashMap<String, Object>();
		logger.info(user.toString());
		if(user==null) {  
			result.put("status", 1);
			result.put("setMsg", "该用户不存在");
			return result;
		}  
		// TODO Auto-generated method stub 
		logger.info(user.toString()); 
		if(!user.get(0).get("password").equals(password)) {
			result.put("status", 2);
			result.put("setMsg", "用户名或密码不正确");
			return result;
		} 
		 
		result.put("status", 0);
		result.put("setMsg", "登录成功");
		return result;
	
	}
	
	
	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}
}
