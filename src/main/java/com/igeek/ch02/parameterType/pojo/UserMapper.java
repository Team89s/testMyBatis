package com.igeek.ch02.parameterType.pojo;

import com.igeek.entity.UserCustom;
import com.igeek.entity.UserQueryVO;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    //需求：通过性别和姓名模糊综合查询用户信息，通过pojo包装类型查询信息
    public List<UserCustom> findUserByPojo(UserQueryVO vo);

    //需求：通过性别和姓名模糊综合查询用户信息，通过hashmap类型查询信息
    public List<UserCustom> findUserByHashMap(HashMap<String,String> map);
}
