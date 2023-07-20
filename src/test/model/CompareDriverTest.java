package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareDriverTest {

    private CompareDriver compareDriver;
    private List<Driver> drivers;

    @BeforeEach
    public void setUp() {
        compareDriver = new CompareDriver();
        drivers = new ArrayList<>();
    }

    @Test
    public void testCompareDrivers() {
        Driver drivera = new Driver("Lando Norris", "McLaren Racing", "England",
                470, 0, 7, 1, 5);
        Driver driverb = new Driver("Alexander Albon", "Williams", "Thailand",
                212, 0, 2, 0, 0);

        drivers.add(drivera);
        drivers.add(driverb);

        compareDriver.compareDrivers(drivers);

        assertEquals(483, drivera.getFinalscore());
        assertEquals(214, driverb.getFinalscore());
    }
}
