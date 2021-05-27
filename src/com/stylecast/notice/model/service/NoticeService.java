package com.stylecast.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.stylecast.common.JDBCTemplate.*;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.notice.model.dao.NoticeDao;
import com.stylecast.notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList() {
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		return list;
	}

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new NoticeDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Notice> selectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(conn,pi);
		close(conn);
		
		return list;
	}

	public int increaseCount(int noticeNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Notice selectNotice(int noticeNo) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		Notice n = new NoticeDao().selectNotice(conn,noticeNo);
		close(conn);
		return n;
	}

	
	
}
