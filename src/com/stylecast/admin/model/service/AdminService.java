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
		int listCount = new AdminDao().selectListCount(conn, blackListYN);
		
		close(conn);
		return listCount;
	}

	public ArrayList<Member> selectList(PageInfo pi, String blackListYN) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao().selectList(conn,pi,blackListYN);
		close(conn);
		
		
		return list;
	}

}
