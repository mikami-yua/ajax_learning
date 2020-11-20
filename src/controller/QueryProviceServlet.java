package controller;

import dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryProviceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理get请求
        //System.out.println("响应了ajax请求");
        String strProid=req.getParameter("proid");
        System.out.println("strproid: "+strProid);

        String name="默认无数据";
        //访问dao，查询数据库
        if (strProid != null && !"".equals(strProid.trim())) {
            //创建dao对象，调用dao的方法
            ProvinceDao dao=new ProvinceDao();
            name=dao.queryProvinceNameById(Integer.valueOf(strProid));
        }

        //使用httpResponse输出数据
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw=resp.getWriter();
        //pw.println("中国");
        pw.println(name);
        pw.flush();
        pw.close();
    }
}
