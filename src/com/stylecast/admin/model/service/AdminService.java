package com.stylecast.admin.model.service;

import static com.stylecast.common.JDBCTemplate.*;

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
	
	public int insertCodi(Codi c) {
		Connection conn = getConnection();
		int result = new AdminDao().insertCodi(conn, c);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	
	public ArrayList<Codi> selectSearchList(PageInfo pi, String gender, String weather) {
		Connection conn = getConnection();
		ArrayList<Codi> list = null;
		if(gender.equals("ALL") && weather.equals("ALL")) {
			list = new AdminDao().SelectCodiList(conn, pi);
		}else if(gender.equals("ALL") && weather.equals("CLEAR")) {
			list = new AdminDao().selectListByWeatherClear(conn, pi);
		}else if(gender.equals("ALL") && weather.equals("RAIN")) {
			list = new AdminDao().selectListByWeatherRain(conn, pi);
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("ALL")) {
			list = new AdminDao().selectListByGender(conn, gender, pi);
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("CLEAR")) {
			list = new AdminDao().selectListByBothCLEAR(conn, gender, pi);
		}else {
			list = new AdminDao().selectListByBothRain(conn, gender, pi);
		}
		
		close(conn);
		
		return list;
	}

	public int selectListCount(String gender, String weather) {
		Connection conn = getConnection();
		int listCount = 0;
		if(gender.equals("ALL") && weather.equals("ALL")) {
			listCount = new AdminDao().selectListCount(conn);
		}else if(gender.equals("ALL") && weather.equals("CLEAR")) {
			listCount = new AdminDao().selectListCountByWeatherClear(conn);
		}else if(gender.equals("ALL") && weather.equals("RAIN")) {
			listCount = new AdminDao().selectListCountByWeatherRain(conn);
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("ALL")) {
			listCount = new AdminDao().selectListCountByGender(conn, gender);
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("CLEAR")) {
			listCount = new AdminDao().selectListCountByBothCLEAR(conn, gender);
		}else {
			listCount = new AdminDao().selectListCountByBothRain(conn, gender);
		}
		
		close(conn);
		
		return listCount;
	}

	public int UpdateEnrollCodi(Codi c) {
		Connection conn = getConnection();
		int result = new AdminDao().UpdateEnrollCodi(conn, c);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int UpdateEnrollCodiImg(Codi c) {
		Connection conn = getConnection();
		int result = new AdminDao().UpdateEnrollCodiImg(conn, c);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
