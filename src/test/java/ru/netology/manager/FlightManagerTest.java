package ru.netology.manager;

import static org.apache.commons.lang3.ArrayUtils.isEmpty;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

class FlightManagerTest {

    final FlightManager manager = new FlightManager(new FlightRepository());

    final Flight FLIGHT_1 = new Flight(1, 3000, "MOW", "LED", 120);
    final Flight FLIGHT_2 = new Flight(2, 2000, "MOW", "LED", 100);
    final Flight FLIGHT_3 = new Flight(3, 6000, "MOW", "AER", 360);

    @BeforeEach
    void setUp() {
        manager.add(FLIGHT_1);
        manager.add(FLIGHT_2);
        manager.add(FLIGHT_3);
    }

    @Test
    void shouldFindOne() {
        var actual = manager.findAll("MOW", "AER");
        var expected = new Flight[]{FLIGHT_3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        var actual = manager.findAll("MOW", "LED");
        var expected = new Flight[]{FLIGHT_2, FLIGHT_1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNone() {
        var actual = manager.findAll("MOW", "XYZ");

        assertTrue(isEmpty(actual));
    }
}