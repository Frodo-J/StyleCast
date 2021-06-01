package com.stylecast.member.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.commit;
import static com.stylecast.common.JDBCTemplate.getConnection;
import static com.stylecast.common.JDBCTemplate.rollback;

import java.sql.Connection;

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
}
