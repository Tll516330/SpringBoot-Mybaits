package cn.tll.ssm.service;

import cn.tll.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll() throws Exception;
}
