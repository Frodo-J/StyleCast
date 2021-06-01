package com.stylecast.qna.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.qna.model.vo.Qna;

import static com.stylecast.common.JDBCTemplate.*;

public class QnaDao {
	
	private Properties prop = new Properties();
	
	public QnaDao() {
		
		String filename = QnaDao.class.getResource("/sql/qna/qna-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Qna> selectMyQnaList(Connection conn, int memNo, PageInfo pi){
		
		ArrayList<Qna> list = new ArrayList<Qna>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyQnaList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				list.add(new Qna(rset.getInt("qna_no"),
								 rset.getString("qna_title"),
								 rset.getDate("enr_date"),
								 rset.getString("ans_content")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectMyQnaListCount(Connection conn, int memNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyQnaListCount");
		
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

	public ArrayList<Qna> selectList(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
				
		String sql = prop.getProperty("selectList");
				
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
					
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
					
			rset = pstmt.executeQuery();
					
			while(rset.next()) {
				list.add(new Qna(rset.getInt("qna_no"),
						rset.getString("qna_category"),
						rset.getString("qna_title"),
						rset.getString("mem_name"),
						rset.getDate("enr_date"),
						rset.getString("ans_content")
						));
			}
					
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
				
			return list;
	
	}

	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;

	}

	public Qna selectQna(Connection conn, int qnaNo) {
		// TODO Auto-generated method stub
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna(rset.getInt("qna_no"),
							   rset.getString("qna_category"),
							   rset.getString("qna_title"),
							   rset.getString("mem_name"),
							   rset.getString("qna_content"),
							   rset.getDate("enr_date"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return q;
	}

	public ArrayList<BoardImage> selectBoardImageList(Connection conn, int qnaNo) {
		// TODO Auto-generated method stub
		ArrayList<BoardImage> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardImage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardImage bImg = new BoardImage();
				bImg.setImgNo(rset.getInt("img_no"));
				bImg.setImgPath(rset.getString("img_path"));
				bImg.setPostCategory(rset.getInt("post_category"));
				bImg.setPostNo(rset.getInt("post_no"));
				list.add(bImg);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Qna selectQnaAnswer(Connection conn, int qnaNo) {
		// TODO Auto-generated method stub
		Qna qAnswer = new Qna();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnaAnswer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				qAnswer = new Qna(
							rset.getString("ans_admin"),
							rset.getString("ans_content"),
							rset.getString("ans_date")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return qAnswer;
	}

	public int updateQnaAnswer(Connection conn, Qna q) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateQnaAnswer");
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getAnsContent());
			pstmt.setInt(2, q.getMemAdmin());
			pstmt.setInt(3, q.getQnaNo());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
