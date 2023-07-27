package model;

import java.util.*;

public class CompareDriver {

    public double calculateScore(Driver driver) {
        double score = driver.getPoints() + driver.getRacewins() + driver.getFastestlaps()
                 + driver.getPolepositions() + driver.getTopthrees();

        return score;

    }

    public List<Driver> compareDrivers(List<Driver> drivers) {
        for (Driver driver : drivers) {
            double score = calculateScore(driver);
            driver.setFinalscore(score);

        }

        drivers.sort(Comparator.comparingDouble(Driver::getFinalscore).reversed());

        return drivers;
    }
}
