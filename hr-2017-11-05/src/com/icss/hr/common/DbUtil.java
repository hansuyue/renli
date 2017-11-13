package com.icss.hr.common;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ����ӹ�����
 * @author DLETC
 *
 */
public class DbUtil {
	
	//����Դ����
	private static ComboPooledDataSource dataSource;
	
	//�����̶߳���
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	//�������ӳز���
	static{
		dataSource = new ComboPooledDataSource();
		try{
			//���ݿ���ز���
			dataSource.setUser("myhr");//�û���
			dataSource.setPassword("myhr");//����
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");//�����ַ���
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");//ע������
			//���ӳ���ز���
			dataSource.setInitialPoolSize(10);//��ʼ������
			dataSource.setMaxPoolSize(10);//���������
			dataSource.setMinPoolSize(10);//��С������
			dataSource.setMaxIdleTime(60);//������ʱ��60�룬���Ӷ���60����û��ʹ�òŻᱻ����
		} catch (PropertyVetoException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * ͨ�����ӳض��󷵻����ݿ�����
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		
		//�ӱ����߳�ȡ�����Ӷ���
		Connection conn = threadLocal.get();
		
		//��������߳���û�����Ӷ�����ô�����ӳ��л��һ����������
		
		if(conn == null ||conn.isClosed()){
			//�ѵ�ǰȡ���Ķ����ȷŵ������̶߳�����
			conn = dataSource.getConnection();
			threadLocal.set(conn);
			
		}
		System.out.println("������ݿ����ӣ�ʣ����У�" + dataSource.getNumIdleConnections());
		
		return conn;
	}
	
	/**
	 * ͳһ�ر�����
	 * @return
	 */
	
	public static void close() {
		
		Connection conn = threadLocal.get();
		
		try {
			//������Ӳ�Ϊ����û�йر�
			if (conn != null && !conn.isClosed()) {
				//�ر�����
				conn.close();
				//����洢
				threadLocal.set(null);
				System.out.println("close");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
