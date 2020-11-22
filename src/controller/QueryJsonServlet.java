package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //默认值{}
        String json="{}";
        //获取请求参数，省份的id
        String strProid=request.getParameter("proid");

        //判断proid有值时，调用dao查询数据
        if (strProid !=null && strProid.trim().length()>0){
            ProvinceDao dao=new ProvinceDao();
            Province p = dao.queryProvinceById(Integer.valueOf(strProid));
            //使用jackson把province转为json
            ObjectMapper om = new ObjectMapper();
            json=om.writeValueAsString(p);
        }

        //把获取的数据通过网络传给ajax中的异步对象，响应结果数据
        response.setContentType("application/json;charset=utf-8");//指定服务器端返回浏览器的是json格式的数据
        PrintWriter pw=response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
