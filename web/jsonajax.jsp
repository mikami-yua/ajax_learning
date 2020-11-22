<%--
  Created by IntelliJ IDEA.
  User: jia
  Date: 2020/11/22
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用JSON格式的数据</title>
    <script type="text/javascript">
        function doSearch() {
            //1.创建异步对象
            var xmlhttp=new XMLHttpRequest();
            //2.绑定事件
            xmlhttp.onreadystatechange=function () {
                if (xmlhttp.readyState==4 && xmlhttp.status==200){
                    var data=xmlhttp.responseText;
                    var jsonObj=eval("("+data+")");//eval函数执行括号中的代码，把json字符串转换为json对象

                    //更新dom对象
                    //alert(data);
                    document.getElementById("proname").value=jsonObj.name;
                    document.getElementById("projiancheng").value=jsonObj.jiancheng;
                    document.getElementById("proshenghui").value=jsonObj.shenghui;

                }
            }
            //3.初始异步对象的请求参数
            var proid=document.getElementById("proid").value;
            xmlhttp.open("get","queryjson?proid="+proid,true);
            //4.发送请求
            xmlhttp.send();
        }
    </script>
</head>
<body>
    <p>ajax请求使用json格式的数据</p>
    <table>
        <tr>
            <td>省份编号：</td>
            <td><input type="text" id="proid">
                <input type="button" value="搜索" onclick="doSearch()">
            </td>
        </tr>
        <tr>
            <td>省份名称：</td>
            <td><input type="text" id="proname"></td>
        </tr>
        <tr>
            <td>省份简称：</td>
            <td><input type="text" id="projiancheng"></td>
        </tr>
        <tr>
            <td>省会：</td>
            <td><input type="text" id="proshenghui"></td>
        </tr>
    </table>
</body>
</html>
