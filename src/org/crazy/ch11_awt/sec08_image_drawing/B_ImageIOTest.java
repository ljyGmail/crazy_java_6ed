package org.crazy.ch11_awt.sec08_image_drawing;

import javax.imageio.ImageIO;

public class B_ImageIOTest {
    public static void main(String[] args) {
        String[] readFormats = ImageIO.getReaderFormatNames();
        System.out.println("-----ImageIO能读的所有图形文件格式-----");
        for (var readFormat : readFormats) {
            System.out.println(readFormat);
        }

        String[] writeFormats = ImageIO.getWriterFormatNames();
        System.out.println("-----ImageIO能写的所有图形文件格式-----");
        for (var writeFormat : writeFormats) {
            System.out.println(writeFormat);
        }
    }
}
