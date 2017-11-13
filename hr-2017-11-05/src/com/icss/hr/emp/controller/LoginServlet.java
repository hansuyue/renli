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

import com.icss.hr.emp.service.EmpService;

/**验证登录数据访问接口
 * 
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		response.setContentType("text/html;charSet=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获得输出流
		PrintWriter out = response.getWriter();
		
		
		//获得请求参数
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");
		
		EmpService service = new EmpService();
		
		try {
			int reslut = service.checkLogin(empLoginName, empPwd);
			
			
			if(reslut == 3){
//				response.sendRedirect("http://localhost:7777/hr/addEmp.html");
				
				HttpSession session = request.getSession();
				
				session.setAttribute("empLoginName", empLoginName);
				System.out.println(empLoginName);
				
			}
			out.print(reslut);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
