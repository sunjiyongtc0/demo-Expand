package com.sunjy.secret.repository;

import com.sunjy.secret.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);

    public void  save(Admin a);

    public Admin  findById(long l);
}
