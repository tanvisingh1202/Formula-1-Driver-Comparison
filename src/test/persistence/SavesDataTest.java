package persistence;

import model.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavesDataTest {
    private static final String testSavePath = "./data/testdrivers.json";
    private SavesData savesData;
    private List<Driver> drivers;

    @BeforeEach
    public void setUp() {
        savesData = new SavesData(testSavePath);
        drivers = new ArrayList<>();
        drivers.add(new Driver("Lando Norris", "McLaren Racing", "England", 470,
                0, 7, 1, 5));
        drivers.add(new Driver("Alex Albon", "Williams", "England", 200,
                10, 8, 7, 4));
    }

    @Test
    public void testSavesDriverData() throws IOException {
        savesData.savesDriverData(drivers);

        LoadsData loadsData = new LoadsData(testSavePath);
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
    }

    @Test
    public void testSavesDriverDataIOException() {
        assertThrows(IOException.class, () -> {
            savesData.savesDriverData(null);
        });
    }
}
