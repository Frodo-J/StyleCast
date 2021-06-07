package com.stylecast.daily.controller;

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
import com.stylecast.daily.model.service.DailyService;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.daily.model.vo.Item;

/**
 * Servlet implementation class DailyUpdateController
 */
@WebServlet("/update.da")
public class DailyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyUpdateController() {
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
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/daily_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int dailyNo = Integer.parseInt(multiRequest.getParameter("dno"));
			
			Daily d = new Daily();
			d.setDailyContent(multiRequest.getParameter("dailyContent"));
			d.setTag(multiRequest.getParameter("tag"));
			

			ArrayList<Item> list = new ArrayList<>();
			for(int i=1; i<=3; i++){ // 반복문은 1에서 3까지 총 3번 반복! (왜? 키값 뒤에 매번 1,2,3 이렇게 붙어서 키값으로 i를 활용하기 위해)
				// 상의
				String topNo = "topNo" + i;
				String top = "top" + i;
				String topLink = "topLinkNo" + i;
				if(!multiRequest.getParameter(top).equals("")){ // 넘어온값이 있을때만 => Item객체 새로 생성해서
					Item il = new Item();
					il.setItemNo(Integer.parseInt(topNo));
					il.setItemName(multiRequest.getParameter(top));   // 상의 아이템명 담고
					il.setItemLink(multiRequest.getParameter(topLink));
					il.setItemCategory("상의");
					list.add(il); // 리스트에 추가
				}
				
				// 위와 동일
				String bottomNo = "bottomNo" + i;
				String bottom = "bottom" + i;
				String bottomLink = "bottomLinkNo" + i;
				if(!multiRequest.getParameter(bottom).equals("")){
					Item il = new Item();
					il.setItemNo(Integer.parseInt(bottomNo));
					il.setItemName(multiRequest.getParameter(bottom));
					il.setItemLink(multiRequest.getParameter(bottomLink));
					il.setItemCategory("하의");
					list.add(il);
				}
				
				String shoesNo = "shoesNo" + i;
				String shoes = "shoesNo" + i;
				String shoesLink = "shoesLinkNo" + i;
				if(!multiRequest.getParameter(shoes).equals("")){
					Item il = new Item();
					il.setItemNo(Integer.parseInt(shoesNo));
					il.setItemName(multiRequest.getParameter(shoes));
					il.setItemLink(multiRequest.getParameter(shoesLink));
					il.setItemCategory("신발");
					list.add(il);
				}
				
				String etcNo = "etcNo" + i;
				String etc = "etcNo" + i;
				String etcLink = "etcLinkNo" + i;
				if(!multiRequest.getParameter(etc).equals("")){
					Item il = new Item();
					il.setItemNo(Integer.parseInt(etcNo));
					il.setItemName(multiRequest.getParameter(etc));
					il.setItemLink(multiRequest.getParameter(etcLink));
					il.setItemCategory("기타");
					list.add(il);
				}
				
			}
			
			System.out.println(list);
			int result = new DailyService().updateDaily(d, list);
			
			if(result > 0) {
				response.sendRedirect("datail.da>?dno="+dailyNo);
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
