package org.crazy.ch04_control_flow_and_arrays.sec05_array_type;

public class A_ArrayTest {
    public static void main(String[] args) {
        // 4.5.3 数组的初始化

        // 1. 静态初始化
        // 定义一个int数组类型的变量，变量名为intArr
        int[] intArr;
        // 使用静态初始化，在初始化数组时只指定数组元素的初始值，不指定数组的长度
        intArr = new int[] {5, 6, 8, 20};
        // 定义一个Object数组类型的变量，变量名为objArr
        Object[] objArr;
        // 使用静态初始化，在初始化数组时数组元素的类型是
        // 定义数组时所指定的数组元素类型的子类
        objArr = new String[] {"Java", "圣杰"};
        Object[] objArr2;
        // 使用静态初始化
        objArr2 = new Object[] {"Java", "华建"};

        // 数组的定义和初始化同时完成，使用简化的静态初始化的语法
        // * 只有当数组的定义和初始化同时完成时，才能使用简化的静态初始化语法
        int[] a = {5, 6, 7, 9};

        // 2. 动态初始化
        // 数组的定义和初始化同时完成，使用动态初始化语法
        int[] prices = new int[5];
        // 数组的定义和初始化同时完成，在初始化数组时元素的类型是定义数组时元素类型的子类
        Object[] books = new String[4];

        // 使用var来定义数组变量
        // 编译器推断names变量的类型是String[]
        var names = new String[] {"yeeku", "nono"};
        // 编译器推断weightArr变量的类型是double[]
        var weightArr = new double[4];

        // * 对于使用简化的静态初始化语法执行初始化的数组，不能使用var定义数组变量
        // var demoArr = {1, 2, 3};

        // 4.5.4 使用数组
        // 输出objArr数组的第二个元素，将输出字符串"圣杰"
        System.out.println(objArr[1]);
        // 为objArr2的第一个数组元素赋值
        objArr2[0] = "周华健";
        // 访问数组元素指定的索引值等于数组的长度，所以下面的代码在运行时将出现异常
        // System.out.println(objArr2[2]);

        // 使用循环输出prices数组的每个数组元素的值
        for (var i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
        }

        // 对动态初始化后的数组元素进行赋值
        books[0] = "疯狂Java讲义";
        books[1] = "轻量级Java EE企业应用实战";
        // 使用循环输出books数组的每个数组元素的值
        for (var i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}
