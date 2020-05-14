package com.cabinvoicegenrator;

import com.cabinvoicegenrator.repoisitory.RideRepoisitory;

public class InvoiceService {

    private RideRepoisitory rideRepoisitory;

    public InvoiceService()
    {
        rideRepoisitory=new RideRepoisitory();
    }

    public InvoiceSummary getTotalFare(Ride[] rides)
    {
        double totalFare=0;
        for (Ride ride:rides)
        {
            totalFare+=ride.CabRide.calculateCostOfRide(ride);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public InvoiceSummary getInvoiceSummary(String userId)
    {
        return this.getTotalFare(rideRepoisitory.getRides(userId));
    }

    public void addRides(String userId, Ride[] rides)
    {
        rideRepoisitory.addRides(userId,rides);
    }

    public void setRideRepository(RideRepoisitory rideRepoisitory)
    {
        this.rideRepoisitory=rideRepoisitory;
    }
}

