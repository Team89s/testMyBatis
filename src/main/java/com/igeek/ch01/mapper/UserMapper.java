package com.igeek.ch01.mapper;

import com.igeek.entity.User;

import java.util.List;

/**
 * MyBatis 实现映射关系的规范：
 * 1.Mapper接口与Mapper.xml文件同名且在同路径下
 * 2.Mapper.xml中namespace的值，必须是当前Mapper.xml同名接口的全类名
 * 3.若要为Mapper接口生成代理对象，则需要在MyBatis核心配置文件中添加扫描Mapper.xml文件的包
 * 4.当前Mapper接口中，方法名必须要Mapper.xml中的statement语句的id一致
 * 5.当前Mapper接口中，方法的返回值类型必须要Mapper.xml中的statement语句的resultType类型一致
 * 6.当前Mapper接口中，方法的形参类型必须要Mapper.xml中的statement语句的parameterType类型一致
 */
public interface UserMapper {

    //通过id查询用户信息
    public User selectOneById(int id);

    //根据用户名称模糊查询用户信息
    public List<User> selectListByLikeName(String name);

    //插入用户
    public void insertUser(User user);
}
