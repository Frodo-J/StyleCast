package com.stylecast.main.model.service;

import static com.stylecast.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.main.model.dao.MainDao;
import com.stylecast.main.model.vo.MainSelectCodi;
import com.stylecast.main.model.vo.MainSelectDaily;

public class MainService {
	
	public ArrayList<MainSelectDaily> selectMainList(){
		
		Connection conn = getConnection();
		ArrayList<MainSelectDaily> list = new MainDao().selectMainList(conn);
		
		close(conn);
		return list;
		
	}
	
	public ArrayList<MainSelectCodi> selectCodi(){
		
		Connection conn = getConnection();
		ArrayList<MainSelectCodi> list = new MainDao().selectCodi(conn);
		
		close(conn);
		return list;
	}
	
}
