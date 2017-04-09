package cn.dmego.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class indexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//---�����������---
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String function = request.getParameter("function");
		if(function.equals("online")){
			response.sendRedirect(request.getContextPath()+"/Online.jsp");//�ض������ߴ���ҳ��
		}else if(function.equals("history")){
			response.sendRedirect(request.getContextPath()+"/History.jsp");//�ض��򵽻ع˴���ҳ��
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
