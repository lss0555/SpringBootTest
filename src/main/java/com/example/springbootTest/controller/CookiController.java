package com.example.springbootTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description cookie常用操作
 * @Author lss0555
 * @Date 2018/12/21/021 11:22
 **/
@RestController
@RequestMapping("/cooki")
public class CookiController {
    @Resource
    HttpServletRequest request;
    @Resource
    HttpServletResponse response;

    /**
     * @Description  getCookie
     **/
    @GetMapping("/get")
    public String getCookie(){
        String str_cookie="";
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                String comment = cookie.getComment();
                String path = cookie.getPath();
                int version = cookie.getVersion();
                boolean secure = cookie.getSecure();
                int maxAge = cookie.getMaxAge();
                str_cookie=str_cookie+"name:"+name+" value"+value+" commoent:"+comment+" path:"+path+" version:"+version+" secure:"+secure+" maxAge:"+maxAge+"\n";
            }
        }
        return str_cookie;
    }

    /**
     * @Description  设置cookie
     **/
    @GetMapping("/set")
    public String setCookie(int maxage,String path,String domain){
        Cookie cookie = new Cookie("name_1", "hello");
        if(maxage!=0){
            cookie.setMaxAge(maxage);
        }
        if(path!=null&&!path.equals("")){
            cookie.setPath(path);
        }
        if(domain!=null&&!domain.equals("")){
            cookie.setDomain(domain);
        }
        response.addCookie(cookie);
        return "ok";
    }

    /**
     * @Description  删除cookie
     **/
    @GetMapping("/delete")
    public String deleteCookie(String name){
        if(name!=null&&!name.equals("")){
            Cookie cookie = new Cookie("name_1", "hello");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "ok";
    }
}
