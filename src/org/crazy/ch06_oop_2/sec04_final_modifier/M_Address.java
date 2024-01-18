package org.crazy.ch06_oop_2.sec04_final_modifier;

public class M_Address {
    private final String detail;
    private final String postCode;

    // 在构造器中初始化两个实例变量
    public M_Address(String detail, String postCode) {
        this.detail = detail;
        this.postCode = postCode;
    }

    // 仅为两个实例变量提供getter方法
    public String getDetail() {
        return this.detail;
    }

    public String getPostCode() {
        return this.postCode;
    }

    // 重写equals()方法，判断两个对象是否相等
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj != null && obj.getClass() == M_Address.class) {
            var ad = (M_Address) obj;
            // 当detail和postCode相等时，可以认为两个Address对象相等
            return this.getDetail().equals(ad.getDetail())
                && this.getPostCode().equals(ad.getPostCode());
        }
        return false;
    }

    public int hashCode() {
        return detail.hashCode() + postCode.hashCode() * 31;
    }
}
