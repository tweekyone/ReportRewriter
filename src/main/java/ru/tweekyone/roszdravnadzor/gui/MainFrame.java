package ru.tweekyone.roszdravnadzor.gui;

import ru.tweekyone.roszdravnadzor.controllers.MainController;
import ru.tweekyone.roszdravnadzor.service.FileChooserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends AbstractFrame {
    private MainController mc;
    private FileChooserService fcs;

    public MainFrame(){
        setSize(500, 180);
        setResizable(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width/2 - 250, dimension.height/2 - 90);
        setTitle("ReportMagicApp");
        setResizable(false);
        setVisible(true);
        mc = new MainController();
        fcs = new FileChooserService();
        onInitComponents();
    }

    private void onInitComponents(){
        JLabel pastFileLabel = new JLabel("Укажите предыдущий отчет:");
        JLabel thisFileLabel = new JLabel("Укажите действующий отчет:");
        JLabel newFileLabel = new JLabel("Куда сохранить:");

        TextField pastFileWay = new TextField();
        pastFileWay.setEditable(false);
        pastFileWay.setEnabled(false);
        TextField thisFileWay = new TextField();
        thisFileWay.setEditable(false);
        thisFileWay.setEnabled(false);
        TextField newFileWay = new TextField();
        newFileWay.setEditable(false);
        newFileWay.setEnabled(false);

        JButton pastBrowse = new JButton("...");

        JButton thisBrowse = new JButton("...");
        JButton newBrowse = new JButton("...");

        JButton confirm = new JButton("Запустить");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mc.readPastTable(new File(pastFileWay.getText()));
                mc.readThisTable(new File(thisFileWay.getText()));
                mc.writeTable(newFileWay.getText());
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
                            .addComponent(thisFileLabel)
                            .addComponent(newFileLabel))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pastFileWay)
                            .addComponent(thisFileWay)
                            .addComponent(newFileWay)
                            .addComponent(confirm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pastBrowse)
                            .addComponent(thisBrowse)
                            .addComponent(newBrowse)));

        gl.setVerticalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(pastFileLabel)
                            .addComponent(pastFileWay)
                            .addComponent(pastBrowse))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(thisFileLabel)
                            .addComponent(thisFileWay)
                            .addComponent(thisBrowse))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(newFileLabel)
                            .addComponent(newFileWay)
                            .addComponent(newBrowse))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(confirm)));

        add(mainPanel);
    }


}
