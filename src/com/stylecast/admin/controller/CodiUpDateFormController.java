package com.stylecast.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.admin.model.service.CodiService;
import com.stylecast.admin.model.vo.Codi;
import com.sun.xml.internal.ws.api.message.Attachment;


/**
 * Servlet implementation class CodiUpDateController
 */
@WebServlet("/codiUpDate.ad")
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
		
		int codiNo = Integer.parseInt(request.getParameter("cno"));
		
		Codi c = new CodiService().selectCodiUpdate(codiNo);
		
		
		request.setAttribute("c", c);
		
		request.getRequestDispatcher("views/admin/adminCodiUpdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
