package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**根据id返回图片二进制数据
 * Servlet implementation class GetPicServlet
 */
@WebServlet("/GetPicServlet")
public class GetPicServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//输出流
		OutputStream out = response.getOutputStream();
		
		//
		String picId = request.getParameter("picId");
		
		//
		PicService service = new PicService();
		
		try {
			Pic pic = service.queryById(Integer.parseInt(picId));
			
			//
			InputStream is = pic.getPicData();
			
			//
			byte[] b = new byte[1024 * 8];
			
			int len = is.read(b);
			
			while (len != -1) {
				
				out.write(b,0,len);
				len = is.read(b);
				
			}
			
			is.close();
			out.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
