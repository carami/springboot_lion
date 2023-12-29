package com.example.todo.repository;

import javax.xml.transform.Result;
import java.sql.*;

public class DBUtil {
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
        String userName = "sa";
        String password = "";

        return DriverManager.getConnection(jdbcUrl,userName,password);
    }

    public static void close(Connection conn) {
        if(conn != null){
            try {
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        close(conn);
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn,ps);
    }

    public static void main(String[] args) throws  Exception{
        Connection conn = DBUtil.getConnection();
        if(conn != null)
            System.out.println("^^");
        else
            System.out.println("-_-;;");
    }
}
