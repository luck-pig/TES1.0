package cn.qiyuan.controller;


import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.internal.path.ArraySliceOperation;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;



@Controller

@Log4j
public class HelloController {
	  
	  
	@Autowired
	private  DataSource datasource;
	
	
	
	
}
