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
import com.stylecast.daily.model.vo.Report;
import com.stylecast.member.vo.Member;
import com.stylecast.notice.model.vo.Notice;

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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		//String sql = prop.getProperty("deleteReport");
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


}
