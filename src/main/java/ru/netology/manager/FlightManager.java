package ru.netology.manager;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import ru.netology.domain.Flight;
import ru.netology.domain.FlightByTimeComparator;
import ru.netology.repository.FlightRepository;

public class FlightManager {

    private final FlightRepository repository;

    public FlightManager(FlightRepository repo) {
        this.repository = repo;
    }

    public Flight[] findAll(String from, String to, FlightByTimeComparator comparator) {
        var found = new Flight[0];
        for (var flight : repository.findAll()) {
            if (flight.matches(from, to)) {
                found = ArrayUtils.add(found, flight);
            }
        }
        Arrays.sort(found, comparator);
        return found;
    }

    public void add(Flight item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
