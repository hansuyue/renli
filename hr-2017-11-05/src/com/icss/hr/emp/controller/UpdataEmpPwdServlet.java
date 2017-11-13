package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * Servlet implementation class UpdataEmpPwdServlet
 */
@WebServlet("/UpdataEmpPwdServlet")
public class UpdataEmpPwdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		response.setContentType("text/html;charSet=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获得输出流
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String empLoginName = (String)session.getAttribute("empLoginName");
//		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("newPwd");
		
		Emp emp = new Emp();
		emp.setEmpLoginName(empLoginName);
		emp.setEmpPwd(empPwd);
		
		EmpService service = new EmpService();
		
		try {
			service.updataEmpPwd(emp);
		} catch (SQLException e) {
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
