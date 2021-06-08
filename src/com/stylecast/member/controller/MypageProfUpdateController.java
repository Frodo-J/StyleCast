package com.stylecast.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.stylecast.common.MyFileRenamePolicy;
import com.stylecast.member.service.MemberService;
import com.stylecast.member.vo.Member;

/**
 * Servlet implementation class MypageProfUpdateController
 */
@WebServlet("/updateProf.me")
public class MypageProfUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageProfUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/profile_upfiles/");

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String memId = multiRequest.getParameter("memId");
			
			Member mem = new Member();
			mem.setMemId(multiRequest.getParameter("memId"));
			
			if(multiRequest.getOriginalFileName("userProfImg") != null) {
				mem.setProfImg("/resources/profile_upfiles/" + multiRequest.getFilesystemName("userProfImg"));
			}else {
				mem.setProfImg("/resources/profile_upfiles/2021060816165980780.png");
			}
			
			int result = new MemberService().updateProfImg(mem);
			
			String referer = request.getHeader("Referer");
			//System.out.println(referer);
			
			if(result > 0) {
				
				response.sendRedirect(referer);
				
			}else {
				
				request.setAttribute("errorMsg", "회원 정보 수정에 실패했습니다.");
				request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);
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
