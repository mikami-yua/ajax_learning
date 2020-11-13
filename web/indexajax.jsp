<%--
  Created by IntelliJ IDEA.
  User: jia
  Date: 2020/11/13
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>局部刷新ajax</title>
    <script type="text/javascript">
      //使用内存中的异步对象，代替浏览器发起请求。异步对象使使用js创建和管理的
      function doAjax() {
        //1.创建异步对象
        var xmlhttp=new XMLHttpRequest();
        //2.绑定事件
        xmlhttp.onreadystatechange=function () {
          //处理服务器端返回的数据更新当前页面

        }
        //3.初始请求参数
        xmlhttp.open("get","bmiajax",true);
        //4.发起请求
        xmlhttp.send();
      }

    </script>
  </head>
  <body>
    <p>局部刷新Ajax-计算bmi</p>
    <div>
      <!--与全局刷新的区别，没有使用表单form-->
      姓名：<input type="text" id="name" /><br>
      体重：<input type="text" id="w" /><br>
      身高：<input type="text" id="h" /><br>
      <input type="button" value="计算bmi" onclick="doAjax()" />
    </div>
  </body>
</html>
