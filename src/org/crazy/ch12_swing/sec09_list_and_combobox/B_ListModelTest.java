package org.crazy.ch12_swing.sec09_list_and_combobox;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class B_ListModelTest {
    private JFrame mainWin = new JFrame("ListModel测试");

    // 根据NumberListModel对象来创建JList对象
    private JList<BigDecimal> numScopeList = new JList<>(
        new B_NumberListModel(1, 21, 2));

    // 根据NumberComboBoxModel对象来创建JComboBox对象
    private JComboBox<BigDecimal> numScopeSelector = new JComboBox<>(
        new B_NumberComboBoxModel(0.1, 1.2, 0.1));

    private JTextField showVal =  new JTextField(10);

    public void init() {
        // JList的可视高度同时显示4个列表项
        numScopeList.setVisibleRowCount(4);
        // 默认选中第3项到第5项(第1项的索引是0)
        numScopeList.setSelectionInterval(2, 4);
        // 设置每个 列表项都具有指定的高度和宽度
        numScopeList.setFixedCellHeight(30);
        numScopeList.setFixedCellWidth(90);
        // 为numScopeList添加监听器
        numScopeList.addListSelectionListener(e -> {
            // 获取用户选中的所有数值
            List<BigDecimal> nums = numScopeList.getSelectedValuesList();
            showVal.setText("");
            // 把用户选中的数值添加到单行文本框中
            for (var num : nums) {
                showVal.setText(showVal.getText()
                    + num.toString() + ", ");
            }
        });

        // 设置列表框的可视高度可显示5个列表项
        numScopeSelector.setMaximumRowCount(5);

        var box = new Box(BoxLayout.X_AXIS);
        box.add(new JScrollPane(numScopeList));

        var p = new JPanel();
        p.add(numScopeSelector);
        box.add(p);

        // 为numScopeSelector添加监听器
        numScopeSelector.addItemListener(e -> {
            // 获取JComboBox中所选中的数值
            Object num = numScopeSelector.getSelectedItem();
            showVal.setText(num.toString());
        });

        var  bottom = new JPanel();
        bottom.add(new JLabel("您选择的值是: "));
        bottom.add(showVal);

        mainWin.add(box);
        mainWin.add(bottom,  BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new B_ListModelTest().init();
    }
}

class B_NumberListModel extends AbstractListModel<BigDecimal> {

    protected BigDecimal start;
    protected BigDecimal end;
    protected BigDecimal step;

    public B_NumberListModel(double start, double end, double step) {
        this.start = BigDecimal.valueOf(start);
        this.end = BigDecimal.valueOf(end);
        this.step = BigDecimal.valueOf(step);
    }

    // 返回列表想的数量
    public int getSize() {
        return (int) Math.floor(end.subtract(start)
            .divide(step).doubleValue()) + 1;
    }

    // 返回指定索引处的列表项
    public BigDecimal getElementAt(int index) {
        return BigDecimal.valueOf(index).multiply(step).add(start);
    }
}

class B_NumberComboBoxModel extends B_NumberListModel
    implements ComboBoxModel<BigDecimal> {

    // 用于保存用户选中项的索引
    private int selectId = 0;

    public B_NumberComboBoxModel(double start, double end, double step) {
        super(start, end, step);
    }

    // 设置选中"选择项"
    public void setSelectedItem(Object  anItem) {
        if (anItem instanceof BigDecimal) {
            var target = (BigDecimal) anItem;
            // 根据选中的值来修改选中项的索引
            selectId = target.subtract(super.start).divide(step).intValue();
        }
    }

    // 获取"选择项"的值
    public Object getSelectedItem() {
        // 根据选中项的索引来取得选中项
        return BigDecimal.valueOf(selectId).multiply(step).add(start);
    }
}
