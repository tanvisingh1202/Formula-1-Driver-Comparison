package persistence;

import model.Driver;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoadsDataTest {
    private static final String testLoadPath = "./data/testdrivers.json";

    @Test
    public void testLoadsDriverData() {
        try {
            List<Driver> drivers = List.of(
                    new Driver("Lando Norris", "McLaren Racing", "England",
                            470, 0, 7, 1, 5),
                    new Driver("Max Verstappen", "Red Bull", "Netherlands",
                            558,2,23,7,15)
            );

            SavesData savesData = new SavesData(testLoadPath);
            savesData.savesDriverData(drivers);

            LoadsData loadsData = new LoadsData(testLoadPath);
            List<Driver> loadedDrivers = loadsData.loadsDriverData();

            assertEquals(drivers.size(), loadedDrivers.size());
            for (int i = 0; i < drivers.size(); i++) {
                Driver expectedDriver = drivers.get(i);
                Driver actualDriver = loadedDrivers.get(i);

                assertEquals(expectedDriver.getName(), actualDriver.getName());
                assertEquals(expectedDriver.getTeam(), actualDriver.getTeam());
                assertEquals(expectedDriver.getCountry(), actualDriver.getCountry());
                assertEquals(expectedDriver.getPoints(), actualDriver.getPoints());
                assertEquals(expectedDriver.getRacewins(), actualDriver.getRacewins());
                assertEquals(expectedDriver.getTopthrees(), actualDriver.getTopthrees());
                assertEquals(expectedDriver.getPolepositions(), actualDriver.getPolepositions());
                assertEquals(expectedDriver.getFastestlaps(), actualDriver.getFastestlaps());
            }
        } catch (IOException e) {
            fail("An unexpected IOException occurred: " + e.getMessage());
        }

    }
}
