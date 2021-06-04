package com.stylecast.admin.model.dao;

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
import com.stylecast.theme.model.vo.Theme;

public class AdminDao {

	private Properties prop = new Properties();
	
	public AdminDao() {
		try {
			prop.loadFromXML(new FileInputStream( AdminDao.class.getResource("/sql/admin/admin-mapper.xml").getPath() ));
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
	
	public ArrayList<Theme> selectThemeList(Connection conn, PageInfo pi) {

		ArrayList<Theme> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectThemeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Theme(rset.getInt("theme_no"),
								   rset.getString("theme_title"),
								   rset.getString("theme_title_color"),
								   rset.getString("theme_subtitle"),
								   rset.getDate("enr_date"),
								   rset.getString("status")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertTheme(Connection conn, Theme t) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertTheme");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getThemeTitle());
			pstmt.setString(2, t.getThemeTitleColor());
			pstmt.setString(3, t.getThemeSubtitle());
			pstmt.setString(4, t.getStatus());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			PreparedStatement pstmt2 = null;
			ResultSet rset = null;
			String sql2 = prop.getProperty("selectThemeNo");
			
			try {
				pstmt2 = conn.prepareStatement(sql2);
				rset = pstmt2.executeQuery();
				
				if(rset.next()) {
					result = rset.getInt("theme_no");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt2);
			}
			
			return result;
		}else {
			return result;
		}
	}
	
	public int updateTheme(Connection conn, Theme t) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateTheme");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getThemeTitle());
			pstmt.setString(2, t.getThemeTitleColor());
			pstmt.setString(3, t.getThemeSubtitle());
			pstmt.setString(4, t.getStatus());
			pstmt.setInt(5, t.getThemeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public Theme selectTheme(Connection conn, int tno) {
		Theme t = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTheme");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				t = new Theme(rset.getInt("theme_no"),
							  rset.getString("theme_title"),
							  rset.getString("theme_title_color"),
							  rset.getString("theme_subtitle"),
							  rset.getDate("enr_date"),
							  rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return t;
	}

}
