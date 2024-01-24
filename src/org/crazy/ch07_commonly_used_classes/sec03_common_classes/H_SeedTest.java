package org.crazy.ch07_commonly_used_classes.sec03_common_classes;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class H_SeedTest {
    public static void main(String[] args) {
        var r1 = new Random(50);
        System.out.println("第一个种子为50的Random对象");
        System.out.println("r1.nextBoolean():\t" + r1.nextBoolean());
        System.out.println("r1.nextInt():\t\t" + r1.nextInt());
        System.out.println("r1.nextDouble():\t" + r1.nextDouble());
        System.out.println("r1.nextGaussian():\t" + r1.nextGaussian());
        System.out.println("==============================");

        var r2 = new Random(50);
        System.out.println("第二个种子为50的Random对象");
        System.out.println("r2.nextBoolean():\t" + r2.nextBoolean());
        System.out.println("r2.nextInt():\t\t" + r2.nextInt());
        System.out.println("r2.nextDouble():\t" + r2.nextDouble());
        System.out.println("r2.nextGaussian():\t" + r2.nextGaussian());
        System.out.println("==============================");

        var r3 = new Random(100);
        System.out.println("种子为100的Random对象");
        System.out.println("r3.nextBoolean():\t" + r3.nextBoolean());
        System.out.println("r3.nextInt():\t\t" + r3.nextInt());
        System.out.println("r3.nextDouble():\t" + r3.nextDouble());
        System.out.println("r3.nextGaussian():\t" + r3.nextGaussian());

        // ThreadLocalRandom的简单用法
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        // 生成一个4~20之间的伪随机整数
        var val1 = rand.nextInt(4, 20);
        System.out.println("val1: " + val1);
        // 生成一个2.0~10.0之间的伪随机浮点数
        var val2 = rand.nextDouble(2.0, 10.0);
        System.out.println("val2: " + val2);
    }
}
