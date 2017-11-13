package com.icss.hr.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.a;

/**����������
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class CommonFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CommonFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		
		//
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		
		//����������������ʵ�ǰ��Ŀ
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//
		String uri = request.getRequestURI().toString();	
		System.out.println(uri);
		
		//webӦ������
		String app = request.getContextPath();
		
		
		//�ж��û���¼״̬
		if (!uri.equals(app + '/')
				&& !uri.equals(app + "/login.html")
				&& !uri.equals(app + "/LoginServlet")
				&& !uri.equals(app + "/logout.jsp")
				&& !uri.startsWith(app + "/css")
				&& !uri.startsWith(app + "/js")
				&& !uri.startsWith(app + "/images")) {
			HttpSession session = request.getSession();
			String empLoginName = (String) session.getAttribute("empLoginName");
			
			if(empLoginName == null){
				
				//�ж��ǲ���ajax��������Ӧ��ͷ������һ������ı�־�Ա�ǰ���ж�
				String ajaxHeader = request.getHeader("x-requested-with");
				if(ajaxHeader != null && ajaxHeader.equalsIgnoreCase("XMLHttpRequest")){
					
					response.setHeader("sessionStatus", "timeout");
					
				} else{
					response.sendRedirect(app + "/logout.jsp");
				}
				
				DbUtil.close();
				
				return;
			}
			
			
		}
		
		
		chain.doFilter(request, response);
		
		//ͳһ�ر�����
		
		DbUtil.close();
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
