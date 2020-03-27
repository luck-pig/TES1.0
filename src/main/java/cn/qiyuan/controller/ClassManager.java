package cn.qiyuan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qiyuan.dao.ClassDao;

@Controller
public class ClassManager {
	@Autowired
	ClassDao classDao;

	@ResponseBody
	@RequestMapping("/qryFunction.do")
	public List<Map<String, String>> qryMethod(){
		return classDao.qryFunction();
	}
	
	@RequestMapping("/functionManager")
	public String functionManager(Model model) {
		model.addAttribute("className", "voice");
		return "functionManager";
	}
	
}
