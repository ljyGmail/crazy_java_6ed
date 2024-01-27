package org.crazy.ch08_collections.sec03_set;

import java.util.TreeSet;

class I_M {
    int age;

    public I_M(int age) {
        this.age = age;
    }

    public  String toString() {
        return "M [age: " + age + "]";
    }
}

public class I_TreeSet4Test {
    public static void main(String[] args) {
        // 此处Lambda表达式的目标类型是Comparator
        var ts = new TreeSet((o1, o2) -> {
            var m1 = (I_M) o1;
            var m2 = (I_M) o2;
            // 根据M对象的age属性来决定大小，age越大，M对象反而越小
            return m1.age > m2.age ? -1
                : m1.age < m2.age ? 1 : 0;
        });

        ts.add(new I_M(5));
        ts.add(new I_M(-3));
        ts.add(new I_M(9));
        System.out.println(ts);
    }
}
