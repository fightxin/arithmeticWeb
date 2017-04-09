<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>回顾错题</title>
  </head>
  
  <body>
   <h1 align="center">回顾错题</h1><hr>
        <form action="${pageContext.request.contextPath }/servlet/HistoryServlet"  method="post">
            <table align="center">
                <tr>
                   <td align="center" colspan="2">
                       <input type ="radio"  name="backWrong" value="show"/>查看错题
                       <input type ="radio"  name="backWrong" value="practice"/>练习错题
                   </td>
                </tr> 
                <tr>
                    <td align="center" colspan="2">
                        <input type="submit" value="确定">
                    </td>
                </tr>                
            </table>                     
        </form>
  </body>
</html>
