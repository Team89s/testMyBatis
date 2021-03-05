package com.igeek.ch07.ehcache;

import com.igeek.entity.UserCustom;

public interface UserMapper {

    public UserCustom findUserById(int id);

    public void updateUser(UserCustom userCustom);
}
