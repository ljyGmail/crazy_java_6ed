package org.crazy.ch06_oop_2.sec09_enum;

public class F_BetterGenderTest {
    public static void main(String[] args) {
        E_BetterGender g = Enum.valueOf(E_BetterGender.class, "FEMALE");
        g.setName("女");
        System.out.println(g + "代表: " + g.getName());
        g.setName("男");
        System.out.println(g + "代表: " + g.getName());
    }
}
