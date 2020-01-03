package com.sandra.msc.authserver.entity;

import org.springframework.security.core.GrantedAuthority;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("role")
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 7828538323373930319L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    public Long getId() {

        return id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    @Override
    public String getAuthority() {

        return name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return name;
    }
}
