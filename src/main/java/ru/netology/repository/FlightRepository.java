package ru.netology.repository;

import static org.apache.commons.lang3.ArrayUtils.add;
import static org.apache.commons.lang3.ArrayUtils.removeElement;

import org.apache.commons.lang3.ArrayUtils;
import ru.netology.domain.Flight;

public class FlightRepository {

    private Flight[] flights = new Flight[0];

    public void save(Flight item) {
        flights = add(flights, item);
    }

    public Flight findById(int id) {
        for (Flight item : flights) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        flights = removeElement(flights, findById(id));
    }

    public Flight[] findAll() {
        return ArrayUtils.clone(flights);
    }
}

