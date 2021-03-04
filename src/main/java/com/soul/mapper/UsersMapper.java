package com.soul.mapper;

import com.soul.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsersMapper {
    //根据用户名和密码查询用户
    Users find(Users users);
}
