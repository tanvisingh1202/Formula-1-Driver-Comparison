package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.FormulaOneCompare;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
class DriverTest {
    private CompareDriver compareDriver;
    private FormulaOneCompare formulaOneCompare;

    @BeforeEach
    public void setUp() {
        compareDriver = new CompareDriver();
        formulaOneCompare = new FormulaOneCompare();
    }

    @Test
    public void testCalculateScore() {
        Driver driver = new Driver("Lando Norris", "McLaren Racing", "England",
                470, 0, 7, 1, 5);
        CompareDriver compareDriver = new CompareDriver();
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver);

        compareDriver.compareDrivers(drivers);

        double expected = 483;
        double actual = driver.getFinalscore();

        assertEquals(expected, actual);
    }

    @Test
    public void testExit() {
        String input = "X\n";
        simulateUserInput(input);

        assertEquals(0, formulaOneCompare.getDrivers().size());
    }

    @Test
    public void testInvalidInput() {
        String input = "Lando Norris\nMcLaren\nEngland\nabcd\n0\n0\n0\n0\n";
        simulateUserInput(input);

        assertEquals(0, formulaOneCompare.getDrivers().size());
    }

//    @Test
//    public void testCompareMultiple() {
//        String input = "Lando Norris\nEngland\n100\n5\n10\n3\n8\n"
//                + "Alex Albon\nWilliams\nEngland\n200\n10\n8\n7\n4\nX\n";
//
//        simulateUserInput(input);
//
//        List<Driver> drivers = formulaOneCompare.getDrivers();
//        assertEquals(2, drivers.size());
//
//        Driver winner = drivers.stream().max(Comparator.comparingDouble(Driver::getFinalscore)).orElse(null);
//
//        assertEquals("Alex Albon", winner.getName());
//
//    }

//    @Test
//    public void testEqual() {
//        String input = "Lando Norris\nEngland\n100\n5\n10\n3\n8\n"
//                + "Alex Albon\nWilliams\nEngland\n100\n5\n10\n3\n8\nX\n";
//
//        simulateUserInput(input);
//
//        List<Driver> drivers = formulaOneCompare.getDrivers();
//        assertEquals(2, drivers.size());
//
//        double score = drivers.get(0).getFinalscore();
//        for (Driver driver : drivers) {
//            assertEquals(score, driver.getFinalscore());
//        }
//    }

    @Test
    public void testNoDrivers() {
        simulateUserInput("X\n");

        // No drivers should be added as the loop should exit on "X"
        assertEquals(0, formulaOneCompare.getDrivers().size());
    }


    private void simulateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testSetPoints() {
        Driver driver = new Driver("Yuki Tsunoda", "AlphaTauri", "Japan", 0,0,
                0,0,0);
        driver.setPoints(30);
        assertEquals(30, driver.getPoints());
    }

    @Test
    public void testSetRacewins() {
        Driver driver = new Driver("Yuki Tsunoda", "AlphaTauri", "Japan", 0,0,
                0,0,0);
        driver.setRacewins(30);
        assertEquals(30, driver.getRacewins());
    }

    @Test
    public void testSetTopthrees() {
        Driver driver = new Driver("Yuki Tsunoda", "AlphaTauri", "Japan", 0,0,
                0,0,0);
        driver.setTopthrees(30);
        assertEquals(30, driver.getTopthrees());
    }

    @Test
    public void testSetPole() {
        Driver driver = new Driver("Yuki Tsunoda", "AlphaTauri", "Japan", 0,0,
                0,0,0);
        driver.setPolepositions(30);
        assertEquals(30, driver.getPolepositions());
    }

    @Test
    public void testSetFastest() {
        Driver driver = new Driver("Yuki Tsunoda", "AlphaTauri", "Japan", 0,0,
                0,0,0);
        driver.setFastestlaps(30);
        assertEquals(30, driver.getFastestlaps());
    }




}
