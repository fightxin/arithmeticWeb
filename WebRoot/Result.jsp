<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.dmego.domain.ProAns" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>结果页面</title>
  </head>
  
  <body>
    <h1 align="center">结果页面</h1><hr>
     <%
     session = request.getSession();
     int num = (int)session.getAttribute("Num");
     ProAns[] proBean = new ProAns[num]; 
     proBean = (ProAns[])session.getAttribute("proBean");
     %>
      <form action="" method="post">
        <table align="center">
         <%
         for(int i = 0; i < num; i++){
              if(proBean[i].getYourAns().equals("")){
         %>  
         <tr>
             <td>
                <%out.print("第"+proBean[i].getId()+"题：");%>
             </td>
             <td align="right">
                <%= proBean[i].getProblem()+" = " + proBean[i].getYourAns()%>
             </td>
             <td>
                <%=", 这道题你没有作答,正确答案是"+proBean[i].getRightAns()%>
             </td>
         </tr> 
          <%      
          }else{
          %>
          <tr>
            <td>
               <%out.print("第"+proBean[i].getId()+"题：");%>
            </td>
            <td align="right">
               <%= proBean[i].getProblem()+" = " + proBean[i].getYourAns()%>
            </td>
            <% 
              if(proBean[i].getChecks()== -1){
            %>
             <td>
                <% out.print(", 答错了,正确答案是"+proBean[i].getRightAns());%>
             </td>
            <% 
               }else if(proBean[i].getChecks()== 1){
            %>
             <td>
                <% out.print(", 答对了"); }%>
             </td>
         </tr>  
         <%
           } 
         }   
         %> 

        </table>
     </form>
  </body>
</html>
