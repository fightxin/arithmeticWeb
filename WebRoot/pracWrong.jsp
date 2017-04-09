<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.dmego.domain.WrongPro"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>练习错题</title>
  </head>
  
  <body>
    <h1 align="center">练习错题</h1><hr>
    <%
    session = request.getSession();
    ArrayList<WrongPro> wrongBean = new ArrayList<WrongPro>();
    wrongBean = (ArrayList<WrongPro>)session.getAttribute("wrongBean");
     %>
     <form action="${pageContext.request.contextPath }/servlet/checkWrServlet" method="post">
        <table align="center">
         <%
         for(int i = 0; i < wrongBean.size(); i++){
         %>  
          <tr>
           <td align="left">
                   <% out.print("第"+ (i+1) +"道错题：");%>
               </td>
            <td align="right">
               <%= wrongBean.get(i).getProblem()+" = " %>
            </td>
             <td>
                <input type="text" name="answer+<%=i %>+" />
             </td>
         </tr>  
         <%
         }   
         %> 
         <tr>
            <td colspan="2" align="center">
                <input type="submit" value="交卷" />
            </td>
         </tr>
        </table>
     </form>
  </body>
</html>
