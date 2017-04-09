package cn.dmego.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dmego.domain.WrongPro;
import cn.dmego.service.ProAnsService;

public class OnlineServlet extends HttpServlet {
	ProAnsService service = new ProAnsService();
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//---解决乱码问题---
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String function = request.getParameter("onLineAns");
		if(function.equals("grade")){
			response.sendRedirect(request.getContextPath()+"/grade.jsp");
		}else if(function.equals("parameter")){
			response.sendRedirect(request.getContextPath()+"/Menu.jsp");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
