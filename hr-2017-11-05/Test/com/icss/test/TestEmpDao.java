package com.icss.test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.startup.Tomcat;
import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;

/**
 * 
 * @author DLETC
 *
 */
public class TestEmpDao {
	@Test
	public void testInsert() throws SQLException{
		
		EmpDao dao = new EmpDao();
		
		Dept dept= new Dept();
		dept.setDeptId(2);
		Job job = new Job();
		job.setJobId(2);
		
		Emp emp = new Emp("jack","jack","123456","jack@163.com","13012345678",3600.0,Date.valueOf("1995-10-21"),dept,job,null,"orcale,java");
		
		dao.insert(emp);
		
	}
	@Test
	public void testUpdate() throws SQLException{
		
		EmpDao dao = new EmpDao();
		
		Dept dept= new Dept();
		dept.setDeptId(1);
		Job job = new Job();
		job.setJobId(1);
		
		Emp emp = new Emp(13,"jack","Jack","654321","jack@163.com","13012345678",3600.0,Date.valueOf("1995-10-21"),dept,job,null,"orcale,java");
		
		dao.update(emp);
		
	}
	@Test
	public void testDelete() throws SQLException {
		EmpDao dao = new EmpDao();
		dao.delete(4);
	}
	
	@Test
	public void testQueryById() throws SQLException {
		EmpDao dao = new EmpDao();
		System.out.println(dao.queryById(5));
	}
	
	@Test
	public void testlogin() throws SQLException {
		
		EmpDao dao = new EmpDao();
		
		System.out.println(dao.queryByLoginName("tom"));
		

	}
	
	@Test
	public void testInsertMany() throws SQLException{
		
		EmpDao dao = new EmpDao();
		
		Dept dept= new Dept();
		dept.setDeptId(1);
		Job job = new Job();
		job.setJobId(1);
		
		for (int i = 21 ;i <= 40;i ++){
			Emp emp = new Emp("jack" + i,"jack" + i,"123456","jack@163.com","13012345678",4700.0,Date.valueOf("2000-10-1"),dept,job,null,"orcale,java");
		
			dao.insert(emp);
		}
		
		
		
	}
	
	@Test
	public void testCount() throws SQLException {
		
		EmpDao dao = new EmpDao();
		
		System.out.println(dao.getCount());
		

	}
	
	@Test
	public void testQueryByPage() throws SQLException {
		
		EmpDao dao = new EmpDao();
		
		Pager pager = new Pager(dao.getCount(),10,4);
		
		List<Emp> list = dao.queryByPager(pager);
		
		for(Emp emp : list){
			
			System.out.println(emp);
			
		}

	}
	@Test
	public void testUpdatePwd() throws SQLException{
		EmpDao dao = new EmpDao();
		
		Emp emp = new Emp();
		
		emp.setEmpPwd("456789");
		emp.setEmpLoginName("tom");
		
		dao.updatePwd(emp);
		
		
	}
	
	@Test
	public void testUpdatePic() throws SQLException{
		EmpDao dao = new EmpDao();
		
		Emp emp = new Emp();
		
//		emp.setEmpPic(empPic);
		
		dao.updateEmpPic("tom", "Asd");
		
		
	}
	
	
	
}
