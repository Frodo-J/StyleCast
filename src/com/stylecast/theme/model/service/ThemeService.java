package com.stylecast.theme.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.daily.model.vo.Daily;
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
		ArrayList<ThemePost> plist = new ThemeDao().selectThemePost(conn, tno);
		close(conn);
		return plist;
	}
	
	public ArrayList<Theme> selectThemeList() {
		Connection conn = getConnection();
		ArrayList<Theme> tlist = new ThemeDao().selectThemeList(conn);
		close(conn);
		return tlist;
	}
	
	public ArrayList<Daily> selectOtherPost(int dno, int tno) {
		Connection conn = getConnection();
		ArrayList<Daily> dlist = new ThemeDao().selectOtherPost(conn, dno, tno);
		close(conn);
		return dlist;
	}
	
	public Theme selectThemeInfo(int tno) {
		Connection conn = getConnection();
		Theme m = new ThemeDao().selectThemeInfo(conn, tno);
		close(conn);
		return m;
	}
	
	public Theme selectThemeOthers(int tno) {
		Connection conn = getConnection();
		Theme t = new ThemeDao().selectThemeOthers(conn, tno);
		close(conn);
		return t;
	}
	
	public ArrayList<Theme> selectThemeListOthers(int tno) {
		Connection conn = getConnection();
		ArrayList<Theme> tlist = new ThemeDao().selectThemeListOthers(conn, tno);
		close(conn);
		return tlist;
	}
	
}
