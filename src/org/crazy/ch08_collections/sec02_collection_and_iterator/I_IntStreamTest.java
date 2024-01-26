package org.crazy.ch08_collections.sec02_collection_and_iterator;

import java.util.stream.IntStream;

public class I_IntStreamTest {
    public static void main(String[] args) {
        var is = IntStream.builder()
            .add(20)
            .add(13)
            .add(-2)
            .add(18)
            .build();

        // 下面调用聚集方法的代码每次只能执行一次
        // System.out.println("is所有元素的最大值: " + is.max().getAsInt());
        // System.out.println("is所有元素的最小值: " + is.min().getAsInt());
        // System.out.println("is所有元素的总和: " + is.sum());
        // System.out.println("is所有元素的总数: " + is.count());
        // System.out.println("is所有元素的平均数: " + is.average());
        // System.out.println("is所有元素的平方是否都大于20: "
        //         + is.allMatch(ele -> ele * ele > 20));
        // System.out.println("is是否包含任何元素的平方大于20: "
        //         + is.anyMatch(ele -> ele * ele > 20));
        // 将is映射成一个新Stream，新Stream的每个元素都是原Stream元素的2倍+1
        var newIs = is.map(ele -> ele * 2 + 1);
        // 使用方法引用的发生来变量集合元素
        newIs.forEach(System.out::println); // 输出41, 27, -3, 37
    }
}
