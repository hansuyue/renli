package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**���Ӳ��ſ�����
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�����������
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
//		response.setCharacterEncoding("utf-8");//���Ƽ�����Ҫ������ֶ��л�����
		//������Ӧ��MIME���ͺͱ���
		response.setContentType("text/html;charset=utf-8");
		
		
		//
		PrintWriter out = response.getWriter();
		
		//����������
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
		Dept dept = new Dept(deptName,deptLoc);
		
		//
		DeptService deptService = new DeptService();
		
		try {
			deptService.addDept(dept);
			
			response.sendRedirect("QueryDeptServlet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
