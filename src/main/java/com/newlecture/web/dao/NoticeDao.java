package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

// SQL을 대신하는 녀석
// select 반환,필터링,정렬,집계,....
// 데이터 조작d
// update -> hitup
public interface NoticeDao {
	
	Notice get(int id);
	
	List<Notice> getList(); // 필터링, 정렬, 페이징, 집계
	
	List<Notice> getList(int page); // 필터링, 정렬, 페이징, 집계
	
	List<Notice> getList(int page, String field, String query); // 필터링, 정렬, 페이징, 집계
	
	List<NoticeView> getViewList(int page, String field, String query);
	
	int getCount(String field, String query);
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	//int hitUp();
	//int likeUp(int id);
	
	Notice getNotice(Integer id);
	
}