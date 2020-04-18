package cn.tll.ssm.controller;

import cn.tll.ssm.domain.Product;
import cn.tll.ssm.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4")Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> proList = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(proList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;

    }

    //保存产品信息
    @RequestMapping("/save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }

    //更具产品名称查询用户
    @RequestMapping("/findByName.do")
    public ModelAndView findByProductName(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                          @RequestParam(name = "size",required = true,defaultValue = "4")Integer size,
                                          @RequestParam(name = "productName",defaultValue = "")String proName)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findByName(page,size,proName);
        PageInfo pageInfo = new PageInfo(productList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }
}
