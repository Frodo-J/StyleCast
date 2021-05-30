package com.stylecast.member.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.stylecast.common.JDBCTemplate.*;
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
	
	public int updateMember(Connection conn, Member m) {
			
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
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
	
	
	
}
