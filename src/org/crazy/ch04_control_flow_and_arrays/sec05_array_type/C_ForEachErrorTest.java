package org.crazy.ch04_control_flow_and_arrays.sec05_array_type;

public class C_ForEachErrorTest {
    public static void main(String[] args) {
        // 当使用foreach循环迭代数组元素时，
        // 并不能改变数组元素的值，因此不要对foreach中的循环变量进行赋值
        String[] books = {"轻量级Java EE企业应用实战",
            "疯狂Java讲义",
            "疯狂Android讲义"};
        // 使用foreach循环来变量数组元素，其中book将会自动迭代每个数组元素
        for (var book : books) {
            book = "疯狂前端开发讲义";
            System.out.println(book);
        }
        System.out.println(books[0]);
    }
}
