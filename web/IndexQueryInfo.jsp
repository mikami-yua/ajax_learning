<%--
  Created by IntelliJ IDEA.
  User: jia
  Date: 2020/11/15
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax根据省份的id获取名称</title>
    <script type="text/javascript">
        function search() {
            //发起ajax请求传递参数，服务器返回数据

            //1.创建异步对象
            var xmlhttp=new XMLHttpRequest();
            //2.绑定事件
            xmlhttp.onreadystatechange = function () {
                alert(xmlhttp.readyState)
            }
            //3.初始异步对象
            xmlhttp.open("get","queryprovice",true);
            //4.发送请求
            xmlhttp.send();
        }
    </script>
</head>
<body>
    <p>ajax根据省份的id获取名称</p>
    <table>
        <tr>
            <td>省份编号：</td>
            <td>
                <input type="text" id="proid">
                <input type="button" value="搜索" onclick="search()">
            </td>
        </tr>
        <tr>
            <td>省份名称：</td>
            <td>
                <input type="text" id="proname">
            </td>
        </tr>
    </table>
</body>
</html>
