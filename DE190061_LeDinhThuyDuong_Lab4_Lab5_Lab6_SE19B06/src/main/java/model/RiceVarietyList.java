/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class RiceVarietyList {

    private ArrayList<RiceVariety> riceVarieties = new ArrayList<>();

    public ArrayList<RiceVariety> getRiceVarieties() {
        return riceVarieties;
    }

    public void readFile() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\model\\rice_varieties.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0].trim();
                    String origin = parts[1].trim();
                    Date harvestDate;
                    try {
                        harvestDate = sdf.parse(parts[2].trim());
                    } catch (ParseException ex) {
                        System.out.println("Invalid date format in line: " + line);
                        continue;
                    }
                    double yield;
                    try {
                        yield = Double.parseDouble(parts[3].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid double number format in line: " + line);
                        continue;
                    }
                    String diseaseResistance = parts[4].trim();
                    RiceVariety riceVariety = new RiceVariety(name, origin, harvestDate, yield, diseaseResistance);
                    riceVarieties.add(riceVariety);
                } else {
                    System.out.println("Invalid line format in line: " + line);
                }
            }
            System.out.println("Read file successfully!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RiceVarietyList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RiceVarietyList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addRiceVariety(RiceVariety riceVariety) {
        this.riceVarieties.add(riceVariety);
    }

    public ArrayList<RiceVariety> searchRiceVariety(Predicate<RiceVariety> p) {
        ArrayList<RiceVariety> searchList = new ArrayList<>();
        for (RiceVariety r : riceVarieties) {
            if (p.test(r)) {
                searchList.add(r);
            }
        }
        return searchList;
    }

    public void updateYield(RiceVariety riceVariety, double yield) {
        riceVariety.setYield(yield);
    }
    
    public void updateDiseaseResistance(RiceVariety riceVariety, String dieaseResistance) {
        riceVariety.setDiseaseResistance(dieaseResistance);
    }
    
    public boolean deleteRiceVariety() {
        ArrayList<RiceVariety> deleteList = new ArrayList<>();
        for (RiceVariety r : riceVarieties) {
            if (r.getAge() >= 10) {
                deleteList.add(r);
            }
        }
        if (!deleteList.isEmpty()) {
            riceVarieties.removeAll(deleteList);
            return true;
        } else {
            return false;
        }
    }
}
