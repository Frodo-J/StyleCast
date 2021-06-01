package com.stylecast.theme.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.theme.model.dao.ThemeDao;
import com.stylecast.theme.model.vo.Theme;
import com.stylecast.theme.model.vo.ThemePost;

public class ThemeService {

	public Theme selectThemeMonthly() {
		Connection conn = getConnection();
		Theme t = new ThemeDao().selectThemeMonthly(conn);
		close(conn);
		return t;
	}
	
	public ArrayList<ThemePost> selectThemePost(int tno) {
		Connection conn = getConnection();
		ArrayList<ThemePost> tlist = new ThemeDao().selectThemePost(conn, tno);
		close(conn);
		return tlist;
	}
}
