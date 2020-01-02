package com.sxkj.jwt.filter;

import com.alibaba.fastjson.JSON;
import com.sxkj.jwt.aop.PassToken;
import com.sxkj.jwt.aop.UserLoginToken;
import com.sxkj.jwt.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class JwtInterceptor extends HandlerInterceptorAdapter {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JwtInterceptor.class);

    public static final String USER_INFO_KEY = "user_info_key";
    private String msg = "token验证失败，请重新登录";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                //  获取用户 token
                String token = request.getHeader(JwtTokenUtil.getTokenHeader());
                //  token为空
                if (StringUtils.isEmpty(token)) {
                    returnJson(response, JSON.toJSONString(msg));
                    return false;
                }
                //  校验并解析token，如果token过期或者篡改，则会返回null
                String authToken = token.substring(JwtTokenUtil.getHeaderKey().length());// The part after "Bearer "

                Claims claims = JwtTokenUtil.getClaimsFromToken(authToken);
                if (null == claims) {
                    returnJson(response, JSON.toJSONString(msg));
                    return false;
                }
                //  校验通过后，设置用户信息到request里，在Controller中从Request域中获取用户信息
                request.setAttribute(USER_INFO_KEY, claims);
                return true;
            }
        }
        return true;
    }

    /**
     * 利用response直接输出错误信息
     *
     * @param response
     * @throws IOException
     */
    private void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            LOGGER.error("response error", e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
