package com.stylecast.qna.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.qna.model.service.QnaService;

/**
 * Servlet implementation class QnaDeleteController
 */
@WebServlet("/delete.qna")
public class QnaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int qnaNo = Integer.parseInt(request.getParameter("qno"));
		String savePath = request.getSession().getServletContext().getRealPath("/");
		
		int imgCount = new QnaService().selectBoardImageCount(qnaNo);
		ArrayList<BoardImage> imgList = new QnaService().selectBoardImagePath(qnaNo);
		int result1 = 1;
		if(imgCount > 0){
			for(int i=0; i<imgList.size(); i++) {
				new File(savePath + imgList.get(i).getImgPath()).delete();
			}
			result1 = new QnaService().deleteBoardImage(qnaNo);
		}
		
		int result2 = new QnaService().deleteQna(qnaNo);
		
		
		if(result1 * result2 > 0) {
			response.sendRedirect(request.getContextPath() + "/list.qna?currentPage=1");
		}else {
			//에러페이지
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
