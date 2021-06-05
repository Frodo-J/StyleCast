package com.stylecast.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.admin.model.dao.AdminDao;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.theme.model.vo.Theme;
import com.stylecast.daily.model.vo.Report;
import com.stylecast.member.vo.Member;
import com.stylecast.notice.model.dao.NoticeDao;
import com.stylecast.notice.model.vo.Notice;

import static com.stylecast.common.JDBCTemplate.*;

public class AdminService {

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new AdminDao().selectListCount(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Theme> selectThemeList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Theme> list = new AdminDao().selectThemeList(conn, pi);
		close(conn);
		return list;
	}
	
	public int insertTheme(Theme t) {
		Connection conn = getConnection();
		int result = new AdminDao().insertTheme(conn, t);
		close(conn);
		return result;
	}
	
	public int updateTheme(Theme t) {
		Connection conn = getConnection();
		int result = new AdminDao().updateTheme(conn, t);
		close(conn);
		return result;
	}
	
	public Theme selectTheme(int tno) {
		Connection conn = getConnection();
		Theme t = new AdminDao().selectTheme(conn, tno);
		close(conn);
		return t;
	}


	public int selectListCount(String blackListYN) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = 0;
		if(blackListYN.equals("N")) {
			listCount = new AdminDao().selectBlackListNCount(conn);
		}else if(blackListYN.equals("Y")){
			listCount = new AdminDao().selectBlackListYCount(conn);
		}
		close(conn);
		return listCount;
	}

	public ArrayList<Member> selectList(PageInfo pi, String blackListYN) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Member> list = null;
		if(blackListYN.equals("N")) {
			list = new AdminDao().selectMemberListBlackN(conn,pi);
		}else if(blackListYN.equals("Y")){
			list = new AdminDao().selectMemberListBlackY(conn,pi);
		}
		close(conn);
		
		return list;
	}

	public ArrayList<Report> selectReportList(PageInfo pi, int brCategory) {
		Connection conn = getConnection();
		ArrayList<Report> list = new AdminDao().selectReportList(conn, pi, brCategory);
		close(conn);
		return list;
	}

	public int deleteReport(String[] rptNoArr) {
		Connection conn = getConnection();
		int result = new AdminDao().deleteReport(conn, rptNoArr);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int processReport(String[] rptNoArr) {
		Connection conn = getConnection();
		int result1 = new AdminDao().processReport(conn, rptNoArr);
		int result2 = 0;
		
		if(result1 > 0) {
			result2 = new AdminDao().deleteReport(conn, rptNoArr);
			commit(conn);
		}else {
			rollback(conn);
		}
		
		if(result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		int result = result1 * result2;
		
		close(conn);
		return result;
	}

	public ArrayList<Report> selectSearchReportList(String category, String text, int brCategory) {
		Connection conn = getConnection();
		ArrayList<Report> list = null;

		if(category.equals("mem_id")) {
			list = new AdminDao().selectReportListByMemId(conn, text, brCategory);
		}else if(category.contentEquals("rmem_id")) {
			list = new AdminDao().selectReportListByRmemId(conn, text, brCategory);
		}else if(category.contentEquals("rpt_category")) {
			list = new AdminDao().selectReportListByRptCategory(conn, text, brCategory);
		}
		
		close(conn);
		return list;
	}

	public int updateMemberBlackY(int memNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new AdminDao().updateMemberBlackY(conn, memNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}


	public int updateMemberBlackN(int memNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		System.out.println("updateMemberBlackN Service진입");
		int result = new AdminDao().updateMemberBlackN(conn, memNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
}

	public int selectReportListCount(int brCategory) {
		Connection conn = getConnection();
		int listCount = new AdminDao().selectReportListCount(conn, brCategory);
		close(conn);
		return listCount;
	}

	public int selectSearchReportListCount(String category, String text, int brCategory) {
		Connection conn = getConnection();
		int listCount = 0;

		if(category.equals("mem_id")) {
			listCount = new AdminDao().selectReportListCountByMemId(conn, text, brCategory);
		}else if(category.contentEquals("rmem_id")) {
			listCount = new AdminDao().selectReportListCountByRmemId(conn, text, brCategory);
		}else if(category.contentEquals("rpt_category")) {
			listCount = new AdminDao().selectReportListCountByRptCategory(conn, text, brCategory);
		}
		
		close(conn);
		return listCount;

	}

	public int selectSearchListCount(String category, String text) {
		Connection conn = getConnection();
		int listCount =0;
		if(category.equals("아이디")) {
			listCount = new AdminDao().selectListCountByMemberId(conn,text);
		}else if(category.equals("이메일")) {
			listCount = new AdminDao().selectListCountByEmail(conn,text);
		}else if(category.equals("닉네임")) {
			listCount = new AdminDao().selectListCountByMemName(conn,text);
		}
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Member> selectSearchList(PageInfo pi, String category, String text) {
		Connection conn = getConnection();
		ArrayList<Member> list = null;
		if(category.equals("아이디")) {
			list = new AdminDao().selectListByMemberId(conn,pi,text);
		}else if(category.equals("이메일")) {
			list = new AdminDao().selectListByEmail(conn,pi,text);
		}else if(category.contentEquals("닉네임")) {
			list = new AdminDao().selectListByMemName(conn,pi,text);
		}
		close(conn);
		
		return list;
	}

}
