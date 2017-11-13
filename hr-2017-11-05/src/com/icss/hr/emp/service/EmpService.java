package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
/**
 * Ա��ҵ��
 * @author DLETC
 *
 */
public class EmpService {
	
	EmpDao dao = new EmpDao();
	
	/**
	 * ��¼ҵ�񣺴����û�����������֤�û���¼
	 * @param empLoginName
	 * @param empPwd
	 * @return 1���û���������
	 * 		    2�����벻��ȷ
	 * 			3����¼�ɹ�
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
