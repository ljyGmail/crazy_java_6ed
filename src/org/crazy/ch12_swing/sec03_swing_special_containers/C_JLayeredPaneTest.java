package org.crazy.ch12_swing.sec03_swing_special_containers;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class C_JLayeredPaneTest {
    JFrame jf = new JFrame("JLayeredPane测试");
    JLayeredPane layeredPane = new JLayeredPane();

    public void init() {
        // 向layeredPane中添加三个组件
        layeredPane.add(new C_ContentPanel(10, 20, "疯狂Java讲义",
            "../data/ch12_swing/ico/java.png"), JLayeredPane.MODAL_LAYER);
        layeredPane.add(new C_ContentPanel(100, 60, "疯狂Android讲义",
            "../data/ch12_swing/ico/android.png"), JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(new C_ContentPanel(190, 100, "轻量级Java EE企业应用实战",
            "../data/ch12_swing/ico/ee.png"), 4);

        layeredPane.setPreferredSize(new Dimension(400, 300));
        // layeredPane.setVisible(true);

        jf.add(layeredPane);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new C_JLayeredPaneTest().init();
    }
}

// 扩展了JPanel类，可以直接创建一个放在指定位置
// 且有指定标题、指定图标的JPanel对象
class C_ContentPanel extends JPanel {
    public C_ContentPanel(int xPos, int yPos,
            String title, String ico) {
        setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), title));
        var label = new JLabel(new ImageIcon(ico));
        this.add(label);
        setBounds(xPos, yPos, 160, 220);
    }
}
