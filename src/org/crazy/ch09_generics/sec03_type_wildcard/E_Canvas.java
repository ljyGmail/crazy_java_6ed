package org.crazy.ch09_generics.sec03_type_wildcard;

import java.util.ArrayList;
import java.util.List;

public class E_Canvas {
    // 同时在画布上绘制多个形状
    /*
     * public void drawAll(List<B_Shape> shapes) {
     * for (var s : shapes) {
     * s.draw(this);
     * }
     * }
     */

    public void drawAll(List<? extends B_Shape> shapes) {
        for (var s : shapes) {
            s.draw(this);
        }
    }

    /*
     * public void addRectangle(List<? extends B_Shape> shapes) {
     * // 下面的代码引起编译错误
     * shapes.add(0, new D_Rectangle());
     * }
     */

    public static void main(String[] args) {
        List<C_Circle> circleList = new ArrayList<>();
        circleList.add(new C_Circle());
        circleList.add(new C_Circle());
        var c = new E_Canvas();
        // 不能把List<Circle>当成List<Shape>使用，所以下面代码因此编译错误
        c.drawAll(circleList);
    }
}
