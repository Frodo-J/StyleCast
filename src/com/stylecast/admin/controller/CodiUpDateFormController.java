package com.stylecast.admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.stylecast.admin.model.service.AdminService;
import com.stylecast.admin.model.vo.Codi;
import com.stylecast.common.MyFileRenamePolicy;


/**
 * Servlet implementation class CodiUpDateController
 */
@WebServlet("/UpDateForm.ad")
public class CodiUpDateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodiUpDateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/codi_upfiles/");
			//System.out.println(savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String gender = multiRequest.getParameter("gender");
			String weather = multiRequest.getParameter("weather");
			int lowT = Integer.parseInt(multiRequest.getParameter("lowT"));
			int highT = Integer.parseInt(multiRequest.getParameter("highT"));
			String imgPath = multiRequest.getFilesystemName("imgPath");
			int cno = Integer.parseInt(multiRequest.getParameter("cno"));
			
//			System.out.println(gender);
//			System.out.println(weather);
//			System.out.println(lowT);
//			System.out.println(highT);
//			System.out.println(imgPath);
			
			Codi c = new Codi();
			c.setCodiNo(cno);
	    	c.setGender(gender);
			c.setImgPath("/StyleCast/resources/codi_upfiles/" + imgPath);
			c.setRecHighT(highT);
			c.setRecLowT(lowT);
			c.setRecWeather(weather);
			
			//System.out.println(c.getImgPath());
			
			System.out.println(c.getCodiNo());
			System.out.println(c.getGender());
			System.out.println(c.getImgPath());
			System.out.println(c.getRecHighT());
			System.out.println(c.getRecLowT());
			System.out.println(c.getRecWeather());
			
			if(imgPath == null) {
				System.out.println(c.getImgPath());
				int result = new AdminService().UpdateEnrollCodi(c);
				if(result>0) {
					response.sendRedirect(request.getContextPath() + "/codilist.ad?currentPage=1");
					session.setAttribute("alertMsg", "코디 수정에 성공하였습니다");
				}else {
					new File(savePath + c.getImgPath()).delete();
				}
			}else {
				System.out.println(c.getRecLowT());
				int result = new AdminService().UpdateEnrollCodiImg(c);
				if(result>0) {
					response.sendRedirect(request.getContextPath() + "/codilist.ad?currentPage=1");
					session.setAttribute("alertMsg", "코디 수정에 성공하였습니다");
				}else {
					new File(savePath + c.getImgPath()).delete();
				}
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
