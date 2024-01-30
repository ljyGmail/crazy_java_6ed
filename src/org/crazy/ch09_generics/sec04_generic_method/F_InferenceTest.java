package org.crazy.ch09_generics.sec04_generic_method;

class F_MyUtil<E> {
    public static <Z> F_MyUtil<Z> nil() {
        return null;
    }

    public static <Z> F_MyUtil<Z> cons(Z head, F_MyUtil<Z> tail) {
        return null;
    }

    E head() {
        return null;
    }
}

public class F_InferenceTest {
    public static void main(String[] args) {
        // 通过方法赋值的目标此时来推断泛型为String
        F_MyUtil<String> mu1 = F_MyUtil.nil();
        // 在调用nil()方法时无须使用下面的语句指定泛型的类型
        F_MyUtil<String> mu2 = F_MyUtil.<String>nil();

        // 调用cons()方法所需的参数类型来推断泛型为Integer
        F_MyUtil.cons(42, F_MyUtil.nil());
        // 在调用nil()方法时无须使用下面的语句指定泛型的类型
        F_MyUtil.cons(42, F_MyUtil.<Integer>nil());

        // 希望系统能推断出在调用nil()方法时泛型为String类型
        // 但实际上Java 8推断不出来，所以下面的代码报错
        // String s = F_MyUtil.nil().head();
        String s = F_MyUtil.<String>nil().head();
    }
}
