package com.stylecast.daily.model.service;

import static com.stylecast.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.daily.model.dao.DailyDao;
import com.stylecast.daily.model.vo.Daily;

public class DailyService {

	public ArrayList<Daily> selectDailyList() {
		Connection conn = getConnection();
		ArrayList<Daily> list = new DailyDao().selectDailyList(conn);
		close(conn);
		return list;
		
	}
	
}
