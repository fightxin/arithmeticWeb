package cn.dmego.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dmego.domain.WrongPro;
import cn.dmego.service.WrongProService;

public class HistoryServlet extends HttpServlet {
	WrongProService wrongService = new WrongProService();
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//---解决乱码问题---
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			String function = request.getParameter("backWrong");
			
			HttpSession session = request.getSession();
			ArrayList<WrongPro> wrongBean = new ArrayList<WrongPro>();
			wrongBean = wrongService.showWrong();
			session.setAttribute("wrongBean", wrongBean);
			if(function.equals("show")){
				response.sendRedirect(request.getContextPath()+"/showWrong.jsp");
			}else if(function.equals("practice")){
				response.sendRedirect(request.getContextPath()+"/pracWrong.jsp");
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
