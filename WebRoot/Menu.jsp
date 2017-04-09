<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>参数选择</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/checkForm.js">
		    
    </script>
  </head>
  <!--/arithmeticWeb  -->
  <body>
    <h1 align="center">参数选择</h1><hr>
        <form action="${pageContext.request.contextPath }/servlet/MenuServlet" onsubmit="return checkForm()" method="post">
            <table align="center">
	            <tr>
	               <td >
	                  <font>是否有乘除 : </font>
	               </td>
	                <td>
                      <input type="radio" name="hasMD" id="md" value="Y" />是
                      <input type="radio" name="hasMD" id="md" value="N" />否
                   </td>
	            </tr>
	             <tr>
                   <td >
                     <font>是否有真分数：</font>
                   </td>
                   <td>
                     <input type="radio" name="hasFS" id="fs" value="Y" />是
                     <input type="radio" name="hasFS" id="fs" value="N" />否   
                   </td>
                </tr>
                <tr>
                   <td >
                     <font>运算符个数是否固定：</font>
                   </td>
                   <td>
                     <input type="radio" name="hasGD" id="gd" value="Y" />是
                     <input type="radio" name="hasGD" id="gd" value="N" />否   
                   </td>
                </tr>
                <tr>
                   <td >
                     <font>请输入运算符个数：</font>
                   </td>
                   <td>
                     <input type="text" name="Numsy" id="numsy" size="10" placeholder="固定或最大值"/>
                   </td>
                </tr>
                 <tr>
                   <td >
                     <font>请输入出题数值范围：</font>
                   </td>
                   <td>
                     <input type="text" name="Range" id="range" size="10" placeholder="请输入整数"/>
                   </td>
                </tr>
                 <tr>
                   <td >
                      <font>请输入出题数量：</font>
                   </td>
                   <td>
                      <input type="text" name="Num" id="num" size="10" placeholder="请输入整数"/>
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
