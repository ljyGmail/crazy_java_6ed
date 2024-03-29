package org.crazy.ch11_awt.sec10_drag_and_drop;

import java.awt.Cursor;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class B_DragSourceTest {

    JFrame jf = new JFrame("Swing的拖放支持");
    JLabel srcLabel = new JLabel("Swing的拖放支持.\n"
            + "将该文本的内容拖入其他程序.\n");

    public void init() {
        DragSource dragSource = DragSource.getDefaultDragSource();
        // 将srcLabel转换成拖放源，它能接受复制、移动两种操作
        dragSource.createDefaultDragGestureRecognizer(srcLabel,
                DnDConstants.ACTION_COPY_OR_MOVE,
                event -> {
                    // 将JLabel里的文本信息封装成Transferable对象
                    String txt = srcLabel.getText();
                    var transferable = new StringSelection(txt);
                    // 继续拖放操作，在拖放过程中使用手状光标
                    event.startDrag(Cursor.getPredefinedCursor(Cursor
                                .HAND_CURSOR), transferable);
        });

        jf.add(new JScrollPane(srcLabel));

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new B_DragSourceTest().init();
    }
}
