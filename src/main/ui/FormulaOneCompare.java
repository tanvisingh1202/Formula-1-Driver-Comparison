package ui;

import model.CompareDriver;
import model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormulaOneCompare {

    public void run() {
        Scanner scan = new Scanner(System.in);
        List<Driver> drivers = new ArrayList<>();
        CompareDriver compareDriver = new CompareDriver();
        System.out.println("Formula One Driver Compare");
        System.out.println("Pick a driver of your choice and enter their stats here! Or enter 'X' to exit!");
        while (true) {
            System.out.print("Driver name: ");
            String name = scan.nextLine();
            if (name.contentEquals("X")) {
                break;
            }
            System.out.print("Team: ");
            String team = scan.nextLine();
            System.out.print("Career points: ");
            String points = scan.nextLine();
            Driver driver = new Driver(name, team, points);
            drivers.add(driver);
        }
    }


