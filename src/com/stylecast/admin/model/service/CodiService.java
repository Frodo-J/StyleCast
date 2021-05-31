package com.stylecast.admin.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.admin.model.dao.CodiDao;
import com.stylecast.admin.model.vo.Codi;
import com.stylecast.common.model.vo.PageInfo;

public class CodiService {
	
	public int selectListCount1() {
		Connection conn = getConnection();
		int listCount = new CodiDao().selectListCount1(conn);

		close(conn);
		return listCount;
	}

	public ArrayList<Codi> selectCodiList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Codi> list = new CodiDao().SelectCodiList(conn, pi);
		
		close(conn);
		return list;
		
	}
	
}
