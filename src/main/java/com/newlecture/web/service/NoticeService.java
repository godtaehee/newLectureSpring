package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;

public interface NoticeService {
	
	List<Notice> getList();
	
	List<Notice> getList(int page, String field, String query);
	
	int insert(Notice notice);
	int hitUp(int id);
	int likeUp(int id);

	Notice getNotice(Integer id);

	void delNotice(Integer id);
}