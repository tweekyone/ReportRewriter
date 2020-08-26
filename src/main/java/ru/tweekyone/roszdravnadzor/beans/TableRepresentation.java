package ru.tweekyone.roszdravnadzor.beans;

import com.opencsv.bean.CsvBindByName;

public class TableRepresentation {

    @CsvBindByName(column = "ЛС (связать с DrugID)")
    private String ls;

    @CsvBindByName
    private String drugID;

    @CsvBindByName
    private int segment;

    @CsvBindByName
    private int year;

    @CsvBindByName
    private int month;

    @CsvBindByName
    private String series;

    @CsvBindByName
    private String totDrugQn;

    @CsvBindByName
    private String mnfPrice;

    @CsvBindByName
    private String prcPrice;

    @CsvBindByName
    private String rtlPrice;

    @CsvBindByName
    private String funds;

    @CsvBindByName
    private String vendorID;

    @CsvBindByName
    private String remark;

    @CsvBindByName
    private String srcOrg;

    public String getLs() {
        return ls;
    }

    public void setLs(String ls) {
        this.ls = ls;
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public int getSegment() {
        return segment;
    }

    public void setSegment(int segment) {
        this.segment = segment;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTotDrugQn() {
        return totDrugQn;
    }

    public void setTotDrugQn(String totDrugQn) {
        this.totDrugQn = totDrugQn;
    }

    public String getMnfPrice() {
        return mnfPrice;
    }

    public void setMnfPrice(String mnfPrice) {
        this.mnfPrice = mnfPrice;
    }

    public String getPrcPrice() {
        return prcPrice;
    }

    public void setPrcPrice(String prcPrice) {
        this.prcPrice = prcPrice;
    }

    public String getRtlPrice() {
        return rtlPrice;
    }

    public void setRtlPrice(String rtlPrice) {
        this.rtlPrice = rtlPrice;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSrcOrg() {
        return srcOrg;
    }

    public void setSrcOrg(String srcOrg) {
        this.srcOrg = srcOrg;
    }
}
