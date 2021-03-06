package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Comment;

public interface CommentDao {
	Comment get(int id);
	
	List<Comment> getList(); 
	
	List<Comment> getList(int page); // 필터링, 정렬, 페이징, 집계
	
	List<Comment> getList(int page, String field, String query); // 필터링, 정렬, 페이징, 집계
	
//	List<NoticeView> getViewList(int page, String field, String query);
	
	int getCount(String field, String query);
	int insert(Comment comment);
	int update(Comment comment);
	int delete(int id);
}
