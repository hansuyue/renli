package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**根据id返回员工数据
 * 
 * Servlet implementation class GetEmpServlet
 */
@WebServlet("/GetEmpServlet")
public class GetEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 输出流
		PrintWriter out = response.getWriter();
		
		//获得员工id
		String empId = request.getParameter("empId");
		
		EmpService service = new EmpService();
		
		try {
			Emp emp = service.queryById(Integer.parseInt(empId));
			
			Gson gson = new GsonBuilder()  
					  .setDateFormat("yyyy-MM-dd")  
					  .create();
			out.write(gson.toJson(emp));
			
		} catch (Exception e) {
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
