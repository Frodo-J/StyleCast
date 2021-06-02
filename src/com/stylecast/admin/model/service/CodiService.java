package com.stylecast.admin.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.admin.model.dao.CodiDao;
import com.stylecast.admin.model.vo.Codi;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.daily.model.dao.DailyDao;
import com.stylecast.daily.model.vo.Daily;

public class CodiService {
	
	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new CodiDao().selectListCount(conn);

		close(conn);
		return listCount;
	}

	public ArrayList<Codi> selectCodiList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Codi> list = new CodiDao().SelectCodiList(conn, pi);
		
		close(conn);
		return list;
		
	}
	
	public Codi selectCodiUpdate(int codiNo) {
		Connection conn = getConnection();
		Codi c = new CodiDao().selectCodiUpdate(conn, codiNo);
		
		close(conn);
		return c;
	}
	
}
