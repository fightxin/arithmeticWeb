<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.dmego.domain.ProAns" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>答题页面</title>
  </head>

  <body>
     <h1 align="center">答题界面</h1><hr/>
     <%
     session = request.getSession();
     int num = (int)session.getAttribute("Num");
     ProAns[] proBean = new ProAns[num]; 
     proBean = (ProAns[])session.getAttribute("proBean");
     %>
     <form action="${pageContext.request.contextPath }/servlet/CheckServlet" method="post">
        <table align="center">
	        <%
	         for(int i = 0; i < num; i++){
	         %>
	         <tr>
	           <td align="left">
	               <% out.print("第"+proBean[i].getId()+"题：");%>
	           </td>
	           <td align="right">
	                <%= proBean[i].getProblem()+" = " %>
	            </td>
	            <td>
	             <input type="text" name="answer+<%=i %>+" /><br/> 
	            </td>
	         </tr>
	          <% 
	          }   
	         %>
	         <tr>
	           <td colspan="3" align="center">
	               <input type="submit" value="交卷" />
	           </td>
	         </tr>
        
        </table>
	     
     </form>

  </body>
</html>
