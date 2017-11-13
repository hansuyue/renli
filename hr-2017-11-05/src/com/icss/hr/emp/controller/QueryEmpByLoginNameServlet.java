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
import javax.websocket.Session;

import com.google.gson.Gson;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**根据登录名查询数据
 * Servlet implementation class QueryEmpByLoginNameServlet
 */
@WebServlet("/QueryEmpByLoginNameServlet")
public class QueryEmpByLoginNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		//输出流
		PrintWriter out = response.getWriter();
		
		//从session里取出用户名
		HttpSession session = request.getSession();
		String empLoginName = (String)session.getAttribute("empLoginName");
		System.out.println(empLoginName);
		
		EmpService service = new EmpService();
		
		try {
			
			Emp emp = service.queryEmpByLogIn(empLoginName);
//			System.out.println(emp);
			Gson gson = new Gson();
			
			out.write(gson.toJson(emp));
			System.out.println(gson.toJson(emp));
			
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
