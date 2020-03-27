package cn.qiyuan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.DocxRenderData;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.NumbericRenderData;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Poi_Tl_Test {
	
	
	public Titles datas;
	//@Before
	public void listTest() {
		
		
		Style style = new Style();
        style.setFontSize(10);
        style.setColor("7F7F7F");
        style.setFontFamily("微软雅黑");
		
		List<Title> titles = new ArrayList<Title>();
		for(int i=1;i<10;i++) {
			Title data0 = new Title();
	        data0.setNum("1."+i);
	        data0.setDesc("标题1."+i);
	        data0.setInetrfaceName("interfaceName");
	        TextRenderData textRenderData = new TextRenderData("{{+desc.doc}}") ;
	      //  textRenderData.setStyle(style);
	        data0.setResponsibility(new NumbericRenderData(NumbericRenderData.FMT_LOWER_ROMAN,
	                Arrays.asList(textRenderData)));
	        titles.add(data0);
		}
        datas.setTitle(new DocxRenderData(new File("src/test/resources/resume/segment.docx"), titles));
		
	}
	
	//@Test
    public void testResumeExample() throws Exception {
		
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("responsibility", new NumbericRenderData(new ArrayList<TextRenderData>() {
			  {
				    add(new TextRenderData("Plug-in function, define your own function"));
				    add(new TextRenderData("Supports word text, header..."));
				    add(new TextRenderData("Not just templates, but also style templates"));
				  }
				}));
		Map<String, Object> datass=new HashMap<String, Object>();
		Collection<Map<String, Object>> datas = null;
		datas.add(data);
		datas.add(data);
		datas.add(data);
		datass.put("datas", datas);
        XWPFTemplate template = XWPFTemplate.compile("src/test/resources/resume/segment.docx").render(datas);
        FileOutputStream out = new FileOutputStream("out_example_resume.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
	
	//@Test
	public void listTest1() {
		Map<String,Object> title=new HashMap<String, Object>();
		title.put("title","1.1 [tititit] lll\n\n1.2 []lklklklk] 222\n\n1.3[alalalal] \n\n{{+1.3.doc}}");
		XWPFTemplate template = XWPFTemplate.compile("src/test/resources/temp1.docx").render(title);
        FileOutputStream out;
		try {
			out = new FileOutputStream("out_example_resume.docx");
			template.write(out);
	        out.flush();
	        out.close();
	        template.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
	
	//@Test
	public void listTest2() throws IOException {
		
		TitleLevelTwo titleLevelTwo=new TitleLevelTwo();
		titleLevelTwo.setNumLevel2("2.x");
		titleLevelTwo.setLevel2Title("类描述");
		titleLevelTwo.setClassName("student");
		List<TitleLevelThree> titles=new ArrayList<TitleLevelThree>();
		TitleLevelThree titleLevelThree=null;
		for (int i = 1; i < 10; i++) {
			titleLevelThree=new TitleLevelThree();
			titleLevelThree.setNumLevel3("2."+i+".");
			titleLevelThree.setLevel3Title("接口描述");
			titleLevelThree.setMethodName("method"+i);
			titleLevelThree.setContent("{{+2_"+i+"_x_doc}}");
			RowRenderData header = new RowRenderData(Arrays.asList(new TextRenderData("FFFFFF", "Word处理解决方案"+i),
					new TextRenderData("FFFFFF", "是否跨平台"), new TextRenderData("FFFFFF", "易用性")), "ff9800");
			RowRenderData row0 = RowRenderData.build("Poi-tl", "纯Java组件，跨平台", "简单：模板引擎功能，并对POI进行了一些封装");
			RowRenderData row1 = RowRenderData.build("Apache Poi", "纯Java组件，跨平台", "简单，缺少一些功能的封装");
			RowRenderData row2 = RowRenderData.build("Freemarker", "XML操作，跨平台", "复杂，需要理解XML结构");
			RowRenderData row3 = RowRenderData.build("OpenOffice", "需要安装OpenOffice软件", "复杂，需要了解OpenOffice的API");
			RowRenderData row4 = RowRenderData.build("Jacob、winlib", "Windows平台", "复杂，不推荐使用");
			List<RowRenderData> tableDatas = Arrays.asList(row0, row1, row2, row3, row4);
			titleLevelThree.setTable(new MiniTableRenderData(header, tableDatas,MiniTableRenderData.WIDTH_A4_FULL));
			titles.add(titleLevelThree);
		}
		titleLevelTwo.setTitles(titles);
		
		XWPFTemplate template = XWPFTemplate.compile("src/test/resources/levelTwoTemp.docx").render(titleLevelTwo);

        FileOutputStream out = new FileOutputStream("out_iterable_story.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
		
	}
	
	//@Test
	public void listTest3() throws IOException {
		
		TitleLevelThree titleLevelThree=new TitleLevelThree();
		for(int levelThree=1;levelThree<10;levelThree++) {
			titleLevelThree=new TitleLevelThree();
			titleLevelThree.setNumLevel3("2."+levelThree+".x");
			titleLevelThree.setLevel3Title("三级标题");
			titleLevelThree.setContent("cccc");
			List<TitleLevelFour> titles=new ArrayList<TitleLevelFour>();
			TitleLevelFour titleLevelFour=null;
			for (int levelFour = 1; levelFour < 6; levelFour++) {
				titleLevelFour=new TitleLevelFour();
				titleLevelFour.setNumLevel4("2."+levelThree+"."+levelFour+".");
				titleLevelFour.setLevel4Title("四级标题");
				titleLevelFour.setContent("四级内容");
				RowRenderData header = new RowRenderData(Arrays.asList(new TextRenderData("FFFFFF", "Word处理解决方案"+"四级内容"),
						new TextRenderData("FFFFFF", "是否跨平台"), new TextRenderData("FFFFFF", "易用性")), "ff9800");
				RowRenderData row0 = RowRenderData.build("Poi-tl", "纯Java组件，跨平台", "简单：模板引擎功能，并对POI进行了一些封装");
				List<RowRenderData> tableDatas = Arrays.asList(row0);
				titleLevelFour.setTable(new MiniTableRenderData(header, tableDatas,MiniTableRenderData.WIDTH_A4_FULL));
				titles.add(titleLevelFour);
			}
			titleLevelThree.setTitles(titles);
			XWPFTemplate template = XWPFTemplate.compile("src/test/resources/levelThreeTemp/levelThreeTemp.docx").render(titleLevelThree);

	        FileOutputStream out = new FileOutputStream("2."+levelThree+".x"+".docx");
	        template.write(out);
	        out.flush();
	        out.close();
	        template.close();
		}
		
		
		
	}
	
	@Test
	public void listTest4() throws Exception {
		Map<String, Object> datas=new HashMap<String, Object>();
		
		for(int i=0;i<10;i++) {
			DocxRenderData segment = new DocxRenderData(new File("2."+i+".x"+".docx"));
			datas.put("2_"+i+"_x"+"_doc", segment);
		}
		
		XWPFTemplate template = XWPFTemplate.compile("out_iterable_story.docx").render(datas);

        FileOutputStream out = new FileOutputStream("out_example_story.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
		
	}
 
}


class Title{
	private String num;
	private String desc;
	private String inetrfaceName;
	private NumbericRenderData responsibility;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getInetrfaceName() {
		return inetrfaceName;
	}
	public void setInetrfaceName(String inetrfaceName) {
		this.inetrfaceName = inetrfaceName;
	}
	public NumbericRenderData getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(NumbericRenderData responsibility) {
		this.responsibility = responsibility;
	}
	
}

class Titles{
	private DocxRenderData title;

	public DocxRenderData getTitle() {
		return title;
	}

	public void setTitle(DocxRenderData title) {
		this.title = title;
	}
	
}
