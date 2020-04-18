package cn.tll.dao;

import cn.tll.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 接口AccountDao的方法
 * 把AccountDao也装到IOC容器中去
 */
@Repository
public interface AccountDao {

    /**
     * 保存account
     * @param account
     */
    @Insert("insert into account (name,money) values (#{name},#{money})")
    void saveAccount(Account account);

    /**
     * 查询所有account信息  使用注解
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();
}
