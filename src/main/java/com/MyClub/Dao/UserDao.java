package com.MyClub.Dao;
import com.MyClub.test.Qvo;
import com.MyClub.test.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void saveData(User user);

    void deletData(Integer userId);

    void updateData(User user);

    User findById(Integer userId);

    List<User> findByName(String username);

    int findTotal();

    List<User> findByVo(Qvo vo);

    /**
     * 动态查询
     */
    List<User> findByCondtion(User user);

    List<User> findUserByIds(Qvo vo);
}
