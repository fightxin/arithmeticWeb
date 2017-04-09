<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>年级设置</title>
  </head>
  
  <body>
    <h1 align="center">年级设置</h1><hr>
        <form action="${pageContext.request.contextPath }/servlet/GradeServlet"  method="post">
            <table align="center">
                <tr>
                   <td >
                      <font>年级设置 : </font>
                   </td>
                   <td>
                       <select name="Grade">
                       <option >-请选择-</option>
                       <option value="1">一年级</option>
                       <option value="2">二年级</option>
                       <option value="3">三年级</option>
                       <option value="4">四年级</option>
                       <option value="5">五年级</option>
                       <option value="6">六年级</option>
                       </select>
                    </td>
                </tr>
               <tr>
                  <td align="center" colspan="2">
                      <input type ="submit" value="提交" />
                  </td>
               </tr>                        
           </table>                     
       </form>
  </body>
</html>
