package com.stylecast.main.model.dao;

import static com.stylecast.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.stylecast.main.model.vo.MainSelectCodiF;
import com.stylecast.main.model.vo.MainSelectCodiFR;
import com.stylecast.main.model.vo.MainSelectCodiM;
import com.stylecast.main.model.vo.MainSelectCodiMR;
import com.stylecast.main.model.vo.MainSelectDaily;

public class MainDao {

	private Properties prop = new Properties();
	
	public MainDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(MainDao.class.getResource("/sql/main/main-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<MainSelectDaily> MainSelectDaily(Connection conn){
		ArrayList<MainSelectDaily> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MainSelectDaily");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new MainSelectDaily(rset.getInt("daily_no"),
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
	
	public ArrayList<MainSelectCodiM> MainSelectCodiM(Connection conn, double Nowtemp){
		ArrayList<MainSelectCodiM> listC = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MainSelectCodiM");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, Nowtemp);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listC.add(new MainSelectCodiM(rset.getInt("codi_no"),
								    	 	 rset.getString("img_path")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listC;
		
	}
	
	public ArrayList<MainSelectCodiMR> MainSelectCodiMR(Connection conn, double Nowtemp){
		ArrayList<MainSelectCodiMR> listC = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MainSelectCodiMR");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, Nowtemp);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listC.add(new MainSelectCodiMR(rset.getInt("codi_no"),
								    	 	 rset.getString("img_path")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listC;
		
	}
	
	public ArrayList<MainSelectCodiF> MainSelectCodiF(Connection conn, double Nowtemp){
		ArrayList<MainSelectCodiF> listF = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MainSelectCodiF");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, Nowtemp);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listF.add(new MainSelectCodiF(rset.getInt("codi_no"),
								    	 	 rset.getString("img_path")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listF;
		
	}
	
	public ArrayList<MainSelectCodiFR> MainSelectCodiFR(Connection conn, double Nowtemp){
		ArrayList<MainSelectCodiFR> listC = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MainSelectCodiFR");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, Nowtemp);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listC.add(new MainSelectCodiFR(rset.getInt("codi_no"),
								    	 	 rset.getString("img_path")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listC;
		
	}
}
