package cn.qiyuan;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;


import cn.qiyuan.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

	Logger logger=LoggerFactory.getLogger(getClass()); 

	@Autowired
	DataSource dataSource; 

	@Autowired
	UserDao userdao;
	//@Test
	public void tets() throws Exception {
		logger.info("11111");
		//logger.info(userDao.findByName("1").toString());

		System.out.println(dataSource.getClass());

		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		System.out.println(userdao.findByName("admin"));


		//System.out.println(userdao.findBy());
		connection.close();
	}




	//@Test
	public void listLevel() throws Exception {
		List<Map<String, Object>> datas=new ArrayList<Map<String,Object>>();
		Map<String,Object> data=  new HashMap<String, Object>();
		data.put("picture", new PictureRenderData(160, 160, "src/main/resources/static/dist/img/AdminLTELogo.png") );

		datas.add(data);
		XWPFTemplate template = XWPFTemplate.compile("src/main/resources/template.docx").render(datas);
		FileOutputStream out = new FileOutputStream("/template.docx");
		template.write(out); 
		out.flush();
		out.close();
		template.close();


	}

	//@Test
	public void orkTest() throws IOException {
		Map<String,Object> data=  new HashMap<String, Object>();
		UserTables userTables=new UserTables();
		List<User> users = new ArrayList<User>();
		users.add(new User("[username]","[passerword]","{{users}}"));
		users.add(new User("[username]","[passerword]","{{users}}"));
		users.add(new User("[username]","[passerword]","{{users}}"));
		users.add(new User("[username]","[passerword]","{{users}}"));
		userTables.setUsers(users);
		XWPFTemplate template = XWPFTemplate.compile("src/main/resources/template.docx").render(userTables);
		FileOutputStream out = new FileOutputStream("/output.docx");
		template.write(out); 
		out.flush();
		out.close();
		template.close();

	}

	@Test
	public void exportWord() throws IOException {
		//Map<String,Object> data=  new HashMap<String, Object>();
		UserList userList=new UserList();
		UserList userList1=new UserList();
		System.out.println(System.currentTimeMillis());
		long start=System.currentTimeMillis();
		List<User> users = new ArrayList<User>();
		for(int i=0;i<5;i++) {
			User user = new User("user"+i,"1234567"+i);
			users.add(user);
		}
		HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();
		HackLoopTableRenderPolicy policy1 = new HackLoopTableRenderPolicy();
		Configure config = Configure.newBuilder().bind("userss",policy)
				.bind("users", policy).build();
		userList.setUsers(users);
		userList1.setUsers(users);
		XWPFTemplate template = XWPFTemplate.compile("/output.docx",config).render(userList);
		FileOutputStream out = new FileOutputStream("/output1.docx");
		template.write(out); 
		out.flush();
		out.close();
		template.close();
		System.out.println(System.currentTimeMillis());
		long end=System.currentTimeMillis();

		System.out.println(end-start);
	}





}


class UserList{
	List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
