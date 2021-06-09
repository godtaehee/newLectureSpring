package com.newlecture.web.dao.jdbc;

import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public Notice get(int id) {
		
		Notice notice = null;
		/*
		String sql = "SELECT * FROM NOTICE WHERE ID="+id;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			//int id = rs.getInt("id");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writerId = rs.getString("writer_id");
			Date regDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			
			//System.out.printf("id:%d, nicname:%s, pwd:%s\n", id, nicName, pwd);
			notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setContent(content);
			notice.setWriterId(writerId);
			notice.setRegDate(regDate);
			notice.setHit(hit);
			notice.setFiles(files);									
		}
		
		rs.close();
		st.close();
		con.close();
		*/
		
		return notice;
	}

	@Override
	public List<Notice> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int page, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Notice getNotice(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeView> getViewList(int page, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return 0;
	}

}