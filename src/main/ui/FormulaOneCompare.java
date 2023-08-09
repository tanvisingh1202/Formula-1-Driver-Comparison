package ui;

import model.CompareDriver;
import model.Driver;
import model.EventLog;
import model.Event;
import persistence.LoadsData;
import persistence.SavesData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FormulaOneCompare {
    private final String savePath = "./data/drivers.json";
    private final String loadPath = "./data/drivers.json";
    private List<Driver> drivers;

    // effects: constructs a FormulaOneCompare object with the given (empty) array list
    public FormulaOneCompare() {
        drivers = new ArrayList<>();
    }

    // requires: non-null list of drivers
    // modifies: this
    // effects: constructs a FormulaOneCompare object with the given array list
    public FormulaOneCompare(List<Driver> drivers) {
        this.drivers = drivers;
    }


    // effects: returns the list of drivers
    public List<Driver> getDrivers() {
        return drivers;
    }

    @SuppressWarnings("methodlength")
    // requires: scan should be an object that is valid and of Scanner type
    // modifies: drivers
    //effects: loads driver data from JSON file, adds new driver data, compares drivers, displays winner,
    // and saves driver data
    public void run(Scanner scan) {
        LoadsData loadsData = new LoadsData(loadPath);
        try {
            drivers = loadsData.loadsDriverData();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        CompareDriver compareDriver = new CompareDriver();

        //List<Driver> drivers = new ArrayList<>();

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

            System.out.print("If you want to enter stats for another driver, hit enter! If not, enter 'X' to exit!");
            String next = scan.nextLine();
            if (next.equalsIgnoreCase("X")) {
                break;
            }


        }

        List<Driver> firsttolast = compareDriver.compareDrivers(drivers);
        Driver winner = firsttolast.get(0);

        System.out.println("Winning driver:  ");
        System.out.println(winner.getName() + " " + "from" + " " + winner.getTeam() + " " + "with a score of"
                + " " + winner.getFinalscore() + "!");

        SavesData savesData = new SavesData(savePath);
        try {
            savesData.savesDriverData(drivers);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> printLoggedEvents()));

        System.out.println("Thank you for playing!");
    }

    private void printLoggedEvents() {
        System.out.println("Logged Events:");
        EventLog eventLog = EventLog.getInstance();
        for (Event event : eventLog) {
            System.out.println(event.getDate() + " - " + event.getDescription());

        }
    }
}




