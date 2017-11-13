package com.icss.test;

import java.sql.SQLException;

import org.junit.Test;

import com.icss.hr.emp.service.EmpService;

public class TestEmpService {
	
	private EmpService empService = new EmpService();
	
	@Test
	public void testCheckLogin() throws SQLException{
		int result = empService.checkLogin("tm", "123456");
		
		System.out.println(result);
		
	}
	
}
