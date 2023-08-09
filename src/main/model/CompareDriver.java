package model;

import java.util.*;

public class CompareDriver {

// requires: driver must not be a null object

    public double calculateScore(Driver driver) {
        double score = driver.getPoints() + driver.getRacewins() + driver.getFastestlaps()
                 + driver.getPolepositions() + driver.getTopthrees();

        return score;

    }

// requires: the list of drivers must not be empty
// modifies: the final scores of the drivers
// effects: the drivers list (order)

    public List<Driver> compareDrivers(List<Driver> drivers) {
        StringBuilder driverNames = new StringBuilder();

        for (Driver driver : drivers) {
            double score = calculateScore(driver);
            driver.setFinalscore(score);

            driverNames.append(driver.getName()).append(", ");

        }

        drivers.sort(Comparator.comparingDouble(Driver::getFinalscore).reversed());

        String allDriverNames = driverNames.toString();
        allDriverNames = allDriverNames.substring(0, allDriverNames.length() - 2);

        EventLog.getInstance().logEvent(new Event("Drivers compared: " + allDriverNames));

        return drivers;
    }
}
