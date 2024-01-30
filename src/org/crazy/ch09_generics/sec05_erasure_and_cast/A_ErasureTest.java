package org.crazy.ch09_generics.sec05_erasure_and_cast;

class A_Apple<T extends Number> {
    T size;

    public A_Apple() {
    }

    public A_Apple(T size) {
        this.size = size;
    }

    public void setSize(T size) {
        this.size = size;
    }

    public T getSize() {
        return this.size;
    }
}

public class A_ErasureTest {
    public static void main(String[] args) {
        A_Apple<Integer> a = new A_Apple<>(6);
        // a的getSize()方法返回Integer对象
        Integer as = a.getSize();
        // 把a对象赋给Apple变量，丢失尖括号的类型信息
        A_Apple b = a;
        // b只知道size的类型是Number
        Number size1 = b.getSize();
        // 下面的代码引起编译错误
        // Integer size2 = b.getSize();
        System.out.println("该示例表明当把泛型变量赋给一个不带泛型信息的变量时，编译器会丢失泛型的信息");
    }
}
