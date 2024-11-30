/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class RiceVariety {
    private String name;
    private String origin;
    private Date harvestDate;
    private double yield;
    private String diseaseResistance;

    public RiceVariety() {
    }

    public RiceVariety(String name, String origin, Date harvestDate, double yield, String diseaseResistance) {
        this.name = name;
        this.origin = origin;
        this.harvestDate = harvestDate;
        this.yield = yield;
        this.diseaseResistance = diseaseResistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(Date harvestDate) {
        this.harvestDate = harvestDate;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public String getDiseaseResistance() {
        return diseaseResistance;
    }

    public void setDiseaseResistance(String diseaseResistance) {
        this.diseaseResistance = diseaseResistance;
    }
    public int getAge() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.now();
        String[] dateParts = sdf.format(harvestDate).split("/");
        int harvestYear = Integer.parseInt(dateParts[2]);
        return currentDate.getYear() - harvestYear;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-10s %-10s %-15s %-10.2f %-10s", this.name, this.origin, sdf.format(harvestDate), this.yield, this.diseaseResistance);
    }
    
}
