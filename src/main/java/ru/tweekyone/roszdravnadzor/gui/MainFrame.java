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
        setTitle("ReportMagic");
        setVisible(true);
        mc = new MainController();
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

            }
        });


    }
}
