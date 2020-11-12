package controller;

import java.io.IOException;

public class BmiServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //接收请求参数
        String name = request.getParameter("name");
        String height=request.getParameter("h");
        String weight=request.getParameter("w");

        //计算bmi
        float h=Float.valueOf(height);
        float w=Float.valueOf(weight);
        float bmi=w/(h*h);

        //判断bmi范围
        String msg="";
        if(bmi<=18.5){
            msg="较瘦";
        }else if(bmi>18.5 && bmi <=23.9){
            msg="bmi是正常的";
        }else if(bmi>24 && bmi<=27){
            msg="较重";
        }else {
            msg="胖";
        }
        System.out.println("msg="+msg);
        msg=name+"您的bmi值是"+bmi+","+msg;
        //把数据存入request
        request.setAttribute("msg",msg);

        //转发到新的页面
        request.getRequestDispatcher("/result.jsp").forward(request,response);

    }
}
