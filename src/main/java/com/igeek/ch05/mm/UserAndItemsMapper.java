package com.igeek.ch05.mm;

import com.igeek.entity.UserCustom;

import java.util.List;

public interface UserAndItemsMapper {

    public List<UserCustom> findUserAndItems();

}
