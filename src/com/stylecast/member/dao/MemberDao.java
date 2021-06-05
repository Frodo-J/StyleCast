package com.stylecast.member.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.stylecast.common.JDBCTemplate.*;

import com.stylecast.daily.model.vo.Daily;
import com.stylecast.member.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Member loginMember(Connection conn, String memId, String memPwd) {
		//select문 => ResultSet 객체로 한행 만 가져감  (Member객체로)
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("mem_no"),
							   rset.getString("mem_id"),
							   rset.getString("mem_pwd"),
							   rset.getString("mem_name"),
							   rset.getString("mem_email"),
							   rset.getString("mem_gender"),
							   rset.getDate("enroll_date"),
							   rset.getString("black_yn"),
							   rset.getString("ent_yn"),
							   rset.getInt("warning"),
							   rset.getString("admin_yn"),
							   rset.getDate("update_date"),
							   rset.getDate("ent_date"),
							   rset.getString("prof_img"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPwd());
			pstmt.setString(3, m.getMemName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getGender());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		System.out.println(m.getMemPwd() + ", " + m.getMemName() + ", " + m.getEmail() + ", " + m.getGender() + ", " + m.getMemId());
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemPwd());
			pstmt.setString(2, m.getMemName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getMemId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String checkMember(Connection conn, String memId) {
		
		String memPwd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("checkMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memPwd = rset.getString("mem_pwd");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memPwd;
	}
	
	public String MemberFindId(Connection conn, String email) {
		String memId = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemberId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memId = rset.getString("mem_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memId;
	}
	
	public String MemberFindPwd(Connection conn, Member m) {
		String memPwd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemberPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getEmail());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memPwd = rset.getString("mem_pwd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memPwd;
	}
	
	public int idCheck(Connection conn, String chekId) {
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("idCheck");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chekId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	
	public Member selectMember(Connection conn, String userId) {
		
		Member updateMem = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				updateMem = new Member(rset.getInt("mem_no"),
						   rset.getString("mem_id"),
						   rset.getString("mem_pwd"),
						   rset.getString("mem_name"),
						   rset.getString("mem_email"),
						   rset.getString("mem_gender"),
						   rset.getDate("enroll_date"),
						   rset.getString("black_yn"),
						   rset.getString("ent_yn"),
						   rset.getInt("warning"),
						   rset.getString("admin_yn"),
						   rset.getDate("update_date"),
						   rset.getDate("ent_date"),
						   rset.getString("prof_img"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return updateMem;
	}

	public int deleteMember(Connection conn, String memId) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBookmark(Connection conn, int memNo, int dailyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBookmark");
		
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

	public int deleteBookmark(Connection conn, int memNo, int dailyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBookmark");
		
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

	public ArrayList<Daily> selectMyBookmarkList(Connection conn, int memNo) {
		
		ArrayList<Daily> list = new ArrayList<Daily>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyBookmarkList");
		
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

	public ArrayList<Daily> selectMyLikeList(Connection conn, int memNo) {
		
		ArrayList<Daily> list = new ArrayList<Daily>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyLikeList");
		
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
	
	
	
	
}
