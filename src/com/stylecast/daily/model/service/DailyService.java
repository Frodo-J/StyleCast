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
	
	public int[] selectCommentCountList(PageInfo pi) {
		Connection conn = getConnection();
		int [] CommentCount = new DailyDao().selectCommentCountList(conn, pi);
		close(conn);
		return CommentCount;
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
	
	public Report checkReportCM(DailyCM cm) {
		Connection conn = getConnection();
		Report r = new DailyDao().checkReportCM(conn, cm);
		
		close(conn);
		return r;
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
	
	public int updateDaily(Daily d, ArrayList<Item> list) {
		Connection conn = getConnection();
		
		int result1 = new DailyDao().updateDaily(conn, d);
		
		int result2 = 1;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getDailyNo() > 0) {
				result2 = new DailyDao().updateNewItem(conn, list.get(i)); // insert
			}else {
				result2 = new DailyDao().updateItem(conn, list.get(i)); // update
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

	public int[] selectSearchLikedCountList(PageInfo pi, String text) {
		
		Connection conn = getConnection();
		int[] likeCount = new DailyDao().selectSearchLikedCountList(conn, pi, text);
		close(conn);
		return likeCount;
	}

	public int[] selectSearchBookmarkCountList(PageInfo pi, String text) {
		
		Connection conn = getConnection();
		int[] bookmarkCount = new DailyDao().selectSearchBookmarkCountList(conn, pi, text);
		close(conn);
		return bookmarkCount;
	}
	
	public int[] selectSearchCommentCountList(PageInfo pi, String text) {
		
		Connection conn = getConnection();
		int[] commentCount = new DailyDao().selectSearchCommentCountList(conn, pi, text);
		close(conn);
		return commentCount;
	}
	
	public Report checkReportDaily(int dno) {
		Connection conn = getConnection();
		Report r = new DailyDao().checkReportDaily(conn, dno);
		close(conn);
		return r;
	}
	
	
	public int deleteDaily(int dno) {
		Connection conn = getConnection();

		int result1 = new DailyDao().deleteDailyComment(conn, dno); //댓글 삭제
		int result2 = new DailyDao().deleteItem(conn, dno);  		//아이템 삭제
		int result3 = new DailyDao().deleteDailyLike(conn, dno);	//좋아요 삭제
		int result4 = new DailyDao().deleteBookmark(conn, dno);		//북마크 삭제
		System.out.println(result1 + result2 + result3 + result4);
		
		if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0) {
			int result = new DailyDao().deleteDaily(conn, dno);		//데일리 삭제
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			return result;
		}else {
			rollback(conn);
			close(conn);
			int result = 0;
			return result;
		}
		
		
	}

	public ArrayList<Daily> searchDailyListByTag(PageInfo pi, String text) {
		Connection conn = getConnection();
		ArrayList<Daily> list = null;
			list = new DailyDao().selectDailyByTag(conn, pi, text);

		close(conn);
		
		return list;
	}

	public int[] selectCommentCountList(int memNo) {
		Connection conn = getConnection();
		int count = new DailyDao().selectMyDailyListCount(conn, memNo);
		int [] commentCount = new DailyDao().selectCommentCountList(conn, memNo, count);
		close(conn);
		return commentCount;
	}

	public int[] selectCommentCountBk(int memNo) {
		
		Connection conn = getConnection();
		int count = new DailyDao().selectMyBookmarkListCount(conn, memNo);
		int[] commentCount = new DailyDao().selectCommentCountBk(conn, memNo, count);
		close(conn);
		return commentCount;
	}
	
	
	
}
