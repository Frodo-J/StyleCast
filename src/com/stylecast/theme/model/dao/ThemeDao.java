package com.stylecast.theme.model.dao;

import static com.stylecast.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.stylecast.theme.model.vo.Theme;
import com.stylecast.theme.model.vo.ThemePost;

public class ThemeDao {

	private Properties prop = new Properties();
	
	public ThemeDao() {
		try {
			prop.loadFromXML(new FileInputStream( ThemeDao.class.getResource("/sql/theme/theme-mapper.xml").getPath() ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Theme selectThemeMonthly(Connection conn) {
		Theme t = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectThemeMonthly");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				t = new Theme(rset.getInt("theme_no"),
							  rset.getString("theme_title"),
							  rset.getString("theme_title_color"),
							  rset.getString("theme_subtitle"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return t;
	}
	
	public ArrayList<ThemePost> selectThemePost(Connection conn, int tno) {
		ArrayList<ThemePost> tlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectThemePost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				tlist.add(new ThemePost(rset.getInt("daily_no"),
										rset.getString("daily_img")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return tlist;
		
	}
	
}
