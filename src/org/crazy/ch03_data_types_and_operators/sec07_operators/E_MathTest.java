package org.crazy.ch03_data_types_and_operators.sec07_operators;

public class E_MathTest {
    public static void main(String[] args) {
        var a = 3.2; // 定义变量a为3.2
        // 求a的5次方，并将计算结果赋给b
        double b = Math.pow(a, 5);
        System.out.println(b); // 输出b的值
        // 求a的平方根，并将结果赋给c
        double c = Math.sqrt(a);
        System.out.println(c); // 输出c的值
        // 计算随机数，返回一个0~1之间的伪随机数
        double d = Math.random();
        System.out.println(d); // 输出随机数d的值
        // 求1.57的sin函数值: 1.57被当成弧度数
        double e = Math.sin(1.57);
        System.out.println(e); // 输出接近于1

        // 定义double变量x，其值为-5.0
        double x = -5.0;
        x = -x; // 将x求负，其值变成5.0
        System.out.println(x);
    }
}
