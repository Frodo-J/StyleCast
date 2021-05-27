package com.stylecast.main.model.service;

import static com.stylecast.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.main.model.dao.MainDao;
import com.stylecast.main.model.vo.Main;

public class MainService {
	
	public ArrayList<Main> selectMainList(){
		
		Connection conn = getConnection();
		ArrayList<Main> list = new MainDao().selectMainList(conn);
		
		close(conn);
		return list;
		
	}
	
}
