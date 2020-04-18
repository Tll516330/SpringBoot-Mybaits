package cn.tll.ssm.dao;

import cn.tll.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    //根据id来查询Product对象
    @Select("select * from product where id =#{id}")
    Product findById(String id)throws Exception;

    //查询所有产品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    //根据产品名称查询
    @Select("select * from product where productname like #{proName}")
    List<Product> findByName(String proName);
}
