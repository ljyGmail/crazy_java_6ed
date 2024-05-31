package org.crazy.ch14_annotation.sec01_annotation_basics;

class Fruit {
    public void info() {
        System.out.println("水果的info方法...");
    }
}

class Apple extends Fruit {
    // 使用@Override指定下面的方法必须重写父类的方法
    @Override
    public void info() {
        System.out.println("苹果重写水果的info方法...");
    }
}

public class A_OverrideTest {
    public static void main(String[] args) {
        System.out.println("注解@Override的用法");
    }
}
