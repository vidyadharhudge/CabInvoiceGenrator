package com.cabinvoicegenrator;

public class Ride
{
  public final double distance;
  public final int time;
  public final CabRides CabRide;

    public Ride(CabRides rides,double distance, int time)
    {
        this.CabRide=rides;
        this.distance = distance;
        this.time = time;
    }
}
