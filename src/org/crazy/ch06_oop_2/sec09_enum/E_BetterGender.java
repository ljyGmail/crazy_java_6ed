package org.crazy.ch06_oop_2.sec09_enum;

public enum E_BetterGender {
    MALE, FEMALE;

    private String name;

    public void setName(String name) {
        switch (this) {
            case MALE -> {
                if (name.equals("男")) {
                    this.name = name;
                } else {
                    System.out.println("参数错误");
                    return;
                }
            }
            case FEMALE -> {
                if (name.equals("女")) {
                    this.name = name;
                } else {
                    System.out.println("参数错误");
                    return;
                }
            }
        }
    }

    public String getName() {
        return this.name;
    }
}
