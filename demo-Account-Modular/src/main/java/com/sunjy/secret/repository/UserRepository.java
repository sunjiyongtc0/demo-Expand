package com.sunjy.secret.repository;

import com.sunjy.secret.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
