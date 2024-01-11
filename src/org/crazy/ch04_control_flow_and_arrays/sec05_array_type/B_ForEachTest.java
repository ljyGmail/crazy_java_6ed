package org.crazy.ch04_control_flow_and_arrays.sec05_array_type;

public class B_ForEachTest {
    public static void main(String[] args) {
        String[] books = {"轻量级Java EE企业应用实战",
            "疯狂Java讲义",
            "疯狂Android讲义"};
        // 使用foreach循环来遍历数组元素
        // 其中book将会自动迭代每个数组元素
        for (String book : books) {
            System.out.println(book);
        }

        // 对于foreach循环而言，循环变量的类型可有编译器自动推断出来，
        // 而且使用var定义也不会影响程序的可读性，
        // 因此建议使用var来定义循环变量的类型
        for (var book : books) {
            System.out.println(book);
        }
    }
}
