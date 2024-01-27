package org.crazy.ch08_collections.sec03_set;

import java.util.TreeSet;

class E_Err {}

public class E_TreeSetErrorTest {
    public static void main(String[] args) {
        var ts = new TreeSet();
        // 向TreeSet集合中添加Err对象
        // ts.add(new E_Err());
        System.out.println("此示例表明将没有实现Comparable接口的对象放入到TreeSet时立即引发ClassCastException");
    }
}
