package cn.dmego.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dmego.domain.ProAns;
import cn.dmego.service.ProAnsService;

public class GradeServlet extends HttpServlet {
	ProAnsService service = new ProAnsService();
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//---解决乱码问题---
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				
				int grade= Integer.parseInt(request.getParameter("Grade"));
				System.out.println(grade);
				ProAns[] proBean = new ProAns[10]; 
				proBean = service.produce(grade); //生成题目
				HttpSession session = request.getSession(); 
				session.setAttribute("Num", 10); 
				session.setAttribute("proBean", proBean);
				response.sendRedirect(request.getContextPath()+"/Answer.jsp"); //重定向到答题页面
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
