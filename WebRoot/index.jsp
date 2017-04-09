<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>导航页面</title>
  </head>
  
  <body>
   <h1 align="center">功能选择</h1><hr>
        <form action="${pageContext.request.contextPath }/servlet/indexServlet"  method="post">
            <table align="center">
                <tr>
                   <td align="center" colspan="2">
                       <input type ="radio"  name="function" value="online"/>在线答题
                       <input type ="radio"  name="function" value="history"/>回顾错题
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
