package com.stylecast.notice.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.stylecast.common.JDBCTemplate.*;

import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.notice.model.vo.Notice;

public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(NoticeDao.class.getResource("/sql/notice/notice-mapper.xml").getPath()));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Notice> selectNoticeList(Connection conn) {
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
									rset.getString("mem_name"),
									rset.getString("notice_title"),
									rset.getDate("enr_date")
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
		// TODO Auto-generated method stub
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

	public ArrayList<Notice> selectList(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Notice> list = new ArrayList<>();
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
				list.add(new Notice(rset.getInt("notice_no"),
						rset.getString("mem_name"),
						rset.getString("notice_title"),
						rset.getDate("enr_date")
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

	public int increaseCount(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Notice selectNotice(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice(rset.getInt("notice_no"),
							   rset.getString("mem_name"),
							   rset.getString("notice_title"),
							   rset.getString("notice_content"),
							   rset.getInt("count"),
							   rset.getDate("enr_date"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<BoardImage> selectBoardImageList(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		ArrayList<BoardImage> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardImage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
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

	public int insertNotice(Connection conn, Notice n) {
		// TODO Auto-generated method stub
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(n.getMemNo()));
			pstmt.setString(2, n.getNoticeTitle());
			pstmt.setString(3, n.getNoticeContent());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertBoardImageList(Connection conn, ArrayList<BoardImage> list) {
		// TODO Auto-generated method stub
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoardImageList");
		
		
		try {
			for(BoardImage bImage : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bImage.getImgPath());
				
				result = pstmt.executeUpdate();
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBoardImages(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoardImages");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateNotice(Connection conn, Notice n) {
		// TODO Auto-generated method stub
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertBoardImageList(Connection conn, ArrayList<BoardImage> list, int noticeNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoardImageList2");
		
		
		try {
			for(BoardImage bImage : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bImage.getImgPath());
				pstmt.setInt(2,noticeNo);
				
				result = pstmt.executeUpdate();
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;

	}

	public int updateBoardImage(Connection conn, BoardImage bImage) {
		// TODO Auto-generated method stub
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoardImage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bImage.getImgPath());
			pstmt.setInt(2,bImage.getImgNo());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertNewBoardImage(Connection conn, BoardImage bImage) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNewBoardImage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bImage.getImgPath());
			pstmt.setInt(2, bImage.getPostNo());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Notice> selectListByNoticeTitle(Connection conn, PageInfo pi, String text) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListByNoticeTitle");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
						rset.getString("mem_name"),
						rset.getString("notice_title"),
						rset.getDate("enr_date")
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

	public ArrayList<Notice> selectListByNoticeContent(Connection conn, PageInfo pi, String text) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListByNoticeContent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
						rset.getString("mem_name"),
						rset.getString("notice_title"),
						rset.getDate("enr_date")
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

	public ArrayList<Notice> selectListByMemName(Connection conn, PageInfo pi, String text) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListByMemName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1, text);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
						rset.getString("mem_name"),
						rset.getString("notice_title"),
						rset.getDate("enr_date")
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

	public int selectListCountByNoticeTitle(Connection conn, String text) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByNoticeTitle");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
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

	public int selectListCountByNoticeContent(Connection conn, String text) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByNoticeContent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
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

	public int selectListCountByMemName(Connection conn, String text) {
		// TODO Auto-generated method stub
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountByMemName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text);
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

	public ArrayList<BoardImage> selectBoardImagePath(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		ArrayList<BoardImage> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardImagePath");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new BoardImage(rset.getString("img_path")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int deleteBoardImage(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoardImage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	
	
}
