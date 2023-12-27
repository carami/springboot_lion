package com.example.iocexam.service;

import com.example.iocexam.domain.User;
import com.example.iocexam.repository.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    @Override
    public void joinUser(User user) {
        //비지니스적으로 필요한 코드가 있다면 여기 추가.

        //저장해야할 데이터가 있다면.
        userDao.addUser(user);

    }
}
