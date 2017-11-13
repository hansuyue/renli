package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
/**
 * 员工业务
 * @author DLETC
 *
 */
public class EmpService {
	
	EmpDao dao = new EmpDao();
	
	/**
	 * 登录业务：传入用户名和密码验证用户登录
	 * @param empLoginName
	 * @param empPwd
	 * @return 1：用户名不存在
	 * 		    2：密码不正确
	 * 			3：登录成功
	 * @throws SQLException 
	 */
	public int checkLogin(String empLoginName,String empPwd) throws SQLException{
		
		Emp emp = dao.queryByLoginName(empLoginName);
		
		if (emp == null){
			return 1;
		} else if (!empPwd.equals(emp.getEmpPwd())) {
			return 2;
		} else {
			return 3;
		}
		
	}
	
	public void addEmp(Emp emp) throws SQLException{
		
		dao.insert(emp);
		
	}
	
	public void updateEmp(Emp emp) throws SQLException{
		 
		dao.update(emp);
		
	}
	
	public void deleteEmp(int empId) throws SQLException{
		
		dao.delete(empId);
		
	}
	
	public Emp queryById(int empId) throws SQLException{
		
		return dao.queryById(empId);
		
	}
	

	
	public List<Emp> queryEmpBypage(Pager pager) throws SQLException{
		return dao.queryByPager(pager);
	}
	
	public Emp queryEmpByLogIn(String logName) throws SQLException{
		
		return dao.queryByLoginName(logName);
		
	}
	
	public int getEmpCount() throws SQLException{
		return dao.getCount();
	}
	
	public void updataEmpPwd(Emp emp) throws SQLException{
		dao.updatePwd(emp);
	}
	
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException{
		
		dao.updateEmpPic(empLoginName, empPic);
		
	}
	
	
	
}
