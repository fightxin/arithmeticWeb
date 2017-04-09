package cn.dmego.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dmego.domain.ProAns;
import cn.dmego.service.ProAnsService;

public class MenuServlet extends HttpServlet {
	ProAnsService service = new ProAnsService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//---解决乱码问题---
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String hasMD = request.getParameter("hasMD");
		String hasFS = request.getParameter("hasFS");
		String hasGD = request.getParameter("hasGD");
		int Range = Integer.parseInt(request.getParameter("Range")) ;
		int Num = Integer.parseInt(request.getParameter("Num"));
		int Numsy = Integer.parseInt(request.getParameter("Numsy"));
		ProAns[] proBean = new ProAns[Num]; 
		proBean = service.produce(hasMD, hasFS,hasGD, Range, Num,Numsy); //生成题目
		HttpSession session = request.getSession(); 
		session.setAttribute("Num", Num); 
		session.setAttribute("proBean", proBean);
		response.sendRedirect(request.getContextPath()+"/Answer.jsp"); //重定向到答题页面	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);

	}

}
