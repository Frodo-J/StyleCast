package com.stylecast.admin.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.admin.model.dao.AdminDao;
import com.stylecast.admin.model.vo.Codi;
import com.stylecast.common.model.vo.PageInfo;

public class AdminService {
	
	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new AdminDao().selectListCount(conn);

		close(conn);
		return listCount;
	}

	public ArrayList<Codi> selectCodiList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Codi> list = new AdminDao().SelectCodiList(conn, pi);
		
		close(conn);
		return list;
		
	}
	
	public Codi selectCodiUpdate(int codiNo) {
		Connection conn = getConnection();
		Codi c = new AdminDao().selectCodiUpdate(conn, codiNo);
		
		close(conn);
		return c;
	}
	
}
