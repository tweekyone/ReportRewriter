package ru.tweekyone.roszdravnadzor.controllers;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.tweekyone.roszdravnadzor.beans.TableRepresentation;

import java.io.*;
import java.util.List;

public class MainController {
    private List<TableRepresentation> list;

    public List<TableRepresentation> readTable(String path){
        try (FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader( fis, "windows-1251")) {
            list = new CsvToBeanBuilder(isr).withType(TableRepresentation.class).withSeparator(';').build().parse();
        } catch (IOException e){
            e.printStackTrace();
        }

        return list;
    }

    public void writeTable(List<TableRepresentation> result, String path){
        list = result;
        try(FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "windows-1251");
            CSVWriter writer = new CSVWriter(osw, ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)){
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            try {
                beanToCsv.write(list);
            } catch (CsvDataTypeMismatchException e) {
                e.printStackTrace();
            } catch (CsvRequiredFieldEmptyException e) {
                e.printStackTrace();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public List<TableRepresentation> getList() {
        return list;
    }

    public void setList(List<TableRepresentation> list) {
        this.list = list;
    }
}
