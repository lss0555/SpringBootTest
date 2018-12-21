package com.example.springbootTest.controller;

import com.example.springbootTest.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description modelAndViews
 * @Author lss0555
 * @Date 2018/12/20/020 9:15
 **/
@Controller
public class ViewsController {

    @GetMapping("/regist")
    public ModelAndView regist(){
        ModelAndView view = new ModelAndView("regist");
        User user = new User("lss0555","123456");
        view.addObject("name","lss");
        view.addObject("user",user);
        return view;
    }
}
