package org.crazy.ch12_swing.sec02_basic_swing_components;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class D_JToolBarTest {
    JFrame jf = new JFrame("工具栏测试");
    JMenuBar jmb = new JMenuBar();
    JMenu edit = new JMenu("编辑");
    JToolBar jtb = new JToolBar();
    JTextArea jta = new JTextArea(6, 30);

    // 获取系统剪贴板
    Clipboard clipboard = Toolkit.getDefaultToolkit()
        .getSystemClipboard();

    // 创建"复制"Action
    Action copyAction = new AbstractAction("复制", new ImageIcon("../data/ch12_swing/ico/copy.png")) {
        public void actionPerformed(ActionEvent e) {
            var contents = new StringSelection(jta.getSelectedText());
            // 将StringSelection对象放入剪贴板中
            clipboard.setContents(contents, null);
            // 如果剪贴板中包含stringFlavor
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                // 将pasteAction激活
                pasteAction.setEnabled(true);
            }
        }
    };

    // 创建"粘贴"Action，该Action用于创建菜单项、工具按钮和普通按钮
    Action pasteAction = new AbstractAction("粘贴", new ImageIcon("../data/ch12_swing/ico/paste.png")) {
        public void actionPerformed(ActionEvent e) {
            // 如果剪贴板中包含stringFlavor内容
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                try {
                    // 取出剪贴板中的stringFlavor内容
                    var content = (String) clipboard.getData(DataFlavor.stringFlavor);
                    // 将选中内容替换成剪贴板中的内容
                    jta.replaceRange(content, jta.getSelectionStart(),
                            jta.getSelectionEnd());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    };

    public void init() {
        // pasteAction默认处于未激活状态
        pasteAction.setEnabled(false);
        jf.add(new JScrollPane(jta));

        // 以Action创建按钮，并将按钮添加到JPanel中
        var copyBtn = new JButton(copyAction);
        var pasteBtn = new JButton(pasteAction);

        var jp = new JPanel();
        jp.add(copyBtn);
        jp.add(pasteBtn);

        jf.add(jp, BorderLayout.SOUTH);

        // 向工具条中添加Action对象，该对象将会被转换成工具按钮
        jtb.add(copyAction);
        jtb.addSeparator();
        jtb.add(pasteAction);
        // 设置工具条和工具按钮之间的页边距
        jtb.setMargin(new Insets(20, 10, 5, 30));
        // 向窗口添加工具条
        jf.add(jtb, BorderLayout.NORTH);

        // 向菜单中添加Action对象，该对象将会被转换成菜单项
        edit.add(copyAction);
        edit.add(pasteAction);
        // 将edit菜单添加到菜单条中
        jmb.add(edit);
        jf.setJMenuBar(jmb);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new D_JToolBarTest().init();
    }
}
