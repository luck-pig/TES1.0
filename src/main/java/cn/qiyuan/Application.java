package cn.qiyuan;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootApplication
@MapperScan("cn.qiyuan.dao")
public class Application {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(Application.class, args);
		
	}
	
	

}
