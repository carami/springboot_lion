package com.example.todo.repository;

import com.example.todo.domain.Todo;
import org.springframework.stereotype.Repository;

import java.awt.image.DataBufferUShort;
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

    public void save(String content){
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO todos (todo, done) VALUES (?,false)";

        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,content);

            int resutlCount = ps.executeUpdate();

            System.out.println(resutlCount);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps);
        }

    }

    public void update(Todo todo){
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE todos SET done=? WHERE id=?";

        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1,todo.isDone());
            ps.setLong(2, todo.getId());

            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps);
        }

    }

    public void delete(Long id){
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM todos WHERE id = ?";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);

            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps);
        }
    }

    public Todo findById(Long id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Todo todo = null;
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("SELECT id,todo,done FROM todos WHERE id=?");
            ps.setLong(1,id);

            rs = ps.executeQuery();

            if(rs.next()){
                todo = new Todo();
                todo.setId(rs.getLong("id"));
                todo.setContent(rs.getString("todo"));
                todo.setDone(rs.getBoolean("done"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        return todo;
    }

}
