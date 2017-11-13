package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;



/**
 * 测试部门数据访问层方法
 * @author DLETC
 *
 */
public class TestDeptDao {
	
	private DeptDao dao= new DeptDao();
	
	@Test
	public void testInsert() throws SQLException{
		
		Dept dept = new Dept("科技部","北京");
		
		dao.insert(dept);
		
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		Dept dept = new Dept(1,"会计部","南京");
		
		dao.update(dept);
		
	}
	
	@Test
	public void testDelete() throws SQLException{
		
		dao.delete(5);
		
	}
	
	@Test
	public void testQueryById() throws SQLException{
		Dept dept = dao.queryById(2);
		System.out.println(dept);
	}
	@Test
	public void testQuery() throws SQLException{
		List<Dept> list = dao.query();
		for(Dept dept : list){
			System.out.println(dept);
		}
	}
	
//	@Test
//	public void testUpdate(){
//		System.out.println("test update");
//	}
	
}
