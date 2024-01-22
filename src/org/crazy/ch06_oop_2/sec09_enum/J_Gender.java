package org.crazy.ch06_oop_2.sec09_enum;

public enum J_Gender implements H_GenderDesc {
    // 此处的枚举值必须调用对应的构造器来创建
    MALE("男") { // 花括号部分实际上是一个类体部分
        public void info() {
            System.out.println("这个枚举值代表男性");
        }
    },
    FEMALE("女") {
        public void info() {
            System.out.println("这个枚举值代表女性");
        }
    };

    private final String name;

    private J_Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
