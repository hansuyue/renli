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

/**修改部门控制器
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/UpdataDeptServlet")
public class UpdataDeptServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
//		response.setCharacterEncoding("utf-8");//不推荐，需要浏览器手动切换编码
		//设置响应的MIME类型和编码
		response.setContentType("text/html;charset=utf-8");
		
		
		//
		PrintWriter out = response.getWriter();
		
		//获得请求参数
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		String deptId = request.getParameter("deptId");
		
		Dept dept = new Dept(Integer.parseInt(deptId),deptName,deptLoc);
		
		//
		DeptService deptService = new DeptService();
		
		try {
			deptService.updateDept(dept);
			
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
