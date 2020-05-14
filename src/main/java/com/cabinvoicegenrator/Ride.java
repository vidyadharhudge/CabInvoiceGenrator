package com.cabinvoicegenrator;

import com.cabinvoicegenrator.forenum.CabRides;

public class Ride
{
  public final double distance;
  public final double time;
  public final CabRides CabRide;

    public Ride(CabRides rides,double distance, double time)
    {
        this.CabRide=rides;
        this.distance = distance;
        this.time = time;
    }
}
