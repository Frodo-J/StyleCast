package com.stylecast.daily.model.service;

import static com.stylecast.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.daily.model.dao.DailyDao;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.daily.model.vo.DailyCM;
import com.stylecast.daily.model.vo.Item;
import com.stylecast.daily.model.vo.Report;

public class DailyService {

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new DailyDao().selectListCount(conn);

		close(conn);
		return listCount;
	}
	
	public ArrayList<Daily> selectDailyList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Daily> list = new DailyDao().selectDailyList(conn, pi);
		
		close(conn);
		return list;
		
	}
	
	public int insertReportDaily(Report r) {
		Connection conn = getConnection();
		int result = new DailyDao().insertReportDaily(conn, r);

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int insertReportCM(Report r) {
		Connection conn = getConnection();
		int result = new DailyDao().insertReportCM(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Daily selectDailyDetail(int dailyNo) {
		Connection conn = getConnection();
		Daily d = new DailyDao().selectDailyDetail(conn, dailyNo);
		
		close(conn);
		return d;
	}
	
	public ArrayList<Item> selectDailyItem(int dailyNo) {
		Connection conn = getConnection();
		ArrayList<Item> iList = new DailyDao().selectDailyItem(conn, dailyNo);
		
		close(conn);
		return iList;
	}
	
	public ArrayList<DailyCM> selectDailyCM(int dailyNo) {
		Connection conn = getConnection();
		ArrayList<DailyCM> cList = new DailyDao().selectDailyCM(conn, dailyNo);
		
		close(conn);
		return cList;
	}

	public ArrayList<Daily> selectMyDailyList(int memNo) {
		
		Connection conn = getConnection();
		ArrayList<Daily> list = new DailyDao().selectMyDailyList(conn, memNo);
		close(conn);
		
		return list;
	}

	public int selectMyDailyListCount(int memNo) {
		
		Connection conn = getConnection();
		int listCount = new DailyDao().selectMyDailyListCount(conn, memNo);
		close(conn);
		return listCount;
	}

	public int checkLiked(int memNo, int dailyNo) {
		
		Connection conn = getConnection();
		int likeYN = new DailyDao().checkLiked(conn, memNo, dailyNo);
		close(conn);
		return likeYN;
	}

	public int checkBookmark(int memNo, int dailyNo) {
		
		Connection conn = getConnection();
		int bookmarkYN = new DailyDao().checkBookmark(conn, memNo, dailyNo);
		close(conn);
		return bookmarkYN;
	}

	public int selectLikedCount(int dailyNo) {
		
		Connection conn = getConnection();
		int likeCount = new DailyDao().selectLikedCount(conn, dailyNo);
		close(conn);
		return likeCount;
	}

	public int selectBookmarkCount(int dailyNo) {
		
		Connection conn = getConnection();
		int bookmarkCount = new DailyDao().selectBookmarkCount(conn, dailyNo);
		close(conn);
		return bookmarkCount;
	}

	public int[] selectLikedCountList(PageInfo pi) {
		
		Connection conn = getConnection();
		int[] likeCount = new DailyDao().selectLikedCountList(conn, pi);
		close(conn);
		return likeCount;
	}

	public int[] selectBookmarkCountList(PageInfo pi) {
		
		Connection conn = getConnection();
		int[] bookmarkCount = new DailyDao().selectBookmarkCountList(conn, pi);
		close(conn);
		return bookmarkCount;
	}

	public int insertLike(int memNo, int dailyNo) {
		
		Connection conn = getConnection();
		
		int result = new DailyDao().insertLike(conn, memNo, dailyNo);
		close(conn);
		
		return result;
	}

	public int deleteLike(int memNo, int dailyNo) {
		
		Connection conn = getConnection();
		
		int result = new DailyDao().deleteLike(conn, memNo, dailyNo);
		close(conn);
		
		return result;
	}

	public int[] selectLikedCountList(int memNo) {
		
		Connection conn = getConnection();
		int count = new DailyDao().selectMyDailyListCount(conn, memNo);
		int[] likeCount = new DailyDao().selectLikedCountList(conn, memNo, count);
		close(conn);
		return likeCount;
	}

	public int[] selectBookmarkCountList(int memNo) {
		
		Connection conn = getConnection();
		int count = new DailyDao().selectMyDailyListCount(conn, memNo);
		int[] bookmarkCount = new DailyDao().selectBookmarkCountList(conn, memNo, count);
		close(conn);
		return bookmarkCount;
	}

	public int[] selectLikedCountBk(int memNo) {
		
		Connection conn = getConnection();
		int count = new DailyDao().selectMyBookmarkListCount(conn, memNo);
		int[] likeCount = new DailyDao().selectLikedCountBk(conn, memNo, count);
		close(conn);
		return likeCount;
	}

	public int[] selectBookmarkCountBk(int memNo) {
		
		Connection conn = getConnection();
		int count = new DailyDao().selectMyBookmarkListCount(conn, memNo);
		int[] bookmarkCount = new DailyDao().selectBookmarkCountBk(conn, memNo, count);
		close(conn);
		return bookmarkCount;
	}
	
	public int insertDailyCM(DailyCM cm) {
		Connection conn = getConnection();
		int result = new DailyDao().insertDailyCM(conn, cm);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteDailyCM(DailyCM cm) {
		Connection conn = getConnection();
		int result = new DailyDao().deleteDailyCM(conn, cm);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int searchListCount(String text) {
		Connection conn = getConnection();
		int listCount = 0;
		listCount = new DailyDao().selectDailyCount(conn, text);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Daily> searchDailyList(PageInfo pi, String text){
		Connection conn = getConnection();
		ArrayList<Daily> list = null;
			list = new DailyDao().selectDaily(conn, pi, text);

		close(conn);
		
		return list;
	}
	
	public int insertDaily(Daily d, ArrayList<Item> list) {
		Connection conn = getConnection();
		System.out.println(d.getMemNo());
		System.out.println(d.getDailyContent());
		System.out.println(d.getTag());
		System.out.println(d.getDailyImg());
		int result1 = new DailyDao().insertDaily(conn, d);
		int result2 = 1;
		if(list != null) {		
			result2 = new DailyDao().insertItem(conn, list);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
	}
	/*
	public int updateDailyImages(BoardImage bImage) {
		Connection conn = getConnection();
		
		int result = 1;
		if(bImage != null) {
			if(bImage.getImgNo() != 0) {
				result = new DailyDao().updateDailyImage(conn, bImage);
			}else {
				System.out.println("서비스의 첨부파일이 없을 경우 : " + bImage);
				result = new DailyDao().insertNewDailyImage(conn, bImage);
			}
		}
		return result;
	}
	*/
	
	public int updateDaily(Daily d, ArrayList<Item> list) {
		Connection conn = getConnection();
		
		int result1 = new DailyDao().updateDaily(conn, d);
		
		int result2 = 1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getItemName() != null) {
				result2 = new DailyDao().updateItem(conn, list);
			}else {
				result2 = new DailyDao().insertItem(conn, list);
			}
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
