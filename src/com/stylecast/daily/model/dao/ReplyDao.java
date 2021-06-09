package com.stylecast.daily.model.dao;

import static com.stylecast.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.daily.model.vo.Reply;

public class ReplyDao {
	
	private Properties prop = new Properties();

    public ReplyDao() {

        try {
            prop.loadFromXML(new FileInputStream(ReplyDao.class.getResource("/sql/daily/reply-mapper.xml").getPath()));
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

	public ArrayList<Reply> selectMyReplyList(Connection conn, int memNo, PageInfo pi) {

		ArrayList<Reply> list = new ArrayList<Reply>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyReplyList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Reply(rset.getInt("cm_no"),
								   rset.getInt("daily_no"),
						           rset.getString("cm_content"),
						           rset.getDate("enr_date")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectMyReplyListCount(Connection conn, int memNo) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyReplyListCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
		return listCount;
	}
	
	

}
