package cn.tll.ssm.service.impl;

import cn.tll.ssm.dao.IProductDao;
import cn.tll.ssm.domain.Product;
import cn.tll.ssm.service.IProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public List<Product> findAll(int page,int size ) throws Exception {
        PageHelper.startPage(page,size);
        List<Product> list = productDao.findAll();
        return list;
    }

    //保存产品信息
    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    //根据产品名称查询
    @Override
    public List<Product> findByName(Integer page,Integer size,String proName) {
        PageHelper.startPage(page,size);
        proName = "%"+proName+"%";
        List<Product> list = productDao.findByName(proName);
        return list;
    }
}
