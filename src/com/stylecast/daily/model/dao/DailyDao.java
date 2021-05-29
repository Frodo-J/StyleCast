package com.stylecast.daily.model.dao;

import static com.stylecast.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.daily.model.vo.Report;

public class DailyDao {
	
	private Properties prop = new Properties();
	
	public DailyDao() {
		try {
			prop.loadFromXML(new FileInputStream( DailyDao.class.getResource("/sql/daily/daily-mapper.xml").getPath() ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectListCount(Connection conn) {
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
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Daily> selectDailyList(Connection conn, PageInfo pi) {
		
		ArrayList<Daily> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDailyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Daily d = new Daily();
				d.setDailyNo(rset.getInt("daily_no"));
				d.setMemNo(rset.getInt("mem_no"));
				d.setDailyContent(rset.getString("daily_content"));
				d.setEnrDate(rset.getDate("enr_date"));
				d.setDailyImg(rset.getString("daily_img"));
				d.setMemName(rset.getString("mem_name"));
				d.setProfImg(rset.getString("prof_img"));
				
				list.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertReportDaily(Connection conn, Report r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReportDaily");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, r.getrMemNo());
			pstmt.setString(3, r.getContent());
			pstmt.setInt(4, r.getDailyNo());
			pstmt.setString(5, r.getRptCategory());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
