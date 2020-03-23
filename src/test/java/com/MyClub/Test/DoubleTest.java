package com.MyClub.Test;

import com.MyClub.Dao.MoneyDao;
import com.MyClub.test.Money;
import com.MyClub.test.MoneyUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class DoubleTest {
    private MoneyDao moneyDao;
    private SqlSession session;
    private InputStream in;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("Sqlconfiger.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();//传入参数 true 可以直接自动提交 不常用
        moneyDao = session.getMapper(MoneyDao.class);
    }

    @After
    public void destory() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @org.junit.Test
    public void FindAll(){
        List<Money> money = moneyDao.findAll();
        for(Money i : money){
            System.out.println(i);
        }
    }

    @org.junit.Test
    public void FindUserAll(){
        List<MoneyUser> moneyUsers = moneyDao.findUserAll();
        for(Money i : moneyUsers) {
            System.out.println(i);
        }
    }
}
