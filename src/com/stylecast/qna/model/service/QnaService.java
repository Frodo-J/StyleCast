package com.stylecast.qna.model.service;

import static com.stylecast.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.common.model.vo.BoardImage;
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
		Connection conn = getConnection();
		ArrayList<Qna> list = new QnaDao().selectList(conn,pi);
		close(conn);
		
		return list;
	}

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new QnaDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}


	public Qna selectQna(int qnaNo) {
		Connection conn = getConnection();
		Qna q = new QnaDao().selectQna(conn,qnaNo);
		close(conn);
		
		return q;
	}

	public ArrayList<BoardImage> selectBoardImageList(int qnaNo) {
		Connection conn = getConnection();
		
		ArrayList<BoardImage> imgList = new QnaDao().selectBoardImageList(conn,qnaNo);
		close(conn);
		return imgList;
	}

	public Qna selectQnaAnswer(int qnaNo) {
		
		Connection conn = getConnection();
		Qna qAnswer = new QnaDao().selectQnaAnswer(conn,qnaNo);
		close(conn);
		return qAnswer;
	}

	public int updateQnaAnswer(Qna q) {
		
		Connection conn = getConnection();
		int result = new QnaDao().updateQnaAnswer(conn,q);
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int deleteQnaAnswer(int qnaNo) {
		Connection conn = getConnection();
		int result = new QnaDao().deleteQnaAnswer(conn,qnaNo);
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return 0;
	}

	public int insertQna(Qna q, ArrayList<BoardImage> list) {
		Connection conn = getConnection();
		
		int result1 = new QnaDao().insertQna(conn, q);
		
		int result2 = 1;
		if(list.isEmpty()==false) {
			result2 = new QnaDao().insertBoardImageList(conn,list);
		}
		
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
		
	}





}
