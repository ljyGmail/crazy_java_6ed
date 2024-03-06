package org.crazy.ch12_swing.sec10_tree;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class A_SimpleJtreeTest {

    JFrame jf = new JFrame("简单树测试");
    JTree tree;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode guangdong;
    DefaultMutableTreeNode guangxi;
    DefaultMutableTreeNode foshan;
    DefaultMutableTreeNode shantou;
    DefaultMutableTreeNode guilin;
    DefaultMutableTreeNode naning;

    public void init() {
        // 依次创建树中所有的节点
        root = new DefaultMutableTreeNode("中国");
        guangdong = new DefaultMutableTreeNode("广东");
        guangxi = new DefaultMutableTreeNode("广西");
        foshan = new DefaultMutableTreeNode("佛山");
        shantou = new DefaultMutableTreeNode("汕头");
        guilin = new DefaultMutableTreeNode("桂林");
        naning = new DefaultMutableTreeNode("桂林");

        // 通过add()方法建立树节点之间的父子关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(naning);
        root.add(guangdong);
        root.add(guangxi);

        // 以根节点创建树
        tree = new JTree(root);
        jf.add(new JScrollPane(tree));

        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SimpleJtree().init();
    }
}
