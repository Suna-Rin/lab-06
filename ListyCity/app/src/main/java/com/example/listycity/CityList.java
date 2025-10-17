package com.example.listycity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Keeps a collection of {@link City} objects and provides basic operations.
 */
public class CityList {
    /** Backing store for cities. */
    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it doesn't already exist.
     * @param city candidate city to add
     * @throws IllegalArgumentException if the city is already in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists: " + city);
        }
        cities.add(city);
    }

    /**
     * @param city city to check
     * @return {@code true} if the city exists in the list, {@code false} otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city if present.
     * @param city city to remove
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not in list: " + city);
        }
        cities.remove(city);
    }

    /**
     * @return the number of cities in the list
     */
    public int count() {
        return cities.size();
    }

    /** (可选) 兼容之前的命名 */
    public int countCities() {
        return count();
    }

    /**
     * Returns a new list of cities sorted by city name (does not mutate internal list).
     * @return sorted copy of the cities
     */
    public List<City> getCities() {
        List<City> copy = new ArrayList<>(cities);
        // 按城市名升序；需要 City 提供 getCityName()
        copy.sort(Comparator.comparing(City::getCityName));
        return copy;
    }
}
