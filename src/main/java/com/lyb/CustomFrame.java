package com.lyb;

import com.lyb.component.CustomList;

import javax.swing.*;
import java.awt.*;


/**
 * @author lyb
 * @version 1.0
 * @description: TODO
 * @date 2023/7/9 21:40
 */
public class CustomFrame extends JFrame {

    private JList<String> list;

    public CustomFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initData();
    }

    private void initData(){
        JPanel jPanel = new JPanel();
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("安徽");
        model.addElement("湖南");
        model.addElement("山东");
        model.addElement("东北");
        model.addElement("辽宁");
        model.addElement("湖北");
        model.addElement("河北");
        model.addElement("河南");
        model.addElement("江苏");
        model.addElement("浙江");
        model.addElement("新疆");

        list=new CustomList(model);
        model.addElement("黑龙江");
        jPanel.add(new JScrollPane(list),BorderLayout.CENTER);
        setContentPane(jPanel);
        pack();
    }
}
