package cn.tll.ssm.service;

import cn.tll.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    //查询所有权限信息
    List<Permission> findAll(Integer page,Integer size)throws Exception;

    //保存权限
    void save(Permission permission);
}
