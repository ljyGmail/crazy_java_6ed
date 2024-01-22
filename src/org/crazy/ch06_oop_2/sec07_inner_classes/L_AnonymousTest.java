package org.crazy.ch06_oop_2.sec07_inner_classes;

interface L_Product {
    double getPrice();
    String getName();
}

// 如果不使用匿名内部类就需要单独定义接口的实现类
class L_AnonymousProduct implements L_Product {
    public double getPrice() {
        return 567.9;
    }

    public String getName() {
        return "AGP显卡2";
    }
}

public class L_AnonymousTest {
    public void test(L_Product p) {
        System.out.println("购买了一个" + p.getName()
                + "，花掉了" + p.getPrice());
    }

    public static void main(String[] args) {
        var ts = new L_AnonymousTest();
        // 在调用test()方法时，需要传入一个Product参数
        // 此处传入其匿名实现类的实例
        ts.test(new L_Product() {
            public double getPrice() {
                return 567.8;
            }

            public String getName() {
                return "AGP显卡";
            }
        });

        // 将实现类的对象传给test()方法
        ts.test(new L_AnonymousProduct());
    }
}
