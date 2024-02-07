package org.crazy.ch11_awt.sec09_clipboard;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

class G_Dog implements Serializable {
    private String name;
    private Integer age;

    public G_Dog() {}

    public G_Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog[name: " + name + ", age: " + age + "]";
    }
}

public class G_CopySerializableTest {

    Frame f = new Frame("复制对象");
    Button copy = new Button("复制");
    Button paste = new Button("粘贴");
    TextField name = new TextField(15);
    TextField age = new TextField(15);
    TextArea ta = new TextArea(3, 30);

    // 创建系统剪贴板
    Clipboard clipboard = Toolkit.getDefaultToolkit()
        .getSystemClipboard();

    public void init() {
        var p = new Panel();
        p.add(new Label("姓名"));
        p.add(name);
        p.add(new Label("年龄"));
        p.add(age);

        f.add(p, BorderLayout.NORTH);
        f.add(ta);

        var bp = new Panel();
        copy.addActionListener(e -> copyDog());

        paste.addActionListener(e -> {
            try {
                readDog();
            } catch (Exception ex ) {
                ex.printStackTrace();
            }
        });

        bp.add(copy);
        bp.add(paste);

        f.add(bp, BorderLayout.SOUTH);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.pack();
        f.setVisible(true);
    }

    public void copyDog() {
        var d = new G_Dog(name.getText(),
                Integer.parseInt(age.getText()));
        // 把dog实例封装成SerialSelection对象
        var ls = new F_SerialSelection(d);
        // 把SerialSelection对象放入系统剪贴板中
        clipboard.setContents(ls, null);
    }

    public void readDog() throws Exception  {
        var dogFlavor = new DataFlavor(DataFlavor
                .javaSerializedObjectMimeType + ";class=org.crazy.ch11_awt.sec09_clipboard.G_Dog");
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            // 从系统剪贴板中读取信息
            var d = (G_Dog) clipboard.getData(dogFlavor);
            ta.setText(d.toString());
        }
    }

    public static void main(String[] args) {
        new G_CopySerializableTest().init();
    }
}
