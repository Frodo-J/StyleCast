package com.stylecast.main.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.main.model.dao.MainDao;
import com.stylecast.main.model.vo.MainSelectCodiM;
import com.stylecast.main.model.vo.MainSelectDaily;

public class MainService {
	
	public ArrayList<MainSelectDaily> MainSelectDaily(){
		
		Connection conn = getConnection();
		ArrayList<MainSelectDaily> list = new MainDao().MainSelectDaily(conn);
		
		close(conn);
		return list;
		
	}
	
	public ArrayList<MainSelectCodiM> MainSelectCodiM(){
		
		Connection conn = getConnection();
		ArrayList<MainSelectCodiM> list = new MainDao().MainSelectCodiM(conn, 0);
		
		close(conn);
		return list;
	}
	
	
}
