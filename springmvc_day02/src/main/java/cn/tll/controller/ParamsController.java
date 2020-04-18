package cn.tll.controller;

import cn.tll.domain.Account;
import cn.tll.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/params")
public class ParamsController {

    /**
     * 请求数据绑定把数据封装到javaBean中
     * @param user
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(User user){
        System.out.println("获取到参数");
        System.out.println(user);
        return "success";
    }
}
