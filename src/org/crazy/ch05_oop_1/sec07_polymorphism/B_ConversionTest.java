package org.crazy.ch05_oop_1.sec07_polymorphism;

public class B_ConversionTest {
    public static void main(String[] args) {
        var d = 13.4;
        var l = (long) d;
        System.out.println(l);
        var in = 5;
        // 试图把一个数值类型的变量转换为boolean类型，下面的代码编译错误
        // 在编译时会提示: 不可转换的类型
        // var b = (boolean) in;
        Object obj = "Hello";
        // obj变量的编译时类型为Object，Object与String存在继承关系，可以进行类型转换
        // 而且obj变量的实际类型是String，所以在运行时也可通过
        var objStr = (String) obj;
        // 定义一个objPri变量，其编译时类型为Object，实际类型为Integer
        Object objPri = Integer.valueOf(5);
        // objPri变量的编译时类型为Object，objPri的运行时类型为Integer
        // Object与Integer存在继承关系，可以进行强制类型转换
        // 而objPri变量的实际类型是Integer
        // 所以下面的代码在运行时将引发ClassCastException异常
        // var str = (String) objPri;

        // 考虑到在进行强制类型转换时可能出现异常，
        // 在进行类型转换之前应先通过instanceof运算符判断是否可以成功转换
        if (objPri instanceof String) {
            var str = (String) objPri;
        }
    }
}
