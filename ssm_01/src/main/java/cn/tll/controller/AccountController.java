package cn.tll.controller;

import cn.tll.domain.Account;
import cn.tll.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * account WEB
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/springmvc")
    public ModelAndView findAll(){
        System.out.println("表现层：查询所有");
        ModelAndView mv = new ModelAndView();
        List<Account> list = accountService.findAll();
        mv.addObject("list",list);
        mv.setViewName("list");
        return mv;
    }

    /**
     * 保存用户
     * @param account
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response)throws Exception{
        accountService.saveAccount(account);
        //重定向到查询所有用户
        response.sendRedirect(request.getContextPath()+"/account/springmvc");
        return;
    }
}
