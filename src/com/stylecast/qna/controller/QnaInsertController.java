package com.stylecast.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.stylecast.common.MyFileRenamePolicy;
import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.notice.model.service.NoticeService;
import com.stylecast.qna.model.service.QnaService;
import com.stylecast.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaInsertController
 */
@WebServlet("/insert.qna")
public class QnaInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)){
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("resources/qna_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			Qna q = new Qna();
			q.setMemNo(Integer.parseInt(multiRequest.getParameter("userNo")));
			q.setQnaTitle(multiRequest.getParameter("title"));
			q.setQnaContent(multiRequest.getParameter("content"));
			q.setQnaCategory(multiRequest.getParameter("qna_category"));
			
			System.out.println(q);
			
			ArrayList<BoardImage> list = new ArrayList<>();
			
			
			for(int i=1; i<4; i++) {
				String key = "image" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {
					BoardImage bImage = new BoardImage();
					
					bImage.setImgPath("resources/qna_upfiles/" + multiRequest.getFilesystemName(key));

					list.add(bImage);
				}
				
			}
			System.out.println(list);
			
			int result = new QnaService().insertQna(q,list);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/list.qna?currentPage=1");
			}else {
				//에러페이지
				//RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				//view.forward(request, response);
			}
			
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
