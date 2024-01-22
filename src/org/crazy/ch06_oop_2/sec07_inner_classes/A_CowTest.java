package org.crazy.ch06_oop_2.sec07_inner_classes;

public class A_CowTest {
    private double weight;

    // 外部类的两个重载的构造器
    public A_CowTest() {}

    public A_CowTest(double weight) {
        this.weight = weight;
    }

    // 定义一个非静态内部类
    private class CowLeg {
        // 非静态内部类的两个实例变量
        private double length;
        private String color;

        // 非静态内部类的两个重载的构造器
        public CowLeg() {}

        public CowLeg(double length, String color) {
            this.length = length;
            this.color = color;
        }

        public double getLength() {
            return this.length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return this.color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        // 非静态内部类的实例方法
        private void info() {
            System.out.println("当前牛腿的颜色是: "
                    + color + "，高: " + length);
            // 直接访问外部类的private修饰的成员变量
            System.out.println("本牛腿所在奶牛重: " + weight);
        }
    }

    public void test() {
        var cl = new CowLeg(1.12, "黑白相间");
        // 访问内部类的private成员(变量和方法)
        System.out.println(cl.length);
        cl.info();
    }

    public static void main(String[] args) {
        var cow = new A_CowTest(378.9);
        cow.test();
    }
}
