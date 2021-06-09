package com.newlecture.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("adminHomeController")
@RequestMapping("/admin")
public class HomeController {
	
	@GetMapping("/index")
	public String index() {
		return "admin index page";
	}
	
	
	@PostMapping("/upload")
	public String upload(MultipartFile[] postFiles, HttpServletRequest request) {
		
		ServletContext application = request.getServletContext();
		String path = "/upload";
		String realPath = application.getRealPath(path);

		for(MultipartFile postFile : postFiles) {
			System.out.println(postFile.getSize());
			if (postFile.getSize() == 0) continue;
			String fileName = postFile.getOriginalFilename();
			
			File pathFile = new File(realPath);
			if(!pathFile.exists())
				pathFile.mkdirs();
			
			String filePath = realPath + File.separator + fileName;
			
			File saveFile = new File(filePath);
			
			try {
				postFile.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}

		}
		
		
		return "ok";
	}
}
