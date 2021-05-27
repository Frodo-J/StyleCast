package com.stylecast.notice.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.stylecast.common.JDBCTemplate.*;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.notice.model.vo.Notice;

public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(NoticeDao.class.getResource("/sql/notice/notice-mapper.xml").getPath()));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Notice> selectNoticeList(Connection conn) {
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
									rset.getString("mem_name"),
									rset.getString("notice_title"),
									rset.getDate("enr_date")
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int selectListCount(Connection conn) {
		// TODO Auto-generated method stub
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public ArrayList<Notice> selectList(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
						rset.getString("mem_id"),
						rset.getString("notice_title"),
						rset.getDate("enr_date")
						));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int increaseCount(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Notice selectNotice(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice(rset.getInt("notice_no"),
							   rset.getString("mem_name"),
							   rset.getString("notice_title"),
							   rset.getString("notice_content"),
							   rset.getInt("count"),
							   rset.getDate("enr_date"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}

}
