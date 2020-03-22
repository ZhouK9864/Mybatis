package com.MyClub.Test;

import com.MyClub.Dao.UserDao;
import com.MyClub.test.Qvo;
import com.MyClub.test.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private UserDao userDao;
    private SqlSession session;
    private InputStream in;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("Sqlconfiger.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();//传入参数 true 可以直接自动提交 不常用
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @org.junit.Test
    public void TestFindAll(){
        List<User> hero = userDao.findAll();    //执行dao方法
        for(User a : hero){
            System.out.println(a);
        }
    }

    @org.junit.Test
    public void SaveData(){
        User user = new User();
        user.setName("周凯");
        user.setHp(999);
        user.setDamage(99999);
        userDao.saveData(user);
        System.out.println(user);
    }

    @org.junit.Test
    public void UpdateData(){
        User user = new User();
        user.setId(1);
        user.setName("周凯");
        user.setHp(999);
        user.setDamage(99999);
        userDao.updateData(user);
    }

    @org.junit.Test
    public void DeletData(){
        userDao.deletData(2);
    }

    @org.junit.Test
    public void FindById(){
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @org.junit.Test
    public void FindByName(){
        List<User> user = userDao.findByName("%雄%");
        for(User a : user){
            System.out.println(a);
        }
    }

    @org.junit.Test
    public void FindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }

    @org.junit.Test
    public void FindByVo(){
        Qvo vo = new Qvo();
        User user = new User();
        user.setName("%凯%");
        vo.setUser(user);
        List<User> users = userDao.findByVo(vo);
        for(User a : users){
            System.out.println(a);
        }
    }

    /*
    *条件限定动态查询
    */
    @org.junit.Test
    public void FindByCondtion(){
        User user = new User();
        user.setName("周凯");
        user.setHp(313);
        List<User> users = userDao.findByCondtion(user);
        for(User a : users){
            System.out.println(a);
        }
    }

    /*
     *多id查询
     */
    @org.junit.Test
    public void FindUserByIds(){
        Qvo vo = new Qvo();
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(12);
        vo.setIds(list);
        List<User> users = userDao.findUserByIds(vo);
        for(User a : users){
            System.out.println(a);
        }
    }


}
