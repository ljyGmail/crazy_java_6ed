package org.crazy.ch06_oop_2.sec04_final_modifier;

public class O_PersonTest {
    private final N_Name name;

    public  O_PersonTest(N_Name name) {
        // 设置name实例变量为临时创建的Name对象，该对象的firstName和lastName
        // 与传入的name参数的firstName和lastName相同
        this.name = new N_Name(name.getFirstName(), name.getLastName());
    }

    public N_Name getName() {
        // 返回一个匿名对象，该对象的firstName和lastName
        // 与该对象中的name的firstName和lastName相同
        return new N_Name(name.getFirstName(), name.getLastName());
    }

    public static void main(String[] args) {
        var n = new N_Name("悟空", "孙");
        var p = new O_PersonTest(n);
        // Person对象的name的firstName值为"悟空"
        System.out.println(p.getName().getFirstName());
        // 改变Person对象的name的firstName值
        n.setFirstName("八戒");
        // Person对象的name的firstName值没有被改为"八戒"，仍然保持值为"悟空"
        System.out.println(p.getName().getFirstName());
    }
}
