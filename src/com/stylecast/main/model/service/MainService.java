package com.stylecast.main.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.main.model.dao.MainDao;
import com.stylecast.main.model.vo.MainSelectCodiF;
import com.stylecast.main.model.vo.MainSelectCodiFR;
import com.stylecast.main.model.vo.MainSelectCodiM;
import com.stylecast.main.model.vo.MainSelectCodiMR;
import com.stylecast.main.model.vo.MainSelectDaily;

public class MainService {
	
	public ArrayList<MainSelectDaily> MainSelectDaily(){
		
		Connection conn = getConnection();
		ArrayList<MainSelectDaily> list = new MainDao().MainSelectDaily(conn);
		
		close(conn);
		return list;
		
	}
	
	public ArrayList<MainSelectCodiM> MainSelectCodiM(double NowTemp){
		
		Connection conn = getConnection();
		ArrayList<MainSelectCodiM> listC = new MainDao().MainSelectCodiM(conn, NowTemp);
		
		close(conn);
		return listC;
	}
	
	public ArrayList<MainSelectCodiMR> MainSelectCodiMR(double NowTemp){
		
		Connection conn = getConnection();
		ArrayList<MainSelectCodiMR> listC = new MainDao().MainSelectCodiMR(conn, NowTemp);
		
		close(conn);
		return listC;
	}
	
	public ArrayList<MainSelectCodiF> MainSelectCodiF(double NowTemp){
		
		Connection conn = getConnection();
		ArrayList<MainSelectCodiF> listF = new MainDao().MainSelectCodiF(conn, NowTemp);
		
		close(conn);
		return listF;
	}
	
	public ArrayList<MainSelectCodiFR> MainSelectCodiFR(double NowTemp){
		
		Connection conn = getConnection();
		ArrayList<MainSelectCodiFR> listF = new MainDao().MainSelectCodiFR(conn, NowTemp);
		
		close(conn);
		return listF;
	}
	
}
