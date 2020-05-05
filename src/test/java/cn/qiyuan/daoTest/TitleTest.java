package cn.qiyuan.daoTest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.qiyuan.dao.TitleListDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TitleTest {
	@Autowired
	TitleListDao titleListDao;
	
	//@Test
	public void isert() {
		System.out.println(titleListDao.qryTitleList());
	}
	
	@Test
	public void insertTitle() {
		Map<String, Object> data=new HashMap<String, Object>();
		int count=1;
		for(int i=1;i<11;i++) {
			data.put("titleId", Integer.toString(i));
			data.put("level", 1);
			data.put("titleDesc", "一级标题测试"+i);
			data.put("parentId","");
			data.put("eq", count++);
			System.out.println(titleListDao.insertTitle(data));
			for(int j=1;j<11;j++) {
				data.put("titleId", i+"."+j);
				data.put("level", 2);
				data.put("titleDesc", "二级标题测试"+j);
				data.put("parentId",Integer.toString(i));
				data.put("eq", count++);
				System.out.println(titleListDao.insertTitle(data));
				for(int k=1;k<11;k++) {
					data.put("titleId", i+"."+j+"."+k);
					data.put("level", 3);
					data.put("titleDesc", "三级标题测试"+k);
					data.put("parentId",i+"."+j);
					data.put("eq", count++);
					System.out.println(titleListDao.insertTitle(data));
				}
			}
		}
	}
}
