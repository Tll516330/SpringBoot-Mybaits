package cn.tll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    //请求映射
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("你好,世界");
        return "success";
    }
}
