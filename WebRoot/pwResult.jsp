<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.dmego.domain.WrongPro" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>错题练习结果</title>
  </head>
  
  <body>
   <h1 align="center">结果页面</h1><hr>
     <%
      session = request.getSession();
    ArrayList<WrongPro> wrongBean = new ArrayList<WrongPro>();
    wrongBean = (ArrayList<WrongPro>)session.getAttribute("wrongBean");
     %>
      <form action="" method="post">
        <table align="center">
         <%
         for(int i = 0; i < wrongBean.size(); i++){
            if(wrongBean.get(i).getYourAns().equals("")){
         %>  
          <tr>
             <td>
                <%out.print("第"+( i+1 )+"题：");%>
             </td>
             <td align="right">
                <%= wrongBean.get(i).getProblem()+" = " + wrongBean.get(i).getYourAns()%>
             </td>
             <td>
                <%=", 这道题你没有作答,正确答案是"+wrongBean.get(i).getRightAns()%>
             </td>
         </tr> 
          <%      
          }else{
          %>
         <tr>
            <td>
               <% out.print("第"+ (i+1) +"道错题：");%>
            </td>
            <td align="right">
               <%out.print( wrongBean.get(i).getProblem()+" = " + wrongBean.get(i).getYourAns());%>
            </td>
            <% 
              if(wrongBean.get(i).getChecks()== -1){
            %>
             <td>
                <% out.print(", 这是第"+wrongBean.get(i).getTimes()+"次答错该道题,正确答案是"+wrongBean.get(i).getRightAns());%>
             </td>
            <% 
               }else if(wrongBean.get(i).getChecks()== 1){
            %>
             <td>
                <% out.print(", 恭喜你答对了，已经将该道题从错题本中移除"); }%>
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
