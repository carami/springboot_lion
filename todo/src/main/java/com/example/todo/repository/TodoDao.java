package com.example.todo.repository;

import com.example.todo.domain.Todo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {
    //JDBC
    //1.접속   -- Connection
    //2. 쿼리생성   -- Statement - PreParedStatement, Call~~
    //3. 실행  -     결과  ResultSet
    //4. 결과얻기..

    public List<Todo> findAll(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Todo> todos = new ArrayList<>();

        try{
            //1.접속
            conn = DBUtil.getConnection();
            String sql = "select id, todo, done from todos order by id desc";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Todo todo = new Todo();
                todo.setId(rs.getLong("id"));
                todo.setContent(rs.getString("todo"));
                todo.setDone(rs.getBoolean("done"));

                todos.add(todo);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        return todos;
    }
}
