package cn.dmego.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dmego.domain.WrongPro;
import cn.dmego.service.WrongProService;

public class checkWrServlet extends HttpServlet {
	WrongProService wroService = new WrongProService();
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<WrongPro> wrongBean = new ArrayList<WrongPro>();
	    wrongBean = (ArrayList<WrongPro>)session.getAttribute("wrongBean");
		Enumeration<String> enumeration = request.getParameterNames();
		int i = 0;
		while(enumeration.hasMoreElements()){
			String name = (String) enumeration.nextElement();
			String yourAns = request.getParameter(name);
			wrongBean.get(i).setYourAns(yourAns);
			i++;
		}
		wrongBean = wroService.checkWrAnswer(wrongBean);
		session.setAttribute("wrongBean", wrongBean);
		wroService.reSaveWrongToDB(wrongBean); //�����ô�����ٴ�
		wroService.wipeWrongInDB(); //Ȼ��Ӵ������ɾ����Ե���
		response.sendRedirect(request.getContextPath()+"/pwResult.jsp");//�ض�����ϰ����Ľ������
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
