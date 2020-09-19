package ru.tweekyone.roszdravnadzor.gui;

import ru.tweekyone.roszdravnadzor.controllers.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends AbstractFrame {
    private MainController mc;

    public MainFrame(){
        setSize(300, 300);
        setResizable(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width/2 - 150, dimension.height/2 - 150);
        setTitle("ReportMagicApp");
        setVisible(true);
        mc = new MainController();
        onInitComponents();
    }

    private void onInitComponents(){
        JLabel pastFileLabel = new JLabel("Укажите предыдущий отчет:");
        JLabel thisFileLabel = new JLabel("Укажите действующий отчет:");
        JLabel newFileLabel = new JLabel("Куда сохранить:");

        JFileChooser pastFileChooser = new JFileChooser();
        JFileChooser thisFileChooser = new JFileChooser();
        JFileChooser newFileChooser = new JFileChooser();

        JButton confirm = new JButton("Запустить");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mc.readPastTable(pastFileChooser.getCurrentDirectory());
                mc.readThisTable(thisFileChooser.getCurrentDirectory());
                mc.writeTable(newFileChooser.getCurrentDirectory().getPath());
            }
        });

        JPanel mainPanel = new JPanel();
        GroupLayout gl = new GroupLayout(mainPanel);
        mainPanel.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pastFileLabel)
                            .addComponent(pastFileChooser))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(thisFileLabel)
                            .addComponent(thisFileChooser))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(newFileLabel)
                            .addComponent(newFileChooser))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(confirm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gl.setVerticalGroup(gl.createSequentialGroup());

        add(mainPanel);
    }


}
