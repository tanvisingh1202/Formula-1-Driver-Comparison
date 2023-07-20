package ui;

import model.CompareDriver;
import model.Driver;

import java.util.ArrayList;
import java.util.Comparator;
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
            System.out.print("Country: ");
            String country = scan.nextLine();
            System.out.print("Career points: ");
            int points = Integer.parseInt(scan.nextLine());
            System.out.print("Career wins: ");
            int racewins = Integer.parseInt(scan.nextLine());
            System.out.print("Podium finishes: ");
            int topthrees = Integer.parseInt(scan.nextLine());
            System.out.print("Pole positions: ");
            int polepositions = Integer.parseInt(scan.nextLine());
            System.out.print("Fastest laps: ");
            int fastestlaps = Integer.parseInt(scan.nextLine());
            Driver driver = new Driver(name, team, country, points, racewins, topthrees, polepositions, fastestlaps);
            drivers.add(driver);
        }
    }

    public void runafter() {
        private CompareDriver compareDriver;
        private List<Driver> drivers
        compareDriver.compareDrivers(drivers);

        Driver winner = drivers.stream().max(Comparator.comparingDouble(Driver::getFinalscore)).orElse(null);

        if (winner != null) {
            System.out.println("Winning driver:  ");
            System.out.println(winner.getName() + "from" + winner.getTeam() + "with a score of"
                     + winner.getFinalscore() + "!");
        } else {
            System.out.println(" ");
        }
    }
}
