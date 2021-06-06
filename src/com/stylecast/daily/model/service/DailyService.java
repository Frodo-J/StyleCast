package com.stylecast.daily.model.service;

import static com.stylecast.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.daily.model.dao.DailyDao;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.daily.model.vo.DailyCM;
import com.stylecast.daily.model.vo.Item;
import com.stylecast.daily.model.vo.Report;

public class DailyService {

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new DailyDao().selectListCount(conn);

		close(conn);
		return listCount;
	}
	
	public ArrayList<Daily> selectDailyList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Daily> list = new DailyDao().selectDailyList(conn, pi);
		
		close(conn);
		return list;
		
	}
	
	public int insertReportDaily(Report r) {
		Connection conn = getConnection();
		int result = new DailyDao().insertReportDaily(conn, r);

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int insertReportCM(Report r) {
		Connection conn = getConnection();
		int result = new DailyDao().insertReportCM(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Daily selectDailyDetail(int dailyNo) {
		Connection conn = getConnection();
		Daily d = new DailyDao().selectDailyDetail(conn, dailyNo);
		
		close(conn);
		return d;
	}
	
	public ArrayList<Item> selectDailyItem(int dailyNo) {
		Connection conn = getConnection();
		ArrayList<Item> iList = new DailyDao().selectDailyItem(conn, dailyNo);
		
		close(conn);
		return iList;
	}
	
	public ArrayList<DailyCM> selectDailyCM(int dailyNo) {
		Connection conn = getConnection();
		ArrayList<DailyCM> cList = new DailyDao().selectDailyCM(conn, dailyNo);
		
		close(conn);
		return cList;
	}
	
	public int insertDailyCM(DailyCM cm) {
		Connection conn = getConnection();
		int result = new DailyDao().insertDailyCM(conn, cm);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteDailyCM(DailyCM cm) {
		Connection conn = getConnection();
		int result = new DailyDao().deleteDailyCM(conn, cm);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int searchListCount(String text) {
		Connection conn = getConnection();
		int listCount = 0;
		listCount = new DailyDao().selectDailyCount(conn, text);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Daily> searchDailyList(PageInfo pi, String text){
		Connection conn = getConnection();
		ArrayList<Daily> list = null;
			list = new DailyDao().selectDaily(conn, pi, text);

		close(conn);
		
		return list;
	}
	
	public int insertDaily(Daily d, ArrayList<Item> list) {
		Connection conn = getConnection();
		System.out.println(d.getMemNo());
		System.out.println(d.getDailyContent());
		System.out.println(d.getTag());
		System.out.println(d.getDailyImg());
		int result1 = new DailyDao().insertDaily(conn, d);
		int result2 = 1;
		if(list != null) {		
			result2 = new DailyDao().insertItem(conn, list);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
