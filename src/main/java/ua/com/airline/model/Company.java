package ua.com.airline.model;

import ua.com.airline.model.entity.Plane;

import java.util.List;

/**
 * Created by Владислав on 24.01.2018.
 */
public abstract class Company {
    List<Plane> planeList;
    abstract List<Plane> getAllPlanes();
}
