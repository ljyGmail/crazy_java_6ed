package org.crazy.ch06_oop_2.sec02_handle_object;

class B_Apple {
    private String color;
    private double weight;

    public B_Apple() {}

    // 提供有参数的构造器
    public B_Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // 重写toString()方法，用于实现Apple对象的"自我描述"
    public String toString() {
        /*
        return "一个苹果，颜色是：" + color
            + "，重量是：" + weight;
        */
        return "Apple{color=" + color + ", weight=" + weight + "}";
    }
}

public class B_ToStringTest {
    public static void main(String[] args) {
        var a = new B_Apple("红色", 5.68);
        // 打印Apple对象
        System.out.println(a);
    }
}
