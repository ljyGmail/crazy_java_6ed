package org.crazy.ch11_awt.sec06_awt_menu;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class B_PopupMenuTest {
    private Frame f = new Frame("右键菜单");

    private TextArea ta = new TextArea(4, 30);

    PopupMenu pop = new PopupMenu();
    CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
    MenuItem copyItem = new MenuItem("复制");
    MenuItem pasteItem = new MenuItem("粘贴");

    Menu format = new Menu("格式");
    // 创建commentItem菜单项，指定使用"Ctrl+Shift+/"快捷键
    MenuItem commentItem = new MenuItem("注释",
            new MenuShortcut(KeyEvent.VK_SLASH, true));
    MenuItem cancelItem = new MenuItem("取消注释");

    public void init() {
        // 以Lambda表达式创建菜单事件监听器
        ActionListener menuListener = e -> {
            var cmd = e.getActionCommand();
            ta.append("点击了'" + cmd + "'菜单\n");
        };

        // 为commentItem菜单项添加事件监听器
        commentItem.addActionListener(menuListener);

        // 为pop菜单添加菜单项
        pop.add(autoWrap);
        // 使用addSeparator方法添加菜单分割线
        pop.addSeparator();
        pop.add(copyItem);
        pop.add(pasteItem);

        // 为format菜单添加菜单项
        format.add(commentItem);
        format.add(cancelItem);

        // 使用new MenuItem("-")的方式添加菜单分割线
        pop.add(new MenuItem("-"));
        // 将format菜单组合到pop菜单中，从而形成二级菜单
        pop.add(format);

        final var p = new Panel();
        p.setPreferredSize(new Dimension(300, 160));
        // 向p窗口中添加PopupMenu对象
        p.add(pop);
        // 添加鼠标监听器
        p.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                // 如果释放的是鼠标右键
                if (e.isPopupTrigger()) {
                    pop.show(p, e.getX(), e.getY());
                }
            }
        });

        f.add(p);
        f.add(ta, BorderLayout.NORTH);

        // 以匿名内部类的形式创建事件监听器对象
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new B_PopupMenuTest().init();
    }
}
