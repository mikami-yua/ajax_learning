<%--
  Created by IntelliJ IDEA.
  User: jia
  Date: 2020/11/12
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>全局刷新</title>
  </head>
  <body>
    <p>全局刷新计算bmi</p>
    <form action="bmiprint" method="get">
      姓名：<input type="text" name="name"><br>
      体重（kg）：<input type="text" name="w"><br>
      身高（m）：<input type="text" name="h"><br>
      <input type="submit" value="提交"><br>
    </form>
  </body>
</html>
