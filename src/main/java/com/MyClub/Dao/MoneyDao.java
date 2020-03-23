package com.MyClub.Dao;

import com.MyClub.test.Money;
import com.MyClub.test.MoneyUser;

import java.util.List;

public interface MoneyDao {
    List<Money> findAll();

    List<MoneyUser> findUserAll(); //查询所有并返回User信息

}
