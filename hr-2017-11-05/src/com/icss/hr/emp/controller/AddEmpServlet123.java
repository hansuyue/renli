package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.job.pojo.Job;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/AddEmpServlet123")
public class AddEmpServlet123 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//输出流
		PrintWriter out = response.getWriter();
		
		//获得请求参数
		
		String empName = request.getParameter("empName");
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");
		String empEmail = request.getParameter("empEmail");
		String empPhone = request.getParameter("empPhone");
		String empSalary = request.getParameter("empSalary");
		String empHiredate = request.getParameter("empHiredate");
		String empDept = request.getParameter("empDeptId");
		String empJob = request.getParameter("empJobId");
		String empInfo = request.getParameter("empInfo");
		
		Dept dept = new Dept();
		dept.setDeptId(Integer.parseInt(empDept));
		Job job = new Job();
		job.setJobId(Integer.parseInt(empJob));
		
		Emp emp = new Emp(empName,empLoginName,empPwd,empEmail,empPhone,Integer.parseInt(empSalary),Date.valueOf(empHiredate),dept,job,null,empInfo);
		
		EmpService es = new EmpService();
		
		try {
			es.addEmp(emp);
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
