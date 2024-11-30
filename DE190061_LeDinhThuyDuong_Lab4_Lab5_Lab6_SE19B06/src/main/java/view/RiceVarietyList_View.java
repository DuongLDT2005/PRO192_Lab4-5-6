/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.*;

/**
 *
 * @author DELL
 */
public class RiceVarietyList_View {

    private RiceVarietyList riceVarietyList = new RiceVarietyList();

    public void readFile() {
        riceVarietyList.readFile();
    }

    public void addRiceVariety() {
        System.out.print("Enter name: ");
        String name = DataInput.inputString();
        System.out.print("Enter origin: ");
        String origin = DataInput.inputString();
        System.out.print("Enter harvest date: ");
        Date harvestDate = DataInput.inputDate();
        System.out.print("Enter yield: ");
        Double yield = DataInput.inputPositiveDouble();
        System.out.print("Enter disease resistance: ");
        String diseaseResistance = DataInput.inputString();
        RiceVariety riceVariety = new RiceVariety(name, origin, harvestDate, yield, diseaseResistance);
        riceVarietyList.addRiceVariety(riceVariety);
        System.out.println("Added successfully!");
    }

    public void updateRiceVariety() {
        System.out.print("Enter name to update: ");
        String nameToUpdate = DataInput.inputString();
        ArrayList<RiceVariety> searchList = riceVarietyList.searchRiceVariety(r -> r.getName().equals(nameToUpdate));
        if (searchList.isEmpty()) {
            System.out.println("Rice variety not found!");
            return;
        }
        RiceVariety updateRiceVariety = searchList.get(0);
        String[] options = {
            "Update Yield",
            "Update Disease Resistance"
        };
        Menu updateMenu = new Menu("Update Menu", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        System.out.print("Enter yield to update: ");
                        double yield = DataInput.inputPositiveDouble();
                        riceVarietyList.updateYield(updateRiceVariety, yield);
                        break;
                    }
                    case 2 -> {
                        System.out.print("Enter disease resistance to update: ");
                        String diseaseResistance = DataInput.inputString();
                        riceVarietyList.updateDiseaseResistance(updateRiceVariety, diseaseResistance);
                        break;
                    }
                }
                System.out.println("Updated successfully!");
            }
        };
        updateMenu.run();
    }

    public void searchRiceVariety() {
        String[] options = {
            "Search By Name",
            "Search By Origin",
            "Search By Disease Resistence"
        };
        Menu searchMenu = new Menu("Search Menu", options) {
            @Override
            public void execute(int n) {
                ArrayList<RiceVariety> searchList = new ArrayList<>();
                switch (n) {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = DataInput.inputString();
                        searchList = riceVarietyList.searchRiceVariety(r -> r.getName().contains(name));
                        break;
                    }
                    case 2 -> {
                        System.out.print("Enter origin: ");
                        String origin = DataInput.inputString();
                        searchList = riceVarietyList.searchRiceVariety(r -> r.getOrigin().contains(origin));
                        break;
                    }
                    case 3 -> {
                        System.out.print("Enter disease resistance: ");
                        String diseaseResistance = DataInput.inputString();
                        searchList = riceVarietyList.searchRiceVariety(r -> r.getDiseaseResistance().contains(diseaseResistance));
                        break;
                    }
                }
                if (!searchList.isEmpty()) {
                    System.out.printf("%-10s %-10s %-15s %-10s %-10s\n", "Name", "Origin", "Harvest Date", "Yield", "Disease Resistance");
                    for (RiceVariety r : searchList) {
                        System.out.println(r);
                    }
                } else {
                    System.out.println("Rice variety not found!");
                }
            }
        };
        searchMenu.run();
    }

    public void displayAll() {
        System.out.printf("%-10s %-10s %-15s %-10s %-10s\n", "Name", "Origin", "Harvest Date", "Yield", "Disease Resistance");
        for (RiceVariety r : riceVarietyList.getRiceVarieties()) {
            System.out.println(r);
        }
    }

    public void deleteRiceVariety() {
        if (riceVarietyList.deleteRiceVariety()) {
            System.out.println("Deleted successfully!");
            displayAll();
        } else {
            System.out.println("No rice variety's age is 10 years or older!");
        }
    }
}
