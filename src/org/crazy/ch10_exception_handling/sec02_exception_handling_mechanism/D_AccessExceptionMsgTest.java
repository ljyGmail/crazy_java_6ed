package org.crazy.ch10_exception_handling.sec02_exception_handling_mechanism;

import java.io.FileInputStream;
import java.io.IOException;

public class D_AccessExceptionMsgTest {
    public static void main(String[] args) {
        try {
            var fis = new FileInputStream("nonexist.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
