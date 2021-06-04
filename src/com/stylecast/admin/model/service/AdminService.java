package com.stylecast.admin.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.admin.model.dao.AdminDao;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.theme.model.vo.Theme;

public class AdminService {

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new AdminDao().selectListCount(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Theme> selectThemeList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Theme> list = new AdminDao().selectThemeList(conn, pi);
		close(conn);
		return list;
	}
	
	public int insertTheme(Theme t) {
		Connection conn = getConnection();
		int result = new AdminDao().insertTheme(conn, t);
		close(conn);
		return result;
	}
	
	public int updateTheme(Theme t) {
		Connection conn = getConnection();
		int result = new AdminDao().updateTheme(conn, t);
		close(conn);
		return result;
	}
	
	public Theme selectTheme(int tno) {
		Connection conn = getConnection();
		Theme t = new AdminDao().selectTheme(conn, tno);
		close(conn);
		return t;
	}
}
