package cn.tll.ssm.service.impl;

import cn.tll.ssm.dao.IOrdersDao;
import cn.tll.ssm.domain.Orders;
import cn.tll.ssm.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    //自动注入
    @Autowired
    private IOrdersDao ordersDao;


    //查询订单所有
    @Override
    public List<Orders> findAll(int page, int pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }

    //根据id来查询orders
    @Override
    public Orders findById(String ordersId) {
        return ordersDao.findById(ordersId);
    }
}
