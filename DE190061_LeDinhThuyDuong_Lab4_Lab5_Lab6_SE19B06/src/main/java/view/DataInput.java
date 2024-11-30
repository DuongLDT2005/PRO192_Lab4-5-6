/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class DataInput {

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (!input.isBlank()) {
                return input;
            } else {
                System.out.println("Input must not be empty! Please enter again!");
            }
        }
    }
    
    public static Date inputDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while (true) {
            try {
                Date date = sdf.parse(inputString());
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please enter again!");
            }
        }
    }
    
    public static double inputPositiveDouble() {
        while (true) {
            try {
                Double input = Double.parseDouble(inputString());
                if (input < 0 ) {
                    System.out.println("Input must be positive! Please enter again!");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid double number format! Please enter again!");
            }
        }
    }
}
