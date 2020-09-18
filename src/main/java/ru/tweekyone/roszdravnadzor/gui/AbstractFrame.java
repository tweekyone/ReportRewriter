package ru.tweekyone.roszdravnadzor.gui;

import javax.swing.*;

public class AbstractFrame extends JFrame {

    static{
        try{
            String className = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch (Exception ignore) {}
    }

    public AbstractFrame(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
