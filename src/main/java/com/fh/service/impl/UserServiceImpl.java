package com.fh.service.impl;

import com.fh.mapper.UserMapper;
import com.fh.model.ResponseEnum;
import com.fh.model.ServerResponse;
import com.fh.model.UserInfo;
import com.fh.service.UserService;
import com.fh.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/13
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    //验证用户是否登录
    @Override
    public ServerResponse login(String userName, String password) {
        //用户名验证是否为空
        if(StringUtils.isBlank(userName)){
            return ServerResponse.error(ResponseEnum.MEMBER_LOGINNAME_IS_NULL);
        }
        //密码验证是否是空
        if(StringUtils.isBlank(password)){
            return ServerResponse.error(ResponseEnum.MEMBER_PASSWORD_IS_NULL);
        }
        //验证用户是否存在
        UserInfo userInfo=userMapper.getMemberByLoginname(userName);
        if(userInfo==null){
            return ServerResponse.error(ResponseEnum.MEMBER_NOT_EXISTED);
        }
        //生成Token
     UserInfo userInfo1=new UserInfo();
        userInfo1.setUuid(UUID.randomUUID().toString());
        userInfo1.setId(userInfo.getId());
         userInfo1.setUserName(userInfo.getUserName());
         String token= JwtUtil.createToken(userInfo1);
         //redis 存key
        redisTemplate.opsForValue().set("user:"+userInfo1.getUuid(),"123",30, TimeUnit.MINUTES);

        return ServerResponse.success(token);
    }
}
