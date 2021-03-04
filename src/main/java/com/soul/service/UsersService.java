package com.soul.service;


import com.soul.entity.Users;
import org.springframework.stereotype.Service;


public interface UsersService {
    Users login(Users users);
}
