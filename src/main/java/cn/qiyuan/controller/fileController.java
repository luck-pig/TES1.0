package cn.qiyuan.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class fileController {
	
	@RequestMapping("/upload")
	public void upload(@RequestParam("file")MultipartFile file) throws IOException {
		String filePath=file.getOriginalFilename();
		BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(filePath));
		outputStream.write(file.getBytes());
		outputStream.flush();
		outputStream.close();
	}
}
