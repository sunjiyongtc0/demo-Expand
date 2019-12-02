package com.sunjy.secret.repository;

import com.sunjy.secret.entity.User;

import java.util.List;

public interface UserRepository {
    public User login(String username, String password);

    public List<User> findAll(int begin , int end);

    public int  count();

    public void save(User u);

    public  void deleteById(long l);

    public User  findById(long l);

    public void updateUser(User u);
}
