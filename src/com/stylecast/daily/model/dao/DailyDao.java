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

import com.stylecast.common.model.vo.BoardImage;
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
	
	public int insertReportCM(Connection conn, Report r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReportCM");
		
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
						 			  rset.getString("enr_date"),
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
	
	public int[] selectCommentCountList(Connection conn, PageInfo pi) {

		int[] commentCount = new int[pi.getBoardLimit()];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCommentCountList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			int i = 0;
			
			while(rset.next()) {
				commentCount[i] = rset.getInt("comment_count");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return commentCount;
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
	
	
	
	public int insertDailyCM(Connection conn, DailyCM cm) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertDailyCM");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cm.getMemNo());
			pstmt.setInt(2, cm.getDailyNo());
			pstmt.setString(3, cm.getCmContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteDailyCM(Connection conn, DailyCM cm) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteDailyCM");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cm.getCmNo());
			pstmt.setInt(2, cm.getDailyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public Report checkReportCM(Connection conn, DailyCM cm) {
		Report r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("checkReportCM");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cm.getDailyNo());
			pstmt.setInt(2, cm.getCmNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r = new Report(rset.getInt("rpt_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return r;
		
	}
	
	public int selectDailyCount(Connection conn, String text) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDailyCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.setString(2, text);
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
	
	public ArrayList<Daily> selectDaily(Connection conn, PageInfo pi, String text){
		ArrayList<Daily> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDaily");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setString(2, text);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Daily(rset.getInt("daily_no"),
								   rset.getInt("mem_no"),
								   rset.getString("daily_content"),
								   rset.getDate("enr_date"),
								   rset.getString("daily_img"),
								   rset.getString("tag"),
								   rset.getString("mem_name"),
								   rset.getString("prof_img")));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	

	public int insertDaily(Connection conn, Daily d) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertDaily");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getMemNo());
			pstmt.setString(2, d.getDailyContent());
			pstmt.setString(3, d.getDailyImg());
			pstmt.setString(4, d.getTag());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	public int insertItem(Connection conn, ArrayList<Item> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertItem");
		
		try {			
			for(Item il : list) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, il.getItemName());
					pstmt.setString(2, il.getItemLink());
					pstmt.setString(3, il.getItemCategory());
					
					result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e)  {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	public int updateDaily(Connection conn, Daily d) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateDaily");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getDailyContent());
			pstmt.setString(2, d.getTag());
			pstmt.setInt(3, d.getDailyNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	public int updateItem(Connection conn, ArrayList<Item> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateItem");
		
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
		
		
	}

	public int[] selectSearchLikedCountList(Connection conn, PageInfo pi, String text) {
		
		int[] likeCount = new int[pi.getBoardLimit()];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSearchLikedCountList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setString(2, text);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
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

	public int[] selectSearchBookmarkCountList(Connection conn, PageInfo pi, String text) {
		
		int[] bookmarkCount = new int[pi.getBoardLimit()];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSearchBookmarkCountList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setString(2, text);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
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
	
	public int[] selectSearchCommentCountList(Connection conn, PageInfo pi, String text) {
		
		int[] commentCount = new int[pi.getBoardLimit()];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSearchCommentCountList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setString(2, text);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			int i = 0;
			
			while(rset.next()) {
				commentCount[i] = rset.getInt("daily_count");
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return commentCount;
	}
	
	public Report checkReportDaily(Connection conn, int tno) {
		Report r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("checkReportDaily");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r = new Report(rset.getInt("rpt_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return r;
	}
	
	
	public int deleteDailyComment(Connection conn, int dno) {
		
		PreparedStatement pstmt = null;
		int result1 = 0;
		String sql = prop.getProperty("deleteDailyComment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			
			result1 = pstmt.executeUpdate();
			result1++;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result1;
		
	}
	
	public int deleteItem(Connection conn, int dno) {
		
		
		PreparedStatement pstmt = null;
		int result2 = 0;
		String sql = prop.getProperty("deleteItem");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			
			result2 = pstmt.executeUpdate();
			result2++;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result2;
		
	}
	public int deleteDailyLike(Connection conn, int dno) {
		
		PreparedStatement pstmt = null;
		int result3 = 0;
		String sql = prop.getProperty("deleteDailyLike");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			
			result3 = pstmt.executeUpdate();
			result3++;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result3;
	}
	
	public int deleteBookmark(Connection conn, int dno) {
		
		PreparedStatement pstmt = null;
		int result4 = 0;
		String sql = prop.getProperty("deleteBookmark");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			
			result4 = pstmt.executeUpdate();
			result4++;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result4;
	}
	
	public int deleteTrendingPost(Connection conn, int dno) {
		
		PreparedStatement pstmt = null;
		int result5 = 0;
		String sql = prop.getProperty("deleteTrendingPost");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			
			result5 = pstmt.executeUpdate();
			result5++;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result5;
	}
	
	public int deleteDaily(Connection conn, int dno) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteDaily");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
