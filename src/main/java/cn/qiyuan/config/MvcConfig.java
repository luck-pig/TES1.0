package cn.qiyuan.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.qiyuan.interceptor.MyInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Bean
	public MyInterceptor mypInterceptor() {
		return new MyInterceptor();
	}
	 
	
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//registry.addInterceptor(mypInterceptor()).addPathPatterns("/*");
	}
	 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		//registry.addViewController("/hello").setViewName("success");
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/login.html").setViewName("login");
		registry.addViewController("/index").setViewName("index");
		//registry.addViewController("/functionManager").setViewName("functionManager");
		registry.addViewController("/ListManager").setViewName("ListManager");
		
	}
	
	
	

}
