package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Data class which implements flight offer
 *
 * @author me
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class Flight implements Comparable<Flight> {

    private int id;
    private int price;
    private String orig;    // departure airport IATA code
    private String dest;    // arrival airport IATA code
    private int time;       // flight duration in minutes

    @Override
    public int compareTo(@NonNull Flight offer) {
        return this.price - offer.price;
    }

    public boolean matches(String from, String to) {
        return orig.equalsIgnoreCase(from) && dest.equalsIgnoreCase(to);
    }
}
