package org.crazy.ch07_commonly_used_classes.sec03_common_classes;

class A_Address {
    String detail;

    public A_Address(String detail) {
        this.detail = detail;
    }
}

// 实现Cloneable接口
class A_User implements Cloneable {
    int age;
    A_Address address;

    public A_User(int age) {
        this.age = age;
        this.address = new A_Address("辽宁铁岭");
    }

    // 通过调用super.clone()来实现clone()方法
    public A_User clone()
        throws CloneNotSupportedException {
        return (A_User) super.clone();
    }
}

public class A_CloneTest {
    public static void main(String[] args)
        throws CloneNotSupportedException {
        var u1 = new A_User(29);
        // 克隆得到u1对象的副本
        var u2 = u1.clone();
        // 判断u1、u2是否相同
        System.out.println(u1 == u2); // false
        // 判断u1、u2的address是否相同
        System.out.println(u1.address == u2.address);
    }
}
