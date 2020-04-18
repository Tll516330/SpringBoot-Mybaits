package cn.tll.ssm.service;

import cn.tll.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    //查询订单所有
    List<Orders> findAll(int page,int pageSize)throws Exception;

    //根据id来查询orders
    Orders findById(String ordersId);
}
