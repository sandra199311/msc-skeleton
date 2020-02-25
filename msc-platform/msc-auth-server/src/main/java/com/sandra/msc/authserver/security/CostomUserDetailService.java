package com.sandra.msc.authserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sandra.msc.authserver.entity.User;
import com.sandra.msc.authserver.mapper.UserMapper;
import com.sandra.msc.common.core.security.CostomUserDetails;

@Service
public class CostomUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final QueryWrapper<User> queryWarrper = new QueryWrapper<>();
        queryWarrper.lambda().eq(User::getUsername, username);
        final User user = userMapper.selectOne(queryWarrper);
        if (null == user) {
            throw new UsernameNotFoundException("username not found");
        }

        final CostomUserDetails userDetails = new CostomUserDetails();
        userDetails.setId(user.getId());
        userDetails.setPassword(user.getPassword());
        userDetails.setUsername(user.getUsername());
        return userDetails;
    }
}
