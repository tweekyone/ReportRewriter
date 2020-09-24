package ru.tweekyone.roszdravnadzor.gui;

import ru.tweekyone.roszdravnadzor.controllers.MainController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends AbstractFrame {
    private MainController mc;

    public MainFrame(){
        setSize(550, 180);
        setResizable(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width/2 - 250, dimension.height/2 - 90);
        setTitle("ReportMagicApp");
        setVisible(true);
        setResizable(false);
        mc = new MainController();
        onInitComponents();
    }

    private void onInitComponents(){
        JLabel pastFileLabel = new JLabel("Укажите предыдущий отчет:");
        JLabel thisFileLabel = new JLabel("Укажите действующий отчет:");
        JLabel newFileLabel = new JLabel("Куда сохранить:");
        JLabel errorLabel = new JLabel();
        errorLabel.setVisible(false);
        errorLabel.setForeground(Color.red);

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
        pastBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Отчет за предыдущий месяц");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
                int result = fileChooser.showOpenDialog(MainFrame.this);

                if(result == JFileChooser.APPROVE_OPTION){
                    String way = fileChooser.getSelectedFile().getPath();
                    if(!mc.getFileExtension(way).equals("csv")){
                        errorLabel.setText("Не верный формат файла!");
                        errorLabel.setVisible(true);
                    } else {
                        errorLabel.setVisible(false);
                        pastFileWay.setText(way);
                    }
                }
            }
        });

        JButton thisBrowse = new JButton("...");
        thisBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Отчет за нынешний месяц");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
                int result = fileChooser.showOpenDialog(MainFrame.this);

                if(result == JFileChooser.APPROVE_OPTION){
                    String way = fileChooser.getSelectedFile().getPath();
                    if(!mc.getFileExtension(way).equals("csv")){
                        errorLabel.setText("Не верный формат файла!");
                        errorLabel.setVisible(true);
                    } else {
                        errorLabel.setVisible(false);
                        thisFileWay.setText(way);
                    }
                }
            }
        });

        JButton newBrowse = new JButton("...");
        newBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Сохранить в...");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(MainFrame.this);

                if(result == JFileChooser.APPROVE_OPTION){
                    newFileWay.setText(fileChooser.getSelectedFile().getPath());
                }
            }
        });

        JButton confirm = new JButton("Запустить");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!pastFileWay.getText().isEmpty() || !thisFileWay.getText().isEmpty() || !newFileWay.getText().isEmpty()) {
                    errorLabel.setVisible(false);
                    mc.readPastTable(new File(pastFileWay.getText()));
                    File thisFile = new File(thisFileWay.getText());
                    mc.readThisTable(thisFile);
                    StringBuilder newFilePath = new StringBuilder(newFileWay.getText());
                    newFilePath.append("\\new");
                    newFilePath.append(thisFile.getName());
                    mc.writeTable(newFilePath.toString());
                    errorLabel.setText("Отчет сохранен!");
                    errorLabel.setForeground(Color.green);
                    errorLabel.setVisible(true);
                } else {
                    errorLabel.setText("Укажите путь!");
                    errorLabel.setVisible(true);
                }
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
                            .addComponent(newFileLabel)
                            .addComponent(errorLabel))
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
                            .addComponent(errorLabel)
                            .addComponent(confirm)));

        add(mainPanel);
        revalidate();
    }


}
