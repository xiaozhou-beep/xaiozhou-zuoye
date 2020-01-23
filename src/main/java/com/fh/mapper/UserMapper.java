package com.fh.mapper;

import com.fh.model.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/13
 * @Version V1.0
 **/
@Repository
public interface UserMapper {

    UserInfo getMemberByLoginname(String userName);
}
