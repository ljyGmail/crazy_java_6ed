package org.crazy.ch11_awt.sec07_awt_drawing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.Timer;

public class B_PinBallTest {

    Random rand = new Random();
    // 桌面的宽度
    private final int TABLE_WIDTH = 300;
    // 桌面的高度
    private final int TABLE_HEIGHT = 400;
    // 球拍的垂直位置
    private final int RACKET_Y = 340;
    // 球拍的水平位置
    private int racketX = rand.nextInt(200);

    // 下面定义球拍的高度和宽度
    private final int RACKET_HEIGHT = 20;
    private final int RACKET_WIDTH = 60;

    // 小球的大小
    private final int BALL_SIZE = 16;
    // 小球纵向的运行速度
    private int ySpeed = 10;
    // 返回一个-0.5~0.5的比率，用于控制小球的运行方向
    private double xyRate = rand.nextDouble() - 0.5;
    // 小球横向的运行速度
    private int xSpeed = (int) (ySpeed * xyRate * 2);
    // ballX和ballY代表小球的坐标
    private int ballX = rand.nextInt(200) + 20;
    private int ballY = rand.nextInt(10) + 20;

    // 游戏是否结束的旗标
    private boolean isLose = false;

    private Frame f = new Frame("弹球游戏");
    private MyCanvas tableArea = new MyCanvas();
    Timer timer;


    public void init() {
        // 设置桌面区域的最佳大小
        tableArea.setPreferredSize(
                new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        f.add(tableArea);
        // 定义键盘监听器
        var keyProcessor = new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                // 按下向左、向右的键时，球拍水平坐标分别减少、增加
                if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (racketX > 0)
                        racketX -= 10;
                }
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (racketX < TABLE_WIDTH - RACKET_WIDTH)
                        racketX += 10;
                }
            }
        };

        // 为窗口和tableArea对象分别添加键盘监听器
        f.addKeyListener(keyProcessor);
        tableArea.addKeyListener(keyProcessor);

        // 定义每0.1秒执行一次的事件监听器
        ActionListener taskPerformer = evt -> {
            // 如果小球碰到左右边框，横向反弹
            if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
                xSpeed *= -1;
            }

            // 如果小球位于球拍范围之内，且到达球拍位置，小球纵向反弹
            if (ballY <= 0 ||
                (ballY >= RACKET_Y - BALL_SIZE
                 && ballX > racketX && ballX <= racketX + RACKET_WIDTH)) {
                ySpeed *= -1;
            }

            // 如果小球的高度超出了球拍位置，且横向不在球拍范围之内，游戏结束
            if (ballY >= RACKET_Y - BALL_SIZE &&
                    (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
                timer.stop();
                // 设置游戏是否结束的旗标为true
                isLose = true;
                tableArea.repaint();
            }

            // 小球坐标增加
            ballY += ySpeed;
            ballX += xSpeed;
            tableArea.repaint();
        };

        timer = new Timer(100, taskPerformer);
        timer.start();

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.pack();
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        new B_PinBallTest().init();
    }

    class MyCanvas extends Canvas {

        // 重写Canvas的paint()方法，实现绘画
        public void paint(Graphics g) {
            // 如果游戏已经结束
            if (isLose) {
                g.setColor(new Color(255, 0, 0));
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("游戏已结束", 50, 200);
            } 
            /* 如果游戏还未结束 */
            else {
                // 设置颜色，并绘制小球
                g.setColor(new Color(240, 240, 80));
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
                // 设置颜色，并绘制球拍
                g.setColor(new Color(80, 80, 200));
                g.fillRect(racketX, RACKET_Y,
                        RACKET_WIDTH, RACKET_HEIGHT);
            }
        }
    }
}
