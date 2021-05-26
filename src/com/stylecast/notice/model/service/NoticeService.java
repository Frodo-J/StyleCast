package com.stylecast.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.stylecast.common.JDBCTemplate.*;
import com.stylecast.notice.model.dao.NoticeDao;
import com.stylecast.notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		return list;
	}
	
}
