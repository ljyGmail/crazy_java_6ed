package org.crazy.ch10_exception_handling.sec04_using_throw_statement;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class D_Throw2Test {
    public static void main(String[] args) 
        // Java 6认为下面throw ex语句可能抛出Exception异常
        // 所以此处必须声明抛出Exception异常
        // Java 7后检查throw ex语句代码开能抛出的异常的实际类型
        // 因此此处只需要声明抛出FileNotFoundException异常即可
        throws FileNotFoundException {

        System.out.println("该示例演示使用throw语句抛出异常时，方法签名中的throws语句可以抛出异常的实际类型");
        try {
            new FileOutputStream("a.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
