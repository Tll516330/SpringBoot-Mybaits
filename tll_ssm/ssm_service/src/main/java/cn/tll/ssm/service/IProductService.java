package cn.tll.ssm.service;

import cn.tll.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    //查询所有产品
    List<Product> findAll(int page,int size) throws Exception;

    //保存产品
    void save(Product product);

    //根据产品名称查询产品
    List<Product> findByName(Integer page,Integer size,String proName);
}
