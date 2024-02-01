package org.crazy.ch11_awt.sec05_event_handling;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class E_MailerListener implements ActionListener {
    // 该TextField文本框用于输入发送邮件的地址
    private TextField mailAddress;

    public E_MailerListener() {}

    public E_MailerListener(TextField mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setMailAddress(TextField mailAddress) {
        this.mailAddress = mailAddress;
    }

    // 实现发送邮件
    public void actionPerformed(ActionEvent e) {
        System.out.println("程序向"
                + mailAddress.getText() + "发送邮件...");
        // 发送邮件的真实实现
    }
}
