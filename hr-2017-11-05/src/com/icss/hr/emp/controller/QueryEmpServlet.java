package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * Servlet implementation class QueryEmpServlet
 */
@WebServlet("/QueryEmpServlet")
public class QueryEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		//输出流
		PrintWriter out = response.getWriter();
		
		//获得页码
		String pageNumStr = request.getParameter("pageNum");
		//
		String pageSizeStr = request.getParameter("pageSize");
		
		
		int pageNum = 1;
		int pageSize = 10;
		
		try {
			
			pageNum = Integer.parseInt(pageNumStr);
			
		} catch (Exception e) {
			// TODO: handle exception
				
		}
		
		try {
			
			pageSize = Integer.parseInt(pageSizeStr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//调用业务对象
		EmpService service = new EmpService();
		
		Pager pager;
		try {
			
			pager = new Pager(service.getEmpCount(),pageSize,pageNum);
			
			List<Emp> list = service.queryEmpBypage(pager);
			
			HashMap<String, Object> map = new HashMap<>();
			
			map.put("pager", pager);
			map.put("list", list);
			
			Gson gson = new GsonBuilder()  
					  .setDateFormat("yyyy-MM-dd")  
					  .create();
			out.write(gson.toJson(map));

			
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
