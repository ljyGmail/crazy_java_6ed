package org.crazy.ch05_oop_1.sec04_info_hide_and_encapsulation;

public class B_PersonTest {
    public static void main(String[] args) {
        var p = new A_Person();
        // 因为age成员变量已被隐藏，所以下面的语句将出现错误
        // p.age = 1000;
        // 下面的语句编译不会出现错误，但运行时将提示"您设置的年龄不合法"
        // 程序不会修改p的age成员变量
        p.setAge(1000);
        // 访问p的age成员变量也必须通过其对应的getter方法
        // 因为 上面从未成功设置p的age成员变量，故此处输出0
        System.out.println("未能设置age成员变量时: "
                + p.getAge());
        // 成功修改p的age成员变量
        p.setAge(30);
        // 因为上面成功设置了p的age成员变量，故此处输出30
        System.out.println("成功设置age成员变量后: "
                + p.getAge());
        // 不能直接操作p的name成员变量，只能通过其对应的setter方法
        // 因为"周华健"字符串长度满足2~6，所以可以成功设置
        p.setName("周华健");
        System.out.println("成功设置name成员变量后: "
                + p.getName());
    }
}
