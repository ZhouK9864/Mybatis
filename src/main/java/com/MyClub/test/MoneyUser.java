package com.MyClub.test;

public class MoneyUser extends Money {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return super.toString() + "MoneyUser{" + //集成父类Money的toString方法
                "name='" + name + '\'' +
                '}';
    }
}
