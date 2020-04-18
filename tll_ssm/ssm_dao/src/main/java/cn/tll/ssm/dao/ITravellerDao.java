package cn.tll.ssm.dao;

import cn.tll.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    //通过orders - traveller表查询
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    public List<Traveller> findByOrderId(String ordersId)throws Exception;
}
