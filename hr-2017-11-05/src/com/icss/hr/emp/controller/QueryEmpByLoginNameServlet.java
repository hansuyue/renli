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

/**���ݵ�¼����ѯ����
 * Servlet implementation class QueryEmpByLoginNameServlet
 */
@WebServlet("/QueryEmpByLoginNameServlet")
public class QueryEmpByLoginNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		//�����
		PrintWriter out = response.getWriter();
		
		//��session��ȡ���û���
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
