package com.icss.hr.dept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**��ѯ���ſ�����
 * Servlet implementation class QueryDeptServlet
 */
@WebServlet("/QueryDeptServlet")
public class QueryDeptServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeptService service = new DeptService();
		
		try {
			List<Dept> list = service.querydept();
			
			request.setAttribute("list", list);
			
			//����ת����jsp
			RequestDispatcher rd = request.getRequestDispatcher("/queryDept.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//�ֶ�ת��
			request.getRequestDispatcher("/error.html");
			
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
