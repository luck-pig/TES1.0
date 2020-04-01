package cn.qiyuan.poi_test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListTest {
	
	@Test
	public void ListTest() throws IOException {
		
		Level0Titles level0Titles=new Level0Titles();
		level0Titles.setLevel1Num("");
		List<Level1Title> level1Titles=new ArrayList<Level1Title>();
		for(int l=1;l<11;l++) {
			Level1Title level1Title=new Level1Title();
			level1Title.setLevel1Num(Integer.toString(l));
			level1Title.setLevel1Desc("一级标题测试"+l);
			List<ParentTitle> parentTitles=new ArrayList<ParentTitle>();
			for(int k=1;k<11;k++) {
				ParentTitle parentTitle=new ParentTitle();
				parentTitle.setTitleNum(l+"."+k);
				parentTitle.setTitleDesc("二级级标题测试");
				List<SonTitle> sonTitles=new ArrayList<SonTitle>();

				SonTitle sonTitle=new SonTitle();
				for(int i=1;i<11;i++) {
					sonTitle=new SonTitle();
					sonTitle.setTitleNum(l+"."+k+"."+i);
					sonTitle.setTitleDesc("三级级标题测试");
					sonTitle.setContent("neirong");
					List<Param> params=new ArrayList<Param>();
					for (int j = 1; j < 11; j++) {
						Param param=new Param();
						param.setParamName("param"+j);
						param.setParamType("int"+j);
						param.setEq(j);
						params.add(param);
					}
					sonTitle.setClassName("className"+i);
					sonTitle.setClassDesc("classDesc"+i);
					sonTitle.setParams(params);
					sonTitle.setReturnType("String"+i);
					sonTitles.add(sonTitle);
				}

				parentTitle.setSonTitles(sonTitles);
				System.out.println(parentTitle.toString());
				parentTitles.add(parentTitle);
			}
			level1Title.setParentTitles(parentTitles);
			level1Titles.add(level1Title);
		}
		level0Titles.setLevel1Titles(level1Titles);
		
		
		
		HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();
		Configure config = Configure.newBuilder().bind("params",policy).build();
		
		XWPFTemplate template = XWPFTemplate.compile("src/test/resources/testTemp.docx",config).render(level0Titles);

        FileOutputStream out = new FileOutputStream("testx"+".docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
		
		
	}
	
	
}

class Level0Titles{
	public String level1Num;
	public List<Level1Title> level1Titles;
	public String getLevel1Num() {
		return level1Num;
	}
	public void setLevel1Num(String level1Num) {
		this.level1Num = level1Num;
	}
	public List<Level1Title> getLevel1Titles() {
		return level1Titles;
	}
	public void setLevel1Titles(List<Level1Title> level1Titles) {
		this.level1Titles = level1Titles;
	}
}

class Level1Title{
	public String level1Num;
	public String level1Desc;
	public String getLevel1Desc() {
		return level1Desc;
	}
	public void setLevel1Desc(String level1Desc) {
		this.level1Desc = level1Desc;
	}
	public List<ParentTitle> parentTitles;
	public String getLevel1Num() {
		return level1Num;
	}
	public void setLevel1Num(String level1Num) {
		this.level1Num = level1Num;
	}
	public List<ParentTitle> getParentTitles() {
		return parentTitles;
	}
	public void setParentTitles(List<ParentTitle> parentTitles) {
		this.parentTitles = parentTitles;
	}
}



