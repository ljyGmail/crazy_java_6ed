package org.crazy.ch09_generics.sec03_type_wildcard;

public class H_Apple<T extends Number> {
    T col;

    public static void main(String[] args) {
        H_Apple<Integer> ai = new H_Apple<>();
        H_Apple<Double> ad = new H_Apple<>();
        // 下面的代码将引发编译异常，下面的代码试图把String类型传给了T形参
        // 但String不是Number的子类型，所以引发编译错误
        // H_Apple<String> as = new H_Apple<>();
        System.out.println("该示例表明在定义类时设定上限时，实际传入的类型只能是上限指定类或者其子类，否则将引发编译错误");
    }
}
