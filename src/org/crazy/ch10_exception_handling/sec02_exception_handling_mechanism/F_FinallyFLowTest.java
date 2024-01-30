package org.crazy.ch10_exception_handling.sec02_exception_handling_mechanism;

public class F_FinallyFLowTest {
    public static void main(String[] args) {
        boolean a = test();
        System.out.println(a);
        System.out.println("该示例表明如果在finally块中包含了return或throw语句将导致try/catch块中的return/throw语句失效");
    }

    public static boolean test() {
        try {
            // 因为finally块中包含了return语句
            // 所以下面的return语句失去作用
            return true;
        } finally {
            return false;
        }
    }
}
