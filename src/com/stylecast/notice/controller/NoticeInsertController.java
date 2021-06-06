package com.stylecast.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
import com.stylecast.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)) {
			// 전송 용량 제한
			int maxSize = 10 * 1024 * 1024;
			
			// 저장할 폴더의 물리 경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles/");
			
			// 전달된 파일명 수정 작업후 서버에 업로드처리
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			Notice n = new Notice();
			n.setMemNo(multiRequest.getParameter("userNo"));
			n.setNoticeTitle(multiRequest.getParameter("title"));
			n.setNoticeContent(multiRequest.getParameter("content"));
			
			
			ArrayList<BoardImage> list = new ArrayList<>();
			
			for(int i=1; i<4; i++) {
				String key = "image" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {
					BoardImage bImage = new BoardImage();
					
					bImage.setImgPath("resources/notice_upfiles/" + multiRequest.getFilesystemName(key));

					list.add(bImage);
				}
				
			}
			System.out.println(list);
			int result = new NoticeService().insertNotice(n,list);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/list.no?currentPage=1");
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
