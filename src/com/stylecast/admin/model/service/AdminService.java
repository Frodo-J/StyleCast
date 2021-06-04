package com.stylecast.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.admin.model.dao.AdminDao;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.member.vo.Member;
import static com.stylecast.common.JDBCTemplate.*;

public class AdminService {

	public int selectListCount(String blackListYN) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = 0;
		if(blackListYN.equals("N")) {
			listCount = new AdminDao().selectBlackListNCount(conn);
		}else if(blackListYN.equals("Y")){
			listCount = new AdminDao().selectBlackListYCount(conn);
		}
		close(conn);
		return listCount;
	}

	public ArrayList<Member> selectList(PageInfo pi, String blackListYN) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Member> list = null;
		if(blackListYN.equals("N")) {
			list = new AdminDao().selectMemberListBlackN(conn,pi);
		}else if(blackListYN.equals("Y")){
			list = new AdminDao().selectMemberListBlackY(conn,pi);
		}
		close(conn);
		
		
		return list;
	}

	public int updateMemberBlackY(int memNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new AdminDao().updateMemberBlackY(conn, memNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

}
