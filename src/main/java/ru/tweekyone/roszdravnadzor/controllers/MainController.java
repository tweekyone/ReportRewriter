package ru.tweekyone.roszdravnadzor.controllers;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.tweekyone.roszdravnadzor.beans.TableRepresentation;
import ru.tweekyone.roszdravnadzor.service.TablesService;

import java.io.*;
import java.util.List;

public class MainController {
    private List<TableRepresentation> pastMonth;
    private List<TableRepresentation> thisMonth;

    public void readPastTable(File file){
        try (FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader( fis, "windows-1251")) {
            pastMonth = new CsvToBeanBuilder(isr).withType(TableRepresentation.class).withSeparator(';').build().parse();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readThisTable(File file){
        try (FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader( fis, "windows-1251")) {
            thisMonth = new CsvToBeanBuilder(isr).withType(TableRepresentation.class).withSeparator(';').build().parse();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeTable(String path){
        try(FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "windows-1251");
            CSVWriter writer = new CSVWriter(osw, ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)){
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            try {
                TablesService.doComparsion(pastMonth, thisMonth);
                if(TablesService.getResultTable() != null && !TablesService.getResultTable().isEmpty()){
                    beanToCsv.write(TablesService.getResultTable());
                }
            } catch (CsvDataTypeMismatchException e) {
                e.printStackTrace();
            } catch (CsvRequiredFieldEmptyException e) {
                e.printStackTrace();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public List<TableRepresentation> getPastMonth() {
        return pastMonth;
    }

    public List<TableRepresentation> getThisMonth() {
        return thisMonth;
    }
}
