package com.al.cc2.use_cases.location.infrastructure;

import com.al.cc2.use_cases.location.domain.Location;
import com.al.cc2.use_cases.location.domain.LocationID;
import com.al.cc2.use_cases.location.domain.LocationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class InMemoryLocationRepository implements LocationRepository {
    private final HashMap<LocationID, Location> contractors;

    public InMemoryLocationRepository() {
        this.contractors = new HashMap<>();
    }

    @Override
    public List<Location> findAll() {
        return new ArrayList<>(contractors.values());
    }

    @Override
    public Location byId(LocationID locationID) {
        Location location = contractors.get(locationID);
        if (location == null) {
            throw new NoSuchElementException();
        }
        return location;
    }

    @Override
    public void update(LocationID locationID, Location location) {
        contractors.replace(locationID, location);
    }

    @Override
    public void add(Location location) {
        contractors.put(location.id(), location);
    }

    @Override
    public void delete(LocationID locationID) {
        contractors.remove(locationID);
    }
}
