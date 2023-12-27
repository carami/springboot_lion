package com.example.iocexam.repository;

import com.example.iocexam.domain.User;

import java.util.List;

public class UserDaoCaramiImpl implements UserDao{
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "정보가 caramiDao를 이용해서 잘 저장되었습니다.");
    }
}
