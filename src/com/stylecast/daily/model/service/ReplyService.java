package com.stylecast.daily.model.service;

import static com.stylecast.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.daily.model.dao.ReplyDao;
import com.stylecast.daily.model.vo.Reply;

public class ReplyService {

	public ArrayList<Reply> selectMyReplyList(int memNo, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new ReplyDao().selectMyReplyList(conn, memNo, pi);
		close(conn);
		
		return list;
	}

	public int selectMyReplyListCount(int memNo) {
		
		Connection conn = getConnection();
		
		int listCount = new ReplyDao().selectMyReplyListCount(conn, memNo);
		close(conn);
		
		return listCount;
	}
	
	

}
