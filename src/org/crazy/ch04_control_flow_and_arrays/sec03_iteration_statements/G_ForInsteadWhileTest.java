package org.crazy.ch04_control_flow_and_arrays.sec03_iteration_statements;

public class G_ForInsteadWhileTest {
    public static void main(String[] args) {
        // 把for循环的初始化条件提出来独立定义
        var count = 0;
        // 在for循环里只放循环条件
        for ( ; count < 10; ) {
            System.out.println(count);
            // 把循环迭代部分放在循环体之后定义
            count++;
        }
        System.out.println("循环结束！");
        // 此处还可以访问count变量
        System.out.println("for循环执行完成还可以访问count变量: " + count);

        // 如果想要在循环外面使用循环变量的值，
        // 还可以采用在for外部定义变量的方式
        // 而且更加推荐这种方式，因为前一种方式扩大了循环变量的作用域，更容易引起错误
        int tmp = 0;
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
            // 使用tmp来保存循环变量i的值
            tmp = i;
        }
        System.out.println("循环结束！");
        // 此处还可以通过tmp变量来访问i变量的值
        System.out.println("tmp: " + tmp);
    }
}
