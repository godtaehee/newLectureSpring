package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.CommentDao;
import com.newlecture.web.entity.Comment;

public class MyBatisCommentDao implements CommentDao {

	
	@Autowired
	private SqlSession sqlSession;
	CommentDao mapper;
	
	
	public MyBatisCommentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(CommentDao.class);
	}
	
	@Override
	public Comment get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getList() {
		return mapper.getList(0,"","");
	}

	@Override
	public List<Comment> getList(int page) {
		return mapper.getList(page, "", "");
	}

	@Override
	public List<Comment> getList(int page, String field, String query) {
		return mapper.getList(page, field, query);
	}

	@Override
	public int getCount(String field, String query) {
		return mapper.getCount(field, query);
	}

	@Override
	public int insert(Comment comment) {
		return mapper.insert(comment);
	}

	@Override
	public int update(Comment comment) {
		return mapper.update(comment);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

}
