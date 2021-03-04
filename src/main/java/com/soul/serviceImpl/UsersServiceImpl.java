package com.soul.serviceImpl;

import com.soul.entity.Users;
import com.soul.mapper.UsersMapper;
import com.soul.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users login(Users users) {
        return usersMapper.find(users);
    }
}
