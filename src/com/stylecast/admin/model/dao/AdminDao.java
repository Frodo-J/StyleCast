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
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.daily.model.vo.Report;
import com.stylecast.member.vo.Member;
import com.stylecast.theme.model.vo.Theme;
import com.stylecast.theme.model.vo.ThemePost;



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

	public int selectBlackListNCount(Connection conn) {
		// TODO Auto-generated method stub
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBlackListNCount");
  		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
/*
	public ArrayList<Member> selectList(Connection conn, PageInfo pi, String blackListYN) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, blackListYN);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
						rset.getString("mem_id"),
						rset.getString("mem_name"),
						rset.getString("mem_email"),
						rset.getString("black_yn"),
						rset.getInt("warning"))
						);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
*/
	public int selectBlackListYCount(Connection conn) {
		// TODO Auto-generated method stub
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBlackListYCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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

	public ArrayList<Member> selectMemberListBlackN(Connection conn, PageInfo pi) {
		
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberListBlackN");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
						rset.getString("mem_id"),
						rset.getString("mem_name"),
						rset.getString("mem_email"),
						rset.getString("black_yn"),
						rset.getInt("warning"))
						);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Member> selectMemberListBlackY(Connection conn, PageInfo pi) {
		
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberListBlackY");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1,startRow);
      pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
						rset.getString("mem_id"),
						rset.getString("mem_name"),
						rset.getString("mem_email"),
						rset.getString("black_yn"),
						rset.getInt("warning"))
						);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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


	public int updateMemberBlackY(Connection conn, int memNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMemberBlackY");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Report> selectReportList(Connection conn, PageInfo pi, int brCategory) {
		
		ArrayList<Report> list = new ArrayList<Report>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		
		System.out.println(startRow);
		System.out.println(endRow);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brCategory);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Report(rset.getInt("rpt_no"),
						rset.getString("content"),
						rset.getDate("enr_date"),
						brCategory,
						rset.getInt("daily_no"),
						rset.getString("rpt_category"),
						rset.getInt("cm_no"),
						rset.getString("mem_id"),
						rset.getString("rmem_id"))
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		
		return list;
	}

	public int deleteReport(Connection conn, String[] rptNoArr) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE REPORT SET STATUS = 'Y' WHERE RPT_NO IN (";

		for(int i = 0; i<((rptNoArr.length)-1); i++) {
			sql += rptNoArr[i] + ", ";
		}
		
		sql += rptNoArr[(rptNoArr.length)-1] + ")";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
      			
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


	public int processReport(Connection conn, String[] rptNoArr) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		/*
		String sql = prop.getProperty("processReport");
		
		String sql2 = "";
		for(int i = 0; i<((rptNoArr.length)-1); i++) {
			sql2 += rptNoArr[i] + ", ";
		}
		
		sql2 += rptNoArr[(rptNoArr.length)-1];
		*/
		
		String sql = "UPDATE MEMBER SET WARNING = WARNING + 1 WHERE MEM_NO IN (SELECT RMEM_NO FROM REPORT WHERE RPT_NO IN(";

		for(int i = 0; i<((rptNoArr.length)-1); i++) {
			sql += rptNoArr[i] + ", ";
		}
		
		sql += rptNoArr[(rptNoArr.length)-1] + "))";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Report> selectReportListByMemId(Connection conn, String text, int brCategory) {
		
		ArrayList<Report> list = new ArrayList<Report>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportListByMemId");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brCategory);
			pstmt.setString(2, text);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Report(rset.getInt("rpt_no"),
						rset.getString("content"),
						rset.getDate("enr_date"),
						brCategory,
						rset.getInt("daily_no"),
						rset.getString("rpt_category"),
						rset.getInt("cm_no"),
						rset.getString("mem_id"),
						rset.getString("rmem_id"))
						);
        			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}

	public ArrayList<Report> selectReportListByRmemId(Connection conn, String text, int brCategory) {
		
		ArrayList<Report> list = new ArrayList<Report>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportListByRmemId");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brCategory);
			pstmt.setString(2, text);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Report(rset.getInt("rpt_no"),
						rset.getString("content"),
						rset.getDate("enr_date"),
						brCategory,
						rset.getInt("daily_no"),
						rset.getString("rpt_category"),
						rset.getInt("cm_no"),
						rset.getString("mem_id"),
						rset.getString("rmem_id"))
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}

	public ArrayList<Report> selectReportListByRptCategory(Connection conn, String text, int brCategory) {
		
		ArrayList<Report> list = new ArrayList<Report>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportListByRptCategory");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brCategory);
			pstmt.setString(2, text);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Report(rset.getInt("rpt_no"),
						rset.getString("content"),
						rset.getDate("enr_date"),
						brCategory,
						rset.getInt("daily_no"),
						rset.getString("rpt_category"),
						rset.getInt("cm_no"),
						rset.getString("mem_id"),
						rset.getString("rmem_id"))
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}


	public ArrayList<ThemePost> selectThemePost(Connection conn, int tno) {
		ArrayList<ThemePost> plist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectThemePost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist.add(new ThemePost(rset.getInt("theme_no"),
										rset.getInt("daily_no"),
										rset.getString("daily_img")));
        			}
			
		} catch (SQLException e) {
			e.printStackTrace();
      		} finally {
      			close(rset);
			close(pstmt);
		}
				return plist;
	}
	
	public int deleteThemePost(Connection conn, int tno, int dno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteThemePost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			pstmt.setInt(2, dno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

	public int selectReportListCount(Connection conn, int brCategory) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportListCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brCategory);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
        			}
			
		} catch (SQLException e) {
			e.printStackTrace();
      }finally {
      			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public int selectReportListCountByMemId(Connection conn, String text, int brCategory) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportListCountByMemId");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brCategory);
			pstmt.setString(2, text);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public int selectReportListCountByRmemId(Connection conn, String text, int brCategory) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportListCountByRmemId");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brCategory);
			pstmt.setString(2, text);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public int selectReportListCountByRptCategory(Connection conn, String text, int brCategory) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportListCountByRptCategory");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brCategory);
			pstmt.setString(2, text);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}


	public int updateMemberBlackN(Connection conn, int memNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMemberBlackN");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selectListCountByMemberId(Connection conn, String text) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByMemberId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public int selectListCountByEmail(Connection conn, String text) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByEmail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public int selectListCountByMemName(Connection conn, String text) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByMemName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
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

	public ArrayList<Member> selectListByMemberId(Connection conn, PageInfo pi, String text) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListByMemberId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
						rset.getString("mem_id"),
						rset.getString("mem_name"),
						rset.getString("mem_email"),
						rset.getString("black_yn"),
						rset.getInt("warning"))
						);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	public ArrayList<Member> selectListByEmail(Connection conn, PageInfo pi, String text) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListByEmail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
						rset.getString("mem_id"),
						rset.getString("mem_name"),
						rset.getString("mem_email"),
						rset.getString("black_yn"),
						rset.getInt("warning"))
						);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Member> selectListByMemName(Connection conn, PageInfo pi, String text) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListByMemName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
						rset.getString("mem_id"),
						rset.getString("mem_name"),
						rset.getString("mem_email"),
						rset.getString("black_yn"),
						rset.getInt("warning"))
						);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Daily> selectDailyList(Connection conn, int tno) {
		ArrayList<Daily> dlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDailyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				dlist.add(new Daily(rset.getInt("daily_no"),
									rset.getInt("mem_no"),
									rset.getString("daily_content"),
									rset.getDate("enr_date"),
									rset.getString("daily_img"),
									rset.getString("tag"),
									rset.getString("mem_name"),
									rset.getString("prof_img"),
									rset.getInt("count_like"),
									rset.getInt("count_bm"),
									rset.getInt("count_cm")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return dlist;
	}
	
	public int insertTPost(Connection conn, int tno, int dno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertTPost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			pstmt.setInt(2, dno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectCodiListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCodiListCount");
		
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
	

