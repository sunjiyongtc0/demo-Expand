package com.sunjy.secret.repository;

import com.sunjy.secret.entity.User;

import java.util.List;

public interface UserRepository {
    public User login(String username, String password);

    public List<User> findAll(int begin , int end);

    public int  count();
}
