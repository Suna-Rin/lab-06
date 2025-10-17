package com.example.listycity;

import java.util.Objects;

/**
 * Represents a Canadian city with a name and province/territory.
 *
 * <p>Implements {@link Comparable} so lists of cities can be sorted by name.
 * {@code equals} / {@code hashCode} are provided so collections treat two
 * City objects with the same name+province as the same logical city.</p>
 */
public class City implements Comparable<City> {
    /** The city name (e.g., "Edmonton"). */
    private final String city;
    /** The province or territory name (e.g., "Alberta"). */
    private final String province;

    /**
     * Constructs a City.
     * @param city the city name
     * @param province the province/territory name
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /** @return the city name */
    public String getCityName() { return this.city; }

    /** @return the province/territory name */
    public String getProvinceName() { return this.province; }

    /**
     * Natural ordering: case-insensitive by city name.
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareToIgnoreCase(o.city);
    }

    /**
     * Two cities are equal if both name and province match (case-insensitive).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return city.equalsIgnoreCase(other.city)
                && province.equalsIgnoreCase(other.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city.toLowerCase(), province.toLowerCase());
    }

    @Override
    public String toString() {
        return city + ", " + province;
    }
}
