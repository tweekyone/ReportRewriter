package ru.tweekyone.roszdravnadzor.service;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import ru.tweekyone.roszdravnadzor.beans.TableRepresentation;

import java.util.ArrayList;
import java.util.List;

public class TablesService {
    private static List<TableRepresentation> resultTable = new ArrayList<>();

    public static List<TableRepresentation> getResultTable() {
        return resultTable;
    }

    public static List<TableRepresentation> doComparsion(List<TableRepresentation> pastMonth, List<TableRepresentation> thisMonth){
        if((pastMonth != null || !pastMonth.isEmpty()) && (thisMonth != null || !pastMonth.isEmpty())){
            for (int i = 0; i < thisMonth.size(); i++) {
                TableRepresentation result = null;
                for (int j = 0; j < pastMonth.size(); j++) {
                    StringBuilder pastMonthSeries0 = new StringBuilder();
                    pastMonthSeries0.append("0");
                    pastMonthSeries0.append(pastMonth.get(j).getSeries());
                    if((thisMonth.get(i).getSeries().equals(pastMonth.get(j).getSeries())
                            && thisMonth.get(i).getLs().toLowerCase().trim().equals(pastMonth.get(j).getLs().toLowerCase().trim()))
                        || (thisMonth.get(i).getSeries().equals(pastMonthSeries0.toString())
                            && thisMonth.get(i).getLs().toLowerCase().trim().equals(pastMonth.get(j).getLs().toLowerCase().trim()))){
                        result = new TableRepresentation();
                        result.setLs(thisMonth.get(i).getLs());
                        result.setDrugID(pastMonth.get(j).getDrugID());
                        result.setSegment(thisMonth.get(i).getSegment());
                        result.setYear(thisMonth.get(i).getYear());
                        result.setMonth(thisMonth.get(i).getMonth());
                        result.setSeries(thisMonth.get(i).getSeries());
                        result.setTotDrugQn(thisMonth.get(i).getTotDrugQn());
                        result.setMnfPrice(pastMonth.get(j).getMnfPrice());
                        result.setPrcPrice(thisMonth.get(i).getPrcPrice());
                        result.setRtlPrice(thisMonth.get(i).getRtlPrice());
                        result.setFunds(thisMonth.get(i).getFunds());
                        result.setVendorID(pastMonth.get(j).getVendorID());
                        result.setRemark(pastMonth.get(j).getRemark());
                        result.setSrcOrg(pastMonth.get(j).getSrcOrg());
                    }
                }

                if(result != null){
                    resultTable.add(result);
                } else {
                    resultTable.add(thisMonth.get(i));
                }
            }
        }
        return resultTable;
    }
}
