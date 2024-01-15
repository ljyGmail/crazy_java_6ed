package org.crazy.ch05_oop_1.sec06_inheritance;

class H_Creature {
    public H_Creature() {
        System.out.println("Creature无参数的构造器");
    }
}

class H_Animal extends H_Creature {
    public H_Animal(String name) {
        System.out.println("Animal带一个参数的构造器，"
                + "该动物的name为" + name);
    }

    public H_Animal(String name, int age) {
        // 使用this调用同一个类中重载的构造器
        this(name);
        System.out.println("Animal带两个参数的构造器，"
                + "其age为" + age);
    }
}

public class H_WolfTest extends H_Animal {
    public H_WolfTest() {
        // 显式调用父类中有两个参数的构造器
        super("灰太狼", 3);
        System.out.println("Wolf无参数的构造器");
    }

    public static void main(String[] args) {
        new H_WolfTest();
    }
}
