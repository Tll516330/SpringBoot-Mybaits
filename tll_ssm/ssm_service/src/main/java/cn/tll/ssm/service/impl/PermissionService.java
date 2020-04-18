package cn.tll.ssm.service.impl;

import cn.tll.ssm.dao.IPermissionDao;
import cn.tll.ssm.domain.Permission;
import cn.tll.ssm.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionService implements IPermissionService {

    @Autowired
    private IPermissionDao iPermissionDao;

    //查询所有权限资源
    @Override
    public List<Permission> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return iPermissionDao.findAll();
    }

    //保存权限
    @Override
    public void save(Permission permission) {
        iPermissionDao.save(permission);
    }
}
