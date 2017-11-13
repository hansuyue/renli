package com.icss.hr.job.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务业务
 * @author DLETC
 *
 */
public class JobService {
	
	JobDao dao = new JobDao();
	
	public void addJob(Job job) throws SQLException {
		dao.insert(job);
	}
	
	public void updateJob(Job job) throws SQLException{
		dao.update(job);
	}
	
	public void deleteJob(int id) throws SQLException{
		dao.delete(id);
	}
	
	public Job queryById(int id) throws SQLException {
		Job job = dao.queryById(id);
		return job;
	}
	
	public List<Job> query() throws SQLException{
		List<Job> list = dao.query();
		
		return list;
	}
	
}
