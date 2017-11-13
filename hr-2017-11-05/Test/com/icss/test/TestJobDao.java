package com.icss.test;

import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务dao测试类
 * @author DLETC
 *
 */
public class TestJobDao {
	
	JobDao dao = new JobDao();
	
	@Test
	public void testInsert() throws SQLException{
		
		Job job = new Job("董事长",10000,15000);
		
		dao.insert(job);
		
		
	}
	
	@Test
	public void testUpdate() throws SQLException{
		
		Job job = new Job(3,"董事长",50000,100001);
		
		dao.update(job);
		
	}
	
	@Test
	public void testdelete() throws SQLException {
		int id = 2;
		dao.delete(id);
	}
	
	@Test
	public void testQueryById() throws SQLException {
		
		int jobId = 1;
		
		System.out.println(dao.queryById(jobId));
		
		
	}
	
	@Test
	public void testQuery() throws SQLException{
		
		List<Job> list = dao.query();
		for ( Job job  : list) {
			System.out.println(job);
		}
		
	}
	
}
