package cn.tll.ssm.service;

import cn.tll.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    //保存日志信息
    public void sava(SysLog sysLog)throws Exception;

    //查询所有日志信息
    List<SysLog> findAll(Integer page,Integer size);
}
