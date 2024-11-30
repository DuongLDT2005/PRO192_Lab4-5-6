/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.*;

/**
 *
 * @author DELL
 */
public class RiceVarietyManagement {
    public static void main(String[] arts) {
        RiceVarietyList_View riceVarietyLV = new RiceVarietyList_View();
        riceVarietyLV.readFile();
        String[] options = {
            "Add a new rice variety",
            "Display all rice varieties",
            "Update information of a rice variety",
            "Search rice varieties",
            "Delete old rice varieties"
        };
        Menu menu = new Menu("Rice Variety Management System", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        riceVarietyLV.addRiceVariety();
                        break;
                    }
                    case 2 -> {
                        riceVarietyLV.displayAll();
                        break;
                    }
                    case 3 -> {
                        riceVarietyLV.updateRiceVariety();
                        break;
                    }
                    case 4 -> {
                        riceVarietyLV.searchRiceVariety();
                        break;
                    }
                    case 5 -> {
                        riceVarietyLV.deleteRiceVariety();
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
