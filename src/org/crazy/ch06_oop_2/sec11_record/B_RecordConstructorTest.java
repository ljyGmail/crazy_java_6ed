package org.crazy.ch06_oop_2.sec11_record;

record B_MyRecord(int x, int y) {
    // 新增的构造器
    public B_MyRecord(int x, int y, String color) {
        // 直接调用相同为MyRecord生成的带int、int参数的构造器
        // 而且必须是第一个语句
        // 下面语句报错
        // System.out.println("xxx");
        this(x, y);
    }

    // 新增的构造器
    public B_MyRecord() {
        // 直接调用上面的构造器
        // 间接调用系统为MyRecord生成的带int、int参数的构造器
        // 而且必须是第一个语句
        // 下面语句报错
        // System.out.println("xxx");
        this(2, 3, "clear");
    }
}

public class B_RecordConstructorTest {
    public static void main(String[] args) {
        // 调用系统生成的带int、int参数的构造器创建实例
        var mr1 = new B_MyRecord(4, 5);
        System.out.println(mr1);

        // 调用自己定义的、无参数的构造器创建实例
        var mr2 = new B_MyRecord();
        System.out.println(mr2);

        // 定义自己定义的、带3个参数的构造器创建实例
        var mr3 = new B_MyRecord(7, 8, "red");
        System.out.println(mr3);
    }
}
