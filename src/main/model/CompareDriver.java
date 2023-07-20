package model;

import java.util.*;

public class CompareDriver {

    public double calculateScore(Driver driver) {
         // driver.getPoints() + driver.getRacewins() + driver.getFastestlaps() + driver.getPolepositions() +
        // driver.getTopthrees();

        return driver.getPoints() + driver.getRacewins() + driver.getFastestlaps() + driver.getPolepositions()
                + driver.getTopthrees();

    }

    public void compareDrivers(List<Driver> drivers) {
        for (Driver driver : drivers) {
            double finalscores = calculateScore(driver);
            driver.setFinalscore(finalscores);

        }
    }
}
