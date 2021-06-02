package com.stylecast.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.stylecast.common.JDBCTemplate.*;

import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.notice.model.dao.NoticeDao;
import com.stylecast.notice.model.vo.Notice;
import com.stylecast.qna.model.vo.Qna;

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

	public int deleteNotice(int noticeNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<BoardImage> selectBoardImageList(int noticeNo) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		ArrayList<BoardImage> imgList = new NoticeDao().selectBoardImageList(conn,noticeNo);
		close(conn);
		
		return imgList;
	}

	public int insertNotice(Notice n, ArrayList<BoardImage> list) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		int result1 = new NoticeDao().insertNotice(conn,n);
		int result2 = 1;
		
		if(list.isEmpty()==false) {
			 result2 = new NoticeDao().insertBoardImageList(conn,list);
		}
		
		if(result1>0 && result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
	}

//	public int updateNotice(Notice n, ArrayList<BoardImage> list) {
//		// TODO Auto-generated method stub
//		Connection conn = getConnection();
//		
//		int result2 = new NoticeDao().updateNotice(conn,n);
//		int result3 = new NoticeDao().insertBoardImageList(conn, list,n.getNoticeNo());
//		
//			
//		if(result2 >0) {
//			commit(conn);
//		}else {
//			rollback(conn);
//		}
//		
//		close(conn);
//		
//		return result2;
//	}

	public int deleteBoardImages(Notice n) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result1 = new NoticeDao().deleteBoardImages(conn,n.getNoticeNo());
		
	
		commit(conn);

		return result1;
	}

	public int updateNotice(Notice n) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		int result1 = new NoticeDao().updateNotice(conn,n);
		
//		int result2 = 1;
//		if(bImage != null) { // 새로 첨부된 파일 있을 경우 
//			if(bImage.getImgNo() != 0) { // 기존 첨부파일 있을 경우
//				result2= new NoticeDao().updateBoardImage(conn,bImage);
//			}else { // 기존 첨부파일이 없을 경우
//				System.out.println("서비스의 첨부파일이 없을 경우: " + bImage);
//				result2 = new NoticeDao().insertNewBoardImage(conn,bImage);
//			}
//			
//		}
		
		if(result1 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result1;
	}
	
	public int updateBoardImages(BoardImage bImage) {
		Connection conn = getConnection();
		
		int result = 1;
		if(bImage != null) { // 새로 첨부된 파일 있을 경우 
			if(bImage.getImgNo() != 0) { // 기존 첨부파일 있을 경우
				result = new NoticeDao().updateBoardImage(conn,bImage);
			}else { // 기존 첨부파일이 없을 경우
				System.out.println("서비스의 첨부파일이 없을 경우: " + bImage);
				result = new NoticeDao().insertNewBoardImage(conn,bImage);
			}
			
		}
		
		return result;
	}

	public ArrayList<Notice> selectSearchList(PageInfo pi, String category, String text) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		ArrayList<Notice> list = null;
		if(category.equals("notice_title")) {
			System.out.println("notice_title진입");
			System.out.println(pi);
			System.out.println(text);
			list = new NoticeDao().selectListByNoticeTitle(conn,pi,text);
		}else if(category.equals("notice_content")) {
			list = new NoticeDao().selectListByNoticeContent(conn,pi,text);
		}else if(category.contentEquals("mem_name")) {
			list = new NoticeDao().selectListByMemName(conn,pi,text);
		}
		close(conn);
		
		return list;
		

	}

	public int selectListCount(String category, String text) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount =0;
		if(category.equals("notice_title")) {
			listCount = new NoticeDao().selectListCountByNoticeTitle(conn,text);
		}else if(category.equals("notice_content")) {
			listCount = new NoticeDao().selectListCountByNoticeContent(conn,text);
		}else if(category.contentEquals("mem_name")) {
			listCount = new NoticeDao().selectListCountByMemName(conn,text);
		}
		
		close(conn);
		
		return listCount;
	}


		

	
	
}
