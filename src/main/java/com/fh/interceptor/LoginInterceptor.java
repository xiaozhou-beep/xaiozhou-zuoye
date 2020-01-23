package com.fh.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.fh.model.ResponseEnum;
import com.fh.model.ServerResponse;
import com.fh.model.UserInfo;
import com.fh.util.JsonUtil;
import com.fh.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //首先获取请求中的token
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            JsonUtil.outJson(response, ServerResponse.error(ResponseEnum.TOKEN_IS_NULL));
            return false;
        }
        String[] tokenArr = token.split("\\.");
     if(tokenArr.length!=3){
         JsonUtil.outJson(response, ServerResponse.error(ResponseEnum.TOKEN_IS_SHORT_OF));
         return false;
     }
     String loginMemberJson=null;
        try {

            loginMemberJson=JwtUtil.verifyToken(token);
        } catch (Exception e) {
            JsonUtil.outJson(response, ServerResponse.error(ResponseEnum.TOKEN_VERIFY_ERROR));
            return false;
        }
        UserInfo userInfo=JSONObject.parseObject(loginMemberJson, UserInfo.class);
         //从redis中查看是否存在当前登录会员对应的key
        if(!redisTemplate.hasKey("user:"+userInfo.getUuid())){
            JsonUtil.outJson(response, ServerResponse.error(ResponseEnum.TOKEN_IS_EXPIRED));
            return false;
        }
           //给redis中当前登录会员对应的key进行续命操作
        redisTemplate.expire("user:"+userInfo.getUuid(),30, TimeUnit.MINUTES);

        request.setAttribute("userInfo",userInfo);
        return true;
    }

}
