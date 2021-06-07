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

import com.stylecast.admin.model.vo.Codi;
import com.stylecast.common.model.vo.PageInfo;

public class AdminDao {
	
	private Properties prop = new Properties();
	
	public AdminDao() {
		try {
			prop.loadFromXML(new FileInputStream(AdminDao.class.getResource("/sql/admin/admin-mapper.xml").getPath() ));
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
	
	public ArrayList<Codi> SelectCodiList(Connection conn, PageInfo pi) {
			
			ArrayList<Codi> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("SelectCodiList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Codi c = new Codi();
					c.setCodiNo(rset.getInt("codi_no"));
					c.setGender(rset.getString("gender"));
					c.setImgPath(rset.getString("img_path"));
					c.setRecWeather(rset.getString("rec_weather"));
					c.setRecLowT(rset.getInt("rec_lowt"));
					c.setRecHighT(rset.getInt("rec_hight"));
					
					list.add(c);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
	
	
	
	public Codi selectCodiUpdate(Connection conn, int codiNo) {
		Codi c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCodiUpdate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codiNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Codi(rset.getInt("codi_no"),
							 rset.getString("gender"),
							 rset.getString("img_path"),
							 rset.getString("rec_weather"),
							 rset.getInt("rec_lowt"),
							 rset.getInt("rec_hight"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}
	
	public int UpdateEnrollCodi(Connection conn, Codi c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("UpdateEnrollCodi");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getGender());
			pstmt.setString(2, c.getRecWeather());
			pstmt.setInt(3, c.getRecLowT());
			pstmt.setInt(4, c.getRecHighT());
			pstmt.setInt(5, c.getCodiNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int UpdateEnrollCodiImg(Connection conn, Codi c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("UpdateEnrollCodiImg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getGender());
			pstmt.setString(2, c.getImgPath());
			pstmt.setString(3, c.getRecWeather());
			pstmt.setInt(4, c.getRecLowT());
			pstmt.setInt(5, c.getRecHighT());
			pstmt.setInt(6, c.getCodiNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int insertCodi(Connection conn, Codi c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCodi");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getGender());
			pstmt.setString(2, c.getImgPath());
			pstmt.setString(3, c.getRecWeather());
			pstmt.setInt(4, c.getRecLowT());
			pstmt.setInt(5, c.getRecHighT());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int selectListCountByWeatherClear(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByWeatherClear");
		
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
	
	public int selectListCountByWeatherRain(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByWeatherRain");
		
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
	
	public int selectListCountByGender(Connection conn, String gender) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByGender");
		
		System.out.println(gender);
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender);
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
	
	public int selectListCountByBothRain(Connection conn, String gender) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByBothRain");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender);
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
	
	public int selectListCountByBothCLEAR(Connection conn, String gender) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByBothCLEAR");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender);
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

	public ArrayList<Codi> selectListByWeatherClear(Connection conn, PageInfo pi) {
		ArrayList<Codi> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListByWeatherClear");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Codi c = new Codi();
				c.setCodiNo(rset.getInt("codi_no"));
				c.setGender(rset.getString("gender"));
				c.setImgPath(rset.getString("img_path"));
				c.setRecWeather(rset.getString("rec_weather"));
				c.setRecLowT(rset.getInt("rec_lowt"));
				c.setRecHighT(rset.getInt("rec_hight"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Codi> selectListByWeatherRain(Connection conn, PageInfo pi) {
		ArrayList<Codi> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListByWeatherRain");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Codi c = new Codi();
				c.setCodiNo(rset.getInt("codi_no"));
				c.setGender(rset.getString("gender"));
				c.setImgPath(rset.getString("img_path"));
				c.setRecWeather(rset.getString("rec_weather"));
				c.setRecLowT(rset.getInt("rec_lowt"));
				c.setRecHighT(rset.getInt("rec_hight"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Codi> selectListByGender(Connection conn, String gender, PageInfo pi) {
		ArrayList<Codi> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListByGender");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, gender);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Codi c = new Codi();
				c.setCodiNo(rset.getInt("codi_no"));
				c.setGender(rset.getString("gender"));
				c.setImgPath(rset.getString("img_path"));
				c.setRecWeather(rset.getString("rec_weather"));
				c.setRecLowT(rset.getInt("rec_lowt"));
				c.setRecHighT(rset.getInt("rec_hight"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Codi> selectListByBothCLEAR(Connection conn, String gender, PageInfo pi) {
		ArrayList<Codi> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListByBothCLEAR");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, gender);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Codi c = new Codi();
				c.setCodiNo(rset.getInt("codi_no"));
				c.setGender(rset.getString("gender"));
				c.setImgPath(rset.getString("img_path"));
				c.setRecWeather(rset.getString("rec_weather"));
				c.setRecLowT(rset.getInt("rec_lowt"));
				c.setRecHighT(rset.getInt("rec_hight"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Codi> selectListByBothRain(Connection conn, String gender, PageInfo pi) {
		ArrayList<Codi> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListByBothRain");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, gender);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Codi c = new Codi();
				c.setCodiNo(rset.getInt("codi_no"));
				c.setGender(rset.getString("gender"));
				c.setImgPath(rset.getString("img_path"));
				c.setRecWeather(rset.getString("rec_weather"));
				c.setRecLowT(rset.getInt("rec_lowt"));
				c.setRecHighT(rset.getInt("rec_hight"));
				
				list.add(c);
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
