package com.icss.hr.dept.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**����ID��ò������ݵĿ�����
 * Servlet implementation class GetDeptServlet
 */
@WebServlet("/GetDeptServlet")
public class GetDeptServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptId = request.getParameter("deptId");
		
		DeptService service = new DeptService();
		
		try {
			
			Dept dept = service.querydeptById(Integer.parseInt(deptId));
			
			//��request�д洢����
			request.setAttribute("dept", dept);
			//ת����jsp
			request.getRequestDispatcher("/updataDept.jsp").forward(request,response);
			
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
