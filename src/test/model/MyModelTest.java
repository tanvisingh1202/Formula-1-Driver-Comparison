package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DriverTest {
    @Test
    public void testCalculateScore() {
        Driver driver = new Driver("Lando Norris", "McLaren Racing", "England",
                470, 0, 7, 1, 5);
        CompareDriver compareDriver = new CompareDriver();

        compareDriver.compareDrivers(List.of(driver));

        double expected = 483;

        assertEquals(expected, driver.getFinalscore());
    }
}