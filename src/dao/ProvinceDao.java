package dao;

import entity.Province;

import java.sql.*;

/**
 * 使用jdbc访问数据库
 */
public class ProvinceDao {
    //根据id获取名称
    public String queryProvinceNameById(Integer provinceId){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="";
        String url="jdbc:mysql://localhost:3306/springdb";
        String username="root";
        String password="333";
        String name="";

        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,password);

            //创建PreparedStatement
            sql="select name from province where id=?";
            ps=conn.prepareStatement(sql);
            //设置参数值
            ps.setInt(1,provinceId);
            //执行sql
            rs=ps.executeQuery();
            //遍历rs
//            while (rs.next()){rt中有多余一条记录时可以这样做
//                name=rs.getString("name");
//            }
            if (rs.next()){//只有一行可以这样做
                name=rs.getString("name");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return name;
    }

    /**
     * 根据id获取一个完整的province对象
     * @param provinceId
     * @return
     */
    public Province queryProvinceById(Integer provinceId){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="";
        String url="jdbc:mysql://localhost:3306/springdb";
        String username="root";
        String password="333";
        Province province=null;

        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,password);

            //创建PreparedStatement
            sql="select id,name,jiancheng,shenghui from province where id=?";
            ps=conn.prepareStatement(sql);
            //设置参数值
            ps.setInt(1,provinceId);
            //执行sql
            rs=ps.executeQuery();

            if (rs.next()){//只有一行可以这样做
                province =new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return province;
    }
}
