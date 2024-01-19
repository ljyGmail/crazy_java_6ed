package org.crazy.ch06_oop_2.sec05_abstract_classes;

public class E_CarSpeedMeterTest extends D_SpeedMeter {

    private double radius;

    public E_CarSpeedMeterTest(double radius) {
        this.radius = radius;
    }

    public double calGirth() {
        return radius * 2 * Math.PI;
    }

    public static void main(String[] args) {
        var csm = new E_CarSpeedMeterTest(0.34);
        csm.setTurnRate(15);
        System.out.println(csm.getSpeed());
    }
}
