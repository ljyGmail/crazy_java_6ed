package org.crazy.ch11_awt.sec08_image_drawing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class C_ZoomImageTest {
    // 下面两个常量设置缩小后位图的大小
    private final int WIDTH = 80;
    private final int HEIGHT = 60;
    // 定义一个BufferedImage对象，用于保存缩小后的位图
    BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();

    public void zoom() throws Exception {
        // 读取原始位图
        Image srcImage = ImageIO.read(new File("../data/ch11_awt/watchos.jpg"));
        // 将原始位图缩小后绘制到image对象中
        g.drawImage(srcImage, 0, 0, WIDTH, HEIGHT, null);
        // 将image对象输出到磁盘文件中
        ImageIO.write(image, "jpeg",  new File("../data/ch11_awt/" + System.currentTimeMillis() + ".jpg"));
    }

    public static void main(String[] args) throws Exception {
        new C_ZoomImageTest().zoom();
    }
}
