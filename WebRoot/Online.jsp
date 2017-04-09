<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>在线答题</title>
  </head>
  
  <body>
     <h1 align="center">在线答题</h1><hr>
        <form action="${pageContext.request.contextPath }/servlet/OnlineServlet"  method="post">
            <table align="center">
                <tr>
                   <td align="center" colspan="2">
                       <input type ="radio"  name="onLineAns" value="grade"/>按年级答题
                       <input type ="radio"  name="onLineAns" value="parameter"/>按参数答题
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
