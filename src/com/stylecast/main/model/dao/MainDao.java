package com.stylecast.main.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.stylecast.main.model.vo.Main;
import static com.stylecast.common.JDBCTemplate.*;

public class MainDao {

	private Properties prop = new Properties();
	
	public MainDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(MainDao.class.getResource("/sql/main/main-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Main> selectMainList(Connection conn){
		ArrayList<Main> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMainList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Main(rset.getInt("daily_no"),
								  rset.getString("daily_img")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	
}
