package com.sxkj.jwt.utils;

import cn.hutool.core.date.DateUtil;
import com.sxkj.jwt.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.ExceptionUtils;
import org.apache.tomcat.util.http.parser.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    /**
     * 存放token的请求头对应的key的名字
     */
    private static String headerKey = "Bearer";
    private static String tokenHeader = "Authorization";
    /**
     * 加密的secret
     */
    private static String secret = "SxkjTestSecret";
    /**
     * 过期时间，单位为秒
     */
    private static long expire = 1800L;

    static {
        // TODO 上面变量的值应该从配置文件中读取,方便测试这里就不从配置文件中读取
        // 利用配置文件中的值覆盖静态变量初始化的值
    }

    /**
     * 根据负责生成JWT的token
     */
    public static String generateToken(Map<String, Object> userInfoMap) {
        if (Objects.isNull(userInfoMap)) {
            userInfoMap = new HashMap<>();
        }
        //  过期时间
        Date expireDate = new Date(System.currentTimeMillis() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")   // 设置头部信息
                .setClaims(userInfoMap)               // 装入自定义的用户信息
                .setExpiration(expireDate)            // token过期时间
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 校验token并解析token  从token中获取JWT中的负载
     *
     * 如果过期或者是被篡改，则会抛异常.
     * 注意点：只有在生成token设置了过期时间(setExpiration(expireDate))才会校验是否过期，
     * 可以参考源码io.jsonwebtoken.impl.DefaultJwtParser的299行。
     * 拓展：利用不设置过期时间就不校验token是否过期的这一特性，我们不设置Expiration;
     * 而采用自定义的字段来存放过期时间放在Claims（可以简单的理解为map）中;
     * 通过token获取到Claims后自己写代码校验是否过期。
     * 通过这思路，可以去实现对过期token的手动刷新
     * @param token
     * @return Claims：它继承了Map,而且里面存放了生成token时放入的用户信息
     */
    public static Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            LOGGER.info("JWT格式验证失败:{}", token);
            return null;
        }
    }
    /**
     * 从token中获取登录用户名
     */
    public static String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param user 从数据库中查询出来的用户信息
     */
    public boolean validateToken(String token, User user) {
        String username = getUserNameFromToken(token);
        return username.equals(user.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否已经失效
     */
    private static boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private static Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 根据用户信息生成token
     */
    public static String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, user.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 当原来的token没过期时是可以刷新的
     *
     * @param oldToken 带tokenHead的token
     */
    public static String refreshHeadToken(String oldToken) {
        if(StringUtils.isEmpty(oldToken)){
            return null;
        }
        String token = oldToken.substring(headerKey.length());
        if(StringUtils.isEmpty(token)){
            return null;
        }
        //token校验不通过
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            return null;
        }
        //如果token已经过期，不支持刷新
        if(isTokenExpired(token)){
            return null;
        }
        //如果token在30分钟之内刚刷新过，返回原token
        if(tokenRefreshJustBefore(token,30*60)){
            return token;
        }else{
            claims.put(CLAIM_KEY_CREATED, new Date());
            return generateToken(claims);
        }
    }

    /**
     * 判断token在指定时间内是否刚刚刷新过
     * @param token 原token
     * @param time 指定时间（秒）
     */
    private static boolean tokenRefreshJustBefore(String token, int time) {
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        //刷新时间在创建时间的指定时间内
        if(refreshDate.after(created)&&refreshDate.before(DateUtil.offsetSecond(created,time))){
            return true;
        }
        return false;
    }

    /**
     * 获取token的头部key
    * @return
     */
    public static String getHeaderKey(){
        return headerKey;
    }

    /**
     * 获取token的头部key
     * @return
     */
    public static String getTokenHeader(){
        return tokenHeader;
    }
}
