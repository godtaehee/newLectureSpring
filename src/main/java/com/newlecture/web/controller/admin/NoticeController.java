package com.newlecture.web.controller.admin;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice/")
public class NoticeController { //noticeController
	
	@Autowired
	NoticeService service;
	
	@RequestMapping("list")
	//@ResponseBody
	public String list(Model model) {
		List<Notice> list = service.getList();
		//List<Notice> list = service.getList(1, "title", "");
		//List<Notice> list = service.getList(1, "title", "t");
		model.addAttribute("noticeList", list);
		
		return "admin.notice.list";
		//return "admin.notice.list";
		//return "/WEB-INF/view/admin/notice/list.jsp";
	}
	
	@RequestMapping("detail")
	public String detail(Model model, @RequestParam(name="id", defaultValue="0") Integer id) {
		
		Notice notice = service.getNotice(id);
		
		model.addAttribute("notice", notice);
		model.addAttribute("title", notice.getTitle());
		
		return "admin.notice.detail";
	}
	
	// /admin/notice/detail
	
	//@RequestMapping(value ="reg", method = RequestMethod.GET)
	@GetMapping("reg")
	public ModelAndView reg(
			@RequestParam(name = "f", defaultValue = "title") String field, 
			@RequestParam(defaultValue = "0") Integer x, 
			@RequestParam(defaultValue = "0") Integer y,/*, HttpServletRequest request*/
			@CookieValue(name = "test", defaultValue = "hi") String test,			
			MultipartFile file,
			HttpServletResponse response
			) {	
		
		if(test.equals("hi")) {
		   	Cookie cookie = new Cookie("test", "hello");
		   	cookie.setMaxAge(10*24*60*60);
		   	cookie.setPath("/");
		   	response.addCookie(cookie);
		   	
		   	//   /admin/notice/*
		   	//   /admin/notice/aa/bb/list
		   	//   /notice/list
	   	}
		
		// 1. Servlet API를 이용한 방법
		//String x_ = request.getParameter("x");
		//String y_ = request.getParameter("y");
		
		// 2. 파라미터 이름으로 자동 입력
//		int x = 0;
//		
//		if(x != null && x.) // 널인지 아닌지..
//			x = Integer.parseInt(x);				
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin.notice.reg");
		
		return mv;
		
		//return String.format("x_:%s, y_:%s", x_, y_) + "<br>" + String.format("x:%s, y:%s", x, y);
		//return String.format("x:%d, y:%d, result:%d, field:%s, test cookie:%s, uid:%s, id : %d", x, y, x+y, field, test, uid, id);
	}
	
	//@RequestMapping(value ="reg", method = RequestMethod.POST)
	@PostMapping("reg")
	public String reg(String title, String content) {		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriterId("test01");
		service.insert(notice);
		return "redirect:list";
	}
	
	
	@Autowired
	private NoticeDao noticeDao;
	
	@GetMapping("edit")
	public String edit(int id, Model model) {
		Notice notice = noticeDao.get(id);
		model.addAttribute("notice", notice);
		return "admin.notice.edit";
	}
	
	
	@PostMapping("edit")
	public String edit(Notice notice) {
		
		noticeDao.update(notice);
		
		return "redirect:detail?id=" + notice.getId();
	}
	
	@RequestMapping("del")
	public String del(@RequestParam(name="id", defaultValue="0") Integer id) {
	
		service.delNotice(id);
		return "redirect:list";
	}
	
	
}