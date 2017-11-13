package com.icss.hr.pic.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.service.PicService;

/**É¾³ýÍ¼Æ¬¿ØÖÆÆ÷
 * Servlet implementation class DelPicServlet
 */
@WebServlet("/DelPicServlet")
public class DelPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String picId = request.getParameter("picId");
		
		System.out.println(picId);
		
		PicService service = new PicService();
		
		try {
			service.delete(Integer.parseInt(picId));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
