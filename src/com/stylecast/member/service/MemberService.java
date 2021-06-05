package com.stylecast.member.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.commit;
import static com.stylecast.common.JDBCTemplate.getConnection;
import static com.stylecast.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.daily.model.vo.Daily;
import com.stylecast.member.dao.MemberDao;
import com.stylecast.member.vo.Member;

public class MemberService {

	public Member loginMember(String memId, String memPwd) {
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, memId, memPwd);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public String MemberFindId(String email) {
		Connection conn = getConnection();
		String memId = new MemberDao().MemberFindId(conn, email);
		close(conn);
		return memId;
	}
	
	public String MemberFindPwd(Member m) {
		Connection conn = getConnection();
		String memPwd = new MemberDao().MemberFindPwd(conn, m);
		close(conn);
		return memPwd;
	}

	public int deleteMember(String memId) {

		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, memId);
		close(conn);
		
		return result;
		
	}

	public int insertBookmark(int memNo, int dailyNo) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertBookmark(conn, memNo, dailyNo);
		close(conn);
		
		return result;
	}

	public int deleteBookmark(int memNo, int dailyNo) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteBookmark(conn, memNo, dailyNo);
		close(conn);
		
		return result;
	}

	public ArrayList<Daily> selectMyBookmarkList(int memNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Daily> list = new MemberDao().selectMyBookmarkList(conn, memNo);
		close(conn);
		
		return list;
	}

	public ArrayList<Daily> selectMyLikeList(int memNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Daily> list = new MemberDao().selectMyLikeList(conn, memNo);
		close(conn);
		
		return list;
	}
	
	public int idCheck(String checkId) {
		Connection conn = getConnection();
		int count = new MemberDao().idCheck(conn, checkId);
		close(conn);
		return count;
	}
}
