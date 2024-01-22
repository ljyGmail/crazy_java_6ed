package org.crazy.ch06_oop_2.sec09_enum;

public class B_EnumTest {
    public void judge(A_SeasonEnum s) {
        // switch语句中的表达式可以是枚举值
        switch (s) {
            case SPRING -> System.out.println("春暖花开，正好踏青");
            case SUMMER -> System.out.println("夏日炎炎，适合游泳");
            case FALL -> System.out.println("秋高气爽，进步及时");
            case WINTER -> System.out.println("冬日雪飘，围护赏雪");
        }
    }

    public static void main(String[] args) {
        // 枚举类默认又一个values()方法，该方法返回该枚举类的所有实例
        for (var s : A_SeasonEnum.values()) {
            System.out.println(s);
        }

        // 当使用枚举实例时，可通过EnumClass.variable的形式来访问
        new B_EnumTest().judge(A_SeasonEnum.SPRING);
    }
}
