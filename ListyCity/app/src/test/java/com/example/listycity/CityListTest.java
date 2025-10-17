package com.example.listycity;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class CityListTest {

    private City mockCity() { return new City("Edmonton", "Alberta"); }

    private CityList mockCityList() {
        CityList list = new CityList();
        list.add(mockCity());
        return list;
    }

    @Test
    public void addCity_works() {
        CityList list = mockCityList();
        int oldSize = list.getCities().size();
        list.add(new City("Calgary", "Alberta"));
        assertEquals(oldSize + 1, list.getCities().size());
    }

    @Test
    public void hasCity_trueAfterAdd() {
        CityList list = new CityList();
        City c = new City("Calgary", "Alberta");
        list.add(c);
        assertTrue(list.hasCity(c));
    }

    @Test
    public void deleteCity_removesIt() {
        CityList list = mockCityList();
        City c = new City("Calgary", "Alberta");
        list.add(c);
        list.delete(c);
        assertFalse(list.hasCity(c));
    }

    @Test
    public void count_returnsSize() {
        CityList list = mockCityList();
        int n = list.getCities().size();
        assertEquals(n, list.count());
        list.add(new City("Calgary", "Alberta"));
        assertEquals(n + 1, list.count());
    }

    @Test
    public void add_duplicateThrows() {
        CityList list = new CityList();
        City c = new City("Edmonton", "Alberta");
        list.add(c);
        try {
            list.add(c);
            fail("Should throw on duplicate");
        } catch (IllegalArgumentException expected) {
            // ok
        }
    }

    @Test
    public void getCities_returnsSortedByName() {
        CityList list = new CityList();
        list.add(new City("Calgary", "Alberta"));
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Banff", "Alberta"));
        List<City> cities = list.getCities();
        assertEquals("Banff", cities.get(0).getCityName());
        assertEquals("Calgary", cities.get(1).getCityName());
        assertEquals("Edmonton", cities.get(2).getCityName());
    }
}
