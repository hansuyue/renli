package com.icss.hr.dept.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.DeptService;

import oracle.net.aso.e;

/**删除部门的控制器
 * Servlet implementation class DelDeptServlet
 */
@WebServlet("/DelDeptServlet")
public class DelDeptServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptId = request.getParameter("deptId");
		
		//
		DeptService service = new DeptService();
		
		try {
			service.deleteDept(Integer.parseInt(deptId));
			
			//重定向到查询
			response.sendRedirect("QueryDeptServlet");
			
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
