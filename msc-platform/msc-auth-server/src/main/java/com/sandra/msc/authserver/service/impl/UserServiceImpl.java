package com.sandra.msc.authserver.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sandra.msc.authserver.entity.User;
import com.sandra.msc.authserver.mapper.UserMapper;
import com.sandra.msc.authserver.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
