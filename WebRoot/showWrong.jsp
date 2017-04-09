<%@page import="cn.dmego.domain.WrongPro"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看错题</title>
  </head>
  <body>
    <h1 align="center">查看错题</h1><hr>
    <%
    session = request.getSession();
    ArrayList<WrongPro> wrongBean = new ArrayList<WrongPro>();
    wrongBean = (ArrayList<WrongPro>)session.getAttribute("wrongBean");
     %>
     <form action="" method="post">
        <table align="center">
         <%
         for(int i = 0; i < wrongBean.size(); i++){
         %>  
          <tr>
            <td align="right">
               <%= wrongBean.get(i).getProblem()+" = " + wrongBean.get(i).getYourAns()%>
            </td>
             <td>
                <% out.print(", 该题答错了"+wrongBean.get(i).getTimes()+"次！");%>
             </td>
         </tr>  
         <%
         }   
         %> 
        </table>
     </form>
  </body>
</html>
