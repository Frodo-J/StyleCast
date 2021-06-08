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
			
			Daily d = new Daily();
			d.setDailyImg(multiRequest.getParameter("originImage"));
			
			//새로 전달된 파일이 있는 경우
			//if(multiRequest.getParameter("reUpfile") != null) {
			if(multiRequest.getOriginalFileName("reUpfile") != null) {
				
				if(multiRequest.getParameter("originImage") != null) { // 기존의 파일이 있었을 경우 
					
					d.setDailyImg("/resources/daily_updiles/" + multiRequest.getFilesystemName("reUpfile"));
					
					new File(savePath + multiRequest.getParameter("originFilePath")).delete();
				}/*else {
					d.setDailyImg("resources/daily_updiles/" + multiRequest.getFilesystemName("reUpfile"));
				}*/
				
			}
			
			
			int dailyNo = Integer.parseInt(multiRequest.getParameter("dno"));
			
			d.setDailyNo(dailyNo);
			d.setDailyContent(multiRequest.getParameter("dailyContent"));
			d.setTag(multiRequest.getParameter("tag"));
			

			ArrayList<Item> list = new ArrayList<>();
			for(int i=1; i<=3; i++){ 

	          // 상의
	            String topNo = "topNo" + i; // 기존의 상의가 2개가 이미 존재했을 경우 그때는 topNo1, topNo2라는 키값으로 값이 넘어왔을것 
	            String top = "top" + i;
	            String topLink = "topLink" + i;

	            if(!multiRequest.getParameter(top).equals("")){ // 우선 해당 키값의 아이템명이 넘어왔을 경우

	                Item il = new Item(); // 우선 기존의 아이템이 있었던 새로운 아이템이 추가가 됏던 간에 값을 담기위한 Item객체 생성
	                il.setItemName(multiRequest.getParameter(top));   // 상의 아이템명 담고
	                il.setItemLink(multiRequest.getParameter(topLink)); // 상의 링크 담고
	                il.setItemCategory("상의"); // 상의 카테고리 담고
	                // 위의 아이템 명과 링크, 카테고리는 기존에 item이 있었던 새로이 추가된 item이던 간에 공통적으로 필요한 값

	                if(multiRequest.getParameter(topNo) != null){ // 근데 만약에 topNoX 키값으로 뭔가 넘어온 값이 존재할경우 == 기존에 애초에 등록되어있는 item이 있었다란 소리
	                    il.setItemNo(Integer.parseInt(multiRequest.getParameter(topNo)));
	                }else{ // 새로이 추가된 item이란 소리
	                    il.setDailyNo(dailyNo); // 이때는 현재의 데일리번호를 담음 => 왜? insert할때 필요하니깐! 
	                }
	               
	                list.add(il); // 리스트에 추가
	            }
	            
	         // 하의
	            String bottomNo = "bottomNo" + i; // 기존의 하의가 2개가 이미 존재했을 경우 그때는 bottomNo1, bottomNo2라는 키값으로 값이 넘어왔을것 
	            String bottom = "bottom" + i;
	            String bottomLink = "bottomLink" + i;

	            if(!multiRequest.getParameter(bottom).equals("")){ // 우선 해당 키값의 아이템명이 넘어왔을 경우

	                Item il = new Item(); // 우선 기존의 아이템이 있었던 새로운 아이템이 추가가 됏던 간에 값을 담기위한 Item객체 생성
	                il.setItemName(multiRequest.getParameter(bottom));   // 하의 아이템명 담고
	                il.setItemLink(multiRequest.getParameter(bottomLink)); // 하의 링크 담고
	                il.setItemCategory("하의"); // 하의 카테고리 담고
	                // 위의 아이템 명과 링크, 카테고리는 기존에 item이 있었던 새로이 추가된 item이던 간에 공통적으로 필요한 값

	                if(multiRequest.getParameter(bottomNo) != null){ // 근데 만약에 bottomNoX 키값으로 뭔가 넘어온 값이 존재할경우 == 기존에 애초에 등록되어있는 item이 있었다란 소리
	                    il.setItemNo(Integer.parseInt(multiRequest.getParameter(bottomNo)));
	                }else{ // 새로이 추가된 item이란 소리
	                    il.setDailyNo(dailyNo); // 이때는 현재의 데일리번호를 담음 => 왜? insert할때 필요하니깐!
	                }
	               
	                list.add(il); // 리스트에 추가
	            }
	            
	         // 신발
	            String shoesNo = "shoesNo" + i; // 기존의 신발이 2개가 이미 존재했을 경우 그때는 shoesNo1, shoesNo2라는 키값으로 값이 넘어왔을것 
	            String shoes = "shoes" + i;
	            String shoesLink = "shoesLink" + i;

	            if(!multiRequest.getParameter(shoes).equals("")){ // 우선 해당 키값의 아이템명이 넘어왔을 경우

	                Item il = new Item(); // 우선 기존의 아이템이 있었던 새로운 아이템이 추가가 됏던 간에 값을 담기위한 Item객체 생성
	                il.setItemName(multiRequest.getParameter(shoes));   // 신발 아이템명 담고
	                il.setItemLink(multiRequest.getParameter(shoesLink)); // 신발 링크 담고
	                il.setItemCategory("신발"); // 상의 카테고리 담고
	                // 위의 아이템 명과 링크, 카테고리는 기존에 item이 있었던 새로이 추가된 item이던 간에 공통적으로 필요한 값

	                if(multiRequest.getParameter(shoesNo) != null){ // 근데 만약에 shoesNoX 키값으로 뭔가 넘어온 값이 존재할경우 == 기존에 애초에 등록되어있는 item이 있었다란 소리
	                    il.setItemNo(Integer.parseInt(multiRequest.getParameter(shoesNo)));
	                }else{ // 새로이 추가된 item이란 소리
	                    il.setDailyNo(dailyNo); // 이때는 현재의 데일리번호를 담음 => 왜? insert할때 필요하니깐! 
	                }
	               
	                list.add(il); // 리스트에 추가
	            }
	            
	         // 기타
	            String etcNo = "etcNo" + i; // 기존의 기타가 2개가 이미 존재했을 경우 그때는 etcNo1, etcNo2라는 키값으로 값이 넘어왔을것 
	            String etc = "etc" + i;
	            String etcLink = "etcLink" + i;

	            if(!multiRequest.getParameter(etc).equals("")){ // 우선 해당 키값의 아이템명이 넘어왔을 경우

	                Item il = new Item(); // 우선 기존의 아이템이 있었던 새로운 아이템이 추가가 됏던 간에 값을 담기위한 Item객체 생성
	                il.setItemName(multiRequest.getParameter(etc));   // 기타 아이템명 담고
	                il.setItemLink(multiRequest.getParameter(etcLink)); // 기타 링크 담고
	                il.setItemCategory("기타"); // 상의 카테고리 담고
	                // 위의 아이템 명과 링크, 카테고리는 기존에 item이 있었던 새로이 추가된 item이던 간에 공통적으로 필요한 값

	                if(multiRequest.getParameter(etcNo) != null){ // 근데 만약에 topNoX 키값으로 뭔가 넘어온 값이 존재할경우 == 기존에 애초에 등록되어있는 item이 있었다란 소리
	                    il.setItemNo(Integer.parseInt(multiRequest.getParameter(etcNo)));
	                }else{ // 새로이 추가된 item이란 소리
	                    il.setDailyNo(dailyNo); // 이때는 현재의 데일리번호를 담음 => 왜? insert할때 필요하니깐! 
	                }
	               
	                list.add(il); // 리스트에 추가
	            }

			}
			
			
			System.out.println(list);
            int result = new DailyService().updateDaily(d, list);
            
            if(result > 0) {
               response.sendRedirect("detail.da?dno="+dailyNo);
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
