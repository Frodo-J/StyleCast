package com.stylecast.admin.model.service;

import static com.stylecast.common.JDBCTemplate.close;
import static com.stylecast.common.JDBCTemplate.commit;
import static com.stylecast.common.JDBCTemplate.getConnection;
import static com.stylecast.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.stylecast.admin.model.dao.AdminDao;
import com.stylecast.admin.model.vo.Codi;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.daily.model.vo.Report;
import com.stylecast.member.vo.Member;
import com.stylecast.theme.model.vo.Theme;
import com.stylecast.theme.model.vo.ThemePost;

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
	
	public ArrayList<ThemePost> selectThemePost(int tno) {
		Connection conn = getConnection();
		ArrayList<ThemePost> plist = new AdminDao().selectThemePost(conn, tno);
		close(conn);
		return plist;
	}
	
	public int deleteThemePost(int tno, int dno) {
		Connection conn = getConnection();
		int result = new AdminDao().deleteThemePost(conn, tno, dno);
		close(conn);
		return result;
	}


	public int updateMemberBlackN(int memNo) {
		Connection conn = getConnection();
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
	
	public ArrayList<Daily> selectDailyList(int tno) {
		Connection conn = getConnection();
		ArrayList<Daily> dlist = new AdminDao().selectDailyList(conn, tno);
		close(conn);
		return dlist;
	}

	public int insertTPost(int tno, int dno) {
		Connection conn = getConnection();
		int result = new AdminDao().insertTPost(conn, tno, dno);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int selectCodiListCount() {
		Connection conn = getConnection();
		int listCount = new AdminDao().selectCodiListCount(conn);
		System.out.println(listCount);
		close(conn);
		return listCount;
	}

	public ArrayList<Codi> selectCodiList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Codi> list = new AdminDao().SelectCodiList(conn, pi);
		
		close(conn);
		return list;
		
	}
	
	public Codi selectCodiUpdate(int codiNo) {
		Connection conn = getConnection();
		Codi c = new AdminDao().selectCodiUpdate(conn, codiNo);
		
		close(conn);
		return c;
	}
	
	public int selectCodiDelete(Codi c) {
		Connection conn = getConnection();
		int result = new AdminDao().selectCodiDelete(conn, c);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public int insertCodi(Codi c) {
		Connection conn = getConnection();
		int result = new AdminDao().insertCodi(conn, c);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	
	public ArrayList<Codi> selectSearchCodiList(PageInfo pi, String gender, String weather) {
		Connection conn = getConnection();
		ArrayList<Codi> list = null;
		if(gender.equals("ALL") && weather.equals("ALL")) {
			list = new AdminDao().SelectCodiList(conn, pi);
		}else if(gender.equals("ALL") && weather.equals("CLEAR")) {
			list = new AdminDao().selectListByWeatherClear(conn, pi);
		}else if(gender.equals("ALL") && weather.equals("RAIN")) {
			list = new AdminDao().selectListByWeatherRain(conn, pi);
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("ALL")) {
			list = new AdminDao().selectListByGender(conn, gender, pi);
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("CLEAR")) {
			list = new AdminDao().selectListByBothCLEAR(conn, gender, pi);
		}else {
			list = new AdminDao().selectListByBothRain(conn, gender, pi);
		}
		
		close(conn);
		
		return list;
	}

	public int selectCodiListCount(String gender, String weather) {
		Connection conn = getConnection();
		int listCount = 0;
		if(gender.equals("ALL") && weather.equals("ALL")) {
			listCount = new AdminDao().selectCodiListCount(conn);
		}else if(gender.equals("ALL") && weather.equals("CLEAR")) {
			listCount = new AdminDao().selectListCountByWeatherClear(conn);
		}else if(gender.equals("ALL") && weather.equals("RAIN")) {
			listCount = new AdminDao().selectListCountByWeatherRain(conn);
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("ALL")) {
			listCount = new AdminDao().selectListCountByGender(conn, gender);
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("CLEAR")) {
			listCount = new AdminDao().selectListCountByBothCLEAR(conn, gender);
		}else {
			listCount = new AdminDao().selectListCountByBothRain(conn, gender);
		}
		
		close(conn);
		
		return listCount;
	}

	public int UpdateEnrollCodi(Codi c) {
		Connection conn = getConnection();
		int result = new AdminDao().UpdateEnrollCodi(conn, c);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int UpdateEnrollCodiImg(Codi c) {
		Connection conn = getConnection();
		int result = new AdminDao().UpdateEnrollCodiImg(conn, c);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
	

