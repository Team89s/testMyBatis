package com.igeek.ch03.resultType.simple;

import com.igeek.entity.UserQueryVO;

public interface UserMapper {

    //需求：根据性别和姓名模糊 综合查询总记录数
    public int findCountsByPojo(UserQueryVO vo);

}
