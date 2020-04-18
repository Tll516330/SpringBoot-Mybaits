package cn.tll.ssm.service.impl;

import cn.tll.ssm.dao.ISyslogDao;
import cn.tll.ssm.domain.SysLog;
import cn.tll.ssm.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISyslogDao syslogDao;

    //保存日志信息
    @Override
    public void sava(SysLog sysLog) throws Exception {
        syslogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return syslogDao.findAll();
    }


}
