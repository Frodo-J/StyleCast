package com.stylecast.notice.controller;

import java.io.File;
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
import com.stylecast.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/update.no")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			int noticeNo = Integer.parseInt(multiRequest.getParameter("nno"));
			String noticeTitle = multiRequest.getParameter("title");
			String noticeContent = multiRequest.getParameter("content");
			
			Notice n = new Notice();
			n.setNoticeNo(noticeNo);
			n.setNoticeTitle(noticeTitle);
			n.setNoticeContent(noticeContent);
			
			
			
			ArrayList<BoardImage> list = new ArrayList<>();
			
			for(int i=1; i<4; i++) {
				String key = "image" + i;
				String originalFilePath = "originFilePath" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {
					BoardImage bImage = new BoardImage();
					
					bImage.setImgPath("resources/notice_upfiles/" + multiRequest.getFilesystemName(key));
					System.out.println("bImage.getimgPath(): " +bImage.getImgPath());
					System.out.println("multi: "+ multiRequest.getOriginalFileName(key));
					
					// 지우는 과정 // 여기 꼼꼼히 보고 다시 작업하셈
					if(multiRequest.getParameter(originalFilePath) != null) {
						new File(multiRequest.getParameter(originalFilePath)).delete();
					}
					
					list.add(bImage);
				}
				
			}
			
			System.out.println(list);
			System.out.println(n);
			
			int dresult = new NoticeService().deleteBoardImages(n);
			
			int result = new NoticeService().updateNotice(n,list);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/detail.no?nno=" + noticeNo);
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
