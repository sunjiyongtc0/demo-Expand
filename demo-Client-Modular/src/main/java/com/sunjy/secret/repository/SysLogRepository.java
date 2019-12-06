package com.sunjy.secret.repository;

import com.sunjy.secret.entity.SysLog;

import java.util.List;

public interface SysLogRepository {

    public void save(SysLog sl);

    public List<SysLog> findAll(int begin,int end);

    public int  count();
}
