package com.newlecture.web.entity;

import java.util.Date;

public class Comment {
	
	private int id;
	private String content;
	private Date regDate;
	private int writerId;
	private int noticeId;
	
	public Comment() {}
	
	public Comment(int id, String content, Date regDate, int writerId, int noticeId) {
		super();
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.writerId = writerId;
		this.noticeId = noticeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	
	
	

}
