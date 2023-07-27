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
        for (Driver driver : drivers) {
            double score = calculateScore(driver);
            driver.setFinalscore(score);

        }

        drivers.sort(Comparator.comparingDouble(Driver::getFinalscore).reversed());

        return drivers;
    }
}
