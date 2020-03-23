package com.MyClub.test;

import java.io.Serializable;

public class Money implements Serializable {
    private Integer id;
    private Integer money;
    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Money{" +
                "id=" + id +
                ", money=" + money +
                ", sid=" + sid +
                '}';
    }
}
