package com.icss.hr.analysis.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.icss.hr.analysis.dao.AnaDao;

public class AnaService {
	
	AnaDao dao = new AnaDao();
	
	public List<HashMap<String, Object>> queryEmpCount() throws SQLException{
		
		List<HashMap<String, Object>> list = dao.queryEmpCount();
		return list;
				
	}
	
	
}
