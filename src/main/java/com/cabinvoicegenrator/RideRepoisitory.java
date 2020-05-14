package com.cabinvoicegenrator;

import java.lang.reflect.Array;
import java.util.*;

public class RideRepoisitory
{
    Map<String, ArrayList<Ride>>Rides;
    public RideRepoisitory()
    {
        this.Rides=new HashMap<>();
    }
    public void addRides(String userId, Ride[] rides)
    {
        this.Rides.put(userId,new ArrayList<>(Arrays.asList(rides)));
    }
    public Ride[]getRides(String userId)
    {
        return this.Rides.get(userId).toArray(new Ride[0]);
    }
}
