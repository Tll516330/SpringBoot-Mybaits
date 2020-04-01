package cn.tll.ssm.service.impl;

import cn.tll.ssm.dao.IProductDao;
import cn.tll.ssm.domain.Product;
import cn.tll.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    //查询产品所有
    @Override
    public List<Product> findAll() throws Exception {
        List<Product> list = productDao.findAll();
        return list;
    }
}
