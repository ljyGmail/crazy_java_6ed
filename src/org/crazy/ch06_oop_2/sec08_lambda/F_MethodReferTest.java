package org.crazy.ch06_oop_2.sec08_lambda;

import javax.swing.JFrame;

@FunctionalInterface
interface F_Converter {
    Integer convert(String from);
}

@FunctionalInterface
interface F_SubString {
    String test(String a, int b, int c);
}

@FunctionalInterface
interface F_ConstructorRefer {
    JFrame win(String title);
}

public class F_MethodReferTest {
    public static void main(String[] args) {
        // 1. 引用类方法
        F_Converter converter1 = from -> Integer.valueOf(from);

        Integer val = converter1.convert("99");
        System.out.println(val); // 输出99

        // 方法引用代替Lambda表达式: 引用类方法
        // 将函数式接口中被实现方法的全部参数传给该类方法作为参数
        F_Converter converter1Refer = Integer::valueOf;
        val = converter1Refer.convert("100");
        System.out.println(val); // 输出100

        // 2. 引用特定对象的实例方法
        // 下面的代码使用Lambda表达式创建Converter对象
        F_Converter converter2 = from -> "fkit.org".indexOf(from);

        val = converter2.convert("it");
        System.out.println(val); // 输出2

        F_Converter converter2Refer = "fkit.org"::indexOf;
        val = converter2Refer.convert("it");
        System.out.println(val); // 输出2

        // 3. 引用某类对象的实例方法
        // 下面的代码使用Lambda表达式创建SubString对象
        F_SubString mt = (a, b, c) -> a.substring(b, c);
        String str = mt.test("Java I Love You", 2, 9);
        System.out.println(str); // 输出"va I lo"
        
        // 方法引用代替Lambda表达式，引用某类对象的实例方法
        // 将函数式接口中被实现方法的第一个参数作为调用者
        // 将后面的参数全部传给方法作为参数
        F_SubString mtRefer = String::substring;
        str = mtRefer.test("Python I Love You", 2, 11);
        System.out.println(str);

        // 4. 引用构造器
        // 下面的代码使用Lambda表达式创建ConstructorRefer对象
        F_ConstructorRefer cr = a -> new JFrame(a);
        JFrame jf = cr.win("我的窗口");
        System.out.println(jf);

        // 构造器引用代替Lambda表达式
        // 将函数式接口中被实现方法的全部参数传给该构造器作为参数
        F_ConstructorRefer crRefer = JFrame::new;
        jf = crRefer.win("你的窗口");
        System.out.println(jf);
    }
}
