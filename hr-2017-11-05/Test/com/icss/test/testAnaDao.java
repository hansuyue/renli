package com.icss.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * 测试数据分析
 * @author DLETC
 *
 */
public class testAnaDao {

	@Test
	public void test(){
		
		HashMap<String, Object> map1 = new HashMap<>();
		map1.put("dept", "会计部");
		map1.put("empCount", 7);
		
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("dept", "会计部");
		map2.put("empCount", 7);
		
		HashMap<String, Object> map3 = new HashMap<>();
		map3.put("dept", "会计部");
		map3.put("empCount", 7);
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		System.out.println(list);
		
		
	}
	
	@Test
	public void testquery() throws Exception{
		
		AnaDao dao = new AnaDao();
		
		List<HashMap<String, Object>> list = dao.queryEmpCount();
		
		System.out.println(list);
		
		
	}
	
}
