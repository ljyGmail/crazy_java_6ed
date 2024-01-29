package org.crazy.ch09_generics.sec02_deep_dive_into_generics;

public class B_A1 extends A_AppleTest<String> {
    // 正确重写了父类的方法，返回值与父类AppleTest<String>的返回值完全相同
    public String getInfo() {
        return "子类" + super.getInfo();
    }

    /*
     * // 下面的方法是错误的，重写父类方法时返回值类型不一致
     * public Object getInfo() {
     * return "子类";
     * }
     */
}
