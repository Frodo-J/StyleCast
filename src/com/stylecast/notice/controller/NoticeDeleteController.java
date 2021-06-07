package com.stylecast.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDeleteController
 */
@WebServlet("/delete.no")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int noticeNo = Integer.parseInt(request.getParameter("nno"));
		String savePath = request.getSession().getServletContext().getRealPath("/");
		
		ArrayList<BoardImage> imgList = new NoticeService().selectBoardImagePath(noticeNo);
		int result1 = 1;
		if(imgList.isEmpty()==false){
			for(int i=0; i<imgList.size(); i++) {
				new File(savePath + imgList.get(i).getImgPath()).delete();
			}
			result1 = new NoticeService().deleteBoardImage(noticeNo);
		}
		
		int result2 = new NoticeService().deleteNotice(noticeNo);
		
		if(result1 * result2 > 0) {
			response.sendRedirect(request.getContextPath() + "/list.no?currentPage=1");
		}else {
			request.setAttribute("errorMsg", "삭제에 실패했습니다.");
			request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
