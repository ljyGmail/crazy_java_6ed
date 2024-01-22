package org.crazy.ch06_oop_2.sec09_enum;

public enum K_OperationTest {
    PLUS {
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double eval(double x, double y) {
            return x - y;
        }
    },
    MULTIPY {
        public double eval(double x, double y) {
            return x * y;
        }
    }, DIVIDE {
        public double eval(double x, double y) {
            return x / y;
        }
    };

    //  为枚举类定义一个抽象方法
    //  这个抽象方法由不同的枚举值提供不同的实现
    public abstract  double eval(double x, double y);

    public static void main(String[] args) {
        System.out.println(K_OperationTest.PLUS.eval(3, 4));
        System.out.println(K_OperationTest.MINUS.eval(5, 4));
        System.out.println(K_OperationTest.MULTIPY.eval(5, 4));
        System.out.println(K_OperationTest.DIVIDE.eval(5, 4));
    }
}
