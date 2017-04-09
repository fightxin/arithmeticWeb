package cn.dmego.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dmego.domain.ProAns;
import cn.dmego.service.ProAnsService;

public class CheckServlet extends HttpServlet {
	ProAnsService service = new ProAnsService();
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ProAns[] proBean = (ProAns[]) session.getAttribute("proBean");
		Enumeration<String> enumeration = request.getParameterNames();
		int i = 0;
		while(enumeration.hasMoreElements()){
			String name = (String) enumeration.nextElement();
			String yourAns = request.getParameter(name);
			proBean[i].setYourAns(yourAns);
			i++;
		}
		proBean = service.checkAnswer(proBean);
		session.setAttribute("proBean", proBean);
		service.saveToDB(proBean);
		response.sendRedirect(request.getContextPath()+"/Result.jsp"); //重定向到结果界面
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
