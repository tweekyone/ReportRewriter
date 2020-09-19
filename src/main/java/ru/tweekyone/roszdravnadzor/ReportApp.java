package ru.tweekyone.roszdravnadzor;

import ru.tweekyone.roszdravnadzor.gui.MainFrame;

public class ReportApp {

    public static void main(String[] args) {
//	// write your code here
//        MainController mc = new MainController();
//        TablesService ts = new TablesService();
//        List<TableRepresentation> pastMonth = mc.readTable("C:\\Users\\Пирожок\\Downloads\\20_07 (1).csv");
//        List<TableRepresentation> thisMonth = mc.readTable("C:\\Users\\Пирожок\\Downloads\\24_08.csv");
//        List<TableRepresentation> result = ts.doComparsion(pastMonth, thisMonth);
//        mc.writeTable(result, "C:\\Users\\Пирожок\\Downloads\\new.csv");

        int a = 10;

        foo();

        Simple simple = new Simple(2, "String");

    }

    public static void foo(){
        int a = 1;
    }



    static class Simple{
        private int a;
        private String s;

        public Simple(int a, String s) {
            this.a = a;
            this.s = s;
        }

    }
}
