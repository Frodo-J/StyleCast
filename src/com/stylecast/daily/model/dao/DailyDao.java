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
import com.stylecast.daily.model.vo.DailyCM;
import com.stylecast.daily.model.vo.Item;
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
			pstmt.setInt(1, r.getMemNo());
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
	
	public int insertReportCm(Connection conn, Report r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReportCm");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getMemNo());
			pstmt.setInt(2, r.getrMemNo());
			pstmt.setString(3, r.getContent());
			pstmt.setInt(4, r.getDailyNo());
			pstmt.setString(5, r.getRptCategory());
			pstmt.setInt(6, r.getCmNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Daily selectDailyDetail(Connection conn, int dailyNo) {
		Daily d = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDailyDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dailyNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				d = new Daily(rset.getInt("daily_no"),
							  rset.getInt("mem_no"),
							  rset.getString("daily_content"),
							  rset.getDate("enr_date"),
							  rset.getString("daily_img"),
							  rset.getString("tag"),
							  rset.getString("mem_name"),
							  rset.getString("prof_img"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return d;
	}
	
	public ArrayList<Item> selectDailyItem(Connection conn, int dailyNo) {
		ArrayList<Item> iList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDailyItem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dailyNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				iList.add(new Item(rset.getInt("item_no"),
							  	   rset.getString("item_name"),
							       rset.getString("item_link"),
							       rset.getString("item_category")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return iList;
	}
	
	public ArrayList<DailyCM> selectDailyCM(Connection conn, int dailyNo) {
		ArrayList<DailyCM> cList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDailyCM");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dailyNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				cList.add(new DailyCM(rset.getInt("cm_no"),
						 			  rset.getInt("mem_no"),
						 			  rset.getString("cm_content"),
						 			  rset.getDate("enr_date"),
						 			  rset.getString("mem_name"),
						 			  rset.getString("prof_img")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cList;
	}

	public ArrayList<Daily> selectMyDailyList(Connection conn, int memNo) {
		
		ArrayList<Daily> list = new ArrayList<Daily>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyDailyList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
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

	public int selectMyDailyListCount(Connection conn, int memNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyDailyListCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
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

	public int checkLiked(Connection conn, int memNo, int dailyNo) {

		int likeYN = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("checkLiked");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, dailyNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				likeYN = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return likeYN;
	}

	public int checkBookmark(Connection conn, int memNo, int dailyNo) {

		int bookmarkYN = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("checkBookmark");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, dailyNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bookmarkYN = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return bookmarkYN;
	}

	public int selectLikedCount(Connection conn, int dailyNo) {
		
		int likeCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLikedCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dailyNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				likeCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return likeCount;
	}

	public int selectBookmarkCount(Connection conn, int dailyNo) {
		
		int bookmarkCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookmarkCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dailyNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bookmarkCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return bookmarkCount;
	}

	public int selectMyBookmarkListCount(Connection conn, int memNo) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyBookmarkListCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}

	public int[] selectLikedCountList(Connection conn, PageInfo pi) {
		
		int[] likeCount = new int[pi.getBoardLimit()];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLikedCountList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			int i = 0;
			
			while(rset.next()) {
				likeCount[i] = rset.getInt("daily_count");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return likeCount;
	}

	public int[] selectBookmarkCountList(Connection conn, PageInfo pi) {
		
		int[] bookmarkCount = new int[pi.getBoardLimit()];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookmarkCountList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			int i = 0;
			
			while(rset.next()) {
				bookmarkCount[i] = rset.getInt("bookmark_count");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookmarkCount;
	}

	public int insertLike(Connection conn, int memNo, int dailyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertLike");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, dailyNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteLike(Connection conn, int memNo, int dailyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteLike");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, dailyNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int[] selectLikedCountList(Connection conn, int memNo, int count) {
		
		int[] likeCount = new int[count];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyLikedCountList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			int i = 0;
			
			while(rset.next()) {
				likeCount[i] = rset.getInt("daily_count");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return likeCount;
	}

	public int[] selectBookmarkCountList(Connection conn, int memNo, int count) {
		int[] bookmarkCount = new int[count];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyBookmarkCountList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			int i = 0;
			
			while(rset.next()) {
				bookmarkCount[i] = rset.getInt("daily_count");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookmarkCount;
	}

	public int[] selectLikedCountBk(Connection conn, int memNo, int count) {
		
		int[] likeCount = new int[count];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLikedCountBk");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			int i = 0;
			
			while(rset.next()) {
				likeCount[i] = rset.getInt("daily_count");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return likeCount;
	}

	public int[] selectBookmarkCountBk(Connection conn, int memNo, int count) {
		int[] bookmarkCount = new int[count];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookmarkCountBk");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			int i = 0;
			
			while(rset.next()) {
				bookmarkCount[i] = rset.getInt("daily_count");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookmarkCount;
	}
	
	
	
}
