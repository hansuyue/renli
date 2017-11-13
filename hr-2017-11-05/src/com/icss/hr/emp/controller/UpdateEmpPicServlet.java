package com.icss.hr.emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.emp.service.EmpService;

/**更新员工头像
 * Servlet implementation class UpdateEmpPicServlet
 */
@WebServlet("/UpdateEmpPicServlet")
public class UpdateEmpPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得头像是base64数据
		
		String empPic = request.getParameter("empPic");
//		System.out.println(empPic);
		//获得当前用户的登录名
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
//		System.out.println(empLoginName);
		//调用业务对象
		EmpService service = new EmpService();
		
		
		try {
			
			service.updateEmpPic(empLoginName, empPic);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
