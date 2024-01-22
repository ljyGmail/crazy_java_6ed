package org.crazy.ch06_oop_2.sec09_enum;

public enum G_BestGender {
    // 此处的枚举值必须调用对应的构造器来创建
    MALE("男"), FEMALE("女");

    private final String name;

    // 枚举类的构造器只能使用private修饰
    private G_BestGender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
