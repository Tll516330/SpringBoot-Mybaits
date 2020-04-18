package cn.tll.ssm.controller;

import cn.tll.ssm.domain.Role;
import cn.tll.ssm. domain.UserInfo;
import cn.tll.ssm.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4")Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 保存用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo)throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    //根据用户id查询用户详细信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id)throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    //查询用户可添加角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId)throws Exception{
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据用户id查询可添加的角色
        List<Role> roleList = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    //添加用户角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,@RequestParam(name = "ids",required = true)String[] roleIds)throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    //根据条件查询
    @RequestMapping("/findByInfo.do")
    public ModelAndView findByInfo(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                   @RequestParam(name = "size",required = true,defaultValue = "4")Integer size,
                                   UserInfo userInfo)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userService.findByInfo(page,size,userInfo);
        PageInfo pageInfo = new PageInfo(userInfoList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-list");
        return mv;
    }

}
