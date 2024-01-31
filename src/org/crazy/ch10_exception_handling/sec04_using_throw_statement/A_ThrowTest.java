package org.crazy.ch10_exception_handling.sec04_using_throw_statement;

public class A_ThrowTest {
    public static void main(String[] args) {
        try {
            // 调用声明抛出Checked异常的方法，要么显式捕捉该异常
            // 要么在main()方法中再次声明抛出
            throwChecked(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 调用声明抛出Runtime异常的方法，既可以显式捕捉该异常
        // 也可以不理会该异常
        throwRuntime(3);
    }

    public static void throwChecked(int a) throws Exception {
        if (a > 0) {
            // 自行抛出Exception异常
            // 该代码必须位于try块中，或者位于带throws声明抛出的方法中
            throw new Exception("a的值大于0，不符合要求");
        }
    }

    public static void throwRuntime(int a) {
        if (a > 0) {
            // 自行抛出RuntimeExcepiton异常，既可以显式捕捉该异常
            // 也可以完全不理会该异常，把该异常交给该方法的调用者处理
            throw new RuntimeException("a的值大于0，不符合要求");
        }
    }
}
