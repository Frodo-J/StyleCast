package com.stylecast.qna.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.stylecast.common.MyFileRenamePolicy;
import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.qna.model.service.QnaService;
import com.stylecast.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaUpdateController
 */
@WebServlet("/update.qna")
public class QnaUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("UTF-8");
		
		boolean flag = true;
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/qna_upfiles/");
			String savePath2 = request.getSession().getServletContext().getRealPath("/");
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			int qnaNo = Integer.parseInt(multiRequest.getParameter("qno"));
			String qnaTitle = multiRequest.getParameter("title");
			String qnaContent = multiRequest.getParameter("content");
			String qnaCategory = multiRequest.getParameter("qna_category");
			
			Qna q = new Qna();
			q.setQnaNo(qnaNo);
			q.setQnaTitle(qnaTitle);
			q.setQnaContent(qnaContent);
			q.setQnaCategory(qnaCategory);
			
			int qresult = new QnaService().updateQna(q);
			
			
			for(int i=1; i<4; i++) {
				BoardImage bImage = null;
				// file input
				String key = "image" + i;

				String originImageNo = "originImageNo" + i;
				// 기존 이미지 경로
				String oFilePathName = "originFilePath" + i;
				String oFilePath = savePath2 + multiRequest.getParameter(oFilePathName);
				String sub_1 = request.getContextPath() + "/";
				oFilePath = oFilePath.replaceAll(sub_1, "");
				oFilePath = oFilePath.replaceAll("/", "\\\\");
				// 기존 이미지 번호 ( 디비 이미지 번호) 
				int oImgNo = Integer.parseInt(multiRequest.getParameter(originImageNo));
	
				if(multiRequest.getOriginalFileName(key) != null) {
					// 새로운 첨부파일이고, 기존의 파일 있었을 경우
					bImage = new BoardImage();
					bImage.setImgPath("resources/qna_upfiles/" + multiRequest.getFilesystemName(key));
					
					if(oImgNo != 0) {
						// 기존의 파일 있을 경우
						bImage.setImgNo(oImgNo);

						new File(oFilePath).delete();
						
					}else {
						// 새로운 첨부파일이 있었을 경우 
						bImage.setPostNo(qnaNo);
					}
				
				}
				
				int result = new QnaService().updateBoardImages(bImage);
				
				if(result <= 0) {
					flag = false;
				}
			}
			
			
			if(flag == true) {
				response.sendRedirect("detail.qna?qno="+qnaNo);
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
