package com.stylecast.qna.model.service;

import static com.stylecast.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.qna.model.dao.QnaDao;
import com.stylecast.qna.model.vo.Qna;

public class QnaService {
	
	public ArrayList<Qna> selectMyQnaList(int memNo, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().selectMyQnaList(conn, memNo, pi);
		close(conn);
		
		return list;
	}
	
	public int selectMyQnaListCount(int memNo) {
		
		Connection conn = getConnection();
		
		int listCount = new QnaDao().selectMyQnaListCount(conn, memNo);
		close(conn);
		
		return listCount;
	}

	public ArrayList<Qna> selectList(PageInfo pi) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Qna> list = new QnaDao().selectList(conn,pi);
		close(conn);
		
		return list;
	}

	public int selectListCount() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = new QnaDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}



}
