package org.crazy.ch06_oop_2.sec09_enum;

public enum I_Gender implements H_GenderDesc {
    MALE("男"), FEMALE("女");

    private final String name;

    private I_Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // 实现GenderDesc接口中必须实现的方法
    public void info() {
        System.out.println("这是一个用于定义性别的枚举类");
    }
}
