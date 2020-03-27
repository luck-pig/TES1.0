package cn.qiyuan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.qiyuan.dao.ClassDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassDaoTest {

	@Autowired
	ClassDao classDao;
	
	//@Test
	public void insertTrst() {
		for(int i=0;i<20;i++) {
			classDao.insertFunction("class"+i, "function"+i);
		}
		
	}
	
	@Test
	public void qryFunction() {
		System.out.println(classDao.qryFunction());
	}
	
}


